package object;
import java.util.*;

public abstract class GameObject {  //  추상 클래스
	protected int distance;  //  한 번 이동 거리
	protected int x, y;  //  현재 위치
	protected char shape;
    
	public static int rNum0_19() { // 0~18의 랜덤한 정수
		return (int)(19*Math.random());
	}
	public static int rNum0_11() { // 0~10의 랜덤한 정수
		return (int)(11*Math.random());
	}
	public static int rNum0_5() { // 0~4의 랜덤한 정수
		return (int)(5*Math.random());
	}
	public static int rNum0_2() { // 0~1의 랜덤한 정수
		return (int)(2*Math.random());
	}
	public GameObject(int startX, int startY, int distance) {  // 초기 위치와 이동 거리 설정		
		this.x = startX; // 
		this.y = startY;
		this.distance = distance;
	}
	public int getX() { return x; } // 객체의 x좌표 반환
	public int getY() { return y; } // 객체의 y좌표 반환
	public boolean collide(GameObject p) {  //  이 객체가 객체 p와 충동했으면 true 리턴
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
		
	protected abstract void move();  //  이동한 후의 새로운 위치로 x, y 변경
	protected abstract char getShape();  //  객체의 모양을 나타내는 문자 리턴  
}

