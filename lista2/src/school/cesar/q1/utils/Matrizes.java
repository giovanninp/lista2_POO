package school.cesar.q1.utils;


import school.cesar.q1.domain.Matriz;

public class Matrizes {
	
	public static Matriz multiplicar(Matriz matrizA,Matriz matrizB) {
		Matriz result = null;
		if(matrizA.getColunas() == matrizB.getLinhas()) {
			int [][] imagemA = matrizA.getMatriz();
			int [][] imagemB = matrizB.getMatriz();
			int [][] imagemFinal = new int [matrizA.getLinhas()][matrizB.getColunas()];
			
			for(int iF = 0;iF < matrizA.getLinhas();iF++) {
				for(int jF = 0;jF < matrizB.getColunas();jF++) {
					//Mudado para colunas
					for(int index = iF;index < matrizA.getColunas();index++) {
						//index e o valor semelhante entre as duas matrizes 
						imagemFinal[iF][jF] += imagemA[iF][index] * imagemB[index][jF];
					}
				}
			}
			result = new Matriz(matrizA.getLinhas(),matrizB.getColunas());
			result.setMatriz(imagemFinal);
		}
		return result;
	}
}
