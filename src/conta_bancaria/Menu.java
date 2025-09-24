package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;
		
		//Instanciar objetos da Classe Conta
		//Primeiro criar a variável que será o tipo do nosso obejto
		//Conta é o tipo, c1 o nome e passamos os dados da minha conta (Aqueles que criamos como modelo dentro de Conta
		//O f é porque é float
		
		Conta c1 = new Conta(1, 123, 1, "Lauren Fogaça", 500000.00f);
		//Vamos testar criar outra conta
		Conta c2 = new Conta(2, 123, 2, "Vitor Fogaça", 500000.00f);
		
		//O que estamos fazendo é encapsulamento, protegendo os atributos para serem manupilados apenas com Get e Set
		//Testando se nossa criação de objeto deu certo
		//Usamos o Get para acessarmos o valor
		System.out.println("O saldo da conta eh: " + c1.getSaldo());
		
		//Testando mudar o atributo com o método Set
		c1.setSaldo(600000.00f);
		
		System.out.println("O saldo da conta eh: " + c1.getSaldo());
		
		//Para visualizarmos todos os dados, teriamos que fazer 5 sysouts para ver, o que não é viável
		//Então vamos criar um método para visualizarmos tudo (Lá na Classe CONTA).
		c1.visualizar();
		c2.visualizar();
		
		System.out.println("\n");
		
		System.out.println(c1.sacar(1000));
		System.out.println("O saldo da conta eh: " + c1.getSaldo());
		
		System.out.println(c2.sacar(1000000));
		System.out.println("O saldo da conta eh: " + c2.getSaldo());
		
		c1.depositar(5000);
		System.out.println("\nO saldo da conta eh: " + c1.getSaldo());
		
		//Instanciar objetos da Classe ContaCorrente e testando essa nova classe que é uma extensão de Conta
		
		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Nívea Fogaça", 1000000.00f, 100000.00f);
		cc1.visualizar();
		
		System.out.println(cc1.sacar(2000000.00f));
		cc1.visualizar();
		
		System.out.println(cc1.sacar(2000.00f));
		cc1.visualizar();
		
		cc1.depositar(5000.00f); //Não usamos o print porque ele é método void (Vazio, não retorna valor! Ele vai fazer e não vai te devolver nada. Diferente do método sacar que é um boolean, ou retorna que deu certo ou que não deu)
		cc1.visualizar();
		
		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    BANCO DA SAPI                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_CYAN);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE + "\nBanco da Sapi - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLACK + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_BLACK + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_BLACK + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_BLACK + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Lauren Gabrielle Fogaça");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/lauhgabrielle14");
		System.out.println("*********************************************************");
	}

}