package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARMADURA")
public class Armadura {

	@Id
	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;
	@Column(name = "MATERIAL", nullable = false, length = 100)
	private String material;
	@Column(name = "DEFESA", nullable = false)
	private int defesa;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

}
