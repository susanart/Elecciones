package co.ufps.elecciones.dao;

import java.sql.SQLException;
import java.util.List;

import co.ufps.elecciones.modelo.Candidato;

public interface CandidatoDao {
	public void insert(Candidato candidato) throws SQLException;
	public Candidato select(int id);
	public List < Candidato > selectAll();
	public void delete(int i) throws SQLException;
	public void update(Candidato candidato) throws SQLException;
}
