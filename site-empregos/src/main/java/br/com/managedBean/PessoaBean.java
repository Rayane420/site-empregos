package br.com.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.dao.DaoUsuario;
import br.com.model.UsuarioPessoa;

@ManagedBean (name = "pessoaBean")
@ViewScoped
public class PessoaBean {

	private UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
	private DaoUsuario<UsuarioPessoa> daoGeneric = new DaoUsuario<UsuarioPessoa>(); 
	private List<UsuarioPessoa> list = new ArrayList<UsuarioPessoa>();
	private String campoBusca;
	

	@PostConstruct
	public void init(){
		list = daoGeneric.listar(UsuarioPessoa.class);
	}
	
	
	public PessoaBean() {

	}


	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}


	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}
	
	public String salvar() {
		daoGeneric.salvar(usuarioPessoa);
		list.add(usuarioPessoa);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:","Cadastro realizado com sucesso!"));
		return "";
	}
	
	public String logar() {
		return "";
	}
	
	
	
	public String novo() {
		usuarioPessoa = new UsuarioPessoa();
		return "";
	}
	
	public List<UsuarioPessoa> getList() {
		return list;
	}
	
	public void pesquisar() {
		list = daoGeneric.pesquisar(campoBusca);
	}


	public String getCampoBusca() {
		return campoBusca;
	}


	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}
	
	
	
}