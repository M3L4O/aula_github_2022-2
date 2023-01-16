import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Cliente.Cliente;
import Conta.Conta;


public class Main {
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Adicionar Conta", "Sair"));
	while(true) {
		
		switch (mainMenu.getSelection()) {
			case 1:
				Scanner s = new Scanner(System.in);
				System.out.println("Digite o seu nome:");
				String name = s.nextLine();
				System.out.println("Digite o seu cpf:");
				String cpf = s.nextLine();
				Cliente cliente = new Cliente(name, cpf);
				clientes.add(cliente);
				break;
			case 2:
				System.out.println("Fim");
				return;
			default:
				break;
		}
		
	}
	}
}