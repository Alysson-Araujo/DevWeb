package br.com.farmacia.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import javax.persistence.Table;

@Table(name="funcionario")
@Entity
public class Funcionario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "cpf")
	@NotBlank
	String cpf;
	
	@Column(name = "nome")
	@NotBlank
	String nome;
	
	@Column(name = "telefone")
	@NotBlank
	String telefone;
	
	@Column(name = "email")
	@NotBlank
	@Email
	String email;
	
	@Column(name = "salario")
	@NotNull
	Double salario;
	
	@Deprecated
	public Funcionario() {}
	
	public Funcionario(@NotBlank String cpf, @NotBlank String nome, @NotBlank String telefone,
			@NotBlank @Email String email, Double salario) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.salario = salario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	

}
