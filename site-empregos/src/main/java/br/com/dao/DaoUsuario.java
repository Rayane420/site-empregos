package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.model.UsuarioPessoa;

public class DaoUsuario<E> extends DaoGeneric<UsuarioPessoa> {
	
	public List<UsuarioPessoa> list =  new ArrayList<UsuarioPessoa>();
	private String sql = " from usuariopessoa ";
	
	

	
	public List<UsuarioPessoa> pesquisar(String campoBusca) {
		/**Fazendo consulta no banco de dados sem fazer distinção de maiusculas para minusculas usando ilike*/
		Query query = super.getEntityManager().createQuery("from UsuarioPessoa where nomecompleto like '%"+campoBusca+"%' ");
		
		return query.getResultList();
	}

	
	
}
