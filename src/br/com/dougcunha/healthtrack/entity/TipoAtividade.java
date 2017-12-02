package br.com.dougcunha.healthtrack.entity;
public class TipoAtividade {
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoAtividade(String nome) {
		super();
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "TipoAtividade [nome=" + nome + "]";
	}

}
