package br.com.dougcunha.healthtrack.entity;

import java.util.Date;

public class Peso extends Monitoramento {
	private float peso;
	
	
	public Peso(int id, Date data, Usuario usuario, float peso) {
		super(id, data, usuario);
		this.peso = peso;
	}

	public Peso(float peso) {
		super();
		this.peso = peso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void exibir() {

	}

}
