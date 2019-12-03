
public class Worstfit {

	public void Worstfit(int[] memory, int space, int totalSpace, BestChoice[] bc) {

		boolean valid = false;//flag
		int sizeBc = 0;// variável usada para armazenar o tamanho do vetor bc, com os dados de onde começa cada lacuna
		int bigger = 0;// variável usada para armazenar o maior espaço encontrado

		for (int i = 0; i < totalSpace; i++) {//percorremos toda memória armazenando as lacunas livres
			if(memory[i] == 0) {
				if(valid == false) {
					bc[sizeBc].setStart(i);//armazenamos onde começa uma lacuna livre
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
		if(valid == true) {//se a flag é true, quer dizer que existe espaço para essa alocação
			System.out.println("Posição: " + bigger);
			for (int i = bigger; i < (bigger + space); i++) //preenchemos as posições do vetor memória, dada a maior lacuna
                memory[i] = 1;
                System.out.println("*******ESPAÇO ALOCADO COM SUCESSO*******");

		}else {//caso false, não existe espaço para esta alocação
			System.out.println("*******ESPAÇO INSUFICIENTE*******");
		}
	}

}