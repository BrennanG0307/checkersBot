import java.util.ArrayList;

class board{
ArrayList<ArrayList> b = new ArrayList<>();
ArrayList<tile> y = new ArrayList();

  board(){
    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
          tile t = new tile();
          y.add(t);
     }
     b.add(y);
    }
  }
/*
  boolean makeMove(int x1,int y1,int x2,int y2){
    int tempX;
    int tempY;
    if(b.get(x1).get(y1).checkMove(x2,y2) != "0"){
      String[] temp = b.get(x1).get(y1).checkMove(x2,y2).split(",");
      for(int i = 0; i < temp.length-2; i++){
        int tempa = Interger.parseInt(temp[i]);
        // stackOverflow https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number
        tempY = tempa % 10;
        tempa = tempa / 10;
        tempX = tempa;
        b.get(tempX).get(tempY).resetTile();
      }
    }
  }
  */

  void makeMove(String[] path){
    int tempX;
    int tempY;
    int tempState;
    int tempSide;
    for(int i = 0; i < path.length - 2; i++){
      int temp = Interger.parseInt(path[i]);
        // stackOverflow https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number
        tempY = temp % 10;
        temp = temp / 10;
        tempX = temp;
        
        if(i == 0){
          tempState = b.get(tempX).get(tempY).getSate();
          tempSide = b.get(tempX).get(tempY).getSide();
        }else if(i == path.length - 2){
          b.get(tempX).get(tempY).changeTile(tempState,tempSide);
        }else{
          b.get(tempX).get(tempY).resetTile();
        }
    }

  }

  void resetBoard(){
    //Reset board to start state

  }

}



 