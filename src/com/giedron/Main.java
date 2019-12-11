package com.giedron;

public class Main {

    public static void main(String[] args) {

        int[][] st = {{1,8,2} , {0,4,3} , {7,6,5}};
        Puzzle puzzle = new Puzzle(st);
        int level = 0;
        Path path = new Path();

        if( puzzle.isSolvable() )
        {
            while( !puzzle.isGoal() )
            {
                Node node = new Node(puzzle , level++);
                path.add(node);
                node.display();

                puzzle = null;
                puzzle = new Puzzle( node.getPuzzleWithMinVal() );
            }
            path.add( new Node(puzzle , level) );

            path.displayPath();
        }
        else
        {
            System.out.println("Układanki nie da się rozwiązć!");
        }

    }
}
