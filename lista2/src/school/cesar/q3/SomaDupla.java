package school.cesar.q3;

import java.util.ArrayList;
import java.util.Scanner;

public class SomaDupla {
	public static String getAlvos(ArrayList <Integer> valores,int alvo) {
		int len = valores.size();
		for(int i = 0;i<len - 1;i++) {
			for(int j = i;j<len;j++) {
				if(valores.get(i) + valores.get(j)== alvo) {
					return (i + "," + j);
				}
			}
		}
		return "|Indices indeterminados";
	}
	
	public static void main(String[] args) {
		ArrayList <Integer> listaDeValores = new ArrayList <>();
		
		Scanner s = new Scanner(System.in);
		
		String ultimaMessagem = null;
		int alvo;
		
		System.out.println("[Digite uma sequencia de numeros ou 'parar' para finalizar:");
		while (true) {
			ultimaMessagem = s.next();
			if(ultimaMessagem.equalsIgnoreCase("parar")){
				break;
			}
			else {
				listaDeValores.add(Integer.parseInt(ultimaMessagem));
			}
		}
		System.out.println("[Digite um valor alvo:");
		alvo = s.nextInt();
		
		System.out.println("|"+SomaDupla.getAlvos(listaDeValores, alvo));
		
		s.close();
		System.out.println("[Fim de execucao]");
	}
}
