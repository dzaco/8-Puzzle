package com.giedron;

import java.util.HashMap;
import java.util.Map;

public class Puzzle implements Cloneable {

    private int [][] puzzle;
    private final int[][] goal = { {1,2,3} , {4,5,6} , {7,8,0} };
    private Map<String , Pair> moves = new HashMap<>();

    Puzzle(int[][] puzzle)
    {
        this.puzzle = new int[3][3];
        this.puzzle = puzzle.clone();
        this.initMoves();
    }

    public Puzzle( Puzzle puzzle )
    {
        this.puzzle = new int[3][3];
        this.puzzle = puzzle.getPuzzle().clone();
        this.initMoves();
    }

    private void initMoves()
    {
        this.moves.put("bottom" ,    new Pair(1, 0) );
        this.moves.put("left" ,      new Pair(0, -1));
        this.moves.put("top" ,       new Pair(-1, 0) );
        this.moves.put("right" ,     new Pair(0, 1)  );
    }

    int[][] getPuzzle()
    {
        return this.puzzle;
    }

    int getCost()
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

    private Pair getBlank()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(this.getPuzzle()[i][j] == 0)
                    return new Pair(i,j);
            }
        }

        return null;
    }


    Puzzle copy()
    {
        int tmp[][] = new int[3][3];

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                tmp[i][j] = this.getPuzzle()[i][j];
            }
        }
        return new Puzzle(tmp);
    }

    Puzzle moveBlankTo( Pair move )
    {
        Puzzle puzzle = this.copy(); //new Puzzle( this.getPuzzle().clone() );

        Pair blankCo = puzzle.getBlank();
        Pair toSwapCo = new Pair(blankCo.row() + move.row() , blankCo.col() + move.col() );

        int tmp = puzzle.getPuzzle()[toSwapCo.row()][toSwapCo.col()];

        puzzle.getPuzzle()[toSwapCo.row()][toSwapCo.col()] = 0;
        puzzle.getPuzzle()[blankCo.row()][blankCo.col()] = tmp;

        return puzzle;
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
