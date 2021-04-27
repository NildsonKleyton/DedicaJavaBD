package TesteDeClasse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteJDBC {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"DEDICAJAVA","DEDICAJAVA");
			
			String sql = "INSERT INTO RACA (NOME, VIDA, DEFESA, ATAQUE, AGILIDADE) " + 
					"    VALUES ('RAÇA BRANCA 2', 6, 6, 6, 6)";
			
			//Prepara a instrução SQL
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Executa a instrução SQL
			ps.execute();
			ps.close();
			
			System.out.println("--- inserido ---");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
