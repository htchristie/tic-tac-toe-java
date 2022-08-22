package board;

public class Board {
    private int rows;
    private int columns;
    private Symbol[][] symbols;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        symbols = new Symbol[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    // retorna o que há na casa [row][column]
    public Symbol findSymbol(int row, int column) {
        return symbols[row][column];
    }

    // retorna o que há na casa [position.getRow()][position.getColumn()]
    public Symbol findSymbol(Position position) {
        return symbols[position.getRow()][position.getColumn()];
    }

    // insere símbolo no array symbols[][] e define a posição do símbolo passado
    public void placeSymbol(Symbol symbol, Position position) {
        symbols[position.getRow()][position.getColumn()] = symbol;
        symbol.position = position;
    }

    // checa se a posição [row][column] existe no tabuleiro
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // checa se a posição position existe no tabuleiro
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    // checa se a casa na posição position está ocupada
    public boolean isThereASymbol(Position position) {
        return findSymbol(position) != null;
    }
}
