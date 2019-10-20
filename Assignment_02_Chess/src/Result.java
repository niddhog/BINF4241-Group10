package src;

public enum Result {
    BlackWin,
    WhiteWin
}

Result result;

public Result (Result result){
    this.result = result;
}

public void winnerIs(){
    switch(result){
        case BlackWin:
            System.out.println("Black wins this game.");
            break;
        case WhiteWin:
            System.out.println("White wins this game.");
            break;
        default:
            System.out.println("It's a draw.");
            break;
    }
}
