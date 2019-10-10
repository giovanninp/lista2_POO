package school.cesar.q1.domain;

import java.util.Random;
import java.util.Scanner;

import school.cesar.q1.utils.Matrizes;

public class Matriz {
	private Random random = new Random();
	private int linhas;
	private int colunas;
	private int matriz[][];
	
	
	public Matriz(int value) {
		this.linhas = value;
		this.colunas = value;
		this.matriz = new int [value][value];
		this.gerarMatriz();
	}
	
	public Matriz(int linhas,int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.matriz = new int [linhas][colunas];
		this.gerarMatriz();
	} 
	
	private void gerarMatriz() {
		for(int i = 0;i < this.linhas;i++ ) {
			for(int j = 0; j < this.colunas;j++) {
				this.matriz[i][j] = random.nextInt(100);
			}
		}
	}
	
	public int getLinhas() {
		return this.linhas;
	}
	
	public int getColunas() {
		return this.colunas;
	}
	
	public int [][] getMatriz() {
		return this.matriz;
	}
	
	public void setMatriz(int [][] matriz) {
		this.matriz = matriz;
	}
	
	public void setValue(int linha,int coluna,int value) {
		this.matriz[linha][coluna] = value;
	}
	
	public int [] getDiagonalPrincipal() {
		int [] result = new int [this.linhas];
		if(this.linhas == this.colunas) {
			int index = 0;
			for(int i = 0; i< this.linhas;i++) {
				for(int j = 0;j < this.colunas;j++) {
					if(i == j) {
						result[index++] = this.matriz[i][j];
					}
				}
			}
			System.out.print("|Diagonal principal ->");
			for(int i = 0; i < result.length;i++) {
				System.out.printf(" %d ",result[i]);
			}
			System.out.println("\n");
		}
		else {
			for (int j = 0; j < result.length; j++) {
				result[j] = 0;
			}
			System.out.println("|ERRO - Matriz nao quadratica!\t");
		}
		
		return result;
	}
	
	public void imprimirMatriz() {
		int [][] imagem = this.getMatriz();
		System.out.println("\n|" + this.getLinhas() + " x " + this.getColunas() + ":");
		for(int i = 0 ; i < this.getLinhas();i++) {
			System.out.print('|');
			for(int j = 0;j < this.getColunas();j++) {
				System.out.printf(" %d\t",imagem[i][j]);
			}
			System.out.print("|\n");
		}
	}
	
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		
		//Testando matriz gerada por um valor:
		System.out.println("|Matriz 1:\n[Digite um valor para linhas e colunas:");
		int t1 = s.nextInt();
		Matriz m1 = new Matriz(t1);
		
		m1.imprimirMatriz();
		m1.getDiagonalPrincipal();
		
		//Testando matriz gerada por dois valores:
		System.out.println("|Matriz 2:\n[Digite um valor para o numero de linhas:");
		int t2l = s.nextInt();
		System.out.println("[Digite um valor para o numero de colunas:");
		int t2c = s.nextInt();
		Matriz m2 = new Matriz(t2l,t2c);
		
		m2.imprimirMatriz();
		m2.getDiagonalPrincipal();
		
		System.out.println("\n{Se primeira possuir o numero de colunas igual ao de linhas da segunda");
		System.out.println("{Será exibido o resultado de uma multiplicação:");
		Matriz result = Matrizes.multiplicar(m1, m2);
		result.imprimirMatriz();
		
		s.close();
		System.out.println("\n[Fim de execucao]");
	}
	
	
}
