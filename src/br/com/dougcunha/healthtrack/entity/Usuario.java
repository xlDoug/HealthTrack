package br.com.dougcunha.healthtrack.entity;
import java.util.Calendar;
public class Usuario {
	private int id;
	private String nome;
	private Calendar dtNasc;
	private String email;
	private String senha;
	private float altura;
	
	public Usuario(int id, String nome, Calendar dtNasc, String email, String senha, float altura) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtNasc = dtNasc;
		this.email = email;
		this.senha = senha;
		this.altura = altura;
	}
	
	public Usuario() {
		super();
	}

	public void calcularIMC() {
	}
	public void exibir() {
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Calendar getDtNasc() {
		return dtNasc;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public float getAltura() {
		return altura;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDtNasc(Calendar dtNasc) {
		this.dtNasc = dtNasc;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", dtNasc=" + dtNasc + ", email=" + email + ", senha=" + senha
				+ ", altura=" + altura + "]";
	}

}
