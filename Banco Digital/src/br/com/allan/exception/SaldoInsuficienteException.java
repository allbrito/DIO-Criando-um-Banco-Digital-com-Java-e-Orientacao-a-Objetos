package br.com.allan.exception;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException() {
        System.out.println("Saldo Insuficiente, tente novamente!");
    }
}