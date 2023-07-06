package br.com.allan.exception;

public class DestinoInvalidoException extends RuntimeException{

    public DestinoInvalidoException() {
        System.out.println("Essa conta nao existe, tente novamente!");
    }
}
