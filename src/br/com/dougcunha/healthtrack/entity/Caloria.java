package br.com.dougcunha.healthtrack.entity;

import java.util.Calendar;

public class Caloria extends Monitoramento {

	private short caloria;

	public short getCaloria() {
		return caloria;
	}

	public void setCaloria(short caloria) {
		this.caloria = caloria;
	}

	public Caloria(short caloria) {
		super();
		this.caloria = caloria;
	}

	public Caloria() {
		super();
	}

	public Caloria(Calendar data, Usuario usuario, short caloria) {
		super(data, usuario);
		this.caloria = caloria;
	}
	
	
	

}
