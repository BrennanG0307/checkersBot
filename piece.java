import java.util.ArrayList;

class piece{
  boolean isActive;
  int x;
  int y;


  static String checkMove(int moveX, int moveY, int side){
    //Check valid move code is at home
    return "a";

  }

  static ArrayList<String> getMoveSet(int x, int y, board b){
    ArrayList<String> moveSet = new ArrayList<>();
    String temp;
    int x1,y1,startSide;
    x1 = x-1;
    y1 = y-1;
    startSide = b.getSide(x,y);

    if(b.getState(x1,y1) == 0){
      temp = Integer.toString(x) + Integer.toString(y);
      temp = temp + Integer.toString(x1) + Integer.toString(y1);
      moveSet.add(temp);
      temp = "";
    }else if(b.getState(x1,y1) == 1){
      //Move is not possible
    }else if(b.getState(x1,y1) == 2){
      if(b.getState(x1-1,y1-1) == 0){
       //Recall Algorithm
      }else{
        //Move is not possible
      }
    }
  return moveSet;



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

}