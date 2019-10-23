public class printStatus{
    public static void printStatus(CheckStatus theStatus){
        switch (theStatus) {
            case BlackInCheck:
                System.out.println("Black king is in check.");
                break;
            case WhiteInCheck:
                System.out.println("Black king is in check.");
                break;
            case BlackCheckmated:
                System.out.println("Black king is in check.");
                break;
            case WhiteCheckmated:
                System.out.println("Black king is in check.");
                break;
            default:
                System.out.println("Black king is in check.");
                break;
        }
    }
}
