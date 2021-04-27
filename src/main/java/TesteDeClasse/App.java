package TesteDeClasse;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Arma;
import entidade.Armadura;
import entidade.Classe;
import entidade.Personagem;
import entidade.Raca;
import util.JpaUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
//		Raca raca = new Raca();
//		
//		raca.setNome("Captão Patria");
//		raca.setAtaque(20);
//		raca.setDefesa(20);
//		raca.setVida(5);
//		raca.setAgilidade(1);
//
////		inserir(raca);
//		
//		Raca pp = (Raca)buscar(Raca.class, "Leitinho");
//		
//		System.out.println(pp.getNome() +" - "+ pp.getVida());
		
//		Arma arma = new Arma();
//        arma.setNome("TesteArma");
//        arma.setAtaque(4);
//        arma.setMaterial("Prata");
////        ent.persist(arma);
//        
//        Armadura armadura = new Armadura();
//        armadura.setNome("TesteArmadura");
//        armadura.setDefesa(5);
//        armadura.setMaterial("Ferro");
////        ent.persist(armadura);
//        
//        Raca raca = new Raca();
//        raca.setNome("TesteRaça");
//        raca.setAtaque(20);
//        raca.setDefesa(20);
//        raca.setVida(5);
//        raca.setAgilidade(1);
////        ent.persist(raca);
//        
//        Classe classe = new Classe();
//        classe.setNome("TesteClase");
//        classe.setVida(3);
//        classe.setAtaque(4);
//        classe.setDefesa(2);
//        classe.setAgilidade(6);
////        ent.persist(classe);
//       
//        Personagem p = new Personagem();
//        p.setNome("Testador");
//        p.setMoeda(10);
//        p.setVida(5);
//        p.setDefesa(4);
//        p.setAtaque(7);
//        p.setAgilidade(6);
//        p.setArma(arma);
//        p.setArmadura(armadura);
//        p.setRaca(raca);
//        p.setClasse(classe);
////        ent.persist(p);
//		
//        inserir(p);

        
		Arma arma = new Arma();
        arma.setNome("TesteArma");
        
        Armadura armadura = new Armadura();
        armadura.setNome("TesteArmadura");
        
        Raca raca = new Raca();
        raca.setNome("TesteRaça");
        
        Classe classe = new Classe();
        classe.setNome("TesteClase");
       
        Personagem p = new Personagem();
        p.setNome("Testador do Mal");
        p.setMoeda(10);
        p.setVida(5);
        p.setDefesa(4);
        p.setAtaque(7);
        p.setAgilidade(6);
        p.setArma(arma);
        p.setArmadura(armadura);
        p.setRaca(raca);
        p.setClasse(classe);
//        ent.persist(p);
		
        inserir(p);
        
//        List<Raca> racas = listarRacas();
//        
//        for (Raca rr : racas) {
//			System.out.println(rr.getNome() + " - " + rr.getAtaque());
//		}
//        
//        System.out.println("++++++++++++++++++++++++++++++++");
//        
//        List<Personagem> personas = listarPersonagens();
//        
//        for (Personagem pp : personas) {
//			System.out.println(pp.getNome() + " - " + pp.getRaca().getNome());
//		}
        
        
		
		System.out.println("-- funfou --");
	}
	
	/**
	 * Metodo de inserir generico
	 * @param obj
	 */
	private static void inserir(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(obj);

		tx.commit();
		ent.close();
		
		System.out.println("-- funfou --");
	}
	
	/**
	 * Metodo que recupera do banco
	 * @param classe
	 * @param chave
	 * @return
	 */
	private static Object buscar(Class classe, Object chave){
		
		EntityManager ent = JpaUtil.getEntityManager();
		return ent.find(classe, chave);
		
	}
	
	/**
	 * MEtodo utilizado para recuperar todos os registros
	 * @return
	 */
	private static List<Raca> listarRacas() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Raca");
		
		List<Raca> racas = query.getResultList();
	
		return racas;
		
	}
	
	/**
	 * MEtodo utilizado para recuperar todos os registros
	 * @return
	 */
	private static List<Personagem> listarPersonagens() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Personagem p where p.raca.nome = 'TesteRaça'");
		
		List<Personagem> personagens = query.getResultList();
	
		return personagens;
		
	}
}
