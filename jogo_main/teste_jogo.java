
package jogo_main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import classes_pecas.*;
import funcoes_auxiliares.Arquivo;

	
public class teste_jogo {

	
	public static void main(String[] args) throws IOException{
		
		menu(); // chamada da exibição do menu
		
		//declaração das variáveis que serão utilizadas
		Scanner sc = new Scanner(System.in);
		String nomeJogador1 = null;
		String nomeJogador2 = null;
		Tabuleiro tabuleiro = new Tabuleiro();
		Jogador[] jogadores = new Jogador[2];
		
		//Atribuindo os valores as variáveis
		System.out.println("Digite o nome do jogador 1:  ");
		nomeJogador1 = sc.next();
		System.out.println("Digite o nome do jogador 2:  ");
		nomeJogador2 = sc.next();
		
		
		//Adicionando os jogadores ao vetor de jogador
		System.out.println("\n----------------------------------\n");
		for (int i=0; i<2; i++) {
			if (i == 0) {
				jogadores[i] = new Jogador(nomeJogador1 , "preto");
			}
			else if( i == 1) {
				jogadores[i] = new Jogador(nomeJogador2 , "branco");
			}
		}
		
		
		//imprimindo os dados dos jogadores
		System.out.println("");
		for (int i = 0; i < 2; i++) {
            jogadores[i].imprimeDados();
            System.out.println("\n----------------------------------\n");
        }
		
		//inicializando e imprimndo o tabuleiro
		tabuleiro.inicializaTabuleiro();
		
		tabuleiro.preencherTabuleiro(jogadores);
		
		tabuleiro.imprimirTabuleiro();
        
        sc.nextLine();
        
        
        
       for(int i = 0; i < 3; i++) {
    	   tabuleiro.Jogar(jogadores);
        }
       
       int aux = 0;
       
       System.out.println("\nDeseja ver as jogadas de qual jogador:\n[1] - " + jogadores[0].getNome() + "\n" + "[2] - " + jogadores[1].getNome());
       
       aux = sc.nextInt();
       
       if(aux == 1) {
    	   buscaPalavra(jogadores[0]);
       }
       if(aux == 2) {
    	   buscaPalavra(jogadores[1]);
       }
       
       
       sc.close();
        
	}
	
	
	
	public static void sleep(int num) { // Função criada para ficilitar o uso do sleep
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void menu() { // função do Menu
		
		System.out.println("Bem-Vindo ao SmartChess");
		sleep(3000);
		System.out.println("Clique [ENTER] para continuar...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();	

	}
	
	public static void buscaPalavra(Jogador j) throws IOException {
		
		
        File arq = new File("Relação de movimentos");
        if (!arq.exists()) {
            System.out.println("Arquivo não encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String linha;
            int rodada = 1;
            boolean encontrou = false;
            while ((linha = br.readLine()) != null) {
                if (linha.contains("Jogador: " + j.getNome())) {
                    System.out.println("Rodada " + rodada + ":\n");
                	for(int i = 0; i < 3; i++) {
                		if ((linha = br.readLine()) != null) {
                            System.out.println(linha);
                        }
                    }
                	System.out.println("----------------------------\n");
                    encontrou = true;
                    rodada++;
                }
            }
            if (!encontrou) {
                System.out.println("Palavra não encontrada no arquivo.");
            }
        }
    }
	
	
	
}
