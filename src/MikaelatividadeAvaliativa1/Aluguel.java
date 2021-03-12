package MikaelatividadeAvaliativa1;

import java.util.Date;

public class Aluguel {

Aluguel(){
	
}
		
	private int cpf;
		private String placa;
		private int dias;
		private Date d;
		private double valor;
		private int fechado;
		private int aluguel=0;

		
		Aluguel( String placa,Date d,int dias,int cpf){
			
		this.cpf = cpf;
		this.placa = placa;
		this.dias = dias;
		this.setD(d);
		
		
		}
		Aluguel( String placa, int cpf,int aluguel, int dias, double valor, int fechado){
			
			this.cpf = cpf;
			this.placa = placa;
			this.dias = dias;
			this.aluguel = aluguel;
			this.dias = dias;
			this.valor = valor;
			this.fechado = fechado;
			
			}


		public int getDias() {
			return dias;
		}


		public void setDias(int dias) {
			this.dias = dias;
		}


		public String getPlaca() {
			return placa;
		}


		public int getCpf() {
			return cpf;
		}


		public Date getD() {
			return d;
		}


		public void setD(Date d) {
			this.d = d;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
		public int getFechado() {
			return fechado;
		}
		public void setFechado(int fechado) {
			this.fechado = fechado;
		}
		public int getAluguel() {
			return aluguel;
		}
}