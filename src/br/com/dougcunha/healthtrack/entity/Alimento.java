package br.com.dougcunha.healthtrack.entity;
public class Alimento extends Caloria {
	private int id;
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
	@Override
	public String toString() {
		return "Alimento [id=" + id + ", tipoAlimento=" + tipoAlimento + ", getCaloria()=" + getCaloria()
				+ ", getData()=" + getData() + ", getUsuario()=" + getUsuario() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	

}
