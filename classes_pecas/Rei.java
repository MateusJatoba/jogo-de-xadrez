package classes_pecas;

public class Rei extends Pecas{
	
	//Construtor do Rei
	public Rei(String cor , int id){
		super(cor , id);
		setTipo("Rei");
	}
	
	//Função de movimentação que será utilizada posteriormente
	public void movimentacao() {
			
		}
	
	//Imprimir dados do rei
	public String toString() {
	       return "Rei [cor = " + getCor() + " , id = " + getId() + "]";
	   }
}
