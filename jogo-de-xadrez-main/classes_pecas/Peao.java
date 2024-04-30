package classes_pecas;

import java.util.ArrayList;
import java.util.List;

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
	
	//Imprime dados do peão
	 public String toString() {
	        return "Peao [cor = " + getCor() + " , id = " + getId() + "]";
	    }

	// Método para calcular as possibilidades de movimento do peão
		@Override
		public List<int[]> calcularPossibilidades(int coluna, int linha) {
			ArrayList<int[]> posicoesFinais = new ArrayList<>();
			
			// Adicionar movimentos para frente (dependendo da cor do peão)
			int incremento = (getCor().equals("Branco")) ? 1 : -1;
			int novaLinha = linha + incremento;
			
			// Verificar se a nova posição está dentro do tabuleiro
			if (novaLinha >= 0 && novaLinha < 8) {
				posicoesFinais.add(new int[]{novaLinha, coluna});
				
				// Se for o primeiro movimento do peão, ele pode avançar duas casas
				if (getQntd_jogadas() == 0) {
					int novaLinhaDuplo = linha + 2 * incremento;
					if (novaLinhaDuplo >= 0 && novaLinhaDuplo < 8) {
						posicoesFinais.add(new int[]{novaLinhaDuplo, coluna});
					}
				}
			}
			
			// Adicionar possíveis movimentos diagonais para captura de peças
			int[] movimentosDiagonais = {(getCor().equals("Branco")) ? 1 : -1, -1, 1};
			for (int movimentoDiagonal : movimentosDiagonais) {
				int novaColuna = coluna + movimentoDiagonal;
				if (novaColuna >= 0 && novaColuna < 8) {
					posicoesFinais.add(new int[]{novaLinha, novaColuna});
				}
			}

			return posicoesFinais;
		}
	 
}
