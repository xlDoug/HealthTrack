package br.com.dougcunha.healthtrack.entity;

import java.util.Calendar;

public class Alimento extends Caloria {
	private int id;
	private String descricao;
	private TipoAlimento tipoAlimento;
	
	public int getId() {
		return id;
	}
	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Alimento(Calendar data, Usuario usuario, short caloria, int id, String descricao,
			TipoAlimento tipoAlimento) {
		super(data, usuario, caloria);
		this.id = id;
		this.descricao = descricao;
		this.tipoAlimento = tipoAlimento;
	}
	public Alimento() {
		super();
	}
	@Override
	public String toString() {
		return "Alimento [id=" + id + ", descricao=" + descricao + ", tipoAlimento=" + tipoAlimento + ", getCaloria()="
				+ getCaloria() + ", getData()=" + getData() + ", getUsuario()=" + getUsuario() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
