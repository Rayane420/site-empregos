package br.com.siteempregos;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteSite {
	
	
	/**------------Teste para criar o banco------------*/
	/*@Test
	public void testeSite() {
		HibernateUtil.getEntityManager();
	}*/
	
	
	
	
	/**------------Teste do método salvar do DaoGeneric------------*/
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setNomeCompleto("Rayane M.");
		pessoa.setLogin("Admin");
		pessoa.setSenha("admin123");
		pessoa.setGithub("https://github.com/Rayane420/");
		
		daoGeneric.salvar(pessoa);
	}
	
	
	/**------------Teste do método pesquisar do DaoGeneric------------*/
	@Test
	public void testeBusca() {
	DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	UsuarioPessoa pessoa = new UsuarioPessoa();
	pessoa.setId(1L);
	
	pessoa = daoGeneric.pesquisar(pessoa);
	
	System.out.println(pessoa);
	
	}
	
}