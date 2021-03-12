/*package MikaelatividadeAvaliativa1;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class DAOClienteTest {

	@Test
	public void DaoAluguel() throws SQLException {
		
		
		Aluguel c = new Aluguel("vrauum",0214,0,34,200,1);
		Carro cui = new Carro("volwza", "gol",2015,30000,450,"lala",1);
		
		DAOAluguel cli = new DAOAluguel();
		DAOVeiculo cu = new DAOVeiculo();
		cu.salvar(cui);
		cli.salvar(c);
		cu.updateDepreciarVeiculos(0.10, 2);
		//cli.salvar(m);
		
		//Cliente  clien = cli.recuperar(123456);
		//assertEquals(123456, clien.CPF, 0.001);
	}

}
*/