package co.ufps.elecciones.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor	
@AllArgsConstructor
public class Candidato implements Serializable {
	private Integer id;
	private String documento;
	private String nombre;
	private String apellido;
	private Integer eleccion;
	private Integer numero;
	public Candidato(String documento, String nombre, String apellido, Integer eleccion, Integer numero) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
		this.numero = numero;
	}
	
	
}
