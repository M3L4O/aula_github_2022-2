import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import Cliente.Cliente;


public class Main {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Adicionar Cliente", "Remover Cliente", "Sair"));
		
		Scanner s = new Scanner(System.in);
		String cpf;

		while(true) {

			switch (mainMenu.getSelection()) {
				case 1:
					System.out.println("Digite o seu nome:");
					String name = s.nextLine();
					System.out.println("Digite o seu cpf:");
					cpf = s.nextLine();
					Cliente cliente = new Cliente(name, cpf);
					clientes.add(cliente);
					break;
				case 2:
					System.out.println("Digite o cpf do cliente para remover:");
					cpf = s.nextLine();

					removerCliente(cpf);
					break;
				case 3:
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