package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "OBJETIVO")
public class Objetivo {
	
	@Id
	@Column (name = "ID", nullable = false)
	@GeneratedValue(generator = "S_ID_OBJETIVO")
	@SequenceGenerator(name = "S_ID_OBJETIVO", sequenceName = "S_ID_OBJETIVO", allocationSize = 1)
	private int id;
	
	@Column (name = "NOME", nullable = false, length = 100)
	private String nome;
	@Column (name = "MOEDA", nullable = false)
	private int moeda;
	@Column (name = "FINAL", nullable = false, length = 1) //"S" ou "N"
	private String finall;
	
	@OneToOne
	@JoinColumn (name = "NOME_ARMADURA", referencedColumnName = "NOME", nullable = true)
	private Armadura armadura;
	
	@OneToOne
	@JoinColumn (name = "NOME_ARMA", referencedColumnName = "NOME", nullable = true)
	private Arma arma;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMoeda() {
		return moeda;
	}
	public void setMoeda(int moeda) {
		this.moeda = moeda;
	}
	
	public String getFinall() {
		return finall;
	}
	public void setFinall(String finall) {
		this.finall = finall;
	}
	public Armadura getArmadura() {
		return armadura;
	}
	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	
	

}
