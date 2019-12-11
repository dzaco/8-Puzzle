package com.giedron;

public class Main {

    public static void main(String[] args) {

        int[][] st = {{1,2,3} , {0,4,6} , {7,5,8}};
        Puzzle start = new Puzzle(st);
        start.display();
    }
}
