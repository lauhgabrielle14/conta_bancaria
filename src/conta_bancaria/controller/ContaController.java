package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Criamos um ArrayList para as contas
	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void listarTodas() {
		// Aqui vamos mostrar todas as contas nesse laço de repetição
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		// Aqui fizemos o comando para adicionar essa conta no nosso ArrayList
		listaContas.add(conta);
		System.out.println("\n✅ Conta Cadastrada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());

		if (buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta);
			System.out.printf("\nA conta número: %d foi atualizada com sucesso!%n", conta.getNumero());
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!%n", numero);
		}

	}

	@Override
	public void procutarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!%n", numero);
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.printf("\nA conta número %d foi deletada com sucesso!%n", numero);
			}
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!%n", numero);
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (conta.sacar(valor) == true) {
				System.out.printf("\nO saque no valor de %.2f, na conta número %d foi efetuado com sucesso!", valor,
						numero);
			}
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!%n", numero);
		}

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.printf("\nO deposito no valor de %.2f, na conta número %d foi efetuado com sucesso!", valor,
					numero);
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!%n", numero);
		}

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.printf("\nA transferência no valor de R$%.2f da conta número %d para a conta número %d foi efetuado com sucesso!", valor, numeroOrigem, numeroDestino);
			}
		} else {
			System.out.println("\nA conta de origem e/ou a de destino não foram encontrada(s)!%n");
		}

	}	
	
	@Override
	//Aplicando Streams
	public void listarPorTitular(String titular) {
		List<Conta> listaTitulares = listaContas.stream().filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase())).collect(Collectors.toList());
		
		if(listaTitulares.isEmpty()) {
			System.out.printf("\nNenhuma conta foi encontrada para titulares que possuam o nome: %s", titular);
		}
		//for each
		for(var conta : listaTitulares) {
			conta.visualizar();
		}
	}

	// Métodos Auxiliares

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;// Quando ele acha, nesse return ele sai do método
			}
		}
		return null;
	}



}
