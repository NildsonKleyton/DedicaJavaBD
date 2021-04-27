package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CLASSE")
public class Classe {
	
	@Id
	@Column(name = "NOME", nullable = false, length = 100) 
	private String nome;
	@Column(name = "VIDA", nullable = false)
	private int vida;
	@Column(name = "DEFESA", nullable = false)
	private int defesa;
	@Column(name = "ATAQUE", nullable = false)
	private int ataque;
	@Column(name = "AGILIDADE", nullable = false)
	private int agilidade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getAgilidade() {
		return agilidade;
	}
	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}
	
	

}
