package main;
import object.*;
import java.util.*;
import java.lang.Math;
public class BunnyBunny {
	// 필드의 현재 상태를 보여주는 메소드
	public static void showField(Player p, Vector<Bunny> bunnyList, Vector<Lion> lionList) {
		char[][] field = new char[6][12]; //필드 생성
		for(int y=0;y<6;y++) {
			for(int x=0;x<12;x++)
				field[y][x] = '-'; // 빈칸은  - 로 표시
		}
		for(int i=bunnyList.size()-1; i>=0;i--) { // 필드에 토끼 표시
			field[bunnyList.get(i).getY()][bunnyList.get(i).getX()] = bunnyList.get(i).getShape(); 
		}
		for(int i=0; i<lionList.size();i++) { // 필드에 사자 표시
			field[lionList.get(i).getY()][lionList.get(i).getX()] = lionList.get(i).getShape();
		}
		field[p.getY()][p.getX()] = p.getShape(); // 필드에 플레이어 표시
		System.out.println("Bunny Count: " + Bunny.bunnyCount);
		for(int y=0;y<6;y++) { // 필드 출력
			for(int x=0;x<12;x++)
				System.out.print(field[y][x]+"  ");
			System.out.println();
		}
		System.out.println("Your Bunny Score: " + p.bunnyScore);
	}
	
	public static void main(String[] args) {
		
		Vector<Bunny> bunnyList = Bunny.bunnyList; // 벡터에 용이하게 접근할 수 있도록 연결
		Vector<Lion> lionList = Lion.lionList;
		bunnyList.add(new Bunny());
		Player p = new Player();
		
		showField(p, bunnyList, lionList);
		while(true)
		{
			p.move(); // 플레이어가 움직인다.
			for(int i=0;i<Bunny.bunnyCount;i++) {
				if(p.collide(bunnyList.get(i))) { 
					// 버니 벡터의 i 번째 객체와 좌표가 같다면 플레이어의 토끼의 숫자를 하나 줄이고 플레이어의 점수를 올린다. 
					Bunny.bunnyCount--;
					bunnyList.remove(i);
					p.bunnyScore++;
					i--;				
				}
					
			}
			for(int i=0; i<bunnyList.size(); i++) // 모든 토끼객체를 움직인다.
				bunnyList.get(i).move();
			for(int i=0;i<Bunny.bunnyCount;i++) { // 토끼가 움직인 후 플레이어와 위치가 같다면 제거한다. 
				if(p.collide(bunnyList.get(i))) { // 그리고 플레이어의 점수를 추가한다.
					Bunny.bunnyCount--;
					bunnyList.remove(i);
					p.bunnyScore++;
					i--;				
				}
				for(int j=0;j<Lion.lionList.size();j++) {
					if(bunnyList.get(i).collide(lionList.get(j))) { // 토끼가 움직인 후 사자와 위치가 같다면 제거한다.
						Bunny.bunnyCount--;  
						bunnyList.remove(i);
						i--;
						break; // 사자 한 하리와 마주쳐도 토끼 제거
					}
				}
			}
			if(bunnyList.size() == 0) {  // 모든 토끼가 잡혔다면 프로그램 종료
				System.out.println("Game End!");
				System.out.println("Your Final Score is " + p.bunnyScore );
				break;
			}
			
			for(int i=0; i<Bunny.bunnyCount/6; i++) {  // 토끼 6마리당 1 마리씩 사자가 추가
				Lion.lionList.add(new Lion());
			}
			
			for(int i=0; i<lionList.size(); i++) {
				lionList.get(i).move(); // 모든 사자가 움직인다.
				for(int j=0;j<Bunny.bunnyCount;j++) {
					if(lionList.get(i).collide(bunnyList.get(j))) { // 어떠한 사자라도와 마주치면 토끼 제거
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
