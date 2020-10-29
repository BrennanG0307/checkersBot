import java.io.*;
import java.util.*;

class agent{

  Random rand = new Random();

  ArrayList<String> savedBoardState = new ArrayList<>();
  ArrayList<String> savedMovePath = new ArrayList<>();
  ArrayList<Integer> moveValue = new ArrayList<>();
  ArrayList<Integer> indexMovesMade = new ArrayList<>();

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
    try {
      for (int i = 0; i < temp.length; i = i + 3) {

        savedBoardState.add(temp[i]);
        savedMovePath.add(temp[i + 1]);
        moveValue.add(Integer.parseInt(temp[i + 2]));

      }
    } catch (Exception e) {
      savedBoardState.add("0");
      savedMovePath.add("0");
      moveValue.add(0);
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
    try {
      moveNumber = possibleMoves.get(0);
      value = moveValue.get(moveNumber);
      for (int i = 1; i < possibleMoves.size() - 1; i++) {
        if (moveValue.get(possibleMoves.get(i)) > value) {
          value = moveValue.get(i);
          moveNumber = i;
        }
      }

      if (value > 0) {
        indexMovesMade.add(possibleMoves.get(moveNumber));
        return savedMovePath.get(possibleMoves.get(moveNumber));
      }
    } catch (Exception e) {
      return randomMove(b);
    }

    return randomMove(b);
  }



  String randomMove(board b){
    int tempX;
    int tempY;
    ArrayList<String> tempArrayList;
    ArrayList<Integer> temp;
    ArrayList<ArrayList<String>> moveSet = new ArrayList();

    temp = b.getList(2);
    for(int i = 0; i < temp.size(); i++){
      tempY = temp.get(i)%10;
      tempX = temp.get(i)/10;
      try {
        if (piece.getPossibleMoves(tempX, tempY, -1, b).get(0) != "-1") {
          moveSet.add(piece.getPossibleMoves(tempX, tempY, -1, b));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

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
    String dumpFile = "";
    for (int i = 0; i < indexMovesMade.size(); i++) {
      moveValue.set(i, moveValue.get(indexMovesMade.get(i)) - 1);
    }
    for (int i = 0; i < savedBoardState.size(); i++) {
      dumpFile = dumpFile + savedBoardState.get(i) + "," + savedMovePath.get(i) + "," + moveValue.get(i) + "\n" ;
    }
    try{
      FileWriter fw = new FileWriter("a.txt");
      fw.write(dumpFile);
      fw.flush();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  void updateFile(){

  }
}