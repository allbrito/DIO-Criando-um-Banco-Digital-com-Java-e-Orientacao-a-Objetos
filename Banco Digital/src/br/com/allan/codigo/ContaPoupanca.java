package br.com.allan.codigo;

public class ContaPoupanca extends Conta{

    private static final double taxaSaque = 0.02;

    public ContaPoupanca(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public boolean sacar(double valor) {
        valor += taxaSaque*valor;
        return super.sacar(valor);
    }
}
