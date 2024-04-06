package classes_pecas;
import java.util.Scanner;




//Classe tabuleiro

public class Tabuleiro extends Casa{
	private Casa[][] matriz; 
	
	
	final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; // Código para setar o background preto
    final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; // Código para setar o background preto
    final String ANSI_RESET = "\u001B[0m"; // Resetar o backgroud

    public Tabuleiro() { //Construtor criando os 64 espaços
        this.matriz = new Casa[8][8]; 
    }
    
    public void inicializaTabuleiro() {
    	for (int i = 0 ; i < 8 ; i++){
    		for(int j = 0 ; j<8; j++) {
    			matriz[i][j] = new Casa();
    			matriz[i][j].setCoordenadaLinha(i);
    			matriz[i][j].setCoordenadaColuna(j);
    			matriz[i][j].setStatusoocupados(0);
    		}
    	}
    	System.out.println("Tabuleiro inicializado\n\n");
    }

    public void imprimirTabuleiro() {
        

        int k = 8; // variavel auxiliar
        
        
        // Lógica de matriz bidimensional para imprimir o tabuleiro
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j].getStatusoocupados() == 0) {
                	
                if ((i+j) % 2 == 0) {
                        System.out.print(ANSI_WHITE_BACKGROUND + "     " + ANSI_RESET + "| ");
                    } else {
                        System.out.print(ANSI_BLACK_BACKGROUND + "     " + ANSI_RESET + "| ");
                    }
                } else {
                    System.out.print(matriz[i][j].getPeca() + " | ");
                }
            }
            
            System.out.println(k);
            k--;
            System.out.println("-------------------------------------------------------");
        }

        System.out.println("   A      B      C      D      E      F      G      H");
    }

    
  

	public Casa[][] getMatriz() {
		return matriz;
	}
	
	
	public void setPeca(int linha, int coluna, Pecas peca) { // "Encaixar" uma peça no tabuleiro
        matriz[linha][coluna].setPeca(peca);
        matriz[linha][coluna].setStatusoocupados(1);
    }

	
    
    
	
	/*public void movimentacao( Casa p) { // lógica para movimentar uma peça 
   	 
		//Variáveis auxiliares:
    	int i = 0;
    	int j = 0;
        boolean objetoEncontrado = false;

        
        //Lógica para encontrar a peça
        
        
    	for(i = 0; i<8; i++) {
    		for(j = 0; j<8;j++) {
    			if(matriz[i][j] == null) {
    				continue;
    			}
    			else {
    				if(matriz[i][j].getCor() == p.getCor() && matriz[i][j].getId() == p.getId() && matriz[i][j].getTipo() == p.getTipo()) {
    					objetoEncontrado = true;
    					System.out.println(i + " " + j);
    					break;
    					
    				}
    			}
    		}
    		
    		if(objetoEncontrado) {
    			break;
    		}
    	}
    	
    	
    	//Lógica para movimentar a peça
    	
    	if (objetoEncontrado) {
    		Scanner sc = new Scanner(System.in);
    		
    		//Switch case para personalizar a movimentação da peça
    		
    		// Fazer associação entre o tabuleiro e as peças. Fazendo um método, que receba o tabuleiro como parametro, em cada subclasse de peca  
    		// Tentar pensar o tabuleiro como uma matriz de Casa
    		switch(matriz[i][j].getTipo()) {
    			case "Peão":
    				
    				matriz[i][j] = null; // Remover a peça da posição atual
                    matriz[i+1][j] = p; // Colocar a peça na nova posição
                    break;
                    
                    
    			case "Cavalo":
    				boolean continua = true;
    				matriz[i][j] = null;
    				while(continua) {
    					System.out.println("Deseja movimentar para qual LADO:\n[1] - Direita\n[2] - Esquerda\n");
    					
        				int l = 0;
        				int s = 0;
        				l = sc.nextInt();
        			
        				
        				++
        		
        				System.out.println("Deseja movimentar duas Casa para:\n[1] - Horizontal\n[2] - Vertical");
        				s = sc.nextInt();
        				
        				if(l == 1 && s == 2) {
        					if(2 + i > 7 || j + 1 > 7) {
        						System.out.println("Movimentação inválida");
        					}
        					else {
        						matriz[i + 2][j + 1] = p;
            					continua = false;
            					
            				}
        					
        				}
        					
        				if(l == 2 && s == 2) {
        					if(i - 2 < 0 || j + 1 > 7) {
        						System.out.println("Movimentação inválida");
        					}
        					else {
        						matriz[i - 2][j + 1] = p;
            					continua = false;
            					
            				}
        				}
        				
        				if(l == 1 && s == 1) {
        					if(1 + i > 8 || j + 2 > 7) {
        						System.out.println("Movimentação inválida");
        					}
        					else {
        						matriz[i + 1][j+2] = p;
            					continua = false;
            					
            				}
        				}
        				if(l == 2 && s == 1) {
        					if(i - 1 < 0 || j + 2 > 7) {
        						System.out.println("Movimentação inválida");
        					}
        					else {
        						matriz[i - 1][j + 2] = p;
            					continua = false;
            					
            				}
        				}
    
    				}
    		
    				
    				matriz[i][j] = null;
    				break;

    				
                default:
                	break;
    		}
    		
            
        }
    }*/
}

