package org.dio.diobank;

import lombok.*;

@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    private double saldo;
    private Pessoa titular;

    protected void exibirSaldo() {
        System.out.printf("Saldo atual: R$%.2f\n", this.saldo);
    }

    protected boolean depositar(double deposito) {
        boolean depositoRealizado;
        if (deposito > 0) {
            this.saldo += deposito;
            depositoRealizado = true;
        } else {
            System.out.println("Não é possivel realizar saques menores ou iguais a 0!");
            depositoRealizado = false;
        }
        return depositoRealizado;
    }

    protected boolean sacar(double saque) {
        boolean saqueRealizado;
        if (saque > this.saldo) {
            System.out.println("Saldo insuficiente");
            saqueRealizado = false;
        } else if (saque <= 0) {
            System.out.println("Não é possivel realizar saques menores ou iguais a 0!");
            saqueRealizado = false;
        } else {
            this.saldo -= saque;
            saqueRealizado = true;
        }
        return saqueRealizado;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }
}
