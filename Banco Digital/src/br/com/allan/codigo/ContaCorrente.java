package br.com.allan.codigo;

import br.com.allan.exception.DestinoInvalidoException;

public class ContaCorrente extends Conta {

    public ContaCorrente(String nome, String cpf) {
        super(nome, cpf);
    }

    public boolean transferir(double valor, Conta contaDestino) {
        if (contaDestino == null) {
            throw new DestinoInvalidoException();
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        return true;
    }
}
