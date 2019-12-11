package object;
import java.util.*;

public class Bunny extends GameObject {
	
	public static Vector<Bunny> bunnyList = new Vector<Bunny>();  // 토끼를 효율적으로 관리할 벡터를 생성합니다.
	private int loneliness= 0; // 토끼의 외로움지수
	public static int bunnyCount = 0; // 토끼의 수
	public Bunny() {
		super(rNum0_11(), rNum0_11()/2, rNum0_19()/9); // 
			shape = 'B';
			bunnyCount++;
	}
	public Bunny(int n_x, int n_y) {
		super(n_x, n_y, rNum0_19()/9); // 생성되는 
	}
		
	public void setDistance() {
		distance = rNum0_19()/4; // 0~4의 랜덤한 정수
	}
	
	public void move() {
		if(rNum0_2()==1) {
			this.x = this.x + (distance - 2); // x를 -2 ~ 2 의 랜덤한 숫자로 정함
			setDistance(); // distance 값을 다시 바꿈
		}
		
		else {
			this.y = this.y + (distance - 2);
			setDistance(); // distance 값을 다시 바꿈
		}
		loneliness++; // 1번 움직이면 토끼의 외로움 지수 올림
		
		if(x<0)	x = 0; if(x>11) x = 11;
		if(y<0) y = 0; if(y>5) y = 5;
		if(loneliness == 4) // 외로움 지수가 4가되면 토끼가 분열하고 외로움 지수를 0으로
		{
			bunnySplit();
			loneliness = 0;
		}
	}
	public char getShape() { return shape; }
	
	public void bunnySplit() {  // 분열한 토끼는 그 자리에서 생성
		bunnyList.add(new LittleBunny(getX(),getY())); 
		bunnyCount++;
		loneliness=0;
	}
}

class LittleBunny extends Bunny {  // 작은 토끼 클래스는 토끼 클래스를 상속함
	public LittleBunny(int momX, int momY) {
		super(momX, momY);
		shape = 'b'; // 작은 토끼의 모양은 b
	}
}