package com.github;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MatrixBFS {
    private int row, col;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        row = R;
        col = C;
        int[][] dist = new int[R*C][2];
        int index = 0;
        boolean[][] matrix = new boolean[R][C];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r0,c0));
        matrix[r0][c0] = true;
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            dist[index][0] = node.x;
            dist[index][1] = node.y;
            index++;
            for(Node child : node.getChilds()) {
                if(!matrix[child.x][child.y]) {
                    queue.add(child);
                    matrix[child.x][child.y] = true;
                }
            }
        }
        return dist;
    }

    class Node {
        int x, y;
        Node(int a,int b) {
            x = a;
            y = b;
        }

        List<Node> getChilds() {
            List<Node> list = new LinkedList<>();
            if(x - 1 >= 0) {
                list.add(new Node(x - 1, y));
            }
            if(y - 1 >= 0) {
                list.add(new Node(x, y - 1));
            }
            if(x + 1 < row) {
                list.add(new Node(x + 1, y));
            }
            if(y + 1 < col) {
                list.add(new Node(x, y + 1));
            }
            return list;
        }

        @Override
        public String toString() {
            return "x " + x + " y " + y;
        }
    }
}