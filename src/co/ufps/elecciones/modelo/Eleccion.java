package co.ufps.elecciones.modelo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor	
@AllArgsConstructor
public class Eleccion implements Serializable {
	private Integer id;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String cargo;
	public Eleccion(String nombre, Date fechaInicio, Date fechaFin, String cargo) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
	}
	
	
	
}
