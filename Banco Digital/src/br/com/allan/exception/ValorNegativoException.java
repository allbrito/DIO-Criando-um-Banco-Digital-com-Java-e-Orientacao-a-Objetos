package br.com.allan.exception;

public class ValorNegativoException extends RuntimeException{

    public ValorNegativoException() {
        System.out.println("O valor digitado não deve ser negativo, tente novamente!");
    }
}
