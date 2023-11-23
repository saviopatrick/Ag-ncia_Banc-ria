package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }
    public static void operacoes(){
        System.out.println("-----------------------------------------------");
        System.out.println("-------------------Bem vindos------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("---Selecione a operação que deseja realizar----");
        System.out.println("-----------------------------------------------");
        System.out.println("|   Opção 1 - Criar Conta    |");
        System.out.println("|   Opção 2 - Depositar      |");
        System.out.println("|   Opção 3 - Sacar          |");
        System.out.println("|   Opção 4 - Transferir     |");
        System.out.println("|   Opção 5 - Listar         |");
        System.out.println("|   Opção 6 - Sair           |");

        int operacao = input.nextInt();

        switch (operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                tranferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigado Ppor usar nosso serviços");
                System.exit(0);
            default:
                System.out.println("Opção invalida");
                operacoes();
                break;
        }
    }

    public static void criarConta(){
        System.out.println("\nNome:");
        String nome = input.nextLine();

        System.out.println("\nCPF:");
        String cpf = input.nextLine();

        System.out.println("\nEmail:");
        String email = input.nextLine();

        Pessoa pessoa = new Pessoa(nome,cpf,email);

        Conta conta = new Conta(pessoa);
        contasBancarias.add((conta));
        System.out.println("Sua conta foi criada com sucesso");

        operacoes();
    }
    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if (contasBancarias.size() > 0){
            for (Conta c: contasBancarias){
                if (c.getNumConta() == numeroConta);
                conta = c;
            }
        }
        return conta;
    }
    private static void depositar(){
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if (conta != null){
            System.out.println("Qual o valor do deposito");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso");

        }
        else {
            System.out.println("conta nao foi encontrada");
        }
        operacoes();
    }
    public static void sacar(){
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if (conta != null){
            System.out.println("Qual o valor do sacar");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Valor do saque com sucesso");

        }
        else {
            System.out.println("conta nao foi encontrada");
        }
        operacoes();

    }
    public static void tranferir(){
        System.out.println("Numero da conta do remetente");
        int numeroContaRemet = input.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemet);
        if (contaRemetente != null){
            System.out.println("Numero da conta do destinatario");
            int numContaDest = input.nextInt();
            Conta contaDestinatario = encontrarConta(numContaDest);

            if (contaDestinatario != null){
                System.out.println("valor da transferencia");
                double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario,valor);
            }

        }
        operacoes();
    }
    public static void listar(){
        if (contasBancarias.size() > 0){
            for (Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }
        else {
            System.out.println("nao ha conta cadrastada");
        }
        operacoes();
    }

}
