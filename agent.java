import java.util.ArrayList;
import java.util.Random;

class agent{
  Random rand = new Random();
  String makeMove(board b){
    //Search for state in txt file


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
      tempX = temp.get(i)%10;
      tempY = temp.get(i)/10;

      moveSet.add(piece.getMoveSet(tempX,tempY,b));
    }
    //Pick a random move from the list generated of moves
    int randomInt = rand.nextInt(moveSet.size());
    int randomInt2 = rand.nextInt(moveSet.get(randomInt).size());
    tempArrayList = moveSet.get(randomInt);
    return tempArrayList.get(randomInt2);
    

  }
}