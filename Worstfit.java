
public class Worstfit {

	public void Worstfit(int[] memory, int space, int totalSpace, BestChoice[] bc) {

		boolean valid = false;//flag
		int sizeBc = 0;// vari�vel usada para armazenar o tamanho do vetor bc, com os dados de onde come�a cada lacuna
		int bigger = 0;// vari�vel usada para armazenar o maior espa�o encontrado

		for (int i = 0; i < totalSpace; i++) {//percorremos toda mem�ria armazenando as lacunas livres
			if(memory[i] == 0) {
				if(valid == false) {
					bc[sizeBc].setStart(i);//armazenamos onde come�a uma lacuna livre
				}
				valid = true;
			}else {
				if(valid == true) {//armazenamos onde a lacuna livre termina
					bc[sizeBc].setEnd(i);
					bc[sizeBc].setTotal(bc[sizeBc].getEnd() - bc[sizeBc].getStart());
					sizeBc++;
				}
				valid = false;
			}
		}
		valid = false;
		for (int i = 0; i < sizeBc; i++) {//agora percorremos o vetor que possui os dados sobre as lacunas livres
			if(bc[i].getTotal() >= space) {//procuramos pela maior lacuna
				if(bc[i].getTotal() > bigger){

					bigger = bc[i].getStart();//caso o elemento atual seja maior, bigger recebe esse elemento
				}
			}

		}
		if(valid == true) {//se a flag � true, quer dizer que existe espa�o para essa aloca��o
			System.out.println("Posi��o: " + bigger);
			for (int i = bigger; i < (bigger + space); i++) //preenchemos as posi��es do vetor mem�ria, dada a maior lacuna
                memory[i] = 1;
                System.out.println("*******ESPA�O ALOCADO COM SUCESSO*******");

		}else {//caso false, n�o existe espa�o para esta aloca��o
			System.out.println("*******ESPA�O INSUFICIENTE*******");
		}
	}

}