package conta_bancaria.model;

public class ContaPoupanca extends Conta {
	
	private int aniversario;
	private float limite;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar (float valor) {
		if(this.getSaldo() + this.getLimite() < valor) {
		System.out.println("\nSaldo Insuficiente!");	
		return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		
		return true;
	}
	
	@Override
	public void visualizar () {
		super.visualizar();
		System.out.printf("Aniversário da Conta Poupança: Dia %d de todo mês%n", this.aniversario);
	}
}
