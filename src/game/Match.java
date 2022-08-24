package game;

import board.Board;
import board.Position;

import java.util.*;

public class Match {
    private Board board;
    private Type currentPlayer;
    private boolean win;
    private boolean draw;
    private List<GamePosition> playerX = new ArrayList<>();
    private List<GamePosition> playerO = new ArrayList<>();
    private List<GamePosition[]> winningConditions = new ArrayList<>();

    // inicia partida com um tabuleiro 3x3
    public Match() {
        this.board = new Board(3, 3);
        currentPlayer = Type.X; //jogo inicia com o jogador X
        setWinningConditions(); //declara as condições de vitória
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

    // coloca o símbolo no tabuleiro, na posição de jogo passada pelo jogador
    public void placeNewSymbol(GamePosition position) {
        PlayerSymbol symbol = new PlayerSymbol(this.board, currentPlayer);
        Position field = position.toPosition(); //converte posição de tabuleiro para matriz
        board.placeSymbol(symbol, field);

        //adiciona posição no array do jogador correspondente
        if (currentPlayer == Type.X) {
            playerX.add(position);
        } else {
            playerO.add(position);
        }

        //se não tiver empate nem vitória, vai pro próximo turno
        if (checkWin()) {
            win = true;
        } else if (checkDraw()) {
            draw = true;
        } else {
            nextTurn();
        }
    }

    // muda de jogador e turno
    private void nextTurn() {
        currentPlayer = (currentPlayer == Type.O) ? Type.X : Type.O;
    }

    // checa se o array do jogador corresponde a alguma das condições de vitória
    public boolean checkWin() {
        for (GamePosition[] arr: winningConditions) {
            if (new HashSet<>(playerX).containsAll(Arrays.asList(arr)) || new HashSet<>(playerO).containsAll(Arrays.asList(arr))) {
                return true;
            }
        }
        return false;
    }

    //define as condições de vitória, cada uma em seu array
    private void setWinningConditions() {
        GamePosition[] mainDiagonal = new GamePosition[board.getRows()];
        GamePosition[] secondaryDiagonal = new GamePosition[board.getRows()];
        GamePosition[] firstColumn = new GamePosition[board.getRows()];
        GamePosition[] secondColumn = new GamePosition[board.getRows()];
        GamePosition[] thirdColumn = new GamePosition[board.getRows()];
        GamePosition[] firstRow = new GamePosition[board.getRows()];
        GamePosition[] secondRow = new GamePosition[board.getRows()];
        GamePosition[] thirdRow = new GamePosition[board.getRows()];

        // diagonal principal
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(i, i);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            mainDiagonal[i] = pos2;
        }

        // diagonal secundária
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(i, 2 - i);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            secondaryDiagonal[i] = pos2;
        }

        // primeira coluna
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(i, 0);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            firstColumn[i] = pos2;
        }

        // segunda coluna
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(i, 1);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            secondColumn[i] = pos2;
        }

        // terceira coluna
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(i, 2);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            thirdColumn[i] = pos2;
        }

        // primeira linha
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(0, i);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            firstRow[i] = pos2;
        }

        // segunda linha
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(1, i);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            secondRow[i] = pos2;
        }

        // terceira linha
        for (int i = 0; i < board.getRows(); i++) {
            Position pos1 = new Position(2, i);
            GamePosition pos2 = GamePosition.fromPosition(pos1);
            thirdRow[i] = pos2;
        }

        winningConditions.add(mainDiagonal);
        winningConditions.add(secondaryDiagonal);
        winningConditions.add(firstColumn);
        winningConditions.add(secondColumn);
        winningConditions.add(thirdColumn);
        winningConditions.add(firstRow);
        winningConditions.add(secondRow);
        winningConditions.add(thirdRow);
    }

    //verifica se ocorreu empate - todos os campos preenchidos e nenhuma condição de vitória atingida
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
