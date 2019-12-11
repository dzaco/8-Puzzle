package com.giedron;

import java.util.ArrayList;
import java.util.List;

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

    }
}
