package main;
import object.*;
import java.util.*;

public class BunnyBunny {
	public static void showField(Player p, Vector<Bunny> bunnyList) {
		char[][] field = new char[6][12];
		for(int y=0;y<6;y++) {
			for(int x=0;x<12;x++)
				field[y][x] = '-';
		}
		for(int i=bunnyList.size()-1; i>=0;i--) {
			field[bunnyList.get(i).getY()][bunnyList.get(i).getX()] = bunnyList.get(i).getShape();
		}
		field[p.getY()][p.getX()] = p.getShape();
		System.out.println("Bunny Count: " + Bunny.bunnyCount);
		for(int y=0;y<6;y++) {
			for(int x=0;x<12;x++)
				System.out.print(field[y][x]);
			System.out.println();
		}
		System.out.println("Your Bunny Score: " + p.bunnyScore);
	}
	
	public static void main(String[] args) {
		
		Vector<Bunny> bunnyList = Bunny.bunnyList;
		bunnyList.add(new Bunny());
		Player p = new Player();
		
		while(true)
		{
			showField(p, bunnyList);
			p.move();
			for(int i=0;i<Bunny.bunnyCount;i++) {
				if(p.collide(bunnyList.get(i))) {
					Bunny.bunnyCount--;
					bunnyList.remove(i);
					p.bunnyScore++;
					i--;				
				}
					
			}
			for(int i=0; i<bunnyList.size(); i++)
				bunnyList.get(i).move();
			for(int i=0;i<Bunny.bunnyCount;i++) {
				if(p.collide(bunnyList.get(i))) {
					Bunny.bunnyCount--;
					bunnyList.remove(i);
					p.bunnyScore++;
					i--;				
				}
			}
			if(bunnyList.size() == 0 || p.life == 0) {
				System.out.println("Game End!");
				System.out.println("Your Final Score is " + p.bunnyScore );
				break;
			}
		}
		
	}
}
