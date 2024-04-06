package classes_pecas;



public class Casa {
	private int coordenadaLinha;
	private int coordenadaColuna;
	private int Statusoocupados;
	private Pecas peca;
	
	
	public Casa() {
		this.Statusoocupados = 0;
	}
	
	
	
	public String getPeca() {
		return peca.getTipo();
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
