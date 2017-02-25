import java.lang.math;

public class Position {
	private double x;
	private double y;
	
	public Position(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}
	
	public void move(double dt, Velocity velocity) {
		this.x = this.x + dt*velocity.xVelocity();
		this.y=this.y+ dt* velocity.yVelocity();
	}
		
	public boolean equals(Position otherPosition) {
		return ((this.x == otherPosition.x) && (this.y == otherPosition.y));		
	}
	
	public double deltaX(Position otherPosition) {
		return (this.x - otherPosition.x);
	}
	
	public double deltaY(Position otherPosition) {
		return (this.y - otherPosition.y);
	}
}
