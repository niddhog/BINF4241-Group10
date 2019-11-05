public class CoordinatesTranslator {
    private int x;
    private int y;

    public static String translate(int x, int y){
        String first;
        String second;
        switch(x) {
            case 0:
                first = "a";
                break;
            case 1:
                first = "b";
                break;
            case 2:
                first = "c";
                break;
            case 3:
                first = "d";
                break;
            case 4:
                first = "e";
                break;
            case 5:
                first = "f";
                break;
            case 6:
                first = "g";
                break;
            case 7:
                first = "h";
                break;
            default:
                first = " ";
                break;
        }
        switch(y) {
            case 0:
                second = "1";
                break;
            case 1:
                second = "2";
                break;
            case 2:
                second = "3";
                break;
            case 3:
                second = "4";
                break;
            case 4:
                second = "5";
                break;
            case 5:
                second = "6";
                break;
            case 6:
                second = "7";
                break;
            case 7:
                second = "8";
                break;
            default:
                second = " ";
                break;
        }
        return first + second;
    }
}

