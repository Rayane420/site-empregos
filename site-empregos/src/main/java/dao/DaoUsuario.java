package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.UsuarioPessoa;

public class DaoUsuario<E> extends DaoGeneric<UsuarioPessoa> {
	
	public List<UsuarioPessoa> list =  new ArrayList<UsuarioPessoa>();
	private String sql = " from UsuarioPessoa ";
	
	
	public List<UsuarioPessoa> getList(){
	return list;
	}
	
	public List<UsuarioPessoa> pesquisar(String campoBusca) {
		Query query = super.getEntityManager().createQuery("from UsuarioPessoa where nome like '%"+campoBusca+"%' ");
		
		return query.getResultList();
	}
	
	public void buscar(String campoBusca) {
		sql += " where nome like  '%"+campoBusca+"%'";
	}
	
}
