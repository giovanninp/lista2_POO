package school.cesar.q4.domain;

import java.util.Scanner;

public class Data {
	
	private enum diaDaSemana {
		DOMINGO(1),
		SEGUNDA_FEIRA(2),
		TERÇA_FEIRA(3),
		QUARTA_FEIRA(4),
		QUINTA_FEIRA(5),
		SEXTA_FEIRA(6),
		SABADO(7);
		
		private int valor;
		diaDaSemana(int valorDoDia){
			valor = valorDoDia;
		}
		
		public int getValor() {
			return valor;
		}
	}
	
	private int dia,mes,ano;
	private diaDaSemana diaSem;
	
	public Data(int dia,int mes,int ano,diaDaSemana diaDaSem) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.diaSem = diaDaSem;
		int [] check = this.checkData();
		if(check[0] < 0) {
			if(check[0] == -1) {
				this.dia = check[1];
			}
			else if(check[0] == -2) {
				this.mes = check[1];
				int [] newChck = checkData();
				
				if(newChck[0] == -1) {
					this.dia = newChck[1];
				}
			}
		}
	}
	
	public int [] checkData() {
		int [] result = new int [2];
		result[0] = 1;
		if(this.mes > 0 && this.mes <=12) {
			int diasNoMes = 0;
			if(this.mes <= 7) {
				if(mes == 2) {
					diasNoMes = 28;
				}
				else {
					if(this.mes % 2 == 0) {
						diasNoMes = 30;
					}
					else {
						diasNoMes = 31;
					}
				}
			}
			else {
				if(this.mes % 2 == 0) {
					diasNoMes = 31;
				}
				else {
					diasNoMes = 30;
				}
			}
			if(diasNoMes < this.dia) {
				result[0] = -1;
				result[1] = diasNoMes;
			}
		}
		else {
			if(this.mes > 12) {
				result[0] = -2;
				result[1] = 12;
			}
			else if(this.mes < 0) {
				result[0] = -2;
				result[1] = 1;
			}
		}
		return result;
	}
	
	private int code() {
		int result = 0;
		String code = ((this.mes < 10 ? this.ano * 10 : this.ano) + "" 
				+ (this.dia < 10 ? this.mes * 10 : this.mes) + "" 
				+ this.dia + "" + this.diaSem.getValor());
		result = Integer.parseInt(code);
		return result;
	}

	public String comparar(Data data) {
		String result = null;
		int code1 = this.code();
		int code2 = data.code();
		
		if(code1 > code2) {
			result = "[Maior]";
		}
		else if(code1 == code2) {
			result = "[Igual]";
		}
		else {
			result = "[Menor]";
		}
		
		return result;
	}
	
	public String comparar(diaDaSemana daSemana) {
		String result = null;
		if(this.diaSem.getValor() > daSemana.getValor()) {
			result = "[Anterior]";
		}
		if(this.diaSem.getValor() == daSemana.getValor()) {
			result = "[Igual]";
		}
		if(this.diaSem.getValor() < daSemana.getValor()) {
			result = "[Posterior]";
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int dia,mes,ano,sem;
		Data [] datalist = new Data [2];

		diaDaSemana [] dias = {diaDaSemana.DOMINGO,
							   diaDaSemana.SEGUNDA_FEIRA,
							   diaDaSemana.TERÇA_FEIRA,
							   diaDaSemana.QUARTA_FEIRA,
							   diaDaSemana.QUINTA_FEIRA,
							   diaDaSemana.SEXTA_FEIRA,
							   diaDaSemana.SABADO};
		
		for(int i = 0;i< 2;i++) {
			System.out.println("| DATA " + (i + 1));
			System.out.println("[ Digite um dia: ");
			dia = s.nextInt();
			System.out.println("| Entrada: " + dia);
			System.out.println("[ Digite o mes: ");
			mes = s.nextInt();
			System.out.println("| Entrada: " + dia + " / " + mes);
			System.out.println("[ Digite o ano: ");
			ano = s.nextInt();
			System.out.println("| Entrada: " + dia + " / " + mes + " / " + ano);
			System.out.println("| Selecione o dia da semana:");
			for(int j = 0; j < dias.length;j++) {
				System.out.println("\t| " + j + " - " + dias[j].toString());
			}
			sem = s.nextInt();
			datalist[i] = new Data(dia,mes,ano,dias[sem]);
		}
		
		System.out.println("| Resultado:");
		System.out.println("\t | Datas:");
		for(Data el : datalist) {
			System.out.println("\t\t | " + el.dia + '/' + el.mes + '/' + el.ano);
		}
		System.out.println("\t| Comparação:");
		System.out.println("\t\t| Data:");
		System.out.println("\t\t\t| Data 1 " + datalist[0].comparar(datalist[1]) + " do que data 2;");
		System.out.println("\t\t| Dia da semana:");
		System.out.println("\t\t\t| Data 1 " + datalist[0].comparar(datalist[1].diaSem) + " do que data 2;");		
		
		System.out.println("[FIM]");

		s.close();
	}
	
}
