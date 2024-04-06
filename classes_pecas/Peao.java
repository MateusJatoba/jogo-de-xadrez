package classes_pecas;

public class Peao extends Pecas {
	
	private int qntd_jogadas;
	


	public Peao(String cor , int id) {
		super(cor , id);
		setTipo("Peão"); 
		
	}
	
	public int getQntd_jogadas() {
		return qntd_jogadas;
	}
	
	public void setQntd_jogadas(int qntd_jogadas) {
		this.qntd_jogadas = getQntd_jogadas() + qntd_jogadas;
	}
	
	
	
	public void movimentacao(Tabuleiro t) {
		t.getMatriz()[getPosicaoLinha()][getPosicaoColuna()].setStatusoocupados(0);
		setPosicaoLinha(getPosicaoLinha() + 1);
		//validar
		//mostrar as casas possíveis para movimentação 
		t.getMatriz()[getPosicaoLinha()][getPosicaoColuna()].setStatusoocupados(1);
		t.getMatriz()[getPosicaoLinha()][getPosicaoColuna()].setPeca(this);
		System.out.println("");
		
	}
	
	 

}
