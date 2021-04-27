package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "PERSONAMGEM_MISSAO")
public class PersonagemMissao {
	
	@Id
	@Column (name = "ID", nullable = false)
	@GeneratedValue(generator = "S_ID_PERSONAGEM_MISSAO")
	@SequenceGenerator(name = "S_ID_PERSONAGEM_MISSAO", sequenceName = "S_ID_PERSONAGEM_MISSAO", allocationSize = 1)
	private int id;
	
	@Column (name = "CONCLUIDA", nullable = false, length = 1) //"S" ou "N"
	private String conluida;
	
	@ManyToOne
	@JoinColumn (name = "ID_PERSONAGEM", referencedColumnName = "ID", nullable = false)
	private Personagem personagem;
	
	@ManyToOne
	@JoinColumn (name = "ID_MISSAO", referencedColumnName = "ID", nullable = false)
	private Missao missao;
	
	//Generate Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConluida() {
		return conluida;
	}
	public void setConluida(String conluida) {
		this.conluida = conluida;
	}
	public Personagem getPersonagem() {
		return personagem;
	}
	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	public Missao getMissao() {
		return missao;
	}
	public void setMissao(Missao missao) {
		this.missao = missao;
	}
	

}
