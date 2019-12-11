package object;
import java.util.Vector;

public class Lion extends GameObject {
	
	public static Vector<Lion> lionList = new Vector<Lion>();  // ���ڸ� ȿ�������� ������ ���͸� �����մϴ�.
	
	public Lion() {
		super(rNum0_11(), rNum0_11()/2, 1); // �����Ǵ� ������ ��ġ�� ����
		shape = 'L';
	}

	public void move() {  // ���ڴ� �� �Ͽ� �����¿� �� �� �������θ� 1~2ĭ���� ������
		if(rNum0_2()==1) {  
			this.x = this.x + (distance - 2);
			setDistance(); // distance ���� ����
		}
		
		else {
			this.y = this.y + (distance - 2);
			setDistance();  // distance ���� ����
		}
		if(x<0)	x = 0; if(x>11) x = 11; // �ʵ带 ����� �������� ���̸� �ʵ��� ��輱�� ��ġ�ϵ��� ��
		if(y<0) y = 0; if(y>5) y = 5;
	}
	public void setDistance() {
		distance = rNum0_19()/4; // distance�� 0~4�� ������ ����
	}
	public char getShape() { // ���ڸ� ǥ���� L ��ȯ
		return shape;
	}
}
