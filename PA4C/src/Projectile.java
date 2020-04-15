/**
 * Abstract projectile class for Asteroids game.
 * 
 * @author Yavuz Yavuzer
 * @version 04/14/2020
 *
 */
public abstract class Projectile implements Collidable, Updateable, Drawable
{
  protected Point location;
  protected Vector2D velocity;
  protected boolean isDefunct;

  /**
   * Constructor for projectile object. Assigns location and velocity.
   * 
   * @param p
   * @param v
   */
  public Projectile(Point p, Vector2D v)
  {
    this.location = p;
    this.velocity = v;
    this.isDefunct = false;
  }

  /**
   * Constructor for projectile object.
   * @param s
   */
  public Projectile(double s)
  {

  }
  
  /**
   * Checks if projectile is defunct.
   * @return
   */
  public boolean isDefunct()
  {
    return isDefunct;
  }
  
  /**
   * Sets value of isDefunct.
   */
  public void setDefunct()
  {
    
  }

  /**
   * Returns location of projectile.
   */
  public Point getLocation()
  {
    return location;
  }
  
  /**
   * Returns points for projectile.
   * @return
   */
  public int getPoints()
  {
    return -1;
  }

}
