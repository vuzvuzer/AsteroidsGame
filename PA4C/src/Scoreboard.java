/**
 * Scoreboard for Asteroids game. Honor code.
 * 
 * @author Yavuz Yavuzer
 * @version 04/17/2020
 *
 */
public class Scoreboard implements Drawable
{
  private int score;
  private int lives;

  /**
   * Default scoreboard constructor.
   */
  public Scoreboard()
  {
    this.score = 0;
    this.lives = GameConstants.NUMBER_OF_LIVES;
  }

  /**
   * Increases the score.
   * 
   * @param k
   *          the amount to increase by
   */
  public void incrementScore(int k)
  {
    score += k;
  }

  /**
   * Decrease lives by 1.
   */
  public void decrementLives()
  {
    lives--;
  }

  /**
   * Checks if game is over.
   * 
   * @return
   */
  public boolean isGameOver()
  {
    if (lives < 1)
    {
      return true;
    }
    return false;
  }

  /**
   * Display score and lives on the screen.
   */
  public void draw()
  {
    StdDraw.textLeft(GameConstants.SCORE_X, GameConstants.SCORE_Y, "Score: " + score);
    StdDraw.textLeft(GameConstants.LIVES_X, GameConstants.LIVES_Y, "Lives: " + lives);
  }

}
