import java.io.*;
import java.util.*;

class agent{
  Random rand = new Random();

  ArrayList<String> savedBoardState;
  ArrayList<String> savedMovePath;
  ArrayList<Integer> moveValue;
  ArrayList<Integer> indexMovesMade;

  String fileName;


  agent(String fileName){
    String rawData = "";
    this.fileName = fileName;

    try{

      FileReader fr = new FileReader(fileName);

      BufferedReader br = new BufferedReader(fr);

      String line = br.readLine();

      while (line != null){

        rawData += (line + ",");

        line = br.readLine();

      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String[] temp = rawData.split(",");

    for (int i = 0; i < temp.length; i = i+3) {

      savedBoardState.add(temp[i]);
      savedMovePath.add(temp[i+1]);
      moveValue.add(i+2);

    }

  }


  String makeMove(board b){
    //Search for state in txt file
    ArrayList<Integer> possibleMoves = new ArrayList<>();
    int value;
    int moveNumber;
    for (int i = 0; i < savedBoardState.size()-1; i++) {

      if(savedBoardState.get(i).equals(b.getBoardState())){
        possibleMoves.add(i);
      }

    }
    moveNumber = possibleMoves.get(0);
    value = moveValue.get(moveNumber);
    for (int i = 1; i < possibleMoves.size()-1; i++) {
      if(moveValue.get(possibleMoves.get(i)) > value){
        value = moveValue.get(i);
        moveNumber = i;
      }
    }

    if(value > 0){
      indexMovesMade.add(possibleMoves.get(moveNumber));
      return savedMovePath.get(possibleMoves.get(moveNumber));
    }

    return randomMove(b);
  }



  String randomMove(board b){
    int tempX;
    int tempY;
    ArrayList<String> tempArrayList;
    ArrayList<Integer> temp;
    ArrayList<ArrayList> moveSet = new ArrayList<>();

    temp = b.getList(1);
    for(int i = 0; i < temp.size()-1; i++){
      tempY = temp.get(i)%10;
      tempX = temp.get(i)/10;

      moveSet.add(piece.getMoveSet(tempX,tempY,b));
    }
    //Pick a random move from the list generated of moves
    int randomInt = rand.nextInt(moveSet.size());
    int randomInt2 = rand.nextInt(moveSet.get(randomInt).size());

    tempArrayList = moveSet.get(randomInt);

    indexMovesMade.add(savedBoardState.size());
    savedBoardState.add(b.getBoardState());
    savedMovePath.add(tempArrayList.get(randomInt2));
    moveValue.add(0);


    return tempArrayList.get(randomInt2);
    

  }

  void saveMoves(){
    try{
      FileWriter fw = new FileWriter(fileName);
      for(int i = 0; i < savedBoardState.size(); i++){
        fw.write(savedMovePath.get(i) + "," + savedBoardState.get(i) + "," + moveValue.get(i) + "/n");
      }
    }
    catch(Exception e){

    }
  }

  void updateFile(){

  }
}