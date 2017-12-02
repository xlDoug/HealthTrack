package br.com.dougcunha.healthtrack.entity;
public class TipoAlimento {
	private String nome;
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAlimento(String nome) {
		super();
		this.nome = nome;
	}

	public TipoAlimento() {
		super();
	}


	@Override
	public String toString() {
		return "TipoAlimento [nome=" + nome + "]";
	}


}
