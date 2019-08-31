package com.github;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapDifference {
    List<List<Record>> mapDiff(Map<String, String[]> existingMap, Map<String, String[]> newMap) {
        List<Record> insert = new LinkedList<>();
        List<Record> update = new LinkedList<>();
        List<Record> delete = new LinkedList<>();
        for (Map.Entry<String, String[]> entry : newMap.entrySet()) {
            String[] existingValues = existingMap.get(entry.getKey());
            if (existingValues == null) {
                updateRecords(insert, entry);
            } else {
                handleUpdateValues(insert, update, delete, entry, existingValues);
                existingMap.remove(entry.getKey());
            }
        }
        for (Map.Entry<String, String[]> entry : existingMap.entrySet()) {
            updateRecords(delete, entry);
        }
        return Arrays.asList(insert, update, delete);
    }

    private void handleUpdateValues(List<Record> insert, List<Record> update, List<Record> delete, Map.Entry<String, String[]> entry, String[] existingValues) {
        String[] newValues = entry.getValue();
        Arrays.sort(newValues);
        Arrays.sort(existingValues);
        int i = 0, j = 0;
        while (i < newValues.length && j < existingValues.length) {
            int compare = newValues[i].compareTo(existingValues[j]);
            if (compare < 0) {
                insert.add(new Record(entry.getKey(), newValues[i], i));
                i++;
            } else if (compare > 0) {
                delete.add(new Record(entry.getKey(), existingValues[j], j));
                j++;
            } else {
                update.add(new Record(entry.getKey(), newValues[i], i));
                i++;
                j++;
            }
        }
        while (i < newValues.length) {
            insert.add(new Record(entry.getKey(), newValues[i], i));
            i++;
        }
        while (j < existingValues.length) {
            delete.add(new Record(entry.getKey(), existingValues[j], j));
            j++;
        }
    }

    private void updateRecords(List<Record> list, Map.Entry<String, String[]> entry) {
        String[] newValues = entry.getValue();
        for (int i = 0; i < newValues.length; i++) {
            list.add(new Record(entry.getKey(), newValues[i], i));
        }
    }

    class Record {
        private String key, value;
        private int priority;

        Record(String key, String value, int priority) {
            this.key = key;
            this.value = value;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }
}
