package classes_pecas;



public class Casa {
	
	//Atributos da Casa
	private int coordenadaLinha;
	private int coordenadaColuna;
	private int Statusoocupados;
	private Pecas peca;
	
	
	//Construtor Casa setando 0 para Statusocupado, simbolizando que a casa - quando construída - está vazia
	public Casa() {
		this.Statusoocupados = 0;
	}
	
	
	//getters e setters
	
	
	public Pecas getPeca() {
		return peca;
	}

	public void setPeca(Pecas peca) {
		this.peca = peca;
	}

	public int getCoordenadaLinha() {
		return coordenadaLinha;
	}
	public void setCoordenadaLinha(int coordenadaLinha) {
		this.coordenadaLinha = coordenadaLinha;
	}
	public int getCoordenadaColuna() {
		return coordenadaColuna;
	}
	public void setCoordenadaColuna(int coordenadaColuna) {
		this.coordenadaColuna = coordenadaColuna;
	}
	public int getStatusoocupados() {
		return Statusoocupados;
	}
	public void setStatusoocupados(int statusoocupados) {
		Statusoocupados = statusoocupados;
	}
	
	
	
	
}
