package br.com.dougcunha.healthtrack.entity;

import java.util.Calendar;

public class PressaoArterial extends Monitoramento {
	private float sistolica;
	private float diastolica;
	public PressaoArterial(int id, Calendar data, Usuario usuario, float sistolica, float diastolica) {
		super(id, data, usuario);
		this.sistolica = sistolica;
		this.diastolica = diastolica;
	}
	public PressaoArterial() {
		super();
	}
	public float getSistolica() {
		return sistolica;
	}
	public void setSistolica(float sistolica) {
		this.sistolica = sistolica;
	}
	public float getDiastolica() {
		return diastolica;
	}
	public void setDiastolica(float diastolica) {
		this.diastolica = diastolica;
	}
	public String calcularSituacao(float diast, float sist) {
		String situacao = "NORMAL";
		if (sist>140F || diast>90F) {
			situacao = "ELEVADA";
		}
		if (sist< 120F || diast<80F) {
			situacao = "ABAIXO DO NORMAL";
		}
		return situacao;
	}
	@Override
	public String toString() {
		return "PressaoArterial [sistolica=" + sistolica + ", diastolica=" + diastolica + "]";
	}
	
}
