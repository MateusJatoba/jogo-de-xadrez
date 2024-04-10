package classes_pecas;

public class Pecas {
	
	//Atributos de Peça
	private String cor;
	private String tipo;
	private int posicaoLinha;
	private int posicaoColuna;
	private int id;
	
	
	//Construtores de Peça
	
	//Construtor sem passar o tipo. Facilitando na criação das Subclasses
	public Pecas(String cor , int id) {
		this.cor = cor;
		this.id = id;
	}
	
	//Construtor com todos os atributos
	public Pecas(String cor , String tipo , int id) {
		this.cor = cor;
		this.tipo = tipo;
		this.id = id;
	}
	
	
	
	//Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getPosicaoLinha() {
		return posicaoLinha;
	}

	public void setPosicaoLinha(int posicaoLinha) {
		this.posicaoLinha = posicaoLinha;
	}

	public int getPosicaoColuna() {
		return posicaoColuna;
	}

	public void setPosicaoColuna(int posicaoColuna) {
		this.posicaoColuna = posicaoColuna;
	}
}
