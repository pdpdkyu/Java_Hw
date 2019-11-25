package object;
import java.util.*;

public abstract class GameObject {  //  �߻� Ŭ����
	protected int distance;  //  �� �� �̵� �Ÿ�
	protected int x, y;  //  ���� ��ġ
	protected char shape;
    
	public static int rNum0_19() {
		return (int)(19*Math.random());
	}
	
	public GameObject(int startX, int startY, int distance) {  // �ʱ� ��ġ�� �̵� �Ÿ� ����		
		this.x = startX; 
		this.y = startY;
		this.distance = distance;
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public boolean collide(GameObject p) {  //  �� ��ü�� ��ü p�� �浿������ true ����
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
		
	protected abstract void move();  //  �̵��� ���� ���ο� ��ġ�� x, y ����
	protected abstract char getShape();  //  ��ü�� ����� ��Ÿ���� ���� ����  
}
