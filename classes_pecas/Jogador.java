package classes_pecas;

public class Jogador {
	
	//Atributos de Jogador
	private String nome;
	private Pecas[] lista;
	private String cor;
	
	//construtor do jogador
	public Jogador(String nome , String cor) {   
		this.nome = nome;
		this.cor = cor;
		this.lista = new Pecas[16];
		this.criaMaoJogador();
		
	}
	
	
	//Método de criar a mão do jogador
    public void criaMaoJogador() {
    	
    	//Vetores dos respectivos tipos de peças
    	Peao[] Peoes = new Peao[8];
    	Bispo[] Bispos = new Bispo[2];
    	Torre[] Torres = new Torre[2];
    	Cavalo[] Cavalos = new Cavalo[2];
    	
    	//Objetos Rei e Rainha
    	Rei Rei = new Rei(this.cor, 15);
		Rainha Rainha = new Rainha(this.cor, 16);
    	
    	//Instânciando as peças e adicionando-as aos vetores
		for (int i =0; i<8; i++) {
			Peoes[i] = new Peao(this.cor, i+1);
		}
    	for (int i=0; i<2; i++) {
			Bispos[i] = new Bispo(this.cor, i+9);
		}
    	for (int i=0; i<2; i++) {
			Torres[i] = new Torre(this.cor, i+11);
		}
    	for (int i=0; i<2; i++) {
			Cavalos[i] = new Cavalo(this.cor, i+13);
		}
    	
    	//Adicionando as peças ao vetor da mão do jogador (atributo do jogador)
    	for (int i = 0; i < 8; i++) {
            lista[i] = Peoes[i];
        }
        for (int i = 8; i < 10; i++) {
            lista[i] = Bispos[i - 8];
        }
        for (int i = 10; i < 12; i++) {
            lista[i] = Torres[i - 10];
        }
        for (int i = 12; i < 14; i++) {
            lista[i] = Cavalos[i - 12];
        }
        lista[14] = Rei;
        lista[15] = Rainha;
	}
    
    
    //Imprimindo dados do jogador
    public void imprimeDados() {
    	System.out.println("Nome: " +this.getNome());
    	System.out.println("Cor: " +this.getCor());
    	for(int i=0; i<16; i++) {
    		System.out.println(lista[i]);
    	}
    }

	
    
    //Getters e Setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pecas[] getLista() {
		return lista;
	}
	
	
	public void setPeca(Pecas p) {
		for(int i = 0 ; i<16 ; i++) {
			
			if(getLista()[i] == null) {
				getLista()[i] = p;
				break;
			}
			
			
		}
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
