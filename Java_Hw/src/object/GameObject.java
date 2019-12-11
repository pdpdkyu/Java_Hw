package object;
import java.util.*;

public abstract class GameObject {  //  �߻� Ŭ����
	protected int distance;  //  �� �� �̵� �Ÿ�
	protected int x, y;  //  ���� ��ġ
	protected char shape;
    
	public static int rNum0_19() { // 0~18�� ������ ����
		return (int)(19*Math.random());
	}
	public static int rNum0_11() { // 0~10�� ������ ����
		return (int)(11*Math.random());
	}
	public static int rNum0_5() { // 0~4�� ������ ����
		return (int)(5*Math.random());
	}
	public static int rNum0_2() { // 0~1�� ������ ����
		return (int)(2*Math.random());
	}
	public GameObject(int startX, int startY, int distance) {  // �ʱ� ��ġ�� �̵� �Ÿ� ����		
		this.x = startX; // 
		this.y = startY;
		this.distance = distance;
	}
	public int getX() { return x; } // ��ü�� x��ǥ ��ȯ
	public int getY() { return y; } // ��ü�� y��ǥ ��ȯ
	public boolean collide(GameObject p) {  //  �� ��ü�� ��ü p�� �浿������ true ����
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
		
	protected abstract void move();  //  �̵��� ���� ���ο� ��ġ�� x, y ����
	protected abstract char getShape();  //  ��ü�� ����� ��Ÿ���� ���� ����  
}

