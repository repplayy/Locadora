package MikaelatividadeAvaliativa1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOAluguel {

	public void salvar(Aluguel c) throws SQLException {



		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();


		String comando = "insert into locadora.aluguel (placa,cpf,aluguel,dias,valor,fechado) values " 
				+ "("+ "\'" + c.getPlaca() + "\' ," +  c.getCpf() + "," + c.getAluguel() + "," + c.getDias() + "," + c.getValor() + "," + c.getFechado() + ")";

		st.executeUpdate(comando);
		st.close();
	}
	
	//mudar metodo para boolean
	public Aluguel recuperarAluguel(String placa) throws SQLException {

		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();
		String comando = "select * from aluguel where placa =   \'" + placa + "\'";

		ResultSet rs = st.executeQuery(comando);

		if (!rs.next()) {

			return null; //veiculo verificado pela placa e definido como não alugado

		}

		String placaa = rs.getString("placa");
		int cpff = rs.getInt("cpf");
		int aluguel1 = rs.getInt("aluguel");	
		int dias = rs.getInt("dias");
		double valor = rs.getDouble("valor");
		int fechado = rs.getInt("Fechado");




		Aluguel a = new Aluguel(placaa,cpff,aluguel1,dias,valor,fechado);
		st.close();

		return a;//retorna informações do aluguel;


	}

	public void removerTodos() throws SQLException {
		
		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();
		String comando = "delete from aluguel";
		st.executeUpdate(comando);
		st.close();	
		
	}


	public void removerUm(String placa) throws SQLException {
		
		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();
		String comando = "delete from locadora.aluguel where placa = \'" + placa + "\'" ;
		System.out.println(comando);
		st.executeUpdate(comando);
		st.close();		
		
	}
	
}
	