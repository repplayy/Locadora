package MikaelatividadeAvaliativa1;

public class Caminhao extends Veiculo{

	   private int capacidadeCarga;

	//contrutor para Caminhao
	   public Caminhao(String marca, String modelo,int anoFabricacao,double valorAvaliadoDoBem,double valorDiaria, String placa,int capacidadeCarga){
		  
		   super(marca,modelo,anoFabricacao,valorAvaliadoDoBem,valorDiaria,placa,4);  

		   this.capacidadeCarga =  capacidadeCarga;
		
		   	
		   	
		   }
	   public int getCapacidadeCarga() {
			return capacidadeCarga;
		}


		public void setCapacidadeCarga(int capacidadeCarga) {
			this.capacidadeCarga = capacidadeCarga;
		}

	
		
	
}
