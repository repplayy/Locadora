/*package MikaelatividadeAvaliativa1;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class DAOVeiculoTest {


	@Test
	public void DaoVeiculo() throws SQLException {
		Carro c = new Carro("volwza", "gol",2015,30000,450,"lala",1);
		Moto m = new Moto("honda","bros",2012,11000,200,"asds",150);
		DAOVeiculo dao = new DAOVeiculo();
		//dao.salvar(c);
		//dao.salvar(m);
		
		ArrayList<Veiculo> outra = dao.recuperarVeiculo(2,1);
		assertEquals(30000, outra.get(3).getValorAvaliado(), 0.001);
	}

}
*/