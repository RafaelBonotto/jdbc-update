package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
				
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			//Alterando BaseSalary na tabela seller com prepareStatement:
			
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE " 
					+ "(DepartmentId = ? )");
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int linhasAfetadas = st.executeUpdate(); // executa o comando SQL e retorna o número de linhas afetadas
			System.out.println("OK! Linhas Afetadas: " + linhasAfetadas );			
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		finally {
			DB.closeStatement(st);
			DB.CloseConnection();
		}
			
	}

}
