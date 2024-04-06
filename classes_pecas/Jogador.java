package classes_pecas;

public class Jogador {
	private String nome;
	private Pecas[] lista;
	private String cor;
	
	public Jogador(String nome , String cor) {
		this.nome = nome;
		this.cor = cor;
		this.lista = new Pecas[16];
		this.criaMaoJogador();
		
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void criaMaoJogador() {
		
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pecas[] getLista() {
		return lista;
	}
	
	
	public void setPeca(Pecas p) {
		for(int i = 0 ; i<16 ; i++) {
			
			if(getLista()[i] == null) {
				getLista()[i] = p;
				break;
			}
			
			
		}
	}
	
	
	
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}
