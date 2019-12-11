package com.giedron;

public class Main {

    public static void main(String[] args) {

        int[][] st = {{1,2,3} , {0,4,6} , {7,5,8}};
        Puzzle start = new Puzzle(st);
        start.display();

        Puzzle sec = start.moveBlankTo( new Pair(1,0) ); //move bottom

        System.out.println("start: ");
        start.display();

        System.out.println("sec: ");
        sec.display();

        sec.moveBlankTo( new Pair(0,1) ); // move right // powino byc na pozycji [1][2]

        System.out.println("start: ");
        start.display();

        System.out.println("sec: ");
        sec.display();


    }
}
