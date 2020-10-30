package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.model.Vagas;

public class DaoVaga<E> extends DaoGeneric<Vagas> {

	public List<Vagas> list = new ArrayList<Vagas>();
	private String sql = " from vagas ";
	
	
	
	public List<Vagas> pesquisar(String campoBusca) {
		
		/*Fazendo consulta no banco pela vaga de titulo informado pelo usuário*/
		Query query = super.getEntityManager().createQuery("from Vagas where titulo like '%"+campoBusca+"%' ");
		
		return query.getResultList();
		
	}
	
}
