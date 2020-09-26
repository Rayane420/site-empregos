package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.UsuarioPessoa;

@ManagedBean (name = "pessoaBean")
@ViewScoped
public class PessoaBean {

	UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
	
	
	
	
	
}