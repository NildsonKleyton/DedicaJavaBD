package TesteDeClasse;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class CriarPersonagemTeste {

	public static void main(String[] args) {
		top();
		System.out.println("Bem vindo ao Mundo Dos Mortos");
		System.out.println("Olá, éhhhh...\nVocê pode se identifique-se, removendo o capus por favor.");
		Scanner sc = new Scanner(System.in);

		int opc;
		System.out.println("\n#Escolha sua Raça:\n1-HUMANO\n2-ELFO\n3-DEMI HUMANO");
		opc = sc.nextInt();

		String racatx = null;
		switch (opc) {
		case 1:
			racatx = "HUMANO";
			break;
		case 2:
			racatx = "ELFO";
			break;
		case 3:
			racatx = "DEMI HUMANO";
			break;

		default:
			System.out.println("Opção invalida");
			break;
		}

		if (racatx == "HUMANO") {
			System.out.println("\nO que um HUMANO faz nesta areas contamidade!");
		} else if (racatx == "ELFO") {
			System.out.println("\nOlha um ELFO, faz tempo que não vejo um!");
		} else if (racatx == "DEMI HUMANO") {
			System.out.println("\nComo vocês DEMI HUMANO são assustadores!");

		}

		System.out.print("Opa! descula meus modos.\nQual seu nome? ");
		String nometx = sc.next();
		
		System.out.println("\n#Escolha sua Classe:\n1-LUTADOR\n2-MERCENÁRIO\n3-ATIRADOR");
		opc = sc.nextInt();

		String classetx = null;
		switch (opc) {
		case 1:
			classetx = "LUTADOR";
			break;
		case 2:
			classetx = "MERCENÁRIO";
			break;
		case 3:
			classetx = "ATIRADOR";
			break;

		default:
			System.out.println("Opção invalida");
			break;
		}
		
		if (classetx == "LUTADOR") {
			System.out.println("\nBelas espadas Senhor(a) "+nometx+", elas eram usada\npor grandes LUTADORES antes da contaminação.");
		} else if (classetx == "MERCENÁRIO") {
			System.out.println("\nDesculpe Senhor(a) "+nometx+" Não reconheci você!");
		} else if (classetx == "ATIRADOR") {
			System.out.println("\nEsta sua Arma e muito Atiga Senhor(a)"+nometx);
		}
		
	}
//Funções
	public static void linha() {
		for (int i = 0; i < 73; i++) {
			System.out.print("=");
		}
		System.out.println("");
	}
	
	public static void top() {
		linha();
		for (int i = 0; i < 60; i++) {
			if (i == 0) {
				System.out.print("|");
			} else if (i == 30) {
				System.out.print(" RPG DE TEXTO ");
			} else if (i == 59) {
				System.out.print("|\n");
			} else {
				System.out.print("*");
			}
		}
		linha();
	}

}
