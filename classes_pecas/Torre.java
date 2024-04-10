package classes_pecas;

public class Torre extends Pecas{
	
	//Construtor da torre
	public Torre(String cor , int id) {
		super(cor , id);
		setTipo("Torre");
	}
	
	//Função de movimentação que será utilizada posteriormente
	public void movimentacao() {
			
		}
	
	//Imprimir dados da Torre
	public String toString() {
        return "Torre [cor = " + getCor() + " , id = " + getId() + "]";
    }
}
