package com.giedron;

import java.util.Objects;

public class Pair {
    private int row;
    private int col;

    public Pair( int row , int col )
    {
        this.row = row;
        this.col = col;
    }

    public int row()
    {
        return row;
    }
    public int col()
    {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row &&
                col == pair.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }


    @Override
    public String toString() {
        return "Pair{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
