package TesteDeClasse;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Classe;
import entidade.Personagem;
import entidade.Raca;
import util.JpaUtil;

public class TesteNomeClasse {

	public static void main(String[] args) {
		Raca r = new Raca();
		
		System.out.println(r.getClass().getSimpleName());
		
		List<Raca> listaRaca = (List<Raca>)listar(r);
		
		for (Raca raca : listaRaca) {
			System.out.println(raca.getNome());
		}

		System.out.println("+++++++++++++++++++++++++++++++++++");
		
		List<Classe> listaClasse = (List<Classe>)listar(new Classe());
		
		for (Classe classe : listaClasse) {
			System.out.println(classe.getNome());
		}
		
		List <Personagem> listaPersonagem = (List<Personagem>)listar(new Personagem());
		
		for (Personagem personagem : listaPersonagem) {
			System.out.println(personagem.getNome());
		}
	}
	
	private static List listar(Object obj) {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from " + obj.getClass().getSimpleName());
	
		return query.getResultList();
		
	}

}
