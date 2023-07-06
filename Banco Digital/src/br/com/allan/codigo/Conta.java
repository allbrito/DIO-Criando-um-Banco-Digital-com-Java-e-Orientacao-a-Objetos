package br.com.allan.codigo;

import java.util.Random;

import br.com.allan.exception.AutenticacaoInvalidaException;
import br.com.allan.exception.SaldoInsuficienteException;
import br.com.allan.exception.ValorNegativoException;

public abstract class Conta implements IAutenticacao {

    private final int agencia = 27;
    private int numero;
    private double saldo;
    private int senha;
    private Cliente cliente;
    private static Random gerador;

    public Conta(String nome, String cpf) {
        this.numero = geradorNumerico();
        this.senha = geradorSenha();
        this.cliente = new Cliente(nome, cpf);
    }

    @Override
    public boolean autenticar(String login, int senha) {
        if (this.getCliente().getCpf() != login) {
            throw new AutenticacaoInvalidaException();
        }
        return login.equals(this.getCliente().getCpf()) && senha == this.senha;
    }

    @Override
    public boolean alterarSenha(int senha, int novaSenha) {
        if (this.getSenha() != senha) {
            throw new AutenticacaoInvalidaException();
        }
        return true;
    }

    public boolean sacar(double valor) {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException();
        } else if (valor < 1) {
            throw new ValorNegativoException();
        }
        this.saldo -= valor;
        return true;
    }

    public boolean depositar(double valor) {
        if (valor < 1) {
            throw new ValorNegativoException();
        }
        this.saldo += valor;
        return true;
    }

    private int geradorNumerico() {
        gerador = new Random();
        return gerador.nextInt(9999, 100000);
    }

    private int geradorSenha() {
        gerador = new Random();
        return gerador.nextInt(999, 10000);
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getSenha() {
        return this.senha;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
}
