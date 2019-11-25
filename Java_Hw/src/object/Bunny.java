package object;
import java.util.*;

public class Bunny extends GameObject {
	
	public static Vector<Bunny> bunnyList = new Vector<Bunny>();  // ���ϸ� ȿ�������� ������ ���͸� �����մϴ�.
	
	int loneliness= 0;
	static int bunnyCount = 0;
	public Bunny() {
		super(rNum0_19(), rNum0_19()/2, rNum0_19()/9);
			shape = 'B';
			bunnyCount++;
	}
		
	public void setDistance() {
		distance = rNum0_19()/9;
	}
	
	public void move() {
		this.x = distance - 2;
		setDistance();
		this.y = distance - 2;
		setDistance();
		loneliness++;
		
		if(x<0)	x = 0; if(x>19) x = 19;
		if(y<0) y = 0; if(y>10) y = 9;
		if(loneliness == 5)
		{
			bunnySplit();
			loneliness = 0;
		}
	}
	public char getShape() { return shape; }
	
	public void bunnySplit() {  // ���ϰ� �ܷο��� �п��� �մϴ�.
		bunnyList.add(new LittleBunny(getX(),getY()));
		countUp();
		loneliness=0;
	}
	public void countUp() { bunnyCount++; }
	public void countDown() { bunnyCount--; }
}

class LittleBunny extends Bunny {
	public LittleBunny(int momX, int momY) {
		this.x = momX;
		this.y = momY;
		shape = 'L';
	}
}