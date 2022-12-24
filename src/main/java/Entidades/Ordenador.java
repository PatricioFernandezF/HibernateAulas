package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "ordenador")
public class Ordenador {

	@Id
	@Column(name = "ordenador_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String marca;
	private int anno;
	private String tipo;
	
	@ManyToOne()
	@JoinColumn(name = "aula_id")
	private Aula aula;
	
	
	public Ordenador() {
		super();
	}
	
	public Ordenador(String marca, int anno, String tipo) {
		super();
		this.marca = marca;
		this.anno = anno;
		this.tipo = tipo;
	}
	
	
	
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
