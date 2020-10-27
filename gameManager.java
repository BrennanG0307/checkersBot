class gameManger{
  agent a = new agent("a.txt");
  board b = new board();
  screenUser g = new screenUser();
  void playGame(){

    boolean gameRun = true;
    boolean gameTurn = true;

    while(gameRun){
      
      while(gameTurn){
        Thread.sleep(1000);
        if(g.isTurn()){
          gameTurn = false;
        }
      }


      b.updateBoard();
      g.makeMove(a.makeMove(b));
      gameTurn = true;

      if(g.gameOver()){
        gameRun = false;
      }

    }

  }


}