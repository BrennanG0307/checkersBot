import java.util.ArrayList;

class agent{

  String makeMove(board b){
    //Search for state in txt file


    return randomMove(b);
  }

  String randomMove(board b){
    ArrayList<Integer> temp = new ArrayList<>();
    ArrayList<ArrayList> moveSet = new ArrayList<>();
    temp = b.getList(1);
    for(int i = 0; i < temp.size()-1; i++){
      
    }
    
    return "s";
  }
}