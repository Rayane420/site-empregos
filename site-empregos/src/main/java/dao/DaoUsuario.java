package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.UsuarioPessoa;

public class DaoUsuario<E> extends DaoGeneric<UsuarioPessoa> {
	
	public List<UsuarioPessoa> list =  new ArrayList<UsuarioPessoa>();

	public List<UsuarioPessoa> getList(){
	
	return list;
	}
	
}
