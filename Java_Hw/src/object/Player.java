package object;
import java.util.Scanner;

public class Player extends GameObject{
	public int bunnyScore = 0;

	public Player() {
		super(0,0,1); // �÷��̾�� �ʵ��� (0,0) ���� �����ϸ� �ѹ��� �� ĭ�� ������ �� ����
		shape = 'P';
	}
	@Override
	public void move() {
		Scanner sc = new Scanner(System.in);
		String direction = sc.nextLine(); // ����ڿ��� �Է¹���
		switch(direction) {
		case "a":  // a��� �������� �̵�
			if( getX() == 0) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.x = this.x - distance;
			break;
		case "s":  // s��� �Ʒ��� �̵�
			if( getY() == 5) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.y = this.y + distance;
			break;
		case "d": // d��� ���������� �̵�
			if( getX() == 11 ) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.x = this.x + distance;
			break;
		case "w": // w��� ���� �̵�
			if( getY() == 0) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.y = this.y - distance;
			break;	
		}
	}
	@Override
	public char getShape() { return shape; } // ��ü�� ��� ��ȯ
}

