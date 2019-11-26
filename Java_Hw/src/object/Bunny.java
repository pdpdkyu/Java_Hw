package object;
import java.util.*;

public class Bunny extends GameObject {
	
	public static Vector<Bunny> bunnyList = new Vector<Bunny>();  // 버니를 효율적으로 관리할 벡터를 생성합니다.
	int loneliness= 0;
	public static int bunnyCount = 0;
	public Bunny() {
		super(rNum0_11(), rNum0_11()/2, rNum0_19()/9);
			shape = 'B';
			bunnyCount++;
	}
	public Bunny(int n_x, int n_y) {
		super(n_x, n_y, rNum0_19()/9);
	}
		
	public void setDistance() {
		distance = rNum0_19()/4;
	}
	
	public void move() {
		if(rNum0_2()==1) {
			this.x = this.x + (distance - 2);
			setDistance();
		}
		
		else {
			this.y = this.y + (distance - 2);
			setDistance();
		}
		loneliness++;
		
		if(x<0)	x = 0; if(x>11) x = 11;
		if(y<0) y = 0; if(y>5) y = 5;
		if(loneliness == 4)
		{
			bunnySplit();
			loneliness = 0;
		}
	}
	public char getShape() { return shape; }
	
	public void bunnySplit() {  // 버니가 외로워서 분열을 합니다.
		bunnyList.add(new LittleBunny(getX(),getY()));
		bunnyCount++;
		loneliness=0;
	}
}

class LittleBunny extends Bunny {
	public LittleBunny(int momX, int momY) {
		super(momX, momY);
		shape = 'B';
	}
}