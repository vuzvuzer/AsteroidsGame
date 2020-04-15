import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class AsteroidsGame
{
  private ArrayList<Asteroid> asteroids;

  public AsteroidsGame(int asteroidCount) throws IllegalArgumentException
  {
    if (asteroidCount < 0)
    {
      throw new IllegalArgumentException("you can have no fewer than 0 asteroids");
    }
    asteroids = new ArrayList<>();
    for (int i = 0; i < asteroidCount; i++)
    {
      asteroids.add(new Asteroid());
    }
  }

  public ArrayList<Asteroid> getAsteroids()
  {
    return asteroids;
  }

  public void add(Asteroid asteroid)
  {
    this.asteroids.add(asteroid);
  }

  public void add(ArrayList<Asteroid> newAsteroids)
  {
    this.asteroids.addAll(newAsteroids);
  }

  public void update()
  {
    Iterator<Asteroid> iterator = asteroids.iterator();
    while (iterator.hasNext())
    {
      Asteroid asteroid = iterator.next();
      asteroid.update();
      if (asteroid.isDefunct())
      {
        asteroids.remove(asteroid);
      }
    }
  }

  public void draw()
  {
    StdDraw.setPenColor(Color.WHITE);
    for (Asteroid asteroid : asteroids)
    {
      asteroid.draw();
    }
  }

}
