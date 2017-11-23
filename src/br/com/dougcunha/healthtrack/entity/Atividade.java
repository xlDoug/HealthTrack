package br.com.dougcunha.healthtrack.entity;
public class Atividade extends Caloria {
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
	private int id;
	private TipoAtividade tipoAtividade;

}
