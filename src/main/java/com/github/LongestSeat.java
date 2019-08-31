package com.github;

class LongestSeat {
    public int maxDistToClosest(int[] seats) {
        int i = 0, j = seats.length - 1;
        int leftDist = 0;
        while(seats[i] == 0) {
            leftDist++;
            i++;
        }
        int rightDist = 0;
        while(seats[j] == 0) {
            rightDist++;
            j--;
        }
        int max = Math.max(leftDist,rightDist);
        int prev = i;
        while(i <= j) {
            if(seats[i] != 0) {
                int dist = (int) Math.ceil((i - prev - 1) * 1.0 / 2);
                max = Math.max(dist, max);
                prev = i;
            }
            i++;
        }
        return max;
    }
}