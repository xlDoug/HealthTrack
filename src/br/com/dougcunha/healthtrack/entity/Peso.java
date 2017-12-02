package br.com.dougcunha.healthtrack.entity;

import java.util.Calendar;

public class Peso extends Monitoramento {
	@Override
	public String toString() {
		return "Peso [peso=" + peso + ", getId()=" + getId() + ", getData()=" + getData() + ", getUsuario()="
				+ getUsuario() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	private float peso;
	
	
	public Peso(int id, Calendar data, Usuario usuario, float peso) {
		super(id, data, usuario);
		this.peso = peso;
	}
	public Peso(Calendar data, Usuario usuario, float peso) {
		super(data, usuario);
		this.peso = peso;
	}
	public Peso() {
		super();
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
