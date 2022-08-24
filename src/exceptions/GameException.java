package exceptions;

public class GameException extends BoardException{

    // repassa a mensagem de erro pro construtor do super
    public GameException(String msg) {
        super(msg);
    }
}
