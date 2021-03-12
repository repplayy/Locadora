package MikaelatividadeAvaliativa1;

public class Veiculo {
	 private String marca;
	   private String modelo;
	   private int anoFabricacao;
	   private String placa;
	   private double valorAvaliadoDoBem;
	   private double valorDiaria;
	   private  int tipo;
	  


	   
	   public Veiculo() {
		   
	   }
	
	   //contrutor da classe veiculos Geral
	   public Veiculo(String marca, String modelo,int anoFabricacao,double valorAvaliadoDoBem,double valorDiaria, String placa,int tipo){
		   this.marca = marca;
		   this.modelo = modelo;
		   this.anoFabricacao = anoFabricacao;
		   this.placa = placa;
this.valorDiaria  = valorDiaria;
		   	this.valorAvaliadoDoBem = valorAvaliadoDoBem;
		   this.tipo = tipo;
		   }
	  
	  

	public double getValorDiaria() {
		return valorDiaria;
	}


	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}


	public double getValorAvaliado() {
		return valorAvaliadoDoBem;
	}


	public void setValorAvaliadoDoBem(double valorAvaliadoDoBem) {
			
		this.valorAvaliadoDoBem = valorAvaliadoDoBem;
	}


	public String getMarca() {
		return marca;
	}


	public String getModelo() {
		return modelo;
	}


	public int getAnoDeFabricacao() {
		return anoFabricacao;
	}


	public String getPlaca() {
		return placa;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	//
	public double valorSeguro(int opcao) {
		//opcao moto
		if(opcao== 1) {
			return (getValorAvaliado()*0.11)/365.0;
		}
		
		//opcao carro
		if(opcao== 2) {
			return (getValorAvaliado()*0.03)/365.0;
			
		}
		
		if(opcao==4) {
			return (getValorAvaliado()*0.08)/365.0;
		}
	
		if(opcao==3) {
			return (getValorAvaliado()*0.20)/365.0;
			
		}
		
		
		return 0;
	}

	//retorna valor do alugel 
	public double valorAluguel(int opcao,int dias) {
		
		return (getValorDiaria() + valorSeguro(opcao)) *dias;
					
	}
	
	//diminui valor do bem

	public double valorDoBemDiminui(double taxa) {
		
		return getValorAvaliado() - taxa*getValorAvaliado();
		
	}
	
public double ValorDiariaAumenta(double taxa) {
		
		return getValorDiaria() + taxa*getValorDiaria();
		
	}
  
}
