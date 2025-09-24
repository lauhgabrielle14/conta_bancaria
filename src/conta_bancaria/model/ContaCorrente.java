package conta_bancaria.model;

public class ContaCorrente extends Conta {
	// Ou seja Conta corrente é uma extenção de Conta (Ou seja Conta corrente é
	// herança de Conta e Conta herda Conta Corrente
	// Regra importante: Java não aceita herança múltipla
	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		// Clicamos na correçãod e criar o contrutor e adicionamos o float limite que é
		// um atributo desta classe

		super(numero, agencia, tipo, titular, saldo); // Aqui trazemos o que é de conta
		this.limite = limite; // Aqui adicionamos o que é específico de uma conta corrente
	}

	//Aqui precisamos gerar o Get e Set de limite que ainda não existe
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	//Copiamos a estrutura do método sacar e mudamos as variaveis "this." para "this.get ou this.set" porque a classe ContaCorrente não possuí estes atributos, estamos extendendo
	public boolean sacar (float valor) {//Boolean porque o saque pode dar certo ou não (True ou False)
		if(this.getSaldo() + this.getLimite() < valor) {
		System.out.println("\nSaldo Insuficiente!");	
		return false; //A operação não deu certo
		}
		
		this.setSaldo(this.getSaldo() - valor);//Aqui usamos set para alterar o saldo
		
		return true;
	}
	
	@Override //Isso indica que o método Visualizar que já existe está sendo sobreescrito da Super Classe (Que é a classe Conta). Isso é um indicador, é uma boa prática para que quem leia o código entenda
	public void visualizar () {
		super.visualizar();
		System.out.printf("Limite da Conta: R$ %.2f%n", this.limite);
	}

}
