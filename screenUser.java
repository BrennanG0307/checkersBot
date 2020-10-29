

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;


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

    void makeMove(String move) throws InterruptedException , NumberFormatException{
        int x = 0;
        int y= 0;
        int x1 = 0;
        int y1 = 0;
        ArrayList<String> moves = new ArrayList<>();

            x = Integer.parseInt(move.substring(0,0+1))+1;
            y = Integer.parseInt(move.substring(0+1,0+2))+1;
            x1 = Integer.parseInt(move.substring(0+2,0+3))+1;
            y1 = Integer.parseInt(move.substring(0+3,0+4))+1;

        for (int i = 0; i < move.length()/2; i = i +1) {
            int j = i*2;

            Thread.sleep(20);
            x = Integer.parseInt(move.substring(j,j+1))+1;
            y = Integer.parseInt(move.substring(j+1,j+2))+1;
            r.mouseMove((topLeftX + (x*boxSizeX)) - (boxSizeX/2), (topLeftY + (y*boxSizeY)) - (boxSizeY/2));
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        }




/*
        r.mouseMove((topLeftX + (x1*boxSizeX)) - (boxSizeX/2), (topLeftY + (y1*boxSizeY)) - (boxSizeY/2));
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


 */

    }

    void getPos(){
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        System.out.println(y + "j");
        System.out.println(x);
        System.out.println(r.getPixelColor(713,951).getGreen());

    }

    boolean gameOver(){
        int tempColour;
        tempColour = r.getPixelColor(676, 587).getRed();
        if(tempColour > 240){
            return true;
        }
        return false;
    }

    boolean isTurn(){
        int tempColour;
        tempColour = r.getPixelColor(713,951).getGreen();
        if(tempColour == 255){
            return true;
        }
        return false;
    }

    


    void defineBoard(){


    }

    String getBoardState(){
        int tempColour;
        int tempColourG;
        String board = "";
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {

                tempColour = r.getPixelColor((topLeftX + (j*boxSizeX)) - (boxSizeX/2), (topLeftY + (i*boxSizeY)) - (boxSizeY/2)).getRed();
                tempColourG = r.getPixelColor((topLeftX + (j*boxSizeX)) - (5), (topLeftY + (i*boxSizeY)) - (5)).getRed();
                System.out.println(tempColourG);

                if (tempColour > 170 && tempColour < 270 && tempColourG > 160){
                    board = board + "00";
                } else if(tempColour > 0 && tempColour < 100 && tempColourG > 70 && tempColourG < 140){
                    board = board + "11";
                } else if(tempColour > 70 && tempColour < 140){
                    board = board + "00";
                } else if(tempColour > 140 && tempColour < 220 && tempColourG > 70 && tempColourG < 140){
                    board = board + "12";
                }



            }

        }
        return board;
    }


}

