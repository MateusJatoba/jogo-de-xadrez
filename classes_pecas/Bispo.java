
package classes_pecas;

import java.util.ArrayList;
import java.util.List;

public class Bispo extends Pecas{
	
	//Construtor do Bispo
	public Bispo(String cor , int id) {
		super(cor , id);
		setTipo("Bispo");
	}
	
	//Dados do bispo
	public String toString() {
	       return "Bispo [cor = " + getCor() + " , id = " + getId() + "]";
	   }


    //Método para calcular as possibilidades de movimento do bispo
	@Override
	public List<int[]> calcularPossibilidades(int coluna, int linha) {
		ArrayList<int[]> posicoesFinais = new ArrayList<>();

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
