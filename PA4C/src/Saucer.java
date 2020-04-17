import java.awt.Color;

/**
 * Saucer object for Asteroids game. Honor code.
 * 
 * @author Yavuz Yavuzer
 * @version 04/17/2020
 *
 */
public class Saucer extends Projectile
{

  /**
   * Constructor for saucer.
   */
  public Saucer()
  {
    super(
        new Point(GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_WIDTH),
            GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_HEIGHT)),
        new Vector2D(GameConstants.GENERATOR.nextDouble() * 2 * Math.PI,
            GameConstants.SAUCER_SPEED));
  }

  /**
   * Returns saucer points.
   */
  public int getPoints()
  {
    return GameConstants.SAUCER_POINTS;
  }

  /**
   * Returns saucer size.
   */
  @Override
  public double getSize()
  {
    return GameConstants.SAUCER_HEIGHT;
  }

  /**
   * Updates location of saucer.
   */
  @Override
  public void update()
  {
    if (GameConstants.GENERATOR.nextDouble() < GameConstants.SAUCER_DIRECTION_PROB)
    {
      this.velocity.setHeading(GameConstants.GENERATOR.nextDouble() * 2 * Math.PI);
    }
    this.location.move(this.velocity);
  }

  /**
   * Displays saucer on the screen.
   */
  @Override
  public void draw()
  {
    StdDraw.setPenColor(Color.WHITE);
    StdDraw.setPenRadius();
    StdDraw.rectangle(this.location.getX(), this.location.getY(), GameConstants.SAUCER_WIDTH / 2,
        GameConstants.SAUCER_HEIGHT / 2);

  }

}
