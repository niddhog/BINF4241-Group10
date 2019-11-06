import java.util.Scanner;

public class Coordinates {
    private int x;
    private int y;

    Coordinates(String input){
        //todo fix problem where if you input only 1 char it fails +++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //fixed I think

        switch(input.charAt(0)) {
            case'a':
                this.x = 0;
                break;
            case'b':
                this.x = 1;
                break;
            case'c':
                this.x = 2;
                break;
            case'd':
                this.x = 3;
                break;
            case'e':
                this.x = 4;
                break;
            case'f':
                this.x = 5;
                break;
            case'g':
                this.x = 6;
                break;
            case'h':
                this.x = 7;
                break;
            default:
                this.x = 10;    // doesnt matter just has to be bigger than 8
                break;
        }
        switch(input.charAt(1)){
            case'1':
                this.y = 0;
                break;
            case'2':
                this.y = 1;
                break;
            case'3':
                this.y = 2;
                break;
            case'4':
                this.y = 3;
                break;
            case'5':
                this.y = 4;
                break;
            case'6':
                this.y = 5;
                break;
            case'7':
                this.y = 6;
                break;
            case'8':
                this.y = 7;
                break;
            default:
                this.y = 10;    // doesnt matter just has to be bigger than 8
                break;
        }
    }

    int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
