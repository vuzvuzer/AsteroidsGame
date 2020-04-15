/**
 * Bullet object for Asteroids game.
 * 
 * @author Yavuz Yavuzer
 * @version 04/14/2020
 *
 */
public class Bullet extends Projectile
{
  private int stepsRemaining;
  
  /**
   * Constructor for bullet.
   * @param p
   * @param h
   */
  public Bullet(Point p, double h)
  {
    super(h);
    this.location = p;
  }

  /**
   * Returns size of bullet.
   */
  @Override
  public double getSize()
  {
    return GameConstants.BULLET_RADIUS;
  }
  
  public int getPoints()
  {
    return super.getPoints();
  }

  /**
   * Updates bullet's position.
   */
  @Override
  public void update()
  {
    // TODO Auto-generated method stub

  }

  /**
   * Displays bullet on the screen.
   */
  @Override
  public void draw()
  {
    // TODO Auto-generated method stub

  }

}
