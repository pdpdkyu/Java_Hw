package object;
import java.util.Scanner;

public class Player extends GameObject{
	public int bunnyScore = 0;

	public Player() {
		super(0,0,1); // 플레이어는 필드의 (0,0) 에서 시작하며 한번에 한 칸만 움직일 수 있음
		shape = 'P';
	}
	@Override
	public void move() {
		Scanner sc = new Scanner(System.in);
		String direction = sc.nextLine(); // 사용자에게 입력받음
		switch(direction) {
		case "a":  // a라면 왼쪽으로 이동
			if( getX() == 0) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.x = this.x - distance;
			break;
		case "s":  // s라면 아래로 이동
			if( getY() == 5) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.y = this.y + distance;
			break;
		case "d": // d라면 오른쪽으로 이동
			if( getX() == 11 ) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.x = this.x + distance;
			break;
		case "w": // w라면 위로 이동
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
	public char getShape() { return shape; } // 객체의 모양 반환
}

