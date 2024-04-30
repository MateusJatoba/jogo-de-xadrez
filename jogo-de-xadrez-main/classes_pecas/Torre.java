package classes_pecas;

import java.util.ArrayList;
import java.util.List;

public class Torre extends Pecas {
	
	// Construtor da torre
	public Torre(String cor, int id) {
		super(cor, id);
		setTipo("Torre");
	}
	
	// Imprimir dados da Torre
		public String toString() {
			return "Torre [cor = " + getCor() + " , id = " + getId() + "]";
		}
	
	// Método para calcular as possibilidades de movimento da torre
	@Override
	public List<int[]> calcularPossibilidades(int coluna, int linha) {
		ArrayList<int[]> posicoesFinais = new ArrayList<>();

		// Adiciona todas as posições na mesma coluna, exceto a posição atual
		for (int i = 0; i < 8; i++) {
			if (i != linha) {
				posicoesFinais.add(new int[]{i, coluna});
			}
		}

		// Adiciona todas as posições na mesma linha, exceto a posição atual
		for (int j = 0; j < 8; j++) {
			if (j != coluna) {
				posicoesFinais.add(new int[]{linha, j});
			}
		}

		return posicoesFinais;
	}
}
