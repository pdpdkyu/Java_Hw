package main;
import object.*;
import java.util.*;

public class BunnyBunny {
	public static void showField(Player p, Vector<Bunny> bunnyList) {
		char[][] field = new char[10][20];
		for(int y=0;y<10;y++) {
			for(int x=0;x<20;x++)
				field[y][x] = '-';
		}
		field[p.getY()][p.getX()] = p.getShape();
		for(int i=0; i<bunnyList.size();i++) {
			field[bunnyList.get(i).getY()][bunnyList.get(i).getX()] = bunnyList.get(i).getShape();
		}
		for(int y=0;y<10;y++) {
			for(int x=0;x<20;x++)
				System.out.print(field[y][x]);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		Vector<Bunny> bunnyList = Bunny.bunnyList;
		bunnyList.add(new Bunny());
		Player p = new Player();
		
		while(true)
		{
			showField(p, bunnyList);
			p.move();
			for(int i=0; i<bunnyList.size(); i++)
				bunnyList.get(i).move();
		}
		
	}
}
