import java.lang.math;

public class Velocity {

	private double xVelocity;
	private double yVelocity;
	private double orientation;
	
	public Velocity(double xVelocity, double yVelocity, double orientation) {
		this.xVelocity=xVelocity;
		this.yVelocity=yVelocity;
		this.orientation = orientation;
	}
	
	public double xVelocity() {
		return this.xVelocity;
	}
	
	public double yVelocity() {
		return this.yVelocity;
	}
	
	// klopt nog niet zie opgave
	public void thrust(double amount) {
		this.xVelocity= this.xVelocity + amount*cos(orientation);
		this.yVelocity= this.yVelocity + amount*sin(orientation);
	}
	
	public double deltaVx(Velocity otherVelocity) {
		return (this.xVelocity - otherVelocity.xVelocity);
	}
	
	public double deltaVy(Velocity otherVelocity) {
		return (this.yVelocity - otherVelocity.yVelocity);
	}
}
