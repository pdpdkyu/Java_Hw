package object;
import java.util.Scanner;

public class Player extends GameObject{
	public int bunnyScore = 0;
	public int life = 1;
	public Player() {
		super(0,0,1);
		shape = 'P';
	}
	@Override
	public void move() {
		Scanner sc = new Scanner(System.in);
		String direction = sc.nextLine();
		switch(direction) {
		case "a":
			if( getX() == 0) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.x = this.x - distance;
			break;
		case "s":
			if( getY() == 5) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.y = this.y + distance;
			break;
		case "d":
			if( getX() == 11 ) {
				System.out.println("You can't move that way!");
				break;
			}
			else
				this.x = this.x + distance;
			break;
		case "w":
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
	public char getShape() { return shape; }
}

