package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.model.Empresas;

public class DaoEmpresa<E> extends DaoGeneric<Empresas> {

	
	public List<Empresas> pesquisar (String campoBusca){
		
		//fazendo consulta no banco
		Query query = super.getEntityManager().createQuery("from Empresas where nome like '%"+campoBusca+"%' ");
		
		return query.getResultList();
	}
	
}
