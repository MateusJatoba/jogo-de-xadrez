package classes_pecas;

import java.util.ArrayList;
import java.util.List;

public class Rei extends Pecas{
	
	//Construtor do Rei
	public Rei(String cor , int id){
		super(cor , id);
		setTipo("Rei");
	}
	
	//Imprimir dados do rei
	public String toString() {
	       return "Rei [cor = " + getCor() + " , id = " + getId() + "]";
	   }
	
	// Método para calcular as possibilidades de movimento do rei
		@Override
		public List<int[]> calcularPossibilidades(int coluna, int linha) {
			ArrayList<int[]> posicoesFinais = new ArrayList<>();

			// Adicionar todas as possibilidades de movimento do rei
			int[][] movimentosPossiveis = {
	            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
	            {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
	        };

	        for (int[] movimento : movimentosPossiveis) {
	            int novoX = linha + movimento[0];
	            int novoY = coluna + movimento[1];

	            // Verifica se a nova posição está dentro do tabuleiro (8x8)
	            if (novoX >= 0 && novoX < 8 && novoY >= 0 && novoY < 8) {
	                posicoesFinais.add(new int[]{novoX, novoY});
	            }
	        }

			return posicoesFinais;
		}
	
}
