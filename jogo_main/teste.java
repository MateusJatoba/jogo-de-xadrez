package jogo_main;
import java.io.IOException;
import java.util.Scanner;


import classes_pecas.*;

	
public class teste {

	
	public static void main(String[] args) {
		
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
		tabuleiro.imprimirTabuleiro();
        
     
		
        sc.nextLine();
		
        
       
        
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
	
	
	


}