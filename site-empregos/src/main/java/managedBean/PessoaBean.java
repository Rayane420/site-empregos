package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.DaoUsuario;
import model.UsuarioPessoa;

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