public enum Result {
    BLACKWINS, WHITEWINS, DRAW;


    Result result;

    Result(Result result)
    {
        this.result = result;
    }

    public void winnerIs() {
        switch (result) {
            case BLACKWINS:
                System.out.println("Black wins this game.");
                break;
            case WHITEWINS:
                System.out.println("White wins this game.");
                break;
            default:
                System.out.println("It's a draw.");
                break;
        }
    }
}