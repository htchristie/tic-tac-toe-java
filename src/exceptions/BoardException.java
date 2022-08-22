package exceptions;

public class BoardException extends RuntimeException {

    // repassa a mensagem de erro pro construtor do suoer
    public BoardException(String msg) {
        super(msg);
    }
}
