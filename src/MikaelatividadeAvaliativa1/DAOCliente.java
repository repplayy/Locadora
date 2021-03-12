package MikaelatividadeAvaliativa1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOCliente {

	public void salvar(Cliente c) throws SQLException {
		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();
		String comando = "insert into locadora.cliente (cpf,nome) values " +
		  "("+ c.CPF + ", \'" +   c.nome +  "\')";
		
		st.executeUpdate(comando);
		st.close();
	}
	
	public Cliente recuperar(int cpf) throws SQLException {
		
		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();
		String comando = "select * from cliente where cpf =  " + cpf;
		
		ResultSet rs = st.executeQuery(comando);
		
		if(!rs.next()) {
			return null;
		}
			
		
		int cpff = rs.getInt("cpf");
		String nome = rs.getString("nome");
		
		Cliente c = new Cliente(cpff,nome);
		st.close();
		rs.close();
		
		return c;
}
	
	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();
		String comando = "delete from cliente";
		st.executeUpdate(comando);
		st.close();	
		
	}
}
