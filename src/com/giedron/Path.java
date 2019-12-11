package com.giedron;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<Node> path = new ArrayList<>();

    public void add(Node node)
    {
        path.add(node);
    }

    public void displayPath()
    {
        for(Node node : path )
        {
            System.out.print("Node: " + node.getLevel() + " ");
            System.out.println("Cost: " + node.getPuzzle().getCost() );
            node.display();
            System.out.println("====== >>> ");
        }
    }
}
