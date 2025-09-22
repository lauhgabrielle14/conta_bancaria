package conta_bancaria.model;

public class Conta {
	//Atributos da Classe
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	//Método Construtor
	//Clicamos em Source, depois em Generate Constructor Using Filds, depois selecionando todas nossas variáveis.
	//Recebe os parametros e armazena nos atributos do objeto, ou seja, usamos ele para construir os objetos.
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	//Métodos Get e Set
	//Clicamos em Source, Generate Getters and Setters e selecionamos tudo.
	//Os atributos são privados, ou seja, só podemos usá-los dentro dessa classe. Para poder usar eles fora, usamos o Get (Pega o valor) e Set (Altera o valor)
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public boolean sacar (float valor) {//Boolean porque o saque pode dar certo ou não (True ou False)
		if(this.saldo < valor) {
		System.out.println("\nSaldo Insuficiente!");	
		return false; //A operação não deu certo
		}
		
		this.saldo = this.saldo - valor;
		
		return true;
	}
	
	public void depositar (float valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void visualizar() {
		//Vamos fazer o método interpretar o que significa o int tipo de conta
		//e retornar de forma mais clara
		
		String tipo = "";
		
		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente"; //Outro tipo de Switch Case (é um Switch Case Lambda, é mais sintético)
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Desconhecido";
		}
		
		System.out.println("\n****************************");
		System.out.println("Dados da Conta");
		System.out.println("****************************");
		System.out.printf("Numero da conta: %d%n", this.numero);
		System.out.printf("Numero da agencia: %d%n", this.agencia);
		System.out.printf("Tipo da conta: %s%n", tipo); 
		System.out.printf("Titular da conta: %s%n", this.titular);
		System.out.printf("Saldo da conta: %.2f%n", this.saldo);
	}
	

}
