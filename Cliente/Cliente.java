package Cliente;
import java.util.ArrayList;
import Conta.Conta;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void addConta(Conta conta){
        contas.add(conta);
    }

}

