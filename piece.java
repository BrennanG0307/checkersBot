static class piece{
  boolean isActive;
  int x;
  int y;


  static String checkMove(int moveX, int moveY, int side){
    //Check valid move code is at home

  }
/*
  boolean makeMove(int moveX, int moveY){
    
    if (checkMove(moveX, moveY)){
      x = moveX;
      y = moveY;
      return true;
    }else{
      return false;
    }
    
  }
*/
  void removePiece(){
    x = -1;
    y = -1;
    isActive = false;
  }
}