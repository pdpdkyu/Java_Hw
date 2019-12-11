package object;
import java.util.*;

public class Bunny extends GameObject {
	
	public static Vector<Bunny> bunnyList = new Vector<Bunny>();  // �䳢�� ȿ�������� ������ ���͸� �����մϴ�.
	private int loneliness= 0; // �䳢�� �ܷο�����
	public static int bunnyCount = 0; // �䳢�� ��
	public Bunny() {
		super(rNum0_11(), rNum0_11()/2, rNum0_19()/9); // 
			shape = 'B';
			bunnyCount++;
	}
	public Bunny(int n_x, int n_y) {
		super(n_x, n_y, rNum0_19()/9); // �����Ǵ� 
	}
		
	public void setDistance() {
		distance = rNum0_19()/4; // 0~4�� ������ ����
	}
	
	public void move() {
		if(rNum0_2()==1) {
			this.x = this.x + (distance - 2); // x�� -2 ~ 2 �� ������ ���ڷ� ����
			setDistance(); // distance ���� �ٽ� �ٲ�
		}
		
		else {
			this.y = this.y + (distance - 2);
			setDistance(); // distance ���� �ٽ� �ٲ�
		}
		loneliness++; // 1�� �����̸� �䳢�� �ܷο� ���� �ø�
		
		if(x<0)	x = 0; if(x>11) x = 11;
		if(y<0) y = 0; if(y>5) y = 5;
		if(loneliness == 4) // �ܷο� ������ 4���Ǹ� �䳢�� �п��ϰ� �ܷο� ������ 0����
		{
			bunnySplit();
			loneliness = 0;
		}
	}
	public char getShape() { return shape; }
	
	public void bunnySplit() {  // �п��� �䳢�� �� �ڸ����� ����
		bunnyList.add(new LittleBunny(getX(),getY())); 
		bunnyCount++;
		loneliness=0;
	}
}

class LittleBunny extends Bunny {  // ���� �䳢 Ŭ������ �䳢 Ŭ������ �����
	public LittleBunny(int momX, int momY) {
		super(momX, momY);
		shape = 'b'; // ���� �䳢�� ����� b
	}
}