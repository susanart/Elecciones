package co.elecciones.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





 
public class ConexionPostgreSQL {
	private Connection con = null;
	private static ConexionPostgreSQL db;  // para patron singleton
	private PreparedStatement  preparedStatement;
	
	
	private static final String dbName = "mnjgxshj";
	private static final String host = "queenie.db.elephantsql.com";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	private static String url = "jdbc:postgresql://" + host + ":5432/" + db;
	
	public ConexionPostgreSQL() {
		
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url+dbName,userName,password);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Patron Silgleton , una sola instancia 
	public static ConexionPostgreSQL getConexion() {
		if(db == null){
			db = new ConexionPostgreSQL();
		}
		return db;
	}
	
	//Metodo para retornar el resultado de una consulta
	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	// metodo para actualizaciones 
	public int execute() throws SQLException {
		int result = preparedStatement.executeUpdate();
		return result; 
	}
	
	// permitir el objeto conexion
	public Connection getCon(){
		return this.con;
	}
	
	//inicializar el preparedStatement 
	public PreparedStatement setPreparedStatement (String sql) throws SQLException{
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
	

	
	
	
	
}	
