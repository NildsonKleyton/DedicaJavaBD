package DedicaJavaBD.DedicaJavaBD;

import java.util.List;
import java.util.Scanner;

import dao.RPGGeralDAO;
import dao.RPGGeralDAOImpl;
import entidade.Fase;
import entidade.Missao;
import entidade.Personagem;

public class FluxoMissao {

	public static void main(String[] args) {
		
		RPGGeralDAO geralDAO = new RPGGeralDAOImpl();
		Scanner sTexto = new Scanner(System.in);
		Scanner sNumero = new Scanner(System.in);
		
		List<Personagem> listaPersonagem = geralDAO.listar(new Personagem());
		List<Missao> listaMissao = geralDAO.listar(new Missao());
		
		Personagem personagem = null;
		Missao missao = null;
		
		System.out.println("------------------------------------------");
		System.out.println("-------------Vamos a missão---------------");
		System.out.println("------------------------------------------");
		
		System.out.println("Escolha um personagem:");

		for (Personagem pers : listaPersonagem) {
			System.out.println(pers.getId() + " - " + pers.getNome());
		}
		
		int idPersonagem = sNumero.nextInt();
		
		personagem = retornarPersonagemId(idPersonagem, listaPersonagem);
		
		
		show(personagem);// mostra os estatos no inicio
	
		
		System.out.println("==============================================");
		System.out.println("----- Escolha uma missão ==-------------------");
		System.out.println("==============================================");
		
		for (Missao mis : listaMissao) {
			System.out.println(mis.getId() +" - "+ mis.getNome());
		}
		
		int idMissao = sNumero.nextInt();
		
		missao = retornaMissaoId(idMissao, listaMissao);
		
		System.out.println("==============================================");
		System.out.println("-----A fase inicial se inicia      -----------");
		System.out.println("==============================================");
		
//		Fase primeiraFase = retornarPrimeiraFase(missao.getListaFases());
		Fase primeiraFase = geralDAO.recuperaPrimeiraFase(missao.getId());
		
		System.out.println(primeiraFase.getHistoria());
		System.out.println("----------- op1 --------");
		System.out.println("(1) - " + primeiraFase.getHistResltadoOp1());
		System.out.println("----------- op2 --------");
		System.out.println("(2) - " + primeiraFase.getHistResutadoOp2());
		System.out.println(" Escolha o seu caminho:");
		
		int opSelecionada = sNumero.nextInt();
		
		Fase faseSelecionada = null;
		
		if(opSelecionada == 1) {
			faseSelecionada = primeiraFase.getOp1();
		}else {
			faseSelecionada = primeiraFase.getOp2();
		}

		boolean fim = false;
		
		while (!fim) {
			System.out.println(faseSelecionada.getHistoria());
			System.out.println("----------- op1 --------");
			System.out.println("(1) - " + faseSelecionada.getHistResltadoOp1());
			System.out.println("----------- op2 --------");
			System.out.println("(2) - " + faseSelecionada.getHistResutadoOp2());
			System.out.println(" Escolha o seu caminho:");
			
			opSelecionada = sNumero.nextInt();
			
			if(opSelecionada == 1) {
				faseSelecionada = faseSelecionada.getOp1();
			}else {
				faseSelecionada = faseSelecionada.getOp2();
			}
			
			if(faseSelecionada.getObjetivo() != null && "S".equals(faseSelecionada.getObjetivo().getFinall())) {
				fim = true;
			}
			
		}
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(faseSelecionada.getHistoria());
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			
		//Fluxo de atribuição de valores ao personagem
		personagem.setArma(faseSelecionada.getObjetivo().getArma());
		personagem.setArmadura(faseSelecionada.getObjetivo().getArmadura());
		personagem.setMoeda(personagem.getMoeda() + faseSelecionada.getObjetivo().getMoeda());
		personagem.setAtaque(personagem.getAtaque() + personagem.getArma().getAtaque());
		personagem.setDefesa(personagem.getDefesa() + personagem.getArmadura().getDefesa());
		
		
		geralDAO.salvar(personagem);//salva informações no banco
				
		System.out.println("\n ------- Jogo Finalizado -------\n");
		
		// mostra os estatos no inicio pegando do Banco de Dados
		show(geralDAO.recuperar(new Personagem(), personagem.getId()));

	}
	
	public static Personagem retornarPersonagemId(int id, List<Personagem> listaPersonagem) {
		for (Personagem pers : listaPersonagem) {
			if(pers.getId() == id) {
				return pers;
			}
		}
		return null;
	}
	
	public static Missao retornaMissaoId(int id, List<Missao> listaMissao) {
		for (Missao mis : listaMissao) {
			if(mis.getId() == id) {
				return mis;
			}
		}
		return null;
	}
	
	public static Fase retornarPrimeiraFase(List<Fase> listaFase) {
		for (Fase fase : listaFase) {
			if (fase.getOrdem() == 1) {
				return fase;
			}
		}
		return null;
	}

	/**
	 * @author Gilberto
	 * 
	 * Mostras informações do personagem e Salva no banco
	 * 
	 * @param geralDAO
	 * @param personagem
	 */
	public static void show(Object personagem) {
		System.out.println("===============================");
		System.out.println(((Personagem) personagem).getNome() + " - " + "@Id - " + ((Personagem) personagem).getId());
		System.out.println("Aqui estão suas skills:");
		System.out.println("Ataque: " + (((Personagem) personagem).getAtaque()));
		System.out.println("Defesa: " + (((Personagem) personagem).getDefesa()));
		System.out.println("Agilidade: " + (((Personagem) personagem).getAgilidade()));
		System.out.println("Vida: " + (((Personagem) personagem).getVida()));
		System.out.println("Classe: " + (((Personagem) personagem).getClasse().getNome()));
		System.out.println("Raça: " + (((Personagem) personagem).getRaca().getNome()));
		System.out.println("Arma: " + (((Personagem) personagem).getArma().getNome()));
		System.out.println("Armadura: " + (((Personagem) personagem).getArmadura().getNome()));
		System.out.println("Moedas: " + (((Personagem) personagem).getMoeda()));
		System.out.println("===============================");
	}
}
