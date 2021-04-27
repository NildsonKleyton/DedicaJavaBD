package dao;

import java.util.List;

import entidade.Fase;

public interface RPGGeralDAO {

	public List listar(Object obj);
	
	public Object salvar(Object obj);

	public Object recuperar(Object obj, Object chavePrimaria);

	public Fase recuperaPrimeiraFase(int idMissao);

}
