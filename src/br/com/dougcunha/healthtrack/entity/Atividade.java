package br.com.dougcunha.healthtrack.entity;

import java.util.Calendar;

public class Atividade extends Caloria {
	private int id;
	private TipoAtividade tipoAtividade;
	private String descricao;
	
	public int getId() {
		return id;
	}
	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	public Atividade(Calendar data, String descricao,Usuario usuario, short caloria, int id, TipoAtividade tipoAtividade) {
		super(data, usuario, caloria);
		this.id = id;
		this.descricao = descricao;
		this.tipoAtividade = tipoAtividade;
	}
	public Atividade(Calendar data, String descricao,Usuario usuario, short caloria, TipoAtividade tipoAtividade) {
		super(data, usuario, caloria);
		this.descricao = descricao;
		this.tipoAtividade = tipoAtividade;
	}
	public Atividade(short caloria) {
		super(caloria);
	}
	@Override
	public String toString() {
		return "Atividade [id=" + id + ", tipoAtividade=" + tipoAtividade + ", getCaloria()=" + getCaloria()
				+ ", getData()=" + getData() + ", getUsuario()=" + getUsuario() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	
}
