package DedicaJavaBD.DedicaJavaBD;

import dao.RPGGeralDAO;
import dao.RPGGeralDAOImpl;
import entidade.Arma;
import entidade.Armadura;
import entidade.Fase;
import entidade.Missao;
import entidade.Objetivo;

public class CriacaoMissaoFase {

	public static void main(String[] args) {

		RPGGeralDAO geralDAO = new RPGGeralDAOImpl();

		Missao m = new Missao();
		m.setNome("Mundo Dos Mortos");
		m.setHistoria("Terra dos mortos, local onde a alma das pessoas "
				+ " se dirigirem após a morte. Nesse local as almas passam"
				+ " por um julgamento, onde seu destino é decidido. Diversos"
				+ " seres abitam este local. Derrote todos os guardiões desse" + " lugar e pegue a chave da morte.");

		m = (Missao) geralDAO.salvar(m);

//----------------------------------------------------------------		
		Objetivo objSair = new Objetivo();
		objSair.setNome("Sair do mundo dos Mortos");
		objSair.setFinall("S");

		objSair = (Objetivo)geralDAO.salvar(objSair);
		
		Fase fSair = new Fase();
		fSair.setMissao(m);
		fSair.setNome("Desistir do mundo dos mortos");
		fSair.setHistoria("Vou sair do mundo dos mortos agora mesmo");
		fSair.setHistResltadoOp1(null);
		fSair.setHistResutadoOp2(null);
		fSair.setOp1(null);
		fSair.setOp2(null);
		fSair.setObjetivo(objSair);
		fSair.setOrdem(5);

		fSair = (Fase) geralDAO.salvar(fSair);
// --------------------------------------------------------------		

		Arma armaFinal = new Arma();
		armaFinal.setNome("Peixeira");
		armaFinal.setAtaque(10);
		armaFinal.setMaterial("Brutalidade");

		geralDAO.salvar(armaFinal);
		
		Armadura armaduraFinal = new Armadura();
		armaduraFinal.setNome("Cangaceiro");
		armaduraFinal.setDefesa(10);
		armaduraFinal.setMaterial("Couro de Gia");

		geralDAO.salvar(armaduraFinal);
		
		Objetivo objFinal = new Objetivo();
		objFinal.setNome("Final do mundo dos mortos");
		objFinal.setFinall("S");
		objFinal.setMoeda(100);
		objFinal.setArma(armaFinal);
		objFinal.setArmadura(armaduraFinal);
		
		objFinal = (Objetivo)geralDAO.salvar(objFinal);

		Fase ffinal = new Fase();
		ffinal.setMissao(m);
		ffinal.setNome("Final");
		ffinal.setHistoria("Você entrou no mundo dos mortos e está aqui a sua " + " recompensa ...");
		ffinal.setHistResltadoOp1(null);
		ffinal.setHistResutadoOp2(null);
		ffinal.setOp1(null);
		ffinal.setOp2(null); // Fase de sair do mundo dos mortos
		ffinal.setObjetivo(objFinal);
		ffinal.setOrdem(4);
		
		ffinal = (Fase)geralDAO.salvar(ffinal);
		
// ----------------------------------------------------------------
		
		Fase fEntrou = new Fase();
		fEntrou.setMissao(m);
		fEntrou.setNome("Após derrotar o cão");
		fEntrou.setHistoria("Após derrotar o cão o personagem entrar ao mundo "
				+ " dos mortos com toda a sua bravura e determinação.");
		fEntrou.setHistResltadoOp1("Finalizar a missão, vc entrou no mundo dos mortos");
		fEntrou.setHistResutadoOp2("Desistir de entrar no mundo dos mortos");
		fEntrou.setOp1(ffinal); //Fase final do jogo
		fEntrou.setOp2(fSair); // Fase de sair do mundo dos mortos
		fEntrou.setObjetivo(null);
		fEntrou.setOrdem(3);

		fEntrou = (Fase)geralDAO.salvar(fEntrou);
		
// ------------------------------------------------------------------
		
		Fase fDesafioCao = new Fase();
		fDesafioCao.setMissao(m);
		fDesafioCao.setNome("Desafiar o cão do mundo dos mortos");
		fDesafioCao.setHistoria("Para seguir no mundo dos mortos, vc tem que passar "
				+ " pelo guardião dos portões, o cão de 3 cabeças !");
		fDesafioCao.setHistResltadoOp1("Derrotar o cão e seguir");
		fDesafioCao.setHistResutadoOp2("Desistir de entrar no mundo dos mortos");
		fDesafioCao.setOp1(fEntrou); //Fase de entrar no mundo
		fDesafioCao.setOp2(fSair); // Fase de sair do mundo dos mortos
		fDesafioCao.setObjetivo(null);
		fDesafioCao.setOrdem(2);

		fDesafioCao = (Fase)geralDAO.salvar(fDesafioCao);

// --------------------------------------------------------------------		
		
		Fase fPrimeira = new Fase();
		fPrimeira.setMissao(m);
		fPrimeira.setNome("Entrada para o mundo dos mortos");
		fPrimeira.setHistoria("Na porta do mundo dos mortos " + " fica um cão demoníaco que protege "
				+ " a entrada para este reino.");
		fPrimeira.setHistResltadoOp1("Desafiar o cão do mundo dos mortos");
		fPrimeira.setHistResutadoOp2("Desistir de entrar no mundo dos mortos");
		fPrimeira.setOp1(fDesafioCao); //Fase de desafir o cão
		fPrimeira.setOp2(fSair); // Fase de sair do mundo dos mortos
		fPrimeira.setObjetivo(null);
		fPrimeira.setOrdem(1);
		
		geralDAO.salvar(fPrimeira);

	}
}
