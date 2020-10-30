package br.com.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.dao.DaoVaga;
import br.com.model.Vagas;

@ManagedBean (name = "vagasBean")
@ViewScoped
public class VagaBean {
	
	private Vagas vagas = new Vagas();
	private DaoVaga<Vagas> daoVaga = new DaoVaga<Vagas>();
	private List<Vagas> list = new ArrayList<Vagas>();
	private String campoBusca;
	
	@PostConstruct
	public void init() {
		list = daoVaga.listar(Vagas.class);
	}
	
	public VagaBean() {
		
	}
	
	public Vagas getVagas() {
		return vagas;
	}
	
	public void setVagas(Vagas vagas) {
		this.vagas = vagas;
	}
	
	public String salvar() {
		
		daoVaga.salvar(vagas);
		list.add(vagas);
		
		/** Mensagem quando a vaga for salva com sucesso*/
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:","Nova Vaga Cadastrada com Sucesso!"));
		
		vagas = new Vagas();
		
		return "";
	}
	
	public void pesquisar() {
		list = daoVaga.pesquisar(campoBusca);
	}
	
	public List<Vagas> getList() {
		return list;
	}
	
	
	public String getCampoBusca() {
		return campoBusca;
	}
	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}
	
}
