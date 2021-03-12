package MikaelatividadeAvaliativa1;

public class Onibus extends Veiculo{

	 private int capacidadePassageiro;
	
	
	//contrutor para Onibus
	   public Onibus(String marca, String modelo,int anoFabricacao,double valorAvaliadoDoBem,double valorDiaria, String placa,int capacidadePassageiro){
		  
		   super(marca,modelo,anoFabricacao,valorAvaliadoDoBem,valorDiaria,placa,3);   

		   this.capacidadePassageiro =  capacidadePassageiro;
		
	
		   	
		   }
	   

		public int getCapacidadePassageiro() {
			return capacidadePassageiro;
		}


		public void setCapacidadePassageiro(int capacidadePassageiro) {
			this.capacidadePassageiro = capacidadePassageiro;
		}
		
		
		
		
}