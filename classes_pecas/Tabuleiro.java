package classes_pecas;

public class Tabuleiro {
	private Pecas[][] matriz;

    public Tabuleiro() {
        this.matriz = new Pecas[8][8]; 
    }

    public void imprimirTabuleiro() {
        final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        final String ANSI_RESET = "\u001B[0m";

        int k = 8;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] == null) {
                	//resolver a questão da ordem
                if ((i+j) % 2 == 0) {
                        System.out.print(ANSI_WHITE_BACKGROUND + "     " + ANSI_RESET + "| ");
                    } else {
                        System.out.print(ANSI_BLACK_BACKGROUND + "     " + ANSI_RESET + "| ");
                    }
                } else {
                    System.out.print(matriz[i][j].getTipo() + " | ");
                }
            }
            System.out.println(k);
            k--;
            System.out.println("-------------------------------------------------------");
        }

        System.out.println("   A      B      C      D      E      F      G      H");
    }

    
  

	public Pecas[][] getMatriz() {
		return matriz;
	}
	
	public void setPeca(int linha, int coluna, Pecas peca) {
        matriz[linha][coluna] = peca;
    }

	/*public void setMatriz(int linha,  int coluna) {
		matriz[linha][coluna] =  
	}*/
    
    
    public void movimentacao( int linha_destino , int coluna_destino , Pecas p) {
    	 
    	int i = 0;
    	int j = 0;
        boolean objetoEncontrado = false;

    	for(i = 0; i<8; i++) {
    		for(j = 0; j<8;j++) {
    			if(matriz[i][j] == null) {
    				continue;
    			}
    			else {
    				if(matriz[i][j].getCor() == p.getCor() && matriz[i][j].getId() == p.getId() && matriz[i][j].getTipo() == p.getTipo()) {
    					objetoEncontrado = true;
    					break;
    					
    				}
    			}
    		}
    		
    		if(objetoEncontrado) {
    			break;
    		}
    	}
    	
    	
    	if (objetoEncontrado) {
            matriz[i][j] = null; // Remover a peça da posição atual
            matriz[linha_destino][coluna_destino] = p; // Colocar a peça na nova posição
        }
    }
}
