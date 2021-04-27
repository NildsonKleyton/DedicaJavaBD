package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Fase;
import util.JpaUtil;

public class RPGGeralDAOImpl implements RPGGeralDAO{

	@Override
	public List listar(Object obj) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		
		Query query = ent.createQuery("from " + obj.getClass().getSimpleName());
	
		return query.getResultList();
	}

	@Override
	public Object salvar(Object obj) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Object retorno = null;
		
		tx.begin();

		retorno = ent.merge(obj);

		tx.commit();
		ent.close();
		
		return retorno;
	}

	@Override
	public Object recuperar(Object obj, Object chavePrimaria) {
		
		EntityManager ent = JpaUtil.getEntityManager();

		Object retorno = null;
		
		retorno = ent.find(obj.getClass(), chavePrimaria);

		ent.close();
		
		return retorno;
	}
	
	@Override
	public Fase recuperaPrimeiraFase(int idMissao) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		
		Query query = ent.createQuery("from Fase f where f.ordem = 1 and f.missao.id = " + idMissao);
		
		return (Fase)query.getSingleResult();
		
	}
	
}
