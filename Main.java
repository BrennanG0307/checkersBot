import java.awt.*;

class Main {
  //This software does not run in repl do to the java.awt.robot class
  public static void main(String[] args) throws AWTException {
    System.out.println("Hello world!");
    screenUser a = new screenUser();
    a.makeMove(1,6,2,5);
    a.getBoardState();


  }
}
