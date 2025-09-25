package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	// Colocamos ele aqui fora para ele se tornar global e
	// poder ser usado em qualquer método e definimos ele
	// como private static final (Final significa que ele
	// não será modificado, assim como quando criamos
	// constante)
	private static final ContaController contaController = new ContaController();
	//Instanciamos um objeto do tipo conta controller e a partir disso temos acessos a todos os métodos que existem em ContaController
	public static void main(String[] args) {

		int opcao;
		
		/*
		 * //Instanciar objetos da Classe Conta //Primeiro criar a variável que será o
		 * tipo do nosso obejto //Conta é o tipo, c1 o nome e passamos os dados da minha
		 * conta (Aqueles que criamos como modelo dentro de Conta //O f é porque é float
		 * 
		 * Conta c1 = new Conta(1, 123, 1, "Lauren Fogaça", 500000.00f); //Vamos testar
		 * criar outra conta Conta c2 = new Conta(2, 123, 2, "Vitor Fogaça",
		 * 500000.00f);
		 * 
		 * //O que estamos fazendo é encapsulamento, protegendo os atributos para serem
		 * manupilados apenas com Get e Set //Testando se nossa criação de objeto deu
		 * certo //Usamos o Get para acessarmos o valor
		 * System.out.println("O saldo da conta eh: " + c1.getSaldo());
		 * 
		 * //Testando mudar o atributo com o método Set c1.setSaldo(600000.00f);
		 * 
		 * System.out.println("O saldo da conta eh: " + c1.getSaldo());
		 * 
		 * //Para visualizarmos todos os dados, teriamos que fazer 5 sysouts para ver, o
		 * que não é viável //Então vamos criar um método para visualizarmos tudo (Lá na
		 * Classe CONTA). c1.visualizar(); c2.visualizar();
		 * 
		 * System.out.println("\n");
		 * 
		 * System.out.println(c1.sacar(1000));
		 * System.out.println("O saldo da conta eh: " + c1.getSaldo());
		 * 
		 * System.out.println(c2.sacar(1000000));
		 * System.out.println("O saldo da conta eh: " + c2.getSaldo());
		 * 
		 * c1.depositar(5000); System.out.println("\nO saldo da conta eh: " +
		 * c1.getSaldo());
		 */

		/* CRIAMOS CONTA CORRENTE E CONTA POUPANÇA
		 * // Instanciar objetos da Classe ContaCorrente e testando essa nova classe que
		 * é // uma extensão de Conta
		 * 
		 * ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Nívea Fogaça", 1000000.00f,
		 * 100000.00f); cc1.visualizar();
		 * 
		 * System.out.println(cc1.sacar(2000000.00f)); cc1.visualizar();
		 * 
		 * System.out.println(cc1.sacar(2000.00f)); cc1.visualizar();
		 * 
		 * cc1.depositar(5000.00f); // Não usamos o print porque ele é método void
		 * (Vazio, não retorna valor! Ele // vai fazer e não vai te devolver nada.
		 * Diferente do método sacar que é um // boolean, ou retorna que deu certo ou
		 * que não deu) cc1.visualizar();
		 * 
		 * // Instanciar objetos da Classe ContaPoupanca e testando a nossa classe que é
		 * // outra extensão de Conta
		 * 
		 * ContaPoupanca cp1 = new ContaPoupanca(14, 253, 2, "Carmen Campos",
		 * 800000.00f, 20); cp1.visualizar();
		 * 
		 * System.out.println(cp1.sacar(1000000));
		 * System.out.println("O saldo da conta eh: " + cp1.getSaldo());
		 * 
		 * cp1.depositar(5000); System.out.println("\nO saldo da conta eh: " +
		 * cp1.getSaldo());
		 * 
		 * System.out.println(cp1.sacar(200.00f)); cp1.visualizar();
		 */
		
		criarContasTeste();
		
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

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 8");
				// Se escrever uma letra ele vai detectar e
				// ao invés de aparecer aqueles erros
				// malucos, ele mostra o que doi
				// (Tratamento de erro)
				leia.nextLine();
			}
			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE + "\nBanco da Sapi - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLACK + "Criar Conta\n\n");
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_BLACK + "Listar todas as Contas\n\n");
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_BLACK + "Consultar dados da Conta - por número\n\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK + "Atualizar dados da Conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK + "Apagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK + "Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_BLACK + "Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK + "Transferência entre Contas\n\n");
				keyPress();
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
	//Criamos esse método para ele parar de exibir o menu sem deixar o usuário ler, nele só continua quando o usuário der um Enter
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\nPressione Enter para continuar...");
		leia.nextLine();
	}
	//Criamos um método e dentro dele nós trouxemos o método cadastrar de ContaController
	private static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(1, 456, 1, "Nívea Fogaça", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(14, 253, 2, "Carmen Campos", 800000.00f, 20));
	}
	//Apenas criamos um método para listarmos as contas usando o método listar de ContaController
	private static void listarContas() {
		contaController.listarTodas();
	}
}