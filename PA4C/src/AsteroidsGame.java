import java.util.ArrayList;

/**
 * The main asteroids game simulation class. This class controls the simulation by setting up the
 * game, telling the other classes to update themselves, adding more asteroids when necessary,
 * freezing the game when it is over, detecting collisions updating the game state, and telling the
 * other classes when to draw themselves. Honor code.
 * 
 * @author: C. Fox & Yavuz Yavuzer
 * @version 04/17/2020
 */
public class AsteroidsGame
{
  private ArrayList<Drawable> drawnObjects; // all the stuff drawn to the screen
  private ArrayList<Updateable> movingObjects; // all the things that move
  private final Ship ship; // for detecting ship collisions
  private final Scoreboard scoreboard; // for checking if the game is over
  private final int asteroidStock; // how many asteroids to start with
  private int asteroidsLeft; // current asteroid count during the game

  /**
   * Allocate the stars, ship, and asteroids.
   * 
   * @param numAsteroids
   *          how many asteroids to start with
   */
  public AsteroidsGame(int numAsteroids)
  {
    asteroidStock = numAsteroids;
    drawnObjects = new ArrayList<Drawable>();
    movingObjects = new ArrayList<Updateable>();

    // Allocate stars.
    for (int i = 0; i < GameConstants.NUMBER_OF_STARS; i++)
    {
      drawnObjects.add(new Star());
    }

    // Allocate Ship.
    ship = new Ship();
    this.drawnObjects.add(ship);
    this.movingObjects.add(ship);

    // Allocate Asteroids.
    for (int i = 0; i < numAsteroids; i++)
    {
      Asteroid tempAst = new Asteroid();
      movingObjects.add(tempAst);
      drawnObjects.add(tempAst);
      asteroidsLeft++;
    }

    // Allocate Scoreboard.
    scoreboard = new Scoreboard();
    drawnObjects.add(scoreboard);
  }

  /**
   * Check if the game is over, tell all the moving objects in the game to update themselves,
   * perhaps add a saucer and fire bullets, check for collisions, remove all the defunct objects
   * from the lists of drawn and moving objects, and replenish the asteroids if necessary.
   */
  public void update()
  {
    // Only run if game is not over.
    if (!scoreboard.isGameOver())
    {
      // Remove defunct obects from movingObjects.
      for (int i = 0; i < movingObjects.size(); i++)
      {
        if (movingObjects.get(i) instanceof Projectile)
        {
          if (((Projectile) movingObjects.get(i)).isDefunct())
          {
            movingObjects.remove(movingObjects.get(i));
          }
        }
      }
      // Remove defunct obects from drawnObjects.
      for (int i = 0; i < drawnObjects.size(); i++)
      {
        if (drawnObjects.get(i) instanceof Projectile)
        {
          if (((Projectile) drawnObjects.get(i)).isDefunct())
          {
            drawnObjects.remove(drawnObjects.get(i));
          }
        }
      }
      // Update objects
      for (Updateable obj : movingObjects)
      {
        obj.update();
      }
      // Generate new saucer based on probability.
      if (GameConstants.GENERATOR.nextDouble() < GameConstants.SAUCER_APPEARANCE_PROB)
      {
        Saucer s = new Saucer();
        movingObjects.add(s);
        drawnObjects.add(s);
      }

      // Fires bullet when space bar is pressed.
      if (StdDraw.hasNextKeyTyped())
      {
        if (StdDraw.nextKeyTyped() == ' ')
        {
          Bullet b = new Bullet(ship.getLocation(), ship.getHeading());
          drawnObjects.add(b);
          movingObjects.add(b);
        }
      }
      // Repopulate screen with asteroids.
      if (asteroidsLeft < 1)
      {
        for (int i = 0; i < GameConstants.DEFAULT_ASTEROIDS_PER_LEVEL; i++)
        {
          Asteroid tempAst = new Asteroid();
          movingObjects.add(tempAst);
          drawnObjects.add(tempAst);
          asteroidsLeft++;
        }
      }
      // Update ship thrust and heading.
      ship.update();
      // Detect collisions.
      detectCollisions();
    }

  }

  /**
   * Tell all the drawn objects to draw themselves.
   */
  public void draw()
  {
    for (Drawable obj : drawnObjects)
    {
      obj.draw();
    }
  }

  /**
   * Detects collisions between appropriate objects. Removes objects when they collide and adjusts
   * score and player lives.
   */
  private void detectCollisions()
  {
    // Checks for ship collisions with asteroids and saucers.
    for (int i = 0; i < movingObjects.size(); i++)
    {
      if (movingObjects.get(i) instanceof Asteroid)
      {
        if (ship.getLocation().distance(((Projectile) movingObjects.get(i))
            .getLocation()) < GameConstants.SHIP_ASTEROID_COLLISION)
        {
          drawnObjects.remove(movingObjects.get(i));
          movingObjects.remove(i);
          scoreboard.incrementScore(GameConstants.ASTEROID_POINTS);
          asteroidsLeft--;
          scoreboard.decrementLives();
          ship.reset();
        }
      }
      else if (movingObjects.get(i) instanceof Saucer)
      {
        if (ship.getLocation().distance(((Projectile) movingObjects.get(i))
            .getLocation()) < GameConstants.SHIP_SAUCER_COLLISION)
        {
          drawnObjects.remove(movingObjects.get(i));
          movingObjects.remove(i);
          scoreboard.incrementScore(GameConstants.SAUCER_POINTS);
          scoreboard.decrementLives();
          ship.reset();
        }
      }
    }
    for (int i = 0; i < movingObjects.size(); i++)
    {
      // Checks for bullet collisions with asteroids and saucers.
      if (movingObjects.get(i) instanceof Bullet)
      {
        for (int j = 0; j < movingObjects.size(); j++)
        {
          // Check for bullet collisions against asteroids.
          if (movingObjects.get(j) instanceof Asteroid)
          {
            if (((Bullet) movingObjects.get(i)).getLocation()
                .distance(((Asteroid) movingObjects.get(j))
                    .getLocation()) < GameConstants.BULLET_ASTEROID_COLLISION)
            {
              ((Bullet) movingObjects.get(i)).setDefunct();
              ((Asteroid) movingObjects.get(j)).setDefunct();
              asteroidsLeft--;
              scoreboard.incrementScore(GameConstants.ASTEROID_POINTS);
            }
          }
          // Check for bullet collisions against saucers.
          else if (movingObjects.get(j) instanceof Saucer)
          {
            if (((Bullet) movingObjects.get(i)).getLocation()
                .distance(((Saucer) movingObjects.get(j))
                    .getLocation()) < GameConstants.BULLET_SAUCER_COLLISION)
            {
              ((Bullet) movingObjects.get(i)).setDefunct();
              ((Saucer) movingObjects.get(j)).setDefunct();
              scoreboard.incrementScore(GameConstants.SAUCER_POINTS);
            }
          }
        }
      }
    }

  }

}
