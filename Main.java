import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

class Main {
  //This software does not run in repl do to the java.awt.robot class
  public static void main(String[] args) throws AWTException, InterruptedException, IOException {
    gameManger g = new gameManger();
    g.playGame();


  }
}
