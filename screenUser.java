

import java.awt.*;
import java.awt.event.InputEvent;


public class screenUser{

    Robot r;
    int topLeftX = 580;
    int topLeftY = 490;
    int bottomRightX = 945;
    int bottomRightY = 850;
    int boxSizeX = 45;
    int boxSizeY = 45;

    screenUser() throws AWTException {
        this.r = new Robot();
    }

    void makeMove(int x, int y, int x1, int y1){

        r.mouseMove((topLeftX + (x*boxSizeX)) - (boxSizeX/2), (topLeftY + (y*boxSizeY)) - (boxSizeY/2));
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        r.mouseMove((topLeftX + (x1*boxSizeX)) - (boxSizeX/2), (topLeftY + (y1*boxSizeY)) - (boxSizeY/2));
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    void makeMove(String move){


    }

    boolean gameOver(){

      return true;
    }

    boolean isTurn(){

      return true;
    }

    


    void defineBoard(){


    }

    String getBoardState(){
        int tempColour;
        String board = "";
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {

                tempColour = r.getPixelColor((topLeftX + (j*boxSizeX)) - (boxSizeX/2), (topLeftY + (i*boxSizeY)) - (boxSizeY/2)).getGreen();


                if (tempColour > 200 && tempColour < 260){

                } else if(tempColour > 0 && tempColour < 70){
                    board = board + "1";
                } else if(tempColour > 70 && tempColour < 140){
                    board = board + "0";
                } else if(tempColour > 160 && tempColour < 200){
                    board = board + "2";
                }




                //Debug Code
                r.mouseMove((topLeftX + (j*boxSizeX)) - (boxSizeX/2), (topLeftY + (i*boxSizeY)) - (boxSizeY/2));
            }

        }
        return board;
    }


}

