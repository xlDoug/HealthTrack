package br.com.dougcunha.healthtrack.entity;

import java.util.Calendar;

public class Monitoramento {

	private int id;

	private Calendar data;

	private Usuario usuario;

	public void exibir() {

	}

	public int getId() {
		return id;
	}

	public Monitoramento() {
		super();
	}

	public Monitoramento(int id, Calendar data, Usuario usuario) {
		super();
		this.id = id;
		this.data = data;
		this.usuario = usuario;
	}
	public Monitoramento(Calendar data, Usuario usuario) {
		super();
		this.data = data;
		this.usuario = usuario;
	}

	public Calendar getData() {
		return data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
