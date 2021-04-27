package entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "PERSONAGEM")
public class Personagem {
	
	@Id
	@Column (name = "ID", nullable = false)
	@GeneratedValue(generator = "S_ID_PERSONAGEM")
	@SequenceGenerator(name = "S_ID_PERSONAGEM", sequenceName = "S_ID_PERSONAGEM", allocationSize = 1)
	private int id;
	
	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;
	@Column (name = "MOEDA", nullable = false)
	private int moeda;
	@Column (name = "VIDA", nullable = false)
	private int vida;
	@Column (name = "DEFESA", nullable = false)
	private int defesa;
	@Column (name = "ATAQUE", nullable = false)
	private int ataque;
	@Column (name = "AGILIDADE", nullable = false)
	private int agilidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "NOME_ARMA", referencedColumnName = "NOME", nullable = false)
	private Arma arma;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "NOME_ARMADURA", referencedColumnName = "NOME", nullable = false)
	private Armadura armadura;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "NOME_RACA", referencedColumnName = "NOME", nullable = false)
	private Raca raca;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "NOME_CLASSE", referencedColumnName = "NOME", nullable = false)
	private Classe classe;
	
	//Generate Getters and Setters
	
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
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public Armadura getArmadura() {
		return armadura;
	}
	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}
	public Raca getRaca() {
		return raca;
	}
	public void setRaca(Raca raca) {
		this.raca = raca;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	

}
