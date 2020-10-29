import java.awt.*;

class gameManger{

  agent a = new agent("a.txt");
  board b = new board();
  screenUser g;

  gameManger() throws AWTException {
    g = new screenUser();

  }


  void playGame() throws InterruptedException {

    boolean gameRun = true;
    boolean gameTurn = true;


    while(gameRun){
      
      while(gameTurn){
        Thread.sleep(1000);
        if(g.isTurn()){
          gameTurn = false;
        }
        if(g.gameOver()){
          a.saveMoves();
        }
      }

      b.updateBoard(g);
      g.makeMove(a.makeMove(b));
      gameTurn = true;

      if(g.gameOver()){
        a.saveMoves();
      }

    }

  }


}