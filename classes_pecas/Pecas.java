package classes_pecas;

public class Pecas {

	private String cor;
	private String tipo;
//	private int posicao;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pecas(String cor , int id) {
		this.cor = cor;
		this.id = id;
	}
	
	public Pecas(String cor , String tipo , int id) {
		this.cor = cor;
		this.tipo = tipo;
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
}
