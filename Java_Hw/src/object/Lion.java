package object;
import java.util.Vector;

public class Lion extends GameObject {
	
	public static Vector<Lion> lionList = new Vector<Lion>();  // 사자를 효율적으로 관리할 벡터를 생성합니다.
	
	public Lion() {
		super(rNum0_11(), rNum0_11()/2, 1); // 생성되는 사자의 위치는 랜덤
		shape = 'L';
	}

	public void move() {  // 사자는 한 턴에 상하좌우 중 한 방향으로만 1~2칸으로 움직임
		if(rNum0_2()==1) {  
			this.x = this.x + (distance - 2);
			setDistance(); // distance 값을 변경
		}
		
		else {
			this.y = this.y + (distance - 2);
			setDistance();  // distance 값을 변경
		}
		if(x<0)	x = 0; if(x>11) x = 11; // 필드를 벗어나는 움직임을 보이면 필드의 경계선에 위치하도록 함
		if(y<0) y = 0; if(y>5) y = 5;
	}
	public void setDistance() {
		distance = rNum0_19()/4; // distance는 0~4의 랜덤한 숫자
	}
	public char getShape() { // 사자를 표현할 L 반환
		return shape;
	}
}
