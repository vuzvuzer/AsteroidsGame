/**
 * Bullet object for Asteroids game. Honor code.
 * 
 * @author Yavuz Yavuzer
 * @version 04/17/2020
 *
 */
public class Bullet extends Projectile
{
  private int stepsRemaining;

  /**
   * Constructor for bullet.
   * 
   * @param p
   * @param h
   */
  public Bullet(Point p, double h)
  {
    super(p, new Vector2D(h, GameConstants.BULLET_SPEED));
    stepsRemaining = GameConstants.BULLET_LIFETIME;
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
    this.location.moveAndWrap(this.velocity, GameConstants.SCREEN_WIDTH,
        GameConstants.SCREEN_HEIGHT);
    stepsRemaining--;
    if (stepsRemaining < 1)
    {
      this.setDefunct();
    }

  }

  /**
   * Displays bullet on the screen.
   */
  @Override
  public void draw()
  {
    StdDraw.filledCircle(this.location.getX(), this.location.getY(), GameConstants.BULLET_RADIUS);

  }

}
