package entities;

public class Empregado {
	private Integer id;
	private String nome;
	private Double salario;
	
	public Empregado(Integer id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	public Integer getId() {
		return id;
	}

	
	public Double getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return id + ", " + nome + ", " + String.format("%.2f", salario);
	}
	
	public void incrementoDeSalario(double porcent) {
		salario += salario * porcent / 100;
	}
	
	public void listaEmpregado() {
		System.out.println(this.id + ", " + this.nome + ", " + this.salario);
	}

}
