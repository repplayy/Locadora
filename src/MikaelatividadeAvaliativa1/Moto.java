package MikaelatividadeAvaliativa1;

public class Moto extends Veiculo{

	   private int cilindrada;
 

	
	

	 //contrutor para Moto
	   public Moto(String marca, String modelo,int anoFabricacao,double valorAvaliadoDoBem,double valorDiaria, String placa,int cilindrada){
		  
		   super(marca,modelo,anoFabricacao,valorAvaliadoDoBem,valorDiaria,placa,1);  

		   this.cilindrada =  cilindrada;
		   	
		   }
	   
	   public int getCilindrada() {
			return cilindrada;
		}


		public void setCilindrada(int cilindrada) {
			this.cilindrada = cilindrada;
		}
		
		
}
