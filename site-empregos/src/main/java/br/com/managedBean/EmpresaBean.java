package br.com.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.dao.DaoEmpresa;
import br.com.model.Empresas;

@ManagedBean (name = "empresaBean")
@ViewScoped
public class EmpresaBean {
	
	private Empresas empresas = new Empresas();
	private DaoEmpresa<Empresas> daoGeneric = new DaoEmpresa<Empresas>();
	private List<Empresas> list = new ArrayList<Empresas>();
	private String campoBusca;
	
	@PostConstruct
	public void init() {
		list = daoGeneric.listar(Empresas.class);
	}
	
	public EmpresaBean() {

	}

	public Empresas getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Empresas empresas) {
		this.empresas = empresas;
	}

	public List<Empresas> getList(){
		return list;
	}
	
	public void pesquisar() {
		list = daoGeneric.pesquisar(campoBusca);
	}
	
	public String salvar() {
		daoGeneric.salvar(empresas);
		list.add(empresas);
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns:","Empresa cadastrada com sucesso!"));
		empresas = new Empresas();
		return "";
	}
	
	public String getCampoBusca() {
		return campoBusca;
	}

	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}
	
	

}
