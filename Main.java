import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

class Main {
  //This software does not run in repl do to the java.awt.robot class
  public static void main(String[] args) throws AWTException, InterruptedException, IOException {
    //Makes a new gameManager Object and starts that game
    gameManger g = new gameManger();
    g.playGame();


  }
}
