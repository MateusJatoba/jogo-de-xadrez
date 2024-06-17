package funcoes_auxiliares;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import classes_pecas.*;

public interface Arquivo {
	
	public String nome = "Relação de movimentos";
	
	default public void abreArquivo() throws IOException {
		File arq = new File(Arquivo.nome);
		if(arq.createNewFile()) {
			System.out.println("Arquivo criado: " + arq.getName());
		}
		else {
			System.out.println("Arquivo já existe, irei gravar por cima" );
		}
	}
	
	default public void gravaRodadas(int rodadas) throws IOException {
		FileWriter w = new FileWriter(Arquivo.nome,true);
		String texto = "------------------------ Rodada " + rodadas + " ------------------------"; 
		
		w.write(texto);
		w.write('\n');
		w.close();
		
	}
	
	
	default public void gravaJogadas(String j ,Pecas peca, int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) throws IOException{
		FileWriter w = new FileWriter(Arquivo.nome,true);
		String texto = "Jogador: " + j +
						"\nPeça movimentada: "+ peca.getTipo() + 
						"\nCasa de origem: " + "Linha - " + linhaOrigem + " " + "Coluna - " + colunaOrigem + 
						"\nCasa de destino: " + "Linha - " + linhaDestino + " " + "Coluna - " + colunaDestino;
		
		

		w.write(texto);
		w.write('\n');
		String text2 = "\n\n\n\n\n";
		w.write(text2);
		w.write('\n');
		w.close();
		
	}
	
	
	

}
