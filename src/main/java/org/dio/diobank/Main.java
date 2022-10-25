package org.dio.diobank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome;
        int idade, op = 1;
        Long cpf = 0L;


        System.out.println("\n-----Bem vindo ao banco digital DIO-BANK----- ");
        System.out.print("Digite seu nome para iniciarmos: ");
        nome = in.nextLine();


        while (op != 0) {
            cpf = 0L;

            System.out.println("\n+----------------+");
            System.out.println("| 1. Criar conta |");
            System.out.println("| 2. Creditos    |");
            System.out.println("| 0. Sair        |");
            System.out.println("+----------------+");
            System.out.print("Escolha uma opção: ");
            op = in.nextInt();


            switch (op) {
                case 1:
                    System.out.println(nome);

                    System.out.print("Digite sua idade: ");
                    idade = in.nextInt();

                    while (size(cpf) != 11) {
                        System.out.print("Digite seu CPF: ");
                        cpf = in.nextLong();
                    }
                    if (idade < 18) {
                        System.out.println("Não é possivel criar conta menor de 18");
                        break;
                    } else {
                        Conta minhaConta = new Conta();
                        minhaConta.setTitular(new Pessoa(nome, idade, cpf));
                        minhaConta.setSaldo(0);
                        System.out.println("\nConta criada com sucesso");

                        realizarOperacoes(minhaConta);
                        break;
                    }
                case 2:
                    creditos();
                    break;
                case 0:
                    System.out.println("Obrigado por usar o sistema da DIO-BANK");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }


    private static void realizarOperacoes(Conta conta) {
        Scanner in = new Scanner(System.in);
        int op = -1;

        while (op != 9) {
            System.out.println("+----------------------------+");
            System.out.println("| 1. Mostrar Saldo           |");
            System.out.println("| 2. Depositar               |");
            System.out.println("| 3. Sacar                   |");
            System.out.println("| 4. Exibir dados do usuário |");
            System.out.println("| 9. Voltar                  |");
            System.out.println("+----------------------------+");
            System.out.print("Escolha uma opção: ");
            op = in.nextInt();
            System.out.println();
            switch (op) {
                case 1:
                    exibirSaldo(conta);
                    break;
                case 2:
                    System.out.print("Digite o valor do deposito: ");
                    boolean depositoRealizado = conta.depositar(in.nextDouble());
                    System.out.println(depositoRealizado ? "Deposito realizado com sucesso" : "Falha ao depositar");
                    exibirSaldo(conta);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    boolean saqueRealizado = conta.sacar(in.nextDouble());
                    System.out.println(saqueRealizado ? "Saque realizado com sucesso" : "Falha ao sacar");
                    exibirSaldo(conta);
                    break;
                case 4:
                    System.out.println("Dados do usuário: ");
                    System.out.println(conta.getTitular());
                    break;
                case 9:
                    System.out.println("Saindo da conta...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void creditos() {
        System.out.println("\n+-------------------------------------+");
        System.out.println("| Desenvolvedor: Caio Rodrigo         |");
        System.out.println("| Linguagem desenvolvida: Java        |");
        System.out.println("| Versão do java: 17.0.3.1            |");
        System.out.println("| Desenvolvimento simples de um banco |");
        System.out.println("| digital para desafio de código da   |");
        System.out.println("| plataforma DIO.                     |");
        System.out.println("+-------------------------------------+");
    }

    private static int size(Long value) {
        int cont = 0;
        Long aux = value;
        while (aux > 0) {
            aux /= 10;
            cont++;
        }
        return cont;
    }

    private static void exibirSaldo(Conta conta) {
        System.out.printf("Saldo atual: R$%.2f\n", conta.getSaldo());
    }

}