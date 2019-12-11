package com.giedron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private Puzzle puzzle;
    private List<Puzzle> children = new ArrayList<>();
    private int level;

    public Node( Puzzle puzzle , int level)
    {
        this.puzzle = new Puzzle( puzzle.getPuzzle().clone() );
        this.level = level;
    }

    public void generateChildren()
    {
        Pair blank = this.puzzle.getBlank();

        Map<String , Pair> moves = new HashMap<>();
        moves.put("bottom" ,    new Pair(1, 0) );
        moves.put("left" ,      new Pair(0, -1));
        moves.put("top" ,       new Pair(-1, 0) );
        moves.put("right" ,     new Pair(0, 1)  );

        if(blank.col() == 0)
            moves.remove("left");
        if(blank.col() == 2)
            moves.remove("right");
        if(blank.row() == 0)
            moves.remove("top");
        if(blank.row() == 2)
            moves.remove("bottom");

        for( Pair move : moves.values() )
        {
            Puzzle puzzle = this.puzzle.copy();
            puzzle = puzzle.moveBlankTo(move);
            this.children.add(puzzle);
        }

    }

    public Puzzle getPuzzleWithMinVal()
    {
        int min = Integer.MAX_VALUE;
        Puzzle minPuzzle = this.children.get(0).copy();

        for( Puzzle child : this.children )
        {
            if(child.getCost() < min)
            {
                min = child.getCost();
                minPuzzle = child;
            }
        }

        return minPuzzle;
    }

}
