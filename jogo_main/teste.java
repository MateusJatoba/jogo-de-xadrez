package jogo_main;
import java.io.IOException;
import java.util.Scanner;


import classes_pecas.*;

	
public class teste {

	
	public static void main(String[] args) {
		/*Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.inicializaTabuleiro();
		preencherTabuleiroComPeoesPretos(tabuleiro);
		tabuleiro.imprimirTabuleiro();*/
		
		Peao p = new Peao("Preto" , 1);
		Bispo b = new Bispo("Branco" , 1);
		
		System.out.println("Cor..." + b.getCor());
		System.out.println("Id..." + b.getId());
		
        
	}
	
	
	
	public static void preencherTabuleiroComPeoesPretos(Tabuleiro tabuleiro) {
		
        for (int i = 0; i < 8; i++) {
        	Peao p = new Peao("Preto" , (i+1));
            tabuleiro.setPeca(1, i, p);
            p.setPosicaoLinha(1);
            p.setPosicaoColuna(i);
            p.movimentacao(tabuleiro);
            
        }
        Pecas cavalo = new Cavalo("Preto" , 0);
        tabuleiro.setPeca(0, 0, cavalo);
        //tabuleiro.movimentacao(cavalo);
    }
	
	public static void sleep(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}