package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
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

	// Instanciamos um objeto do tipo conta controller e a partir disso temos
	// acessos a todos os métodos que existem em ContaController
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

		/*
		 * CRIAMOS CONTA CORRENTE E CONTA POUPANÇA // Instanciar objetos da Classe
		 * ContaCorrente e testando essa nova classe que é // uma extensão de Conta
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
		//Criando conta 1 e 2 para testarmos
		criarContasTeste();

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND
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
			System.out.println("            9 - Procurar pelo Títular da Conta       ");
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
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				cadastrarConta();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				procurarContaPorNumero();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				atualizarConta();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				deletarConta();
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				sacar();
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				depositar();
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				transferir();
				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE + "Procurar pelo Títular da Conta\n\n");
				procurarPorTitular();
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

	// Criamos esse método para ele parar de exibir o menu sem deixar o usuário ler,
	// nele só continua quando o usuário der um Enter
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\nPressione Enter para continuar...");
		leia.nextLine();
	}

	// Criamos um método e dentro dele nós trouxemos o método cadastrar de
	// ContaController
	private static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Nívea Fogaça", 1000000.00f, 100000.00f));
		contaController
				.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 253, 2, "Carmen Campos", 800000.00f, 20));
	}

	// Apenas criamos um método para listarmos as contas usando o método listar de
	// ContaController
	private static void listarContas() {
		contaController.listarTodas();
	}

	// Agora vamos adicionar o método para cadastro
	private static void cadastrarConta() {
		System.out.print("Digite o número da Agência: ");
		int agencia = leia.nextInt();

		System.out.print("Digite o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.print("Digite o Tipo da conta (1 - CC | 2 - CP ): ");
		int tipo = leia.nextInt();

		System.out.print("Digite o Saldo inicial: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.print("Digite o Limite inicial: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.print("Digite o Aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
		}
	}

	private static void procurarContaPorNumero() {

		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procutarPorNumero(numero);
	}

	private static void deletarConta() {

		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) {
			
			System.out.print("\nTem certeza quue deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();
			
			if (confirmacao.equalsIgnoreCase("S")) {
				contaController.deletar(numero);
			} else {
				System.out.println("\nOperação cancelada!");
			}
			
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!%n", numero);
		}

	}
	
	private static void atualizarConta() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) {
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			
			System.out.printf("Agência atual: %d\nNova Agência (Pressione ENTER para manter o valor atual): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
			//If ternário (quando temos só duas condições. Antes da "?" é a condição, o que está depois é o que eu quero que faça
			//Aqui estamos convertendo porque a ideia é não precisar criar uma variável para cada caso! :)
			
			System.out.printf("Titular atual: %s\nNovo Títular (Pressione ENTER para manter o nome atual):", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
			

			System.out.printf("Saldo atual: %.2f\nNovo Saldo (Pressione ENTER para manter o valor atual):", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);
			
			
			switch (tipo) {
			case 1 -> {
				//Casting: Converter um objeto para outro tipo de objeto (Conta -> Conta Corrente)
				//Transforma Conta em Conta corrente
				//Colocanco só conta.get não conseguimos encontrar o Get Limite
				float limite = ((ContaCorrente) conta).getLimite();
				
				System.out.printf("Limite atual: %.2f\nNovo Limite (Pressione ENTER para manter o valor atual): ", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			}
			case 2 -> {
				int aniversario = ((ContaPoupanca) conta).getAniversario();
				
				System.out.printf("Aniversário atual da conta: %d\nNovo Aniversário da conta (Pressione ENTER para manter o valor atual): ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
			}
			
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!%n", numero);
		}

	}
	
	private static void sacar () {

		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor do saque: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		
		contaController.sacar(numero, valor);
	}
	
	private static void depositar () {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor do depósito: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		
		contaController.depositar(numero, valor);
	}
	
	private static void transferir () {
		System.out.print("Digite o número da conta de origem: ");
		int numeroOrigem = leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o número da conta de destino: ");
		int numeroDestino= leia.nextInt();
		leia.nextLine();
		
		System.out.print("Digite o valor da transferência: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		
		contaController.transferir(numeroOrigem, numeroDestino, valor);
	}
	
	private static void procurarPorTitular () {
		System.out.print("Digite o nome do títular da conta: ");
		String titular = leia.nextLine();


		contaController.listarPorTitular(titular);
		
	}
}