public enum CheckStatus {
    BlackInCheck,
    WhiteInCheck,
    BlackCheckmated,
    WhiteCheckmated;
}

CheckStatus status;

    CheckStatus(CheckStatus status){
    this.status = status;
}

    public void warning(){
    switch (status) {
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