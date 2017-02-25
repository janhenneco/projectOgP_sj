
public class Facade implements IFacade{

	public Facade(){
	
	}
	/**
	 * Create a new ship with a default position, velocity, radius and
	 * direction.
	 * 
	 * Result is a unit circle centered on <code>(0, 0)</code> facing right. Its
	 * speed is zero.
	 */
	public Ship createShip() {
		return new Ship();
	}
		
	/**
	 * Create a new ship with the given position, velocity, radius and
	 * orientation (in radians).
	 */
	public Ship createShip(double x, double y, double xVelocity, double yVelocity, double radius, double orientation) {
		return new Ship(x, y, xVelocity, yVelocity, radius, orientation);
	}

	/**
	 * Return the position of <code>ship</code> as an array of length 2, with the
	 * x-coordinate at index 0 and the y-coordinate at index 1.
	 */
	public double[] getShipPosition(Ship ship) {
		return ship.position();
	}
	/**
	 * Return the velocity of <code>ship</code> as an array of length 2, with the velocity
	 * along the X-axis at index 0 and the velocity along the Y-axis at index 1.
	 */
	public double[] getShipVelocity(Ship ship) {
		return ship.velocity();
	}
		
	/**
	 * Return the radius of <code>ship</code>.
	 */
	public double getShipRadius(Ship ship) throws ModelException;

	/**
	 * Return the orientation of <code>ship</code> (in radians).
	 */
	public double getShipOrientation(Ship ship) throws ModelException;

	/**
	 * Update <code>ship</code>'s position, assuming it moves <code>dt</code>
	 * seconds at its current velocity.
	 */
	public void move(Ship ship, double dt) {
		ship.move(dt);
	}

	/**
	 * Update <code>ship</code>'s velocity based on its current velocity, its
	 * direction and the given <code>amount</code>.
	 */
	public void thrust(Ship ship, double amount) {
		ship.thrust(amount);
	}

	/**
	 * Update the direction of <code>ship</code> by adding <code>angle</code>
	 * (in radians) to its current direction. <code>angle</code> may be
	 * negative.
	 */
	public void turn(Ship ship, double angle) {
		ship.turn(angle);
	}

	/**
	 * Return the distance between <code>ship1</code> and <code>ship2</code>.
	 * 
	 * The absolute value of the result of this method is the minimum distance
	 * either ship should move such that both ships are adjacent. Note that the
	 * result must be negative if the ships overlap. The distance between a ship
	 * and itself is 0.
	 */
	public double getDistanceBetween(Ship ship1, Ship ship2) {
		return ship1.getDistanceBetween(ship2);
		//static: return Ship.getDistanceBetween(ship1, ship2)
	}

	/**
	 * Check whether <code>ship1</code> and <code>ship2</code> overlap. A ship
	 * always overlaps with itself.
	 */
	public boolean overlap(Ship ship1, Ship ship2) {
		return ship1.overlap(ship2);
		//kan ook static
	}

	/**
	 * Return the number of seconds until the first collision between
	 * <code>ship1</code> and <code>ship2</code>, or Double.POSITIVE_INFINITY if
	 * they never collide. A ship never collides with itself.
	 */
	public double getTimeToCollision(Ship ship1, Ship ship2) {
		return ship1.getTimeToCollision(ship2);
	}

	/**
	 * Return the first position where <code>ship1</code> and <code>ship2</code>
	 * collide, or <code>null</code> if they never collide. A ship never
	 * collides with itself.
	 * 
	 * The result of this method is either null or an array of length 2, where
	 * the element at index 0 represents the x-coordinate and the element at
	 * index 1 represents the y-coordinate.
	 */
	public double[] getCollisionPosition(Ship ship1, Ship ship2) {
		return ship1.getCollisionPosition(ship2);
	}
	
}

