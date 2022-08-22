package board;

public class Position {

    // utiliza a posição da matriz ex. [0][1]
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // define posição
    public void setPosition(int row, int column) {
        setRow(row);
        setColumn(column);
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
