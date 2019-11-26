package object;

import java.util.Vector;

public class Lion extends GameObject {
	
	public static Vector<Lion> lionList = new Vector<Lion>();  // 사자를 효율적으로 관리할 벡터를 생성합니다.
	public static int p_X;
	public static int p_Y;
	
	public Lion() {
		super(rNum0_11(), rNum0_11()/2, 1);
		shape = 'L';
	}

	public void move() {
		/*
		if(rNum0_2()==1) {
			if(this.x > p_X) this.x=-distance;
			else if(this.x < p_X) this.x=+distance;
			else {
				if(this.y > p_Y) this.y=-distance;
				else if(this.y < p_Y) this.y=+distance;
			}
		}
		else {
			if(this.y > p_Y) this.y=-distance;
			else if(this.y < p_Y) this.y=+distance;
			else {
				if(this.x > p_X) this.x=-distance;
				else if(this.x < p_X) this.x=+distance;
			}
		}
		*/
		if(rNum0_2()==1) {
			this.x = this.x + (distance - 2);
			setDistance();
		}
		
		else {
			this.y = this.y + (distance - 2);
			setDistance();
		}
		if(x<0)	x = 0; if(x>11) x = 11;
		if(y<0) y = 0; if(y>5) y = 5;
	}
	public void setDistance() {
		distance = rNum0_19()/4;
	}
	public char getShape() {
		return shape;
	}
}
