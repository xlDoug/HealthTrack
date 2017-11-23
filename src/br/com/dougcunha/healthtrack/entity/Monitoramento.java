package br.com.dougcunha.healthtrack.entity;

import java.util.Date;

public class Monitoramento {

	private int id;

	private Date data;

	private Usuario usuario;

	public void exibir() {

	}

	public int getId() {
		return id;
	}

	public Monitoramento() {
		super();
	}

	public Monitoramento(int id, Date data, Usuario usuario) {
		super();
		this.id = id;
		this.data = data;
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
