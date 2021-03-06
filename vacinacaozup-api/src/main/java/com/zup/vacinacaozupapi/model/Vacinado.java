package com.zup.vacinacaozupapi.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "vacinas_aplicadas")
public class Vacinado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull
	private String vacina;
	

	@ManyToOne
	private Usuario usuario;
	
	@NotNull
	@Column(name = "e_mail")
	@JoinTable(name="usuario")
	@JsonBackReference
	private String email;
	
	@Column(name = "data_aplicacao")
	private OffsetDateTime data;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OffsetDateTime getData() {
		return data;
	}

	public void setData(OffsetDateTime data) {
		this.data = data;
	}
	
	
	
	

}


