package org.dio.diobank;

import lombok.*;

@Getter
@Setter
public class Pessoa {
    public String nome;
    public int idade;
    public Long _cpf;

    public Pessoa(String nome, int idade, Long _cpf) {
        this.nome = nome;
        this.idade = idade;
        this._cpf = _cpf;
    }

    @Override
    public String toString() {
        return "" +
                "Nome: " + nome + 
                "\nIdade: " + idade +
                "\nCPF: " + _cpf;
    }
}