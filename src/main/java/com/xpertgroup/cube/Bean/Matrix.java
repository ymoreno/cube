package com.xpertgroup.cube.Bean;


public class Matrix {

    long[][][] tree;
    long[][][] nums;
    private int dimensions = 0;

    public long[][][] getTree() {
        return tree;
    }

    public void setTree(long[][][] tree) {
        this.tree = tree;
    }

    public long[][][] getNums() {
        return nums;
    }

    public void setNums(long[][][] nums) {
        this.nums = nums;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
}
