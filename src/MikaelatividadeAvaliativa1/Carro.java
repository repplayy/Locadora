package MikaelatividadeAvaliativa1;

public class Carro extends Veiculo {
	   private int categoriaCarro;

	 //contrutor para carro
	   public Carro(String marca, String modelo,int anoFabricacao,double valorAvaliadoDoBem,double valorDiaria, String placa,int caterigoriaCarro){
		  
		   super(marca,modelo,anoFabricacao,valorAvaliadoDoBem,valorDiaria,placa,2);  
		   
		   this.categoriaCarro = caterigoriaCarro;
		
		   	   	
		   }
	   public int getCategoriaCarro() {
			return categoriaCarro;
		}


		public void setCategoriaCarro(int categoriaCarro) {
			this.categoriaCarro = categoriaCarro;
		}

		
}
