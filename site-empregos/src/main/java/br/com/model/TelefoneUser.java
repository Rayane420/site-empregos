package br.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefoneUser {
	
	/**------------Criando primary Key-----------------*/
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable = false)
	private String tipo;
	
	/**Informando que a coluna não pode ter valor null -- nullable false*/
	@Column (nullable = false)
	private String numero;
	
	/**------Definindo que a relação entre as tabelas é manyToOne = muitos para um e que não é opcional*/
	@ManyToOne (optional = false, fetch = FetchType.EAGER)
	private UsuarioPessoa usuarioPessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}

	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}
	
	
	
	
}
