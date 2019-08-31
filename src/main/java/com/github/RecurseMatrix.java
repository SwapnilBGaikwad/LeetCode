package com.github;

class RecurseMatrix {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        floodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int newColor, int prevColor) {
        if(isInvalidIndex(image, sr, sc) || image[sr][sc] != prevColor || image[sr][sc] == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        floodFill(image, sr + 1, sc, newColor, prevColor);
        floodFill(image, sr - 1, sc, newColor, prevColor);
        floodFill(image, sr, sc + 1, newColor, prevColor);
        floodFill(image, sr, sc - 1, newColor, prevColor);
    }

    private boolean isInvalidIndex(int[][] image, int sr, int sc) {
        return sc < 0 || sr < 0 || sr >= image.length || sc >= image[sr].length;
    }
}
