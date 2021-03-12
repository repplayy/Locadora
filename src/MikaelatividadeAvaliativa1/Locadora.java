package MikaelatividadeAvaliativa1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public abstract class Locadora {

ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
ArrayList<Cliente> clientes = new ArrayList<Cliente>();
ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

public abstract boolean inserir(Veiculo v) throws SQLException;

public boolean inserir(Cliente c) throws SQLException {
Cliente cliente = pesquisarCliente(c.getCPF());
if (cliente == null) {
clientes.add(c);
return true;
}
return false;
}

protected Cliente pesquisarCliente(int cpf) throws SQLException {
for (Cliente c : clientes) {
if (c.getCPF() == cpf) {
return c;
}
}
return null;
}
// Retorna as motos com cilindrada maior ou igual a pesquisada.
public abstract ArrayList<Veiculo> pesquisarMoto(int cilindrada) throws SQLException;
// tipo de carro
// 1 (passeio), 2 (SUV), 3 (pickup)
public abstract ArrayList<Veiculo> pesquisarCarro(int tipoCarro) throws SQLException;
// Retorna os caminh�es com capacidade de carga maior ou igual a pesquisada.
public abstract ArrayList<Veiculo> pesquisarCaminhao(int carga) throws SQLException;
// Retorna os �nibus com capacidade de passageiros maior ou igual a pesquisada.
public abstract ArrayList<Veiculo> pesquisarOnibus(int passageiros) throws SQLException;

//Seguro Moto = (valor do bem * 11%)/365
//Seguro Carro = (valor do bem * 3%)/365
//Seguro Caminh�o = (valor do bem * 8%)/365
//Seguro �nibus = (valor do bem * 20%)/365
//Aluguel = (valor da di�ria + seguro) * quantidade de dias
public abstract double calcularAluguel(String placa, int dias) throws SQLException ;
// Retorna falso se veiculo n�o existir ou se estiver alugado.
public abstract boolean registrarAluguel(String placa, Date data, int dias, int cpf) throws SQLException;
// Retorna falso se veiculo n�o existir ou se n�o estiver alugado.
public abstract boolean registrarDevolucao(String placa) throws SQLException;

// tipo de veiculo
// 0 (todos), 1 (moto), 2 (carro), 3 (caminh�o), 4 (�nibus)
public abstract void depreciarVeiculos(int tipo, double taxaDepreciacao) throws SQLException;
public abstract void aumentarDiaria(int tipo, double taxaAumento) throws SQLException;

// Retorna o valor total de faturamento para um tipo de ve�culo, durante um per�odo.
// Os alugueis devem come�ar e terminar dentro do per�odo.
public abstract double faturamentoTotal(int tipo, Date inicio, Date fim);
// Retorna a quantidade total de di�rias de aluguel para um tipo de ve�culo, durante um per�odo.
// Os alugueis devem come�ar e terminar dentro do per�odo.
public abstract int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim);
}
