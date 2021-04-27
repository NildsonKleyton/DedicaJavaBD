package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "MISSAO")
public class Missao {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "S_ID_MISSAO")
	@SequenceGenerator(name = "S_ID_MISSAO", sequenceName = "S_ID_MISSAO", allocationSize = 1)
	private int id;
	
	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;
	@Column(name = "HISTORIA", nullable = false, length = 4000)
	private String historia;
	
	@OneToMany (mappedBy = "missao", cascade = CascadeType.ALL)
	private List<Fase> listaFasses;
	
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
	public List<Fase> getListaFasses() {
		return listaFasses;
	}
	public void setListaFasses(List<Fase> listaFasses) {
		this.listaFasses = listaFasses;
	}

}
