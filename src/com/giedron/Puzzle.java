package com.giedron;

public class Puzzle {

    private int [][] puzzle = new int[3][3];
    private final int[][] goal = { {1,2,3} , {4,5,6} , {7,8,0} };

    public Puzzle( int [][] puzzle )
    {
        this.puzzle = puzzle.clone();
    }

    public Puzzle( Puzzle puzzle )
    {
        this.puzzle = puzzle.getPuzzle().clone();
    }

    public int[][] getPuzzle()
    {
        return this.puzzle;
    }

    public int getCost()
    {
        int tmp = 0;

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(this.getPuzzle()[i][j] != this.goal[i][j] && this.getPuzzle()[i][j] != 0 )
                    tmp++;
            }
        }

        return tmp;
    }

    public void display()
    {
        System.out.println("+ - - - +");
        for(int i = 0; i < 3; i++ )
        {
            System.out.print("| ");
            for(int j = 0; j < 3; j++)
            {
                System.out.print( this.getPuzzle()[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+ - - - +");
    }

}
