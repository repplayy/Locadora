package MikaelatividadeAvaliativa1;

public class Cliente {
	
		String nome;
		int CPF;


		Cliente(){
			
		}
		Cliente(int CPF,String nome ){
			this.nome = nome;
			this.CPF = CPF;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getCPF() {
			return CPF;
		}
		}


