package cine;

import java.util.Scanner;

import cine.Cinema;

public class CinemaSessao {

	public static void main(String[] args) {
		Cinema cinema = new Cinema();	
		cinema.abreSala();
		
		boolean flag = true;
		Scanner inInt    = new Scanner(System.in);
		
		while (flag)
		{
			System.out.println(
					"#################################################################################### \n"
					+ "######################### CineLab 2015 ############################################# \n"
					+ "########## Digite 1 Mostrar sala                  ################################## \n"
					+ "########## Digite 2 Vender Ingresso               ################################## \n"
					+ "########## Digite 3 Ver Ingresso                  ################################## \n"
					+ "########## Digite 4 ---------------               ################################## \n"
					+ "########## Digite 5 ---------------               ################################## \n"
					+ "########## Digite 6 ---------------               ################################## \n"
					+ "########## Digite 7 para sair da aplicação        ################################## \n"
					+ "####################################################################################");
			int itemMenu = inInt.nextInt();
			switch (itemMenu) {
			case 1:
				cinema.flashSala();;
                break;
			case 2:
				cinema.vendeIngresso();
                break;
			case 3:
				cinema.findIngressoNome();
				break;
			case 7:
				flag = false;
				break;
			}
			
		}
	}

}

