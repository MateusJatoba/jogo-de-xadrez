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
	
	
	public int movimentacao() {
		setQntd_jogadas(1);
		
		if(getQntd_jogadas() == 1) {
			return 2;
		}
		
		else {
			return 1;
		}
	}
	
	 

}
