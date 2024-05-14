package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		System.out.println("Processo Seletivo");
		String [] candidatos ={"FELIPE","FABRÍCIO","MIRELA","DANIELA","JORGE"};
		for(String candidato: candidatos) {
			entrandEmContato(candidato);
		}
		
	}
	
	static void entrandEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("Contato Realizado com Sucesso!");
		}while(continuarTentando && tentativasRealizadas<3);
		
			if(atendeu)
				System.out.println("Conseguimos contato com "+ candidato + " na " +tentativasRealizadas+ " tentativa");
			else
				System.out.println("Não conseguimos contato com o " + candidato +", número maximo de tentativas (" + tentativasRealizadas + ") realizada");
		
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos ={"FELIPE","FABRÍCIO","MIRELA","DANIELA","JORGE"};
		System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
		for(int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de numero "+ (indice + 1) + " é " + candidatos[indice]);
		}
		
		System.out.println("Forma abreviada da iteração for each");
		for(String candidato: candidatos) {
			System.out.println("O candidato selecionado foi " + candidato );
		}
	}
	
	static void selecaoDeCandidatos() {
		String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " solicitou este valor de salario: " + salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato "+ candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double pretensaoSalarial) {
		double salarioBase = 2000.0;
		if(salarioBase > pretensaoSalarial) {
			System.out.println("Ligar para o candidato");
		}
		else if(salarioBase == pretensaoSalarial) {
			System.out.println("Aguardar o resultado dos demais candidatos");
		}
		else {
			System.out.println("Ligar para o candidato com contra proposta");
		}
	}
}
