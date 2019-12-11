package main;
import object.*;
import java.util.*;
import java.lang.Math;
public class BunnyBunny {
	// �ʵ��� ���� ���¸� �����ִ� �޼ҵ�
	public static void showField(Player p, Vector<Bunny> bunnyList, Vector<Lion> lionList) {
		char[][] field = new char[6][12]; //�ʵ� ����
		for(int y=0;y<6;y++) {
			for(int x=0;x<12;x++)
				field[y][x] = '-'; // ��ĭ��  - �� ǥ��
		}
		for(int i=bunnyList.size()-1; i>=0;i--) { // �ʵ忡 �䳢 ǥ��
			field[bunnyList.get(i).getY()][bunnyList.get(i).getX()] = bunnyList.get(i).getShape(); 
		}
		for(int i=0; i<lionList.size();i++) { // �ʵ忡 ���� ǥ��
			field[lionList.get(i).getY()][lionList.get(i).getX()] = lionList.get(i).getShape();
		}
		field[p.getY()][p.getX()] = p.getShape(); // �ʵ忡 �÷��̾� ǥ��
		System.out.println("Bunny Count: " + Bunny.bunnyCount);
		for(int y=0;y<6;y++) { // �ʵ� ���
			for(int x=0;x<12;x++)
				System.out.print(field[y][x]+"  ");
			System.out.println();
		}
		System.out.println("Your Bunny Score: " + p.bunnyScore);
	}
	
	public static void main(String[] args) {
		
		Vector<Bunny> bunnyList = Bunny.bunnyList; // ���Ϳ� �����ϰ� ������ �� �ֵ��� ����
		Vector<Lion> lionList = Lion.lionList;
		bunnyList.add(new Bunny());
		Player p = new Player();
		
		showField(p, bunnyList, lionList);
		while(true)
		{
			p.move(); // �÷��̾ �����δ�.
			for(int i=0;i<Bunny.bunnyCount;i++) {
				if(p.collide(bunnyList.get(i))) { 
					// ���� ������ i ��° ��ü�� ��ǥ�� ���ٸ� �÷��̾��� �䳢�� ���ڸ� �ϳ� ���̰� �÷��̾��� ������ �ø���. 
					Bunny.bunnyCount--;
					bunnyList.remove(i);
					p.bunnyScore++;
					i--;				
				}
					
			}
			for(int i=0; i<bunnyList.size(); i++) // ��� �䳢��ü�� �����δ�.
				bunnyList.get(i).move();
			for(int i=0;i<Bunny.bunnyCount;i++) { // �䳢�� ������ �� �÷��̾�� ��ġ�� ���ٸ� �����Ѵ�. 
				if(p.collide(bunnyList.get(i))) { // �׸��� �÷��̾��� ������ �߰��Ѵ�.
					Bunny.bunnyCount--;
					bunnyList.remove(i);
					p.bunnyScore++;
					i--;				
				}
				for(int j=0;j<Lion.lionList.size();j++) {
					if(bunnyList.get(i).collide(lionList.get(j))) { // �䳢�� ������ �� ���ڿ� ��ġ�� ���ٸ� �����Ѵ�.
						Bunny.bunnyCount--;  
						bunnyList.remove(i);
						i--;
						break; // ���� �� �ϸ��� �����ĵ� �䳢 ����
					}
				}
			}
			if(bunnyList.size() == 0) {  // ��� �䳢�� �����ٸ� ���α׷� ����
				System.out.println("Game End!");
				System.out.println("Your Final Score is " + p.bunnyScore );
				break;
			}
			
			for(int i=0; i<Bunny.bunnyCount/6; i++) {  // �䳢 6������ 1 ������ ���ڰ� �߰�
				Lion.lionList.add(new Lion());
			}
			
			for(int i=0; i<lionList.size(); i++) {
				lionList.get(i).move(); // ��� ���ڰ� �����δ�.
				for(int j=0;j<Bunny.bunnyCount;j++) {
					if(lionList.get(i).collide(bunnyList.get(j))) { // ��� ���ڶ󵵿� ����ġ�� �䳢 ����
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
