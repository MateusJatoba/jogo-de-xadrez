
package classes_pecas;

import java.util.ArrayList;
import java.util.List;

public class Cavalo extends Pecas {
    
    // Construtor do Cavalo
    public Cavalo(String cor, int id) {
        super(cor, id);
        setTipo("Cavalo");
    }
    
    //Imprimir dados do Cavalo
  	public String toString() {
  	       return "Cavalo [cor = " + getCor() + " , id = " + getId() + "]";
  	   }
    
    // Método para calcular as possibilidades de movimento do cavalo a partir de uma posição no tabuleiro
    @Override
    public List<int[]> calcularPossibilidades(int coluna, int linha) {
        int linhaAtual = linha;
        int colunaAtual = coluna;

        ArrayList<int[]> posicoesFinais = new ArrayList<>();
        
        int[][] movimentosPossiveis = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int[] movimento : movimentosPossiveis) {
            int novoX = linhaAtual + movimento[0];
            int novoY = colunaAtual + movimento[1];

            // Verifica se a nova posição está dentro do tabuleiro (8x8)
            if (novoX > 0 && novoX < 8 && novoY > 0 && novoY < 8) {
                posicoesFinais.add(new int[]{novoX, novoY});
            }
        }

        return posicoesFinais;
    }

}
