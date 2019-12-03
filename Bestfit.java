import java.util.Scanner;

public class Bestfit {

	public static void main(String[] args) {

		int p,m;
		Scanner sc = new Scanner(System.in);
		Memoria memoria = new Memoria();
		
		System.out.println("Entre com o número de processos: ");
		p = sc.nextInt();
		
		System.out.println("Entre o numero de blocos de memoria: ");
		m = sc.nextInt();
		
		int[] parr = new int[p];
		int[] marr = new int[m];

		for (int i = 0; i < p; i++) {
			System.out.println("Entre o tamanho do processo: " +i+1);
			parr[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			System.out.println("Entre o tamanho do bloco de memoria: " +i+1);
			marr[i] = sc.nextInt();
		    memoria.setTamanho(i);
		    memoria.setId(marr[i+1]);
		}
		//int j;
		int tamanho = 0;
		
		for (int i = 0; tamanho <=marr[memoria.getTamanho()]; i++) 
			tamanho = marr[memoria.getTamanho()];
			
			int tamanhoVelho = tamanho;
			int im;
			boolean marcador = false;
			
			for (int i = 0; i <p; i++) {
				for (int j = 0; j < m; j++) {
					if(marr[memoria.getTamanho()] >=parr[i] && (marr[memoria.getTamanho()] <tamanho) ) {
						
						im = j;
						tamanho = marr[j] = memoria.getTamanho();
						marcador = true;
					}
					
				}
				if(marcador){
					marcador = false;
					marr[memoria.getTamanho()]-=parr[i];
					 tamanho = tamanhoVelho ;
					 System.out.print("Aloca o processo %d no bloco memoria \n Tamanho restante apos alocar" + i+1 + marr[memoria.getId()] +marr[memoria.getTamanho()]);
				}else {
					System.out.println("Memoria insuficiente para o processo");
					break;
				}
				
			}
		
	}

}
