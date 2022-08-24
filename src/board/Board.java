package board;

import exceptions.BoardException;

public class Board {
    private int rows;
    private int columns;
    private Symbol[][] symbols;

    public Board(int rows, int columns) {
        //não permite a criação de tabuleiros que não sejam 3x3
        if (rows != 3 || columns != 3) {
            throw new BoardException("Board should be a 3x3 grid.");
        }

        this.rows = rows;
        this.columns = columns;
        symbols = new Symbol[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // retorna o que há no campo [row][column]
    public Symbol findSymbol(int row, int column) {
        //lança uma exceção se a posição não existir
        if (!positionExists(row, column)) {
            throw new BoardException("The position you're trying to access doesn't exist.");
        }

        return symbols[row][column];
    }

    // retorna o que há no campo [position.getRow()][position.getColumn()]
    public Symbol findSymbol(Position position) {
        //lança uma exceção se a posição não existir
        if (!positionExists(position)) {
            throw new BoardException("The position (" + position + ") doesn't exist.");
        }

        return symbols[position.getRow()][position.getColumn()];
    }

    // insere símbolo no array symbols[][] e define sua posição
    public void placeSymbol(Symbol symbol, Position position) {
        //lança uma exceção se o campo já tiver algum símbolo
        if (isThereASymbol(position)) {
            throw new BoardException("The position (" + position + ") is already taken.");
        }

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
        //lança uma exceção se a posição não existir
        if (!positionExists(position)) {
            throw new BoardException("The position (" + position + ") doesn't exist.");
        }

        return findSymbol(position) != null;
    }
}
