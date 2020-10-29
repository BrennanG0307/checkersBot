import java.awt.*;
import java.util.ArrayList;


class board{

public ArrayList<tile> b;
//screenUser g = new screenUser();
private String boardStates = "";

  board() throws AWTException {
    this.b = new ArrayList();
    ArrayList<tile> y = new ArrayList<>();
    //Sets up the board with 64 balnk tiles
    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
          tile t = new tile();
          b.add(t);
        }
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
/*
  void makeMove(String[] path){
    int tempX;
    int tempY;
    int tempState = 0;
    int tempSide = 0;
    ArrayList<tile> tempz = new ArrayList<>();

    for(int i = 0; i < path.length - 2; i++){
      int temp = Integer.parseInt(path[i]);
        // stackOverflow https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number
        tempY = temp % 10;
        temp = temp / 10;
        tempX = temp;
         
        if(i == 0){
          //If it is first move in set, gets the piece value that is being moved
          tempz = b.get(tempX);
          tempState = tempz.get(tempY).getState();

          tempz = b.get(tempX);
          tempSide = tempz.get(tempY).getSide();
        }else if(i == path.length - 2){
          tempz = b.get(tempX);
          tempz.get(tempY).changeTile(tempState,tempSide);
        }else{
          tempz = b.get(tempX);
          tempz.get(tempY).resetTile();
        }
    }

  }
*/
  void setBoard(String boardState){
    //Reset board to start state

  }

  String getBoardState(){
    return boardStates;
  }

  int getState(int x, int y){
  return b.get((8*(y)) + x).getState();
  }

  int getSide(int x, int y){
    return b.get((8*(y)) + x).getSide();
  }


  ArrayList<Integer> getList(int side){
    //Searches for any tile that has a side value the same as the one specified in the argument, then returns a list of there x and y
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        int tempTest = getSide(i,j);
        if(getSide(i,j) == side){
          temp.add((i*10) + j);
        }
      }
    }
    return temp;
  }

  void updateBoard(screenUser g){
    String boardState = g.getBoardState();
    boardStates = boardState;
    ArrayList<tile> tempList;
    int section = 0;
    String temp;

    for (int i = 0; i < 64; i++) {

        temp = boardState.substring(section, section+2);
        switch (temp) {
          case "00":
            b.get(i).changeTile(0,0);
            break;

          case "11":
            b.get(i).changeTile(1,1);
            break;

          case "12":
            b.get(i).changeTile(1,2);
            break;
        }
        section = section +2;


    }
    
  }


}



 