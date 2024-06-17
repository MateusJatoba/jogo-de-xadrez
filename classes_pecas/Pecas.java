
package classes_pecas;

import java.util.ArrayList;
import java.util.List;

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
	
	// Método para calcular as possibilidades de movimento da peça a partir de sua posição atual
    public List<int[]> calcularPossibilidades(int coluna, int linha) {
        return new ArrayList<>(); // Por padrão, retornamos uma lista vazia
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
