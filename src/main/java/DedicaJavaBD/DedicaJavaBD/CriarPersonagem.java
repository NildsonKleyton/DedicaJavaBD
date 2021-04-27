package DedicaJavaBD.DedicaJavaBD;

import java.util.List;
import java.util.Scanner;

import dao.RPGGeralDAO;
import dao.RPGGeralDAOImpl;
import entidade.Arma;
import entidade.Armadura;
import entidade.Classe;
import entidade.Personagem;
import entidade.Raca;

public class CriarPersonagem {

	public static void main(String[] args) {

// iniciadores		

		RPGGeralDAO geralDAO = new RPGGeralDAOImpl();
		/**
		 * listas criadas para consulta no banco
		 */
		List<Arma> listaArma = geralDAO.listar(new Arma());
		List<Armadura> listaArmadura = geralDAO.listar(new Armadura());
		List<Raca> listaRaca = geralDAO.listar(new Raca());
		List<Classe> listaClasse = geralDAO.listar(new Classe());
//		List<Personagem> listaPersonagem = geralDAO.listar(new Personagem());
		
		
		Scanner scOpc = new Scanner(System.in);
		Scanner scTexto = new Scanner(System.in);
		String nometx = null;
		Personagem personagem = new Personagem();
//==========

		topo();

		// NPC é um personagem de jogo eletrônico que não pode ser controlado por um
		// jogador.
		// Fala do NPC
		System.out.println("Bem vindo ao Mundo Dos Mortos");
		System.out.println("Olá, éhhhh...\nVocê pode removendo o capus por favor.");

		// inicio de escolha de Raça
		int opcRaca;
		System.out.println("\n#Escolha sua Raça:");
		for (int i = 0; i < listaRaca.size(); i++) {
			Raca raca = listaRaca.get(i);
			System.out.println(i + " - " + raca.getNome());
		}
		// Raça excolhida pelo usuario
		opcRaca = scOpc.nextInt();
		Raca raca = listaRaca.get(opcRaca);// recebe a escolha

		linha(15);
		System.out.println(raca.getNome());// Exibe a Raça
		linha(15);

		// Fala do NPC comforme a escolha do usuário
		switch (raca.getNome()) {
		case ("HUMANO"):
			System.out.println("\nO que um HUMANO faz nesta areas contamidade!");
			break;
		case ("ELFO"):
			System.out.println("\nOlha um ELFO, faz tempo que não vejo um!");
			break;
		case ("DEMI HUMANO"):
			System.out.println("\nComo vocês DEMI HUMANO são assustadores!");
			break;

		default:
			System.out.println("\nVocês " + raca.getNome() + " não deveriam andar por aqui !");
			break;
		}
		// Fala do NPC
		System.out.print("Opa! Descula meus modos.\nQual seu nome? ");
		nometx = scTexto.nextLine();// receber nome do personagem

		// inicio de escolha de Classe
		int opcClasse;
		System.out.println("\n#Escolha sua Classe: ");
		for (int i = 0; i < listaClasse.size(); i++) {
			Classe classe = listaClasse.get(i);
			System.out.println(i + " - " + classe.getNome());
		}

		// Raca excolhida pelo usuario
		opcClasse = scOpc.nextInt();
		Classe classe = listaClasse.get(opcClasse);// recebe a escolha

		linha(15);
		System.out.println(classe.getNome());// Exibe a Classe
		linha(15);

		// Fala do NPC comforme a escolha do usuário
		switch (classe.getNome()) {
		case ("LUTADOR"):
			System.out.println("\nBelas espadas Senhor(a) " + nometx
					+ ", elas eram usada\npor grandes LUTADORES antes da contaminação.");
			break;
		case ("MERCENARIO"):
			System.out.println("\nDesculpe Senhor(a) " + nometx + " Não reconheci você!");
			break;
		case ("ATIRADOR"):
			System.out.println("\nEsta sua Arma e muito Atiga Senhor(a) " + nometx);
			break;
		default:
			System.out.println("\nVocê falou " + nometx
					+ "?\nLembro que ontem tinha um grupo de Mercenários, procurando por alguém com este nome!");
			break;
		}

		// Arma excolhida pelo usúario , falta criar texto para armas
		int opcArma;

		System.out.println("\n#Escolha sua Arma: ");
		for (int i = 0; i < listaArma.size(); i++) {
			Arma arma = listaArma.get(i);
			System.out.println(i + " - " + arma.getNome());
		}

		opcArma = scOpc.nextInt();
		Arma arma = listaArma.get(opcArma);

		System.out.println("===============================");
		System.out.println(arma.getNome());
		System.out.println("===============================");

		switch (arma.getNome()) {
		case ("CRISTAL SWORD"):
			System.out.println("\nBelas espadas Senhor(a) " + arma.getNome()
					+ ", elas eram usada\npor grandes LUTADORES antes da contaminação.");
			break;
		case ("LANÇA DO VAZIO"):
			System.out.println("\nDesculpe Senhor(a) " + arma.getNome() + " Não reconheci você!");
			break;
		case ("PISTOLA ELFICA"):
			System.out.println("\nEsta sua Arma e muito Atiga Senhor(a)" + arma.getNome());
			break;
		default:
			System.out.println("\nClasses dessa " + arma.getNome() + " não são muito vistas!");
			break;
		}

		//Armadura excolhida pelo usúario , falta criar texto para armadura
        int opcArmadura;

        System.out.println("\n#Escolha sua Armadura: ");
        for (int i = 0; i < listaArmadura.size(); i++) {
            Armadura armadura = listaArmadura.get(i);
            System.out.println(i + " - " + armadura.getNome());
        }

        opcArmadura = scOpc.nextInt();
        Armadura armadura = listaArmadura.get(opcArmadura);

        System.out.println("===============================");
        System.out.println(armadura.getNome());
        System.out.println("===============================");

        switch (armadura.getNome()) {
        case ("CRISTAL "):
            System.out.println("\nBela Armadura Senhor(a) "+armadura.getNome()+", elas eram usada\npor grandes LUTADORES antes da contaminação.");
            break;
        case ("ESCUDO DO VAZIO"):
            System.out.println("\nDesculpe Senhor(a) "+armadura.getNome()+" Não reconheci você!");
            break;
        case ("POWER OF THE KING"):
            System.out.println("\nEsta sua Armadura e muito Atiga Senhor(a)"+armadura.getNome());
            break;
        default:
            System.out.println("\nUm dessa "+armadura.getNome()+" não são muito vistas!");
            break;
        }
        
		// Aqui inicia o cadastro do personagem
		// Preencher os atributos com as informações escolhida
		personagem.setNome(nometx);
		personagem.setRaca(raca);
		personagem.setClasse(classe);
		// Preencher atributos do personagem
		personagem.setArma(listaArma.get(0));
		personagem.setArmadura(listaArmadura.get(0));

		// alteração por Gilberto
		personagem.setAgilidade(raca.getAgilidade() + classe.getAgilidade());
		personagem.setAtaque(raca.getAtaque() + classe.getAtaque() + arma.getAtaque());
		personagem.setDefesa(raca.getDefesa() + classe.getDefesa()); // falta defesa armadura
		personagem.setVida(100 + raca.getVida() + classe.getVida());
		personagem.setMoeda(0);

		personagem = (Personagem)geralDAO.salvar(personagem);
		
		linha(50);
		System.out.println(geralDAO.salvar(personagem));// salva personagen no Bando
		System.out.println(personagem.getNome() + " - " + personagem.getId());// mostra "nome" e "ID" no personagem
		linha(50);

		System.out.println("\nOK " + personagem.getNome() + "! Vejo que você já pode seguir sua jornada...");
		System.out.println("");

		/*
		 * Lista de personagem com nome e ID
		 */
		System.out.println("\n#Lista de perssonagem");
//		for (Personagem personagem1 : listaPersonagem ) {
//			System.out.println(geralDAO.listar(personagem1.getNome()+ " - " +personagem1.getId()));
//		}
		
		List <Personagem> listaPersonagem = (List<Personagem>)geralDAO.listar(new Personagem());//
		for (int i = 0; i < listaPersonagem.size(); i++) {
			Personagem pers = listaPersonagem.get(i);
			System.out.println(i+1 + " - " + pers.getNome() + " - " + pers.getId());
		}
		
	}

//Funções
	/**
	 * @author Nildson Kleyton Cria uma linha com o Caracter "=" coma a quantidade
	 *         informada por parametro.
	 * @param n
	 */
	public static void linha(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("=");
		}
		System.out.println("");
	}

	/**
	 * @author Nildson Kleyton Cria três linha para tipo uma Faixa, com o nome RPG
	 *         DE TEXTO dentro
	 */
	public static void topo() {
		linha(73);
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
		linha(73);
	}

	/**
	 * @author Gilberto Mostras informações do personagem e Salva no banco
	 * @param geralDAO
	 * @param personagem
	 */
	public static void show(RPGGeralDAO geralDAO, Object personagem) {
		System.out.println("===============================");

		System.out.println(((Personagem) personagem).getNome() + " - " + "@Id - " + ((Personagem) personagem).getId());
		System.out.println("\nAqui estão suas skills iniciais:");
		System.out.println("\nAtaque: " + (((Personagem) personagem).getAtaque()));
		System.out.println("\nDefesa: " + (((Personagem) personagem).getDefesa()));
		System.out.println("\nAgilidade: " + (((Personagem) personagem).getAgilidade()));
		System.out.println("\nVida: " + (((Personagem) personagem).getVida()));
		System.out.println("\nClasse: " + (((Personagem) personagem).getClasse().getNome()));
		System.out.println("\nRaça: " + (((Personagem) personagem).getRaca().getNome()));
		System.out.println("\nArma: " + (((Personagem) personagem).getArma().getNome()));
		System.out.println("\nArmadura: " + (((Personagem) personagem).getArmadura().getNome()));
		System.out.println("\nMoedas: " + (((Personagem) personagem).getMoeda()));
		System.out.println("===============================");
	}
}
