package MikaelatividadeAvaliativa1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOVeiculo {


	public void salvar(Veiculo c) throws SQLException {
		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();


		int categoriaCarro=0;
		int cargaCaminhao=0;
		int cilindradas=0;
		int passageiros=0;
		if( c instanceof Carro)
		{

			categoriaCarro = ((Carro)c).getCategoriaCarro();

		}
		if( c instanceof Moto)
		{

			cilindradas = ((Moto)c).getCilindrada();

		}

		if( c instanceof Caminhao)
		{

			cargaCaminhao = ((Caminhao)c).getCapacidadeCarga();

		}

		if( c instanceof Onibus)
		{

			passageiros = ((Onibus)c).getCapacidadePassageiro();

		}




		String comando = "insert into locadora.veiculo (placa,marca, modelo, ano,valoravaliado,valordiaria,tipo,carga,cilindrada,passageiro,discriminador) values "
				+ "(" + "\'" + c.getPlaca() + "\', \'" + c.getMarca() + "\', \'" + c.getModelo() + "\' ," + c.getAnoDeFabricacao() + ","
				+ c.getValorAvaliado() + "," + c.getValorDiaria() + "," +  categoriaCarro + ","
				+ cargaCaminhao + ","+ cilindradas + "," + passageiros + "," + c.getTipo() + ")";

		st.executeUpdate(comando);
		st.close();
	}
	
	public double valorAvaliadodobem(){
		
		
		
		
		
		return 0;
	}
	
	
	public void  updateDepreciarVeiculos(double valor,int discrimina) throws SQLException{
	
		Statement st = null;
		
		Connection con = Conexao.getConexao();
		st = con.createStatement();
		if(discrimina == 0) {
			String comando =  "UPDATE locadora.veiculo SET valoravaliado= " + valor;
			st.executeUpdate(comando);
			}
		else if(discrimina == 1) {
		
		String comando =  "UPDATE locadora.veiculo SET valoravaliado= " +valor +" WHERE discriminador = 1";
		
		st.executeUpdate(comando);
		}
		else if(discrimina == 2) {
		
			String comando =  "UPDATE locadora.veiculo SET valoravaliado= " +valor +" WHERE discriminador = 2";
			st.executeUpdate(comando);
			}
		else if(discrimina == 3) {
			String comando =  "UPDATE locadora.veiculo SET valoravaliado= " +valor +" WHERE discriminador = 3";
			st.executeUpdate(comando);
			}
		else if(discrimina == 4) {
			String comando =  "UPDATE locadora.veiculo SET valoravaliado= " +valor +" WHERE discriminador = 4";
			st.executeUpdate(comando);
			}
		
		st.close();
		
	}
	
	
	public int  updateAumentarDiaria(double valor,int discrimina) throws SQLException{
		
		Statement st = null;
	
		//TipoDeDado nomeDaVariavel = meuObjetoResultSet.getTipoDeDado(nomeDaColuna);
		Connection con = Conexao.getConexao();
		st = con.createStatement();
		
		if(discrimina == 0) {
			String comando =  "UPDATE locadora.veiculo SET valordiaria= " +valor ;
			  st.executeUpdate(comando);
			}
		
		else if(discrimina == 1) {
			
		String comando =  "UPDATE locadora.veiculo SET valordiaria= " +valor +" WHERE discriminador = 1";
		 st.executeUpdate(comando);
		}
		else if(discrimina == 2) {
			String comando =  "UPDATE locadora.veiculo SET valordiaria= " +valor +" WHERE discriminador = 2";
			 st.executeUpdate(comando);
			}
		else if(discrimina == 3) {
			String comando =  "UPDATE locadora.veiculo SET valordiaria= " +valor +" WHERE discriminador = 3";
			 st.executeUpdate(comando);
			}
		else if(discrimina == 4) {
			String comando =  "UPDATE locadora.veiculo SET valordiaria= " +valor +" WHERE discriminador = 4";
			 st.executeUpdate(comando);
			}
		
		
		
		st.close();
	return 0;
		
	}



	public Veiculo recuperarVeiculoPlaca(String placa) throws SQLException {



		ResultSet rs = null;
		Statement st = null;

		Connection con = Conexao.getConexao();
		st = con.createStatement();
		String comando = "select * from locadora.veiculo where placa = \'" + placa + "\'";
		rs = st.executeQuery(comando);

		if (!rs.next()) {
			st.close();
			rs.close();
			return null;
		} else {

			String marca = rs.getString("marca");
			String modelo = rs.getString("modelo");
			int ano_fab = rs.getInt("ano");
			String Placa = rs.getString("placa");
			double val_bem = rs.getDouble("valoravaliado");
			double val_diaria = rs.getDouble("valordiaria");
			int discriminador = rs.getInt("discriminador");

			if(discriminador == 1) {
				int info_adicional = rs.getInt("cilindrada");
				Veiculo c = new Moto( marca,  modelo, ano_fab, val_bem, val_diaria,  Placa, info_adicional);
				st.close();
				rs.close();
				return c;
			}else if(discriminador == 2) {
				int info_adicional = rs.getInt("tipo");
				Veiculo c = new Carro( marca,  modelo, ano_fab, val_bem, val_diaria,  Placa, info_adicional);
				st.close();
				rs.close();
				return c;
			}else if(discriminador == 3) {
				int info_adicional = rs.getInt("passageiro");
				Veiculo c = new Onibus( marca,  modelo, ano_fab, val_bem, val_diaria,  Placa, info_adicional);
				st.close();
				rs.close();
				return c;
			}else if(discriminador == 4) {
				int info_adicional = rs.getInt("carga");
				Veiculo c = new Caminhao( marca,  modelo, ano_fab, val_bem, val_diaria,  Placa, info_adicional);
				st.close();
				rs.close();
				return c;
			}else return null;


		}
	}





	public int recuperarDiscriminador(String placa) throws SQLException {



		ResultSet rs = null;
		Statement st = null;

		Connection con = Conexao.getConexao();
		st = con.createStatement();
		String comando = "select * from locadora.veiculo where placa = \'" + placa + "\'";
		rs = st.executeQuery(comando);

		if (!rs.next()) {
			st.close();
			rs.close();
			return 0;
		} else {


			int discriminador = rs.getInt("discriminador");

			if(discriminador == 1) {

				return 1;
			}else if(discriminador == 2) {

				return 2;
			}else if(discriminador == 3) {

				return 3;
			}else if(discriminador == 4) {

				return 4;
			}else return 0;


		}
	}





	
	
	public ArrayList<Veiculo> recuperarVeiculo(int discrimina,int quant) throws SQLException {

		ArrayList<Veiculo> categoriaCarro = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaMoto = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaCaminhao = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaOnibus = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaTodos = new ArrayList<>();
		ArrayList<Veiculo> vazio = new ArrayList<Veiculo>();





		//incluir imprimir todos
		if(discrimina == 0) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo";

			rs = st.executeQuery(comando);

			if (!rs.next()) {
				System.out.println("Veiculo não cadastrado");
			} else {

				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");
				int categorias = rs.getInt("tipo");
				int passageiro = rs.getInt("passageiro");
				int carga = rs.getInt("carga");
				int discriminador = rs.getInt("discriminador");
				Veiculo v;
				if(discriminador == 1) {

					v=new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);
					categoriaTodos.add(v);
				}
				if(discriminador == 2) {
					v=new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);
					categoriaTodos.add(v);
					

				}
				if(discriminador == 3) {
					v=new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);
					categoriaTodos.add(v);

				}
				if(discriminador == 4) {
					v = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);
					categoriaTodos.add(v);

				}


				
			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");
				int categorias = rs.getInt("tipo");
				int passageiro = rs.getInt("passageiro");
				int carga = rs.getInt("carga");
				int discriminador = rs.getInt("discriminador");
				
				Veiculo v;
				if(discriminador == 1) {

					v=new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);
					categoriaTodos.add(v);
				}
				if(discriminador == 2) {
					v=new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);
					categoriaTodos.add(v);
					

				}
				if(discriminador == 3) {
					v=new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);
					categoriaTodos.add(v);

				}
				if(discriminador == 4) {
					v = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);
					categoriaTodos.add(v);

				}


			}

			st.close();
			rs.close();
			return categoriaTodos;

		}

		else if(discrimina ==1) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo where discriminador = 1 AND cilindrada >= " + quant;
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("Moto não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");

				Veiculo c = new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);

				categoriaMoto.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");

				Moto c = new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);

				categoriaMoto.add(c);

			}

			st.close();
			rs.close();
			return categoriaMoto;
		}





		else if(discrimina ==2) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo where discriminador = 2 AND tipo = " + quant;
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("carro não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int categorias = rs.getInt("tipo");

				Carro c = new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);

				categoriaCarro.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int categorias = rs.getInt("tipo");

				Carro c = new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);

				categoriaCarro.add(c);

			}

			st.close();
			rs.close();
			return categoriaCarro;
		}


		else 	if(discrimina == 3) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo where discriminador = 3 AND passageiro >= " + quant;
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("Onibus não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int passageiro = rs.getInt("passageiro");

				Onibus c = new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);

				categoriaOnibus.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int passageiro = rs.getInt("passageiro");

				Onibus c = new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);

				categoriaOnibus.add(c);

			}

			st.close();
			rs.close();
			return categoriaOnibus;
		}

		else if(discrimina ==4) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from veiculo where discriminador = 4 AND carga >= " + quant;
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("Caminhao não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int carga = rs.getInt("carga");

				Caminhao c = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);

				categoriaCaminhao.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int carga = rs.getInt("carga");

				Caminhao c = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);

				categoriaCaminhao.add(c);

			}

			st.close();
			rs.close();
			return categoriaCaminhao;
		}





		return vazio;

	}
	
	
	public ArrayList<Veiculo> recuperarTiposVeiculo(int discrimina) throws SQLException {

		ArrayList<Veiculo> categoriaCarro = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaMoto = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaCaminhao = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaOnibus = new ArrayList<Veiculo>();
		ArrayList<Veiculo> categoriaTodos = new ArrayList<>();
		ArrayList<Veiculo> vazio = new ArrayList<Veiculo>();





		//incluir imprimir todos
		if(discrimina == 0) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo";

			rs = st.executeQuery(comando);

			if (!rs.next()) {
				System.out.println("Veiculo não cadastrado");
			} else {

				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");
				int categorias = rs.getInt("tipo");
				int passageiro = rs.getInt("passageiro");
				int carga = rs.getInt("carga");
				int discriminador = rs.getInt("discriminador");
				Veiculo v;
				if(discriminador == 1) {

					v=new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);
					categoriaTodos.add(v);
				}
				if(discriminador == 2) {
					v=new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);
					categoriaTodos.add(v);
					

				}
				if(discriminador == 3) {
					v=new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);
					categoriaTodos.add(v);

				}
				if(discriminador == 4) {
					v = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);
					categoriaTodos.add(v);

				}


				
			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");
				int categorias = rs.getInt("tipo");
				int passageiro = rs.getInt("passageiro");
				int carga = rs.getInt("carga");
				int discriminador = rs.getInt("discriminador");
				
				Veiculo v;
				if(discriminador == 1) {

					v=new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);
					categoriaTodos.add(v);
				}
				if(discriminador == 2) {
					v=new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);
					categoriaTodos.add(v);
					

				}
				if(discriminador == 3) {
					v=new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);
					categoriaTodos.add(v);

				}
				if(discriminador == 4) {
					v = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);
					categoriaTodos.add(v);

				}


			}

			st.close();
			rs.close();
			return categoriaTodos;

		}

		else if(discrimina ==1) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo where discriminador = 1";
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("Moto não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");

				Moto c = new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);

				categoriaMoto.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int cilindrada = rs.getInt("cilindrada");

				Moto c = new Moto(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, cilindrada);

				categoriaMoto.add(c);

			}

			st.close();
			rs.close();
			return categoriaMoto;
		}





		else if(discrimina ==2) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo where discriminador = 2 ";
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("carro não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int categorias = rs.getInt("tipo");

				Carro c = new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);

				categoriaCarro.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int categorias = rs.getInt("tipo");

				Carro c = new Carro(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, categorias);

				categoriaCarro.add(c);

			}

			st.close();
			rs.close();
			return categoriaCarro;
		}


		else 	if(discrimina == 3) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from locadora.veiculo where discriminador = 3 ";
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("Onibus não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int passageiro = rs.getInt("passageiro");

				Onibus c = new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);

				categoriaOnibus.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int passageiro = rs.getInt("passageiro");

				Onibus c = new Onibus(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, passageiro);

				categoriaOnibus.add(c);

			}

			st.close();
			rs.close();
			return categoriaOnibus;
		}

		else if(discrimina ==4) {
			ResultSet rs = null;
			Statement st = null;

			Connection con = Conexao.getConexao();
			st = con.createStatement();
			String comando = "select * from veiculo where discriminador = 4 ";
			rs = st.executeQuery(comando);


			if (!rs.next()) {
				System.out.println("Caminhao não cadastrado");
			} else {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int carga = rs.getInt("carga");

				Caminhao c = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);

				categoriaCaminhao.add(c);

			}

			while (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anoFabricacao = rs.getInt("ano");
				double valorAvaliadoDoBem = rs.getDouble("valoravaliado");
				double valorDiaria = rs.getDouble("valordiaria");
				String placa = rs.getString("placa");
				int carga = rs.getInt("carga");

				Caminhao c = new Caminhao(marca, modelo, anoFabricacao, valorAvaliadoDoBem, valorDiaria, placa, carga);

				categoriaCaminhao.add(c);

			}

			st.close();
			rs.close();
			return categoriaCaminhao;
		}





		return vazio;

	}
	
	
	
	
	
	
	
	
	

	//falta testar
	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		Statement st = con.createStatement();
		String comando = "delete from veiculo";
		st.executeUpdate(comando);
		st.close();		
	}




}
