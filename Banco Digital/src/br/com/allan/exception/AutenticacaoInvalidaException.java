package br.com.allan.exception;

public class AutenticacaoInvalidaException extends RuntimeException{

    public AutenticacaoInvalidaException() {
        System.out.println("Login ou Senha invalido, tente novamente!");
    }
}
