package main;
import object.*;
import java.util.*;
import java.lang.Math;
public class BunnyBunny {
	public static void showField(Player p, Vector<Bunny> bunnyList, Vector<Lion> lionList) {
		char[][] field = new char[6][12];
		for(int y=0;y<6;y++) {
			for(int x=0;x<12;x++)
				field[y][x] = '-';
		}
		for(int i=bunnyList.size()-1; i>=0;i--) {
			field[bunnyList.get(i).getY()][bunnyList.get(i).getX()] = bunnyList.get(i).getShape();
		}
		for(int i=0; i<lionList.size();i++) {
			field[lionList.get(i).getY()][lionList.get(i).getX()] = lionList.get(i).getShape();
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
			showField(p, bunnyList, Lion.lionList);
			p.move();
			Lion.p_X = p.getX();
			Lion.p_Y = p.getY();
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
				for(int j=0;j<Lion.lionList.size();j++) {
					if(bunnyList.get(i).collide(Lion.lionList.get(j))) {
						Bunny.bunnyCount--;
						bunnyList.remove(i);
						i--;
						break;
					}
				}
			}
			if(bunnyList.size() == 0 || p.life == 0) {
				System.out.println("Game End!");
				System.out.println("Your Final Score is " + p.bunnyScore );
				break;
			}
			
			for(int i=0; i<Bunny.bunnyCount/10; i++) {
				Lion.lionList.add(new Lion());
			}
			
			for(int i=0; i<Lion.lionList.size(); i++) {
				Lion.lionList.get(i).move();
				for(int j=0;j<Bunny.bunnyCount;j++) {
					if(Lion.lionList.get(i).collide(bunnyList.get(j))) {
						Bunny.bunnyCount--;
						bunnyList.remove(j);
						j--;				
					}
				}
			}
			showField(p, bunnyList, Lion.lionList);
		}
		
	}
}
