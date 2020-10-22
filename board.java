import java.util.ArrayList;


class board{
public ArrayList<ArrayList> b;
public ArrayList<tile> y;

  board(){
    this.b = new ArrayList();
    this.y = new ArrayList();
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

  void resetBoard(){
    //Reset board to start state

  }

  int getState(int x, int y){

  return 1;
  }

  int getSide(int x, int y){

  return 1;
  }

  ArrayList<Integer> getList(int side){
    

  }


}



 