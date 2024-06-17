
package classes_pecas;

import java.util.ArrayList;
import java.util.List;

public class Rainha extends Pecas{
	
	//Construtor da rainha
	public Rainha(String cor , int id){
		super(cor , id);
		setTipo("Rainha");
	}
		
	//Imprimir dados da rainha
	public String toString() {
	       return "Rainha [cor = " + getCor() + " , id = " + getId() + "]";
	   }
	
	// Método para calcular as possibilidades de movimento da rainha
		@Override
		public List<int[]> calcularPossibilidades(int coluna, int linha) {
			ArrayList<int[]> posicoesFinais = new ArrayList<>();

			// Adicionar todas as possibilidades horizontais
			for (int i = 0; i < 8; i++) {
				if (i != linha) {
					posicoesFinais.add(new int[]{i, coluna});
				}
			}

			// Adicionar todas as possibilidades verticais
			for (int j = 0; j < 8; j++) {
				if (j != coluna) {
					posicoesFinais.add(new int[]{linha, j});
				}
			}

			// Adicionar todas as possibilidades diagonais
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (Math.abs(i - linha) == Math.abs(j - coluna) && (i != linha || j != coluna)) {
						posicoesFinais.add(new int[]{i, j});
					}
				}
			}

			return posicoesFinais;
		}
	
}
