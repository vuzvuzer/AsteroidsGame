import java.awt.Color;

/**
 * Star object for Asteroids game. Honor code.
 * 
 * @author Yavuz Yavuzer
 * @version 04/17/2020
 *
 */
public class Star implements Drawable
{
  private Point location;

  /**
   * Default constructor for a star.
   */
  public Star()
  {
    this.location = new Point(GameConstants.GENERATOR.nextDouble() * GameConstants.SCREEN_WIDTH,
        GameConstants.GENERATOR.nextDouble() * GameConstants.SCREEN_HEIGHT);
  }

  /**
   * Displays the star on the screen.
   */
  public void draw()
  {
    StdDraw.setPenColor(Color.WHITE);
    StdDraw.setPenRadius();
    StdDraw.filledCircle(this.location.getX(), this.location.getY(), GameConstants.STAR_RADIUS);
  }

}
