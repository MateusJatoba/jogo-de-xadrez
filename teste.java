package jogo_main;
import java.io.IOException;
import java.util.Scanner;


import classes_pecas.*;

	
public class teste {

	
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		Peao p = new Peao("Preto" , 0);
        preencherTabuleiroComPeoesPretos(tabuleiro);
        
		tabuleiro.setPeca(1, 0, p);
		tabuleiro.imprimirTabuleiro();
        
        
        
        
        //sleep(2000);
		Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
        tabuleiro.setPeca(p.movimentacao(), 0, p);
        tabuleiro.movimentacao(2, 0, p);
        tabuleiro.imprimirTabuleiro();
        
	}
	
	public static void preencherTabuleiroComPeoesPretos(Tabuleiro tabuleiro) {
        for (int i = 0; i < 8; i++) {
            tabuleiro.setPeca(1, i, new Peao("Preto" , (i+1)));
        }
    }
	
	public static void sleep(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
