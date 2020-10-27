class tile{
  private int state = 0;
  private int side = 0;

  tile(){


  }

  String checkMove(int x,int y){
    switch(state){
      case 0:
      return "0";

      case 1:
      if(piece.checkMove(x,y,side) != "0"){
        return piece.checkMove(x,y,side);
      }
      case 2:
      if(king.checkMove(x, y, side) != "0"){
        return king.checkMove(x, y, side);
      }
    }
    return "0";
  }

  void resetTile(){
    state = 0;
    side = 0;
  }

  void changeTile(int state, int side){
    this.state = state;
    this.side = side;
  }

  int getState(){

    return state;
  }

  int getSide(){

    return side;
  }

}
