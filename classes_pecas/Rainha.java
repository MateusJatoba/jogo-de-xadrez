package classes_pecas;

public class Rainha extends Pecas{
	
	//Construtor da rainha
	public Rainha(String cor , int id){
		super(cor , id);
		setTipo("Rainha");
	}
	
	//Função de movimentação que será utilizada posteriormente
	public void movimentacao() {
			
		}
	//Imprimir dados da rainha
	public String toString() {
	       return "Rainha [cor = " + getCor() + " , id = " + getId() + "]";
	   }
}
