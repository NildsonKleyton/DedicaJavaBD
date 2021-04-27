package TesteDeClasse;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
public class App_teste 
{
    public static void main( String[] args )
    {
        EntityManager ent = JpaUtil.getEntityManager();
		System.out.println(ent.isOpen());
		if (ent.isOpen() == true) {
			System.out.println("Conecxão Estabelecida!");
		}else {
			System.out.println("Sem Conecxão!");
		} 
       
        Arma arma = new Arma();
        arma.setNome("TesteArma");
        arma.setAtaque(4);
        arma.setMaterial("Prata");
        ent.persist(arma);
        
        Armadura armadura = new Armadura();
        armadura.setNome("TesteArmadura");
        armadura.setDefesa(5);
        armadura.setMaterial("Ferro");
        ent.persist(armadura);
        
        Raca raca = new Raca();
        raca.setNome("TesteRaça");
        raca.setAtaque(20);
        raca.setDefesa(20);
        raca.setVida(5);
        raca.setAgilidade(1);
        ent.persist(raca);
        
        Classe classe = new Classe();
        classe.setNome("TesteClase");
        classe.setVida(3);
        classe.setAtaque(4);
        classe.setDefesa(2);
        classe.setAgilidade(6);
        ent.persist(classe);
       
        Personagem p = new Personagem();
        p.setNome("Testador");
        p.setMoeda(10);
        p.setVida(5);
        p.setDefesa(4);
        p.setAtaque(7);
        p.setAgilidade(6);
        p.setArma(arma);
        p.setArmadura(armadura);
        p.setRaca(raca);
        p.setClasse(classe);
        ent.persist(p);
       
        EntityTransaction tx = ent.getTransaction();
        
        tx.begin();
        
        tx.commit();
        ent.close();
        
        System.out.println("SUCESSO");
    }
}
