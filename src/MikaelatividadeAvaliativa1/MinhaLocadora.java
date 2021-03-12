package MikaelatividadeAvaliativa1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MinhaLocadora extends Locadora{

	Scanner input = new Scanner(System.in);
	public ArrayList<Veiculo>RepositorioDeVeiculo = new ArrayList<>();
	public ArrayList<Cliente>RepositorioDeCliente = new ArrayList<>();
	public ArrayList<Aluguel>RepositorioDeAluguel = new ArrayList<>();

	private double valorTotalMoto =0;
	private double valorTotalCarro =0;
	private double valorTotalCaminhao =0;
	private double valorTotalOnibus =0;
	private double valorTotalVeiculos = 0;
	private int diariaTotalMoto=0;
	private int diariaTotalCarro = 0;
	private int diariaTotalCaminhao = 0;
	private int diariaTotalOnibus = 0;
	private int diariaTotalVeiculos = 0;
	
	
	
	//essa inicialização é feita para zerar os dados inseridos nos testes no bd, possibilitando o teste individual de cada metodo no junit
	public MinhaLocadora() throws SQLException{
		DAOAluguel da = new DAOAluguel();
		DAOVeiculo dv = new DAOVeiculo();
		DAOCliente dc = new DAOCliente();

		da.removerTodos();
		dv.removerTodos();
		dc.removerTodos();

	}

	
	public boolean inserir(Veiculo v) throws SQLException {
		DAOVeiculo dv = new DAOVeiculo();

		Veiculo placa = pesquisar(v.getPlaca());
		if (placa == null) {
			dv.salvar(v);
			return true; //returno verdadeiro para caso o veiculo sejá inserido
		}
		return false;
	}

	public Veiculo pesquisar(String placa) throws SQLException {
		DAOVeiculo dv = new DAOVeiculo();

		if (dv.recuperarVeiculoPlaca(placa)!=null) { //compara se já existe a placa digitada na lista do repositorio
			return dv.recuperarVeiculoPlaca(placa); //placa exite
		}

		return null;//placa não existe 
	}
	//insere o clente no repositorio cliente 
	public boolean inserir(Cliente c) throws SQLException {
		DAOCliente dc = new DAOCliente();
		Cliente cliente = pesquisarCliente(c.getCPF());
		if (cliente == null) {
			dc.salvar(c);
			return true; //returno verdadeiro para caso o Cliente sejá inserido
		}
		return false;
	}
	//pesquisa o CPF dos cliente do repositorio
	public Cliente pesquisarCliente(int CPF) throws SQLException {
		DAOCliente dc = new DAOCliente();

		if (dc.recuperar(CPF)!=null) { //compara se já existe o CPF digitada na lista do repositorio
			return dc.recuperar(CPF); //encontra e retorna o cliente
		}

		return null; //não encontra
	}



	//metodo cadastrar veiculo 
	//não há repetição do menu, pouca funcionalidade 
	//não há  tratamento de erro ou verificação se foi cadastrado com sucesso
	//função comentada por motivos do código teste que será avaliado pelo professor 
	//função inserir faz o cadastro dentro do repositório de veicuos a função a seguir trata de pedir 
	//pro usuario a inserção de informações digitadas por ele e depois faz a chamada da função inserir para finalizar 
	//o cadastro das informações 
	public void cadastrarVeiculo() throws SQLException {

		String marca;
		String modelo;
		int anoFabricacao;
		String placa;
		double valorVeiculo;
		double valorDiaria;
		System.out.println("Selecione a opção de qual veiculo deseja cadastrar\n");
		System.out.println("1-Moto\n");
		System.out.println("2-Carro\n");
		System.out.println("3-Ônibus\n");
		System.out.println("4-caminhão\n");

		int opcao = input.nextInt();

		switch(opcao) {

		case 1: 
			System.out.println("Digite a marca do veiculo\n");
			marca =	input.next();

			System.out.println("Digite o modelo\n");
			modelo =	input.next();

			System.out.println("Digite a placa\n");
			placa = input.next();
			System.out.println("Digite o ano de fabricação\n");
			anoFabricacao = input.nextInt();
			System.out.println("Digite quantidade de cilindras\n");
			int cilindrada = input.nextInt();
			System.out.println("Digite o valor do veiculo\\n");
			valorVeiculo = input.nextDouble();
			System.out.println("Digite o valor do diaria\\n");
			valorDiaria = input.nextDouble();
			Veiculo v1 = new Moto(marca,modelo,anoFabricacao,valorVeiculo,valorDiaria,placa,cilindrada);
			inserir(v1);
			break;
		case 2: 
			System.out.println("Digite a marca do veiculo\n");
			marca=	input.next();
			System.out.println("Digite o modelo\n");
			modelo =	input.next();
			System.out.println("Digite a placa\n");
			placa = input.next();
			System.out.println("Digite o ano de fabricação\n");
			anoFabricacao = input.nextInt();
			System.out.println("Digite a categoria do carro\n");
			int categoriaCarro = input.nextInt();
			System.out.println("Digite o valor do veiculo\n");
			valorVeiculo = input.nextDouble();
			System.out.println("Digite o valor da diaria\\n");
			valorDiaria = input.nextDouble();
			Veiculo v2 = new Carro(marca,modelo,anoFabricacao,valorVeiculo,valorDiaria,placa,categoriaCarro);
			inserir(v2);
			break;

		case 4: 
			System.out.println("Digite a marca do veiculo\n");
			marca=	input.next();
			System.out.println("Digite o modelo\n");
			modelo =	input.next();
			System.out.println("Digite a placa\n");
			placa = input.next();
			System.out.println("Digite o ano de fabricação\n");
			anoFabricacao = input.nextInt();
			System.out.println("Digite a capacidade de Carga\n");
			int capacidadeCarga = input.nextInt();
			System.out.println("Digite o valor do veiculo\n");
			valorVeiculo = input.nextDouble();
			System.out.println("Digite o valor da diaria\\n");
			valorDiaria = input.nextDouble();
			Veiculo v3 = new Caminhao(marca,modelo,anoFabricacao,valorVeiculo,valorDiaria,placa,capacidadeCarga);
			inserir(v3);
			break;

		case 3: 


			System.out.println("Digite a marca do veiculo\n");
			marca=	input.next();
			System.out.println("Digite o modelo\n");
			modelo =	input.next();
			System.out.println("Digite a placa\n");
			placa = input.next();
			System.out.println("Digite o ano de fabricação\n");
			anoFabricacao = input.nextInt();
			System.out.println("Digite a capacidade de passsageiros\n");
			int capacidadePassageiro = input.nextInt();
			System.out.println("Digite o valor do veiculo\n");
			valorVeiculo = input.nextDouble();
			System.out.println("Digite o valor da diaria\\n");
			valorDiaria = input.nextDouble();

			Veiculo v4 = new Onibus(marca,modelo,anoFabricacao,valorVeiculo,valorDiaria,placa,capacidadePassageiro);
			inserir(v4);
			break;

		default: 
			System.out.println("opção inválida\n");
		}


	}

	//função para retornar o tipo do veiculo de acordo com a placa cadastrada


	//metodo consultar aluguel
	//valor da diaria é fixo
	public void consultarAluguel() throws SQLException {

		int dias;
		String placa;

		System.out.println("digite a placa do veiculo desejado\n");
		placa= input.next();
		System.out.println("digite a quantidade de dias\n");
		dias = input.nextInt();
		System.out.println("valor do aluguel: " + calcularAluguel(placa,dias));

	}

	// consultar seguro 
	//falta ser adptado para o método de teste 
	//puxar do bd 
	public double consultarSeguro(int opcao,String placa) throws SQLException {
		Veiculo v = new Veiculo();

		System.out.println("digite a placa do veiculo desejado\n");
		placa= input.nextLine();

		return v.valorSeguro(tipoVeiculo(placa));


	}



	// consultar a frota de acordo com a categoria e dados auxiliares(capacidade de carga,
	//quantidade de passageiro e cilindrada;
	public void consultaFrota() throws SQLException {
		DAOVeiculo dv = new DAOVeiculo();
		int categoria; 
		int cilindrada;
		int capacidadeCarga;
		int capacidadePassageiro;
		int opcao = input.nextInt();

		System.out.println("Selecione a opção de qual veiculo deseja consultar\n");
		System.out.println("1-Moto\n");
		System.out.println("2-Carro\n");
		System.out.println("3-Ônibus\n");
		System.out.println("4-caminhão\n");

		switch(opcao) {
		case 1: 
			System.out.println("digite as cilindradas da moto\n");
			cilindrada =input.nextInt();				

			System.out.println(dv.recuperarVeiculo(opcao, cilindrada));

			break;
		case 2: 
			System.out.println("digite a categoria do carro\n");
			System.out.println("1 (passeio)\n");
			System.out.println("2 (SUV)\n");
			System.out.println(" 3 (pickup)\n");
			categoria =input.nextInt();			

			System.out.println(dv.recuperarVeiculo(opcao, categoria));
			break;
		case 4: 
			System.out.println("digite a capacidade de carga do caminhão\n");
			capacidadeCarga =input.nextInt();				
			System.out.println(dv.recuperarVeiculo(opcao, capacidadeCarga));
			break;
		case 3: 

			System.out.println("digite a capacidade de passagerios do onibus\n");
			capacidadePassageiro =input.nextInt();				
			System.out.println(dv.recuperarVeiculo(opcao, capacidadePassageiro));
			break;
		}
	}
	//retorna uma lista de motos de acordo com as cilindradas pesquisadas
	public ArrayList<Veiculo>pesquisarMoto(int cilindrada) throws SQLException{

		DAOVeiculo dv = new DAOVeiculo();

		return  dv.recuperarVeiculo(1,cilindrada);
	}
	//retorna uma lista de carros do tipo pesquisado
	public ArrayList<Veiculo>pesquisarCarro(int tipoCarro) throws SQLException{

		DAOVeiculo dv = new DAOVeiculo();

		return  dv.recuperarVeiculo(2,tipoCarro);	
	}



	//retorna uma lista de caminhão de acordo com a carga pesquisada
	public ArrayList<Veiculo>pesquisarCaminhao(int carga) throws SQLException{
		DAOVeiculo dv = new DAOVeiculo();

		return  dv.recuperarVeiculo(4,carga);	
	}

	//retorna uma lista de onibus com o numero x de passgeiros informado
	public ArrayList<Veiculo>pesquisarOnibus(int passageiros) throws SQLException{
		DAOVeiculo dv = new DAOVeiculo();

		return  dv.recuperarVeiculo(3,passageiros);	

	}


	public int tipoVeiculo(String placa) throws SQLException {
		DAOVeiculo dv = new DAOVeiculo();
		return  dv.recuperarDiscriminador(placa); //compara se já existe a placa digitada na lista do repositorio e retorna o discriminador ou tipo


	}
	//calcula o valor do aluguel
	public double calcularAluguel(String placa, int dias) throws SQLException{

		DAOVeiculo dv = new DAOVeiculo();
		Veiculo v = dv.recuperarVeiculoPlaca(placa);
		if(v == null) {
			return 0;
		}

		return v.valorAluguel(tipoVeiculo(placa), dias);

	}


	//verifica se a placa do transporte já foi registrado como alugado
	public Aluguel tansporteAlugado(String placa) throws SQLException {

		//DAOAluguel instancia e usa o método para fazer a nova verificação
		DAOAluguel da = new DAOAluguel();

		//compara se já existe a placa está registrada na lista do bd aluguel
		if( da.recuperarAluguel(placa)!= null)//ta alugado
		{
			return da.recuperarAluguel(placa); 
		}

		return null; //não ta alugado

	}






	public boolean registrarAluguel(String placa,Date d, int dias, int cpf) throws SQLException {

		Aluguel b = new Aluguel(placa,cpf,0,dias,0,0);

		DAOVeiculo dv = new DAOVeiculo();
		DAOAluguel da = new DAOAluguel();
		Veiculo v = dv.recuperarVeiculoPlaca(placa);

		if(v == null ) {//condicional para placa inexistente não cadastrada no sistema
			return false;

		}
		if(pesquisarCliente(cpf)==null) {//condicional para CPF não encontrado na lista de cliente
			return false; 
		}
		if (tansporteAlugado(placa) == null) { //condicional para placa não encontrada no repositorio de aluguel

			b.setFechado(1);
			if(v instanceof Moto) {

				valorTotalMoto += calcularAluguel(placa,dias);
				diariaTotalMoto += dias;
				b.setValor(calcularAluguel(placa,dias));
				b = new Aluguel(placa,cpf,0,dias,b.getValor(),b.getFechado());
				da.salvar(b);
			}
			else if(v instanceof Carro) {
				valorTotalCarro += calcularAluguel(placa,dias);
				diariaTotalCarro += dias;
				b.setValor(calcularAluguel(placa,dias));	
				b = new Aluguel(placa,cpf,0,dias,b.getValor(),b.getFechado());
				da.salvar(b);
			}
			else if(v instanceof Caminhao) {
				valorTotalCaminhao += calcularAluguel(placa,dias);
				diariaTotalCaminhao += dias;
				b.setValor(calcularAluguel(placa,dias));
				b = new Aluguel(placa,cpf,0,dias,b.getValor(),b.getFechado());
				da.salvar(b);

			}
			else if(v instanceof Onibus) {
				valorTotalOnibus += calcularAluguel(placa,dias);
				diariaTotalOnibus += dias;
				b.setValor(calcularAluguel(placa,dias));
				b = new Aluguel(placa,cpf,0,dias,b.getValor(),b.getFechado());
				da.salvar(b);

			}

			valorTotalVeiculos += calcularAluguel(placa,dias);
			diariaTotalVeiculos += dias;

			return true;
			//se entrar na condicional o transporte é registrado no repositorio de aluguel
		}

		return false;

	}

	// metodo precisa ser revisto para adequar aos 3 tipos de testes 
	public boolean registrarDevolucao(String placa) throws SQLException {

		DAOAluguel da = new DAOAluguel();	  





		if (tansporteAlugado(placa) != null) {
			da.removerUm(placa);
			
			//se entrar na condicional o transporte é removido da lista aluguel e conclui a devolução
			return true;
		}	
		return false;
	}

	// precisa colocar o cast nesse caso ou só o instanceof resolve ??
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) throws SQLException {

		DAOVeiculo dv = new DAOVeiculo();

		if(tipo==0) {
			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {


				dv.updateDepreciarVeiculos(v.valorDoBemDiminui(taxaDepreciacao), tipo);

			}
		}	

		//faz o depreciamento de cada veiculo acessando a classe de acordo com o tipo

		else if(tipo == 1 ) {

			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {


				dv.updateDepreciarVeiculos(v.valorDoBemDiminui(taxaDepreciacao), tipo);

			}

		}
		else if(tipo == 2 ) {

			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {


				dv.updateDepreciarVeiculos(v.valorDoBemDiminui(taxaDepreciacao), tipo);

			}

		}
		else if(tipo == 4) {

			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {


				dv.updateDepreciarVeiculos(v.valorDoBemDiminui(taxaDepreciacao), tipo);

			}

		}
		else if(tipo == 3) {

			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {


				dv.updateDepreciarVeiculos(v.valorDoBemDiminui(taxaDepreciacao), tipo);

			}
		}


		else {
			System.out.println("not found\n");

		}		




	}




	public void aumentarDiaria(int tipo, double taxaAumento) throws SQLException {
		DAOVeiculo dv = new DAOVeiculo();

		if(tipo==0) {
			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {

				dv.updateAumentarDiaria(v.ValorDiariaAumenta(taxaAumento), tipo);


			}
		}	

		//faz o depreciamento de cada veiculo acessando a classe de acordo com o tipo

		else if(tipo == 1 ) {

			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {

				dv.updateAumentarDiaria(v.ValorDiariaAumenta(taxaAumento), tipo);


			}
		}
		else if(tipo == 2 ) {



			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {

				dv.updateAumentarDiaria(v.ValorDiariaAumenta(taxaAumento), tipo);


			}

		}
		else if(tipo == 4) {

			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {

				dv.updateAumentarDiaria(v.ValorDiariaAumenta(taxaAumento), tipo);


			}
		}
		else if(tipo == 3) {

			for(Veiculo v: dv.recuperarTiposVeiculo(tipo)) {

				dv.updateAumentarDiaria(v.ValorDiariaAumenta(taxaAumento), tipo);


			}
		}


		else {
			System.out.println("not found\n");

		}		




	}

	//não implementado

	//fazer calculo de acordo com o tipo de veiculo 
	//pegando os carros já alugados no reposuitorio de aluguel , consultando o valor de cada carro alugado
	public double faturamentoTotal(int tipo,Date ontem,Date amanha) {

		if(tipo==0) {

			return valorTotalVeiculos;
		}		


		else if(tipo == 1 ) {


			return valorTotalMoto;
		}			


		else if(tipo == 2 ) {

			return valorTotalCarro;
		}		


		else if(tipo == 4 ) {

			return valorTotalCaminhao;
		}		

		else if(tipo == 3 ) {

			return valorTotalOnibus;
		}		


		System.out.println("not found\n");
		return 0;



	}
	//fazer todo calculo de diarias pegando no repositorio de aluguel e somando de acordo com o tipo
	public int quantidadeTotalDeDiarias(int tipo,Date ontem,Date amanha) {

		if(tipo==0) {

			return diariaTotalVeiculos;

		}	

		else if(tipo==1) {



			return diariaTotalMoto;


		}

		else if(tipo == 2 ) {



			return diariaTotalCarro;

		}

		else if(tipo == 4 ) {



			return diariaTotalCaminhao;
		}			

		else if(tipo == 3 ) {



			return diariaTotalOnibus;

		}



		System.out.println("not found\n");
		return 0;


	}
}
