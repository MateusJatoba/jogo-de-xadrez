package funcoes_auxiliares;

public class sleep {
	public static void sleep_func(int num) { // Função criada para ficilitar o uso do sleep
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public sleep() {
		
	}
}
