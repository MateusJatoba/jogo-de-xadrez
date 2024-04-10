package classes_pecas;

public class Peao extends Pecas {
	
	//Atributo adicional
	private int qntd_jogadas;
	

	//Construtor do Peao
	public Peao(String cor , int id) {
		super(cor , id);
		setTipo("Peão"); 
		
	}
	
	//get
	public int getQntd_jogadas() {
		return qntd_jogadas;
	}
	
	//set
	public void setQntd_jogadas(int qntd_jogadas) {
		this.qntd_jogadas = getQntd_jogadas() + qntd_jogadas;
	}
	
	
	//Função de movimentação que será utilizada posteriormente
	public void movimentacao(Tabuleiro t) {
		t.getMatriz()[getPosicaoLinha()][getPosicaoColuna()].setStatusoocupados(0);
		setPosicaoLinha(getPosicaoLinha() + 1);
		//validar
		//mostrar as casas possíveis para movimentação 
		t.getMatriz()[getPosicaoLinha()][getPosicaoColuna()].setStatusoocupados(1);
		t.getMatriz()[getPosicaoLinha()][getPosicaoColuna()].setPeca(this);
		System.out.println("");
		
	}
	
	//Imprime dados do peão
	 public String toString() {
	        return "Peao [cor = " + getCor() + " , id = " + getId() + "]";
	    }

}
