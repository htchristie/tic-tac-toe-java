package game;

import board.Board;
import board.Position;

import java.util.*;

public class Match {
    private Board board;
    private Type currentPlayer;
    private boolean win;
    private boolean draw;
    private List<String> playerX = new ArrayList<>();
    private List<String> playerO = new ArrayList<>();
    List<String[]> winningConditions = new ArrayList<>();

    // inicia partida com um tabuleiro 3x3
    public Match() {
        this.board = new Board(3, 3);
        currentPlayer = Type.X;
        setWinningConditions();
    }

    public Board getBoard() {
        return board;
    }

    public Type getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isDraw() {
        return draw;
    }

    // array do tabuleiro passando as posições já preenchidas
    public PlayerSymbol[][] getSymbols() {
        PlayerSymbol[][] mat = new PlayerSymbol[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (PlayerSymbol) board.findSymbol(i, j);
            }
        }
        return mat;
    }

    // coloca o símbolo no tabuleiro, na posição de jogo passada
    public void placeNewSymbol(char column, int row, PlayerSymbol symbol) {
        board.placeSymbol(symbol, new GamePosition(column, row).toPosition());
    }

    // coloca o símbolo no tabuleiro, na posição de jogo passada pelo jogador
    public void placeNewSymbol(GamePosition position) {
        PlayerSymbol symbol = new PlayerSymbol(this.board, currentPlayer);
        Position field = position.toPosition();
        board.placeSymbol(symbol, field);
        GamePosition pos = GamePosition.fromPosition(field);

        if (currentPlayer == Type.X) {
            playerX.add(pos.toString());
        } else {
            playerO.add(pos.toString());
        }

        System.out.println(playerX);
        System.out.println(playerO);

        if (checkWin()) {
            win = true;
        } else if (checkDraw()) {
            draw = true;
        } else {
            nextTurn();
        }
    }

    // muda de jogador
    private void nextTurn() {
        currentPlayer = (currentPlayer == Type.O) ? Type.X : Type.O;
    }

    public boolean checkWin() {
        for (String[] arr: winningConditions) {
            if (new HashSet<>(playerX).containsAll(Arrays.asList(arr)) || new HashSet<>(playerO).containsAll(Arrays.asList(arr))) {
                return true;
            }
        }
        return false;
    }

    private void setWinningConditions() {
        String[] mainDiagonal = new String[board.getRows()];
        String[] secondaryDiagonal = new String[board.getRows()];

        // diagonal principal
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = (new Position(i, i));
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            mainDiagonal[i] = pos2.toString();
        }

        // diagonal secundária
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = (new Position(i, 2 - i));
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            secondaryDiagonal[i] = pos2.toString();
        }

        winningConditions.add(mainDiagonal);
        winningConditions.add(secondaryDiagonal);
    }

    /*public boolean checkWin() {
        List<Position[]> winningConditions = new ArrayList<Position[]>();

        Position[] mainDiagonal = new Position[board.getRows()];
        Position[] secondaryDiagonal = new Position[board.getRows()];

        // diagonal principal
        for (int i = 0; i < board.getRows(); i++) {
            mainDiagonal[i] = (new Position(i, i));
        }

        // diagonal secundária
        for (int i = 0; i < board.getRows(); i++) {
            secondaryDiagonal[i] = (new Position(i, 2 - i));
        }

        winningConditions.add(mainDiagonal);
        winningConditions.add(secondaryDiagonal);
        //winningConditions.add(firstRow);
        //winningConditions.add(secondRow);
        //winningConditions.add(thirdRow);
        //winningConditions.add(firstColumn);
        //winningConditions.add(secondColumn);
        //winningConditions.add(thirdColumn);

        winningConditions.stream().anyMatch(combination -> {
            for (Position pos: combination) {
                return playerX.contains(pos);
            }
        });

        winningConditions.stream().anyMatch(c -> playerX.containsAll());



        return false;
    }*/

    public boolean checkDraw() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.findSymbol(i, j) == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
