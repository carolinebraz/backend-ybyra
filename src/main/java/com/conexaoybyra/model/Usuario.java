package com.conexaoybyra.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O atributo nome é obrigatório!")
	@Size(max = 255, message = "O atributo nome deve ter no máximo 255 caracteres")
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo e-mail é obrigatório!")
	@Size(max = 255, message = "O atributo e-mail deve ter no máximo 255 caracteres")
	@Email(message = "O atributo e-mail deve ser um e-mail válido!")
	private String email;

	@NotNull(message = "O atributo senha é obrigatório!")
	@Size(min = 8, max = 255, message = "A senha deve ter no mínimo 8 caracteres e no máximo 255 caracteres")
	private String senha;

	@Size(max = 255, message = "O link da foto não pode ser maior do que 255 caracteres")
	private String foto;
	
	@NotNull(message = "O atributo endereço é obrigatório!")
	@Size(max = 255, message = "O atributo endereço deve ter no máximo 255 caracteres")
	private String endereco;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Postagem> getPostagem() {
		return this.postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}