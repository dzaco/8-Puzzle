package com.giedron;

import java.util.ArrayList;
import java.util.List;

public class Puzzle implements Cloneable {

    private int [][] puzzle;
    private final int[][] goal = { {1,2,3} , {4,5,6} , {7,8,0} };

    Puzzle(int[][] puzzle)
    {
        this.puzzle = new int[3][3];
        this.puzzle = puzzle.clone();
    }

    public Puzzle( Puzzle puzzle )
    {
        this.puzzle = new int[3][3];
        this.puzzle = puzzle.getPuzzle().clone();
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

    public Pair getBlank()
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

    public boolean isGoal()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if( this.getPuzzle()[i][j] != this.goal[i][j] )
                    return false;
            }
        }
        return true;
    }

    public boolean isSolvable() {
        int[][] matrix = this.puzzle.clone();
        int count = 0;
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                array.add(matrix[i][j]);
            }
        }

        Integer[] anotherArray = new Integer[array.size()];
        array.toArray(anotherArray);

        for (int i = 0; i < anotherArray.length - 1; i++) {
            for (int j = i + 1; j < anotherArray.length; j++) {
                if (anotherArray[i] != 0 && anotherArray[j] != 0 && anotherArray[i] > anotherArray[j]) {
                    count++;
                }
            }
        }

        return count % 2 == 0;
    }
}
