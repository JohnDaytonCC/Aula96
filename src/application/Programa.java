package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Empregado;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		//List<String> nomeEmpregados = new ArrayList<>();
		//List<Integer> idEmpregados = new ArrayList<>();
		List<Empregado> lista = new ArrayList<>();
		//Empregado EmpregadoObjeto = new Empregado();
		
		
		System.out.print("Quantos empregados serão registrados? ");
		int n = input.nextInt();
		
		
		for(int i=0; i<n; i++) {
			System.out.println("\nEmpregado "+ (i + 1) +":");
			System.out.print("Id: ");
			Integer id = input.nextInt();
			while(verificarId(lista,id)) {
				System.out.println("Este Id já existe, por favor digite um outro Id: ");
				id = input.nextInt();
			}
			//idEmpregados.add(id);
			
			System.out.print("Nome: ");
			input.nextLine();
			String nome = input.nextLine();
			//nomeEmpregados.add(nome);
			
			System.out.print("Salário: ");
			Double salario = input.nextDouble();
			//salariosEmpregados.add(salario);
			
			lista.add(new Empregado(id,nome,salario));
		}
		
		System.out.print("\nEntre com o ID do empregado que será incrementado: ");
		int idProcurado = input.nextInt();
		Empregado local = lista.stream().filter(x -> x.getId() == idProcurado).findFirst().orElse(null);
		
		// ============ Parte da segunda solução possível ========================
		//Integer local = procurarId(lista,idProcurado);
		
		if(local == null) {
			System.out.println("Este ID não existe!");
		} else {
			System.out.print("Entre com a porcentagem de aumento: ");
			double porcentagem = input.nextDouble();
			local.incrementoDeSalario(porcentagem);
		}
		
		// ============ Parte da segunda solução possível ========================
		/*
		 * if(loca == null){
		 * 		System.out.println("Este ID não existe!");
		 * } else {
		 * 		System.out.print("Entre com a porcentagem: ");
		 * 		double porcentagem = input.nextDouble();
		 * 		lista.get(local).inrementoDeSalario(porcentagem);
		 */
		
		
		System.out.println("\nLista dos empregados:\n");
		for(Empregado x: lista) {
			System.out.println(x);
		}
		
		input.close();
	}
	
	// Função para encontrar o ID do empregado sem utilizar uma função lambda. 
	// ============ Parte da segunda solução possível ========================
	public static Integer procurarId(List<Empregado> lista, int id) {
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean verificarId(List<Empregado> lista,int id) {
		Empregado emp = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
