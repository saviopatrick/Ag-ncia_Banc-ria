package Programa;

import Ultilitarios.Ultis;

import javax.swing.*;

public class Conta {
    private static int contadorDeContas;
    private int numConta;
    private Pessoa pessoa;
    private double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numConta = numConta;
        this.pessoa = pessoa;
        contadorDeContas += 1;

    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "\nNumero da conta:" + this.getNumConta() +
                "\nNome:" + this.pessoa.getNome() +
                "\nCpf:" + this.pessoa.getCpf() +
                "\nEmail:" + this.pessoa.getEmail()+
                "\nSaldo:" + Ultis.doubleToString(this.getSaldo())+
                "\n";
    }

    public void depositar(Double valor){
        if (valor > 0){
            setSaldo(getSaldo()+valor);
            System.out.println("Seu deposito foi realizado com sucesso");

        }
        else {
            System.out.println("Não foi possivel realizar deposito");
        }
    }
    public void sacar(Double valor){
        if ( valor >0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi realizado com sucesso");
        }
        else {
            System.out.println("Não foi possivel realizar saque");
        }
    }
    public void transferir(Conta contaParaDeposito, Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso");

        }
        else {
            System.out.println("Não foi possivel realizar a transferencia");
        }
    }
}
