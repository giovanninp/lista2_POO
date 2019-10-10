package school.cesar.q2;

import java.lang.Math;
import java.util.Scanner;

public class EquacaoSegundoGrau {
	private double a,b,c;
	
	public EquacaoSegundoGrau(double a,double b,double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String toString() {
		float [] raizes = getRaizes();
		String result = ("["+this.a + "*x^2 +" + this.b + "*x+ " + this.c + "=0]" +
						"(x1=" + raizes[0] + ",x2=" + raizes[1] + ")]");
		System.out.println(result);
		return result;
	}
	
	public int hashcode() {
		String a = Integer.toString((int) (this.a < 0 ? (this.a*-1) : this.a));
		String b = Integer.toString((int) (this.b < 0 ? (this.b*-1) : this.b));
		String c = Integer.toString((int) (this.c < 0 ? (this.c*-1) : this.c));
		
		float [] xS = getRaizes();
		String x1 = Integer.toString((int) ((xS[0] < 0 ? xS[0] * -1 : xS[0]) * 10));
		String x2 = Integer.toString((int) ((xS[1] < 0 ? xS[1] * -1 : xS[1]) * 10));
		
		String sResult = (a + b + c + x1 + x2);
		int result = Integer.parseInt(sResult);
		return result;
	}
	
	public boolean equals(EquacaoSegundoGrau eq) {
		boolean result = true;
		
		if(this.a == eq.a) {
			if(this.b == eq.b && result == true) {
				if(this.c == eq.c && result == true);
				else {
					result = false;
				}
			}
			else {
				result = false;
			}
		}
		else {
			result = false;
		}
		
		return result;
	}
	
	public float [] getRaizes() {
		float [] result;
		result = new float [2];

		double delta = (Math.pow(this.b, 2)) - ((4*this.a)*this.c);
		if(delta < 0) {
			result[0] = 0;
			result[1] = 0;
			return result;
		}
		result[0] = (float) (((-1*this.b) - (Math.sqrt(delta)))/(2*this.a));
		result[1] = (float) (((-1*this.b) + (Math.sqrt(delta)))/(2*this.a));
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a1,b1,c1;
		
		System.out.println("Equacao 1:");
		System.out.println("Digite o valor de a:");
		a1 = s.nextInt();
		System.out.println("Digite o valor de b:");
		b1 = s.nextInt();
		System.out.println("Digite o valor de c:");
		c1 = s.nextInt();
		
		EquacaoSegundoGrau eq1 = new EquacaoSegundoGrau(a1, b1, c1);
		System.out.println("|x'= "+eq1.getRaizes()[0]);
		System.out.println("|x''= "+eq1.getRaizes()[1]);
		System.out.println("|hashcode: " + eq1.hashcode());
		System.out.println("|To String:");
		eq1.toString();
		
		
		EquacaoSegundoGrau eq1C = new EquacaoSegundoGrau(a1, b1, c1);
		EquacaoSegundoGrau eq2 = new EquacaoSegundoGrau(a1 + 1, b1 - 1, c1 -2);
		
		System.out.println("|Comparacao com um igual: " + eq1.equals(eq1C));
		eq1C.toString();
		
		System.out.println("|Comparacao com um diferente: " + eq1.equals(eq2));
		eq2.toString();
		
		s.close();
		System.out.println("[Fim de execucao]");
	}
	
}
