package classes_pecas;

public class Cavalo extends Pecas{
	
	//Construtor do Cavaloo
	public Cavalo(String cor , int id){
		super(cor , id);
		setTipo("Cavalo");
	}
	
	//Função de movimentação que será utilizada posteriormente
	public void movimentacao() {
		
	}
	//Imprimir dados do cavalo
	public String toString() {
	       return "Cavalo [cor = " + getCor() + " , id = " + getId() + "]";
	   }
	
	
}
