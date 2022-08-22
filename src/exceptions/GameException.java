package exceptions;

public class GameException extends RuntimeException{

    // repassa a mensagem de erro pro construtor do suoer
    public GameException(String msg) {
        super(msg);
    }
}
