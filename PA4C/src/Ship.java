/**
 * Ship object for Asteroids game.
 * 
 * @author Yavuz Yavuzer
 * @version 04/14/2020
 *
 */
public class Ship implements Updateable, Drawable, Collidable
{
  private Pose pose;
  private Vector2D velocity;

  /**
   * Default ship constructor.
   */
  public Ship()
  {

  }
  
  /**
   * Resets the ship's position.
   */
  public void reset()
  {
    
  }

  /**
   * Returns the heading of the ship in radians.
   * @return
   */
  public double getHeading()
  {
    return -1;
  }

  /**
   * Returns the location of the ship.
   */
  public Point getLocation()
  {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Returns the size of the ship.
   */
  @Override
  public double getSize()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  /**
   * Displays the ship on the screen.
   */
  @Override
  public void draw()
  {
    // TODO Auto-generated method stub

  }

  /**
   * Updates the ships location and velocity.
   */
  @Override
  public void update()
  {
    // TODO Auto-generated method stub

  }

}
