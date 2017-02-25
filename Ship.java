import java.lang.math;

public class Ship  {
	
	/**
	 * 
	 */
	
	
//	private double x;
//	private double y;
	private Position position;
	private Velocity velocity;
	private double radius;
	private double orientation;
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param xVelocity
	 * @param yVelocity
	 * @param radius
	 * @param orientation
	 */
	public Ship(double x, double y, double xVelocity, double yVelocity, double radius, double orientation) {
		this.position= new Position(x,y);
		this.velocity= new Velocity(xVelocity,yVelocity, orientation);
		this.radius=radius;
	}
	
	
	// kan je ook meteen al opslagen als double[]
	// of een klasse positie maken
	public double[] position() {
		//double[] resultPosition = new double[2];
		//resultPosition[0] = this.position.x;
		//resultPosition[1] = this.position.y;
		//return resultPosition;
		return new double[2] {this.position.x(), this.position.y()};
	}
	
	public double[] velocity() {
		return new double[2] {this.velocity.xVelocity(), this.velocity.yVelocity()};
	}
	
	//move zit in de klasse Position
	public void move(double dt) {
		this.position.move(dt, this.velocity); 
	}
		
	public void thrust(double amount) {
		this.velocity.thrust(amount);
	}
	
	public void turn(double angle) {
		this.velocity.orientation = this.velocity.orientation + angle;
	}
	
	public double getDictanceBetween(Ship otherShip) {
		return sqrt((this.position.deltaX)^2+(this.position.deltaY)^2);
	}
	
	private double getVelocityBetween(Ship otherShip) {
		return sqrt((this.velocity.deltaVx)^2+(this.velocity.deltaVy)^2);
	}
	
	private double getVelocityDistance(Ship othership) {
		return (this.position.deltaX*this.velocity.deltaVx)+(this.position.deltaY*this.velocity.deltaVy);
	}
	
	private double getD(Ship otherShip) {
		return (getVelocityDistance(othership))^2-((getVelocityBetween(otherShip))^2)*((getDictanceBetween(otherShip))^2-(this.radius+otherShip.radius)^2)
	}
	
	private double collisionTime(Ship othership) {
		return -( (getVelocityDistance(othership)+sqrt(getD(otherShip)) / sqrt(getVelocityBetween(otherShip)) );
	}
	
	/**
	 * 
	 * @param othership
	 * @return
	 */
	public boolean overlap(Ship otherShip) {
		if (this.position.equals(otherShip.position)) return true;
		if (this.getDictanceBetween(otherShip) < (this.radius + otherShip.radius)) return true;
		return false;
	}
	
	public double getTimeToCollision(Ship otherShip) {
		if (this.overlap(otherShip)) throw new ModelException("this method does nog apply to ships that overlap");
		if (this.getVelocityDistance(otherShip) >= 0) || (this.getD(otherShip)<=0) return Double.POSITIVE_INFINITY;
		return collisionTime(othership);
	}
	
	private Position positionAtCollision(Ship othership) {
		double time = getTimeToCollision(othership);
		double xPosition = this.position.x() + (this.velocity.xVelocity() * time);
		double yPosition = this.position.y() + (this.velocity.yVelocity() * time);
		return new Position(xPosition, yPosition);
	}
	
	
	private double collisionOrientation(Ship othership) {
		return cos((this.position.x() - otherShip.position.x())/(this.radius + othership.radius));
	}
	
	
	public double[] getCollisionPosition(Ship otherShip) {
		try {
			if (this.getTimeToCollision(othership) == Double.POSITIVE_INFINITY) return null;
		}
		catch (ModelExeption e) {
			return null
		}
		double angle = collisionOrientation(othership);
		double xPosition = this.position.x() + this.radius*cos(angle);
		double yPosition = this.position.y() + this.radius*sin(angle);
		return new double[2] {xPosition,yPosition};
	}
}

	

