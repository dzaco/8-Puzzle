package com.giedron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private Puzzle puzzle;
    private List<Puzzle> children = new ArrayList<>();
    private int level;
    private Map<String , Pair> moves = new HashMap<>();

    public Node( Puzzle puzzle , int level)
    {
        this.puzzle = new Puzzle( puzzle.getPuzzle().clone() );
        this.level = level;

        this.moves.put("bottom" ,    new Pair(1, 0) );
        this.moves.put("left" ,      new Pair(0, -1));
        this.moves.put("top" ,       new Pair(-1, 0) );
        this.moves.put("right" ,     new Pair(0, 1)  );
    }

    public void generateChildren()
    {

    }
}
