import java.util.Scanner;

public class Firstfit {

	public static void main(String[] args) {

		int[] a = new int [20];
		int[] p = new int [20];
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre o número de blocos de memória: ");
		int n = sc.nextInt();

		for (int i = 0; i <n ; i++) {

			System.out.println("Entre o tamanho do bloco de memoria: ");
			a[i] = sc.nextInt();
		}

		System.out.println("Entre com o número de processos: ");
        int m = sc.nextInt();
        
        for (int i = 0; i < m; i++) {
			System.out.println("Entre o tamanho do processo: ");
			p[i] = sc.nextInt();
		}
        for (int i = 0; i <n; i++) {
			for (int j = 0; j < m; j++) {
				if(p[j] <= a[i]) {
					System.out.print("O processo está alocado no bloco memoria: " + j + a[i]);
					p[j] = 10000;
					break;
				}if(p[j] != 10000) {
					System.out.println("O processo não está alocado");
				}
			}
			
		}
	}

}
