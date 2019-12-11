package com.giedron;

public class Main {

    public static void main(String[] args) {

        int[][] st = {{1,2,3} , {0,4,6} , {7,5,8}};
        Puzzle start = new Puzzle(st);
        start.display();


        System.out.println("Cost: " + start.getCost() );
        Pair move = new Pair(1,0);
        Puzzle sec = start.moveBlankTo(move);

        System.out.println("start: " + start.getPuzzle() );
        start.display();

        System.out.println("sec: " + sec.getPuzzle());
        sec.display();
        sec.moveBlankTo( new Pair(0,1) );

        System.out.println("start: " + start.getPuzzle());
        start.display();

        System.out.println("sec: " + sec.getPuzzle());
        sec.display();


    }
}
