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

    //Loop to keep code running while game is running
    while(gameRun){
      //Loop that checks if it is the agents turn. Also checks if the game is over and saves the game if it is
      while(gameTurn){
        Thread.sleep(1000);
        if(g.isTurn()){
          gameTurn = false;
        }
        if(g.gameOver()){
          a.saveMoves();
        }
      }

      //Tells b to update its board
      b.updateBoard(g);
      //Asks screenUser to make the move that agent wants to make
      g.makeMove(a.makeMove(b));
      //Completes turn
      gameTurn = true;

      //Checks if game is over
      if(g.gameOver()){
        a.saveMoves();
      }

    }

  }


}