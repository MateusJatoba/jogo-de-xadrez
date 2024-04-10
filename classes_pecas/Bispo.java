package classes_pecas;

public class Bispo extends Pecas{
	
	//Construtor do Bispo
	public Bispo(String cor , int id) {
		super(cor , id);
		setTipo("Bispo");
	}
	
	//Função de movimentação que será utilizada posteriormente
	public void movimentacao() {
			
		}
	
	//Dados do bispo
	public String toString() {
	       return "Bispo [cor = " + getCor() + " , id = " + getId() + "]";
	   }
}
