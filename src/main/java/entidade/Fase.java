package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "FASE")
public class Fase {
	
	@Id
	@Column (name = "ID", nullable = false)
	@GeneratedValue(generator = "S_ID_FASE")
	@SequenceGenerator(name = "S_ID_FASE", sequenceName = "S_ID_FASE", allocationSize = 1)
	private int id;
	
	@Column (name = "NOME", nullable = false, length = 100)
	private String nome;
	
	@Column (name = "HISTORIA", nullable = false, length = 4000)
	private String historia;
	
	@Column (name = "ORDEM", nullable = false)
	private int ordem;
	
	@OneToOne
	@JoinColumn (name = "OP1", referencedColumnName = "ID", nullable = true)
	private Fase op1;
	
	@Column (name = "HISTRESULTADOOP1", nullable = true, length = 4000)
	private String histResltadoOp1;
	
	@OneToOne
	@JoinColumn (name = "OP2", referencedColumnName = "ID", nullable = true)
	private Fase op2;
	
	@Column (name = "HISTRESULTADOOP2", nullable = true, length = 4000)
	private String histResutadoOp2;
	
	@ManyToOne
	@JoinColumn (name = "ID_MISSAO", referencedColumnName = "ID", nullable = false)
	private Missao missao;
	
	@OneToOne
	@JoinColumn (name = "ID_OBJETIVO", referencedColumnName = "ID", nullable = true)
	private Objetivo objetivo;
	
	
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
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public String getHistResltadoOp1() {
		return histResltadoOp1;
	}
	public void setHistResltadoOp1(String histResltadoOp1) {
		this.histResltadoOp1 = histResltadoOp1;
	}
	public String getHistResutadoOp2() {
		return histResutadoOp2;
	}
	public void setHistResutadoOp2(String histResutadoOp2) {
		this.histResutadoOp2 = histResutadoOp2;
	}
	public Missao getMissao() {
		return missao;
	}
	public void setMissao(Missao missao) {
		this.missao = missao;
	}
	public Objetivo getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}
	public Fase getOp1() {
		return op1;
	}
	public void setOp1(Fase op1) {
		this.op1 = op1;
	}
	public Fase getOp2() {
		return op2;
	}
	public void setOp2(Fase op2) {
		this.op2 = op2;
	}
	

}
