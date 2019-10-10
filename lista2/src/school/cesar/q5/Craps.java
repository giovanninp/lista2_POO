package school.cesar.q5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Craps {
	
	private Scanner s;

	private class Dice {
		private Random rand = new Random();
		private int sides;
		
		public Dice(int sides) {
			this.sides = sides;
		}
		
		public int rollDice() {
			int result = rand.nextInt(this.sides);
			return (result < 1 ? result+=1 : result);
		}
	}
	
	private class Player {
		private ArrayList <Integer> rolls = new ArrayList<Integer>();
		private int rollCount;
		
		public void addRoll(int i) {
			this.rolls.add(i);
			this.rollCount++;
		}
	}
	
	private class Game {
		private Player player = new Player();
		private Dice dice = new Dice(6);
		
		String wMessage = "\n|Parabéns, você venceu!";
		String lMessage = "\n|Eita, não foi dessa vez!";
		
		public boolean applyTurn() {
			boolean repeat = true;
			int roll1 = dice.rollDice();
			int roll2 = dice.rollDice();
			int definitiveRoll = roll1 + roll2;
			System.out.println("\t|Dado 1: " + roll1 +"\n\t|Dado 2: " + roll2 + "\n\t|Pontuacao: " + definitiveRoll);
			this.player.addRoll(definitiveRoll);
			if(this.player.rollCount == 1) {
				if (definitiveRoll == 7 || definitiveRoll == 11) {
					System.out.println(wMessage);
					repeat = false;
				}
				else if(definitiveRoll == 2 || definitiveRoll == 3 || definitiveRoll == 12){
					System.out.println(lMessage);
					repeat = false;
				}
			}
			else {
				if(definitiveRoll == 4
						|| definitiveRoll == 5
						|| definitiveRoll == 6
						|| definitiveRoll == 8
						|| definitiveRoll == 9
						|| definitiveRoll == 10) {
					for(int i = 0; (3 < this.player.rollCount - 1 ? (i < 3) : (i < this.player.rollCount - 1)); i++) {
						int indexTemp = this.player.rollCount - (2+i);
						System.out.println("\t\t|"+definitiveRoll + " == " + this.player.rolls.get(indexTemp) + " = " + (definitiveRoll == this.player.rolls.get(indexTemp)));
						if(this.player.rolls.get(indexTemp) == definitiveRoll) {
							System.out.println();
							System.out.println(wMessage);
							repeat = false;
							break;
						}
						else if(indexTemp < 0) {
							break;
						}
					}
				}
				else if(definitiveRoll == 7) {
					System.out.println(lMessage);
					repeat = false;
				}
			}
			return repeat;
		}
	}
	
	private Game startGame() {
		Game newGame = new Game();
		return newGame;
	}
	
	public void gameTurn() {
		Game game = this.startGame();
		s = new Scanner(System.in);
		String input;
		int count = 1;
		do {
			System.out.println("\n[Toque em Enter para continuar\n[Digite 'parar' para sair");
			input = s.nextLine();
			if(input.equalsIgnoreCase("parar")) {
				break;
			}
			System.out.println("|Jogada: " + (count++));
		}while(game.applyTurn() || count == 31);
	}
	
	public static void main(String [] args) {
		Craps craps = new Craps();
		System.out.println("|JCRAPS");
		for(int i = 0;i < 30;i++) {
			System.out.println("\n+ Partida: " + (i+1)+"------------------");
			craps.gameTurn();
		}
		System.out.println("\n|FIM");
	}
	
}
