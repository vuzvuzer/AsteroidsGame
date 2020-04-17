import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 * Ship object for Asteroids game. Honor code.
 * 
 * @author Yavuz Yavuzer
 * @version 04/17/2020
 *
 */
public class Ship implements Updateable, Drawable, Collidable
{
  private Pose pose;
  private Vector2D velocity;

  /**
   * Default ship constructor. Creates new ship at the center of the screen facing upward.
   */
  public Ship()
  {
    pose = new Pose(GameConstants.SCREEN_WIDTH / 2, GameConstants.SCREEN_HEIGHT / 2,
        GameConstants.SHIP_START_HEADING);
    velocity = new Vector2D(GameConstants.SHIP_START_HEADING, 0);
  }

  /**
   * Resets the ship's position.
   */
  public void reset()
  {
    pose.setHeading(GameConstants.SHIP_START_HEADING);
    pose.setX(GameConstants.SCREEN_WIDTH / 2);
    pose.setY(GameConstants.SCREEN_HEIGHT / 2);
  }

  /**
   * Returns the heading of the ship in radians.
   * 
   * @return
   */
  public double getHeading()
  {
    return pose.getHeading();
  }

  /**
   * Returns the location of the ship.
   */
  public Point getLocation()
  {
    return new Point(pose);
  }

  /**
   * Returns the size of the ship.
   */
  @Override
  public double getSize()
  {
    return GameConstants.SHIP_WIDTH;
  }

  /**
   * Displays the ship on the screen.
   */
  @Override
  public void draw()
  {
    StdDraw.setPenColor(Color.WHITE);
    StdDraw.setPenRadius();
    GameUtils.drawPoseAsTriangle(pose, GameConstants.SHIP_WIDTH, GameConstants.SHIP_HEIGHT);
  }

  /**
   * Updates the ships location and velocity.
   */
  @Override
  public void update()
  {
    // Handles ship turning.
    if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
    {
      velocity.setHeading(velocity.getHeading() + GameConstants.SHIP_TURN_SPEED);
      pose.setHeading(pose.getHeading() + GameConstants.SHIP_TURN_SPEED);
    }
    if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
    {
      velocity.setHeading(velocity.getHeading() - GameConstants.SHIP_TURN_SPEED);
      pose.setHeading(pose.getHeading() - GameConstants.SHIP_TURN_SPEED);
    }

    // Handles ship thrust.
    if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) || StdDraw.isKeyPressed(KeyEvent.VK_UP))
    {
      GameUtils.applyThrust(velocity, pose.getHeading(), GameConstants.SHIP_ACCELERATION);
    }
    else
    {
      velocity.setMagnitude(velocity.getMagnitude() * GameConstants.SHIP_FRICTION);
    }

    pose.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);

  }

}
