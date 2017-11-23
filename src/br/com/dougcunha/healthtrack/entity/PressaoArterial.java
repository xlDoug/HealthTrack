package br.com.dougcunha.healthtrack.entity;
public class PressaoArterial extends Monitoramento {
	private float minima;
	private float maxima;
	public float getMinima() {
		return minima;
	}

	public float getMaxima() {
		return maxima;
	}

	public void setMinima(float minima) {
		this.minima = minima;
	}

	public void setMaxima(float maxima) {
		this.maxima = maxima;
	}


}
