import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import Cliente.Cliente;
import Conta.Conta;


public class Main {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", 
			Arrays.asList("Adicionar Cliente", "Criar Conta", "Remover Cliente","Sacar", "Sair"));
		
		Scanner s = new Scanner(System.in);
		String cpf;
		Cliente cliente;

		while(true) {

			switch (mainMenu.getSelection()) {
				case 1:
					System.out.println("Digite o seu nome:");
					String name = s.nextLine();
					System.out.println("Digite o seu cpf:");
					cpf = s.nextLine();
					cliente = new Cliente(name, cpf);
					clientes.add(cliente);
					break;
				case 2:
					System.out.println("Digite o cpf do cliente para criar a conta:");
					cpf = s.nextLine();
					System.out.println("Digite o limite de crédito da conta:");
					Double limite = s.nextDouble();
					s.nextLine();
					cliente = findCliente(cpf);
					cliente.setConta(new Conta(limite));
					break;

				case 3:
					System.out.println("Digite o cpf do cliente para remover:");
					cpf = s.nextLine();
					removerCliente(cpf);
					break;

				case 4:
					System.out.println("Digite o seu CPF");
					cpf = s.nextLine();
					cliente = findCliente(cpf);
					if(cliente == null){
						System.out.println("Não foi possivel achar o cliente.");
					}
					Conta conta = cliente.getConta();
					System.out.println("Digite o quanto quer sacar:");
					Double valor = s.nextDouble();
					Boolean resultado = conta.sacar(valor);
					if (resultado){
						System.out.println("Você conseguiu sacar: R$" + valor);
					}else{
						System.out.println("Voce não conseguiu sacar.");
					}
				case 5:
					System.out.println("Fim");
					return;

				default:
					break;
			}

		}
	}

	private static void removerCliente(String cpf){
		clientes.removeIf(item -> item.getCpf().compareTo(cpf) == 0);
	}

	private static Cliente findCliente(String cpf){
		for (Cliente cliente : clientes) {
			if(cliente .getCpf().compareTo(cpf) == 0){
				return cliente;
			}
		}

		return null;
	}
}