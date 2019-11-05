import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class ChessGame{
    public static void main(String[] args) {
        PieceSet whiteSet = new PieceSet(PieceColor.WHITE);
        PieceSet blackSet = new PieceSet(PieceColor.BLACK);         //creating PieceSets for both players

        //get Player names, in the player constructor we also give the players the color sets
        //and the colorSet class automatically creates white or black pieces (16 each)
        Player whitePlayer = new Player(getStringInput("Name of Player 1, White Pieces: "), whiteSet);
        Player blackPlayer = new Player(getStringInput("Name of Player 2, Black Pieces: "), blackSet);

        Queue<Player> queue = new LinkedList<>();
        queue.add(whitePlayer);
        queue.add(blackPlayer);
        Player currPlayer = whitePlayer;
        System.out.println("White begins, enjoy!");

        Scoreboard scoreBoard = Scoreboard.getInstance();
        Move move = new Move();
        Board gameBoard = new Board(move);
        InitBoard.init(gameBoard,whitePlayer,blackPlayer);
        gameBoard.printBoard();
        Check checkStatus = new Check(move);
        // the upper part is finished, INITIALIZATION IS COMPLETE


        //gameLoop
        while (true) {
            System.out.println(scoreBoard);
            currPlayer = queue.poll();
            queue.add(currPlayer);
            assert currPlayer != null;

            Coordinates start;
            Coordinates end;
            Piece currPiece;
            boolean capture;
            boolean isCheck = checkStatus.isCheck(gameBoard, currPlayer);

            if(isCheck){
                System.out.println(currPlayer.getPlayerColor() + " you are Checked, be careful!");
            }


            //determine origin square
            while(true){
                String imp = getStringInput(currPlayer.getPlayerColor() + " what piece do you wanna move (square)?");
                if(inputInCorrectSize(imp)){
                    continue;
                    //continues if the input is not exactly 2characters long, only then it passes them into the coordinates class
                }
                //todo check if the figure can be moved if not the code ends in endless loop
                start = new Coordinates(imp);

                if(coordinatesNotOnBoard(start)){
                    continue;
                }

                currPiece = gameBoard.getBoard()[start.getX()][start.getY()].getPieceOnSquare();
                if(currPiece != null && currPiece.getPieceColor() == currPlayer.getPlayerColor()){
                    break;
                    // only if the square is occupied by a piece and a piece of the same color of the current player it will break
                }
            }


            //determine destination square
            while(true){
                String imp = getStringInput(currPlayer.getPlayerColor() + " where to(square)?");
                if(inputInCorrectSize(imp)) {
                    continue;
                }
                end = new Coordinates(imp);


                if(start.getX() == end.getX() && start.getY() == end.getY()){
                    throwInputAndOutputIsTheSame();
                    continue;
                    // continues if the destination square is the same as the origin square
                }
                if(gameBoard.getBoard()[end.getX()][end.getY()].getPieceOnSquare() != null){ //todo null pointer excetion test, but works without it when getting origin square
                    Piece piece = gameBoard.getBoard()[end.getX()][end.getY()].getPieceOnSquare();
                    if(piece.getPieceColor() == currPlayer.getPlayerColor()){
                        throwFriendlyPieceOnDestination();
                        continue;
                        //continues if the selected destination square contains a friendly piece
                    }
                }
                if(coordinatesNotOnBoard(end)){
                    continue;}

                if(gameBoard.isSomethingBetween(currPiece, start, end))  {
                    throwColision();
                    continue;
                }
                if (gameBoard.getBoard()[end.getX()][end.getY()].getPieceOnSquare() != null){
                    capture = gameBoard.getBoard()[end.getX()][end.getY()].getPieceOnSquare().getPieceColor()!=currPlayer.getPlayerColor();
                }
                else{
                    capture = false;
                }

                if(!(currPiece.validMove(start.getX(), start.getY(), end.getX(), end.getY(), capture))){
                    //todo needed to change too much code, to implement the Coordinate Class in Piece
                    // negation because in piece if valid move is true, then it behaves correctly.
                    throwPieceCantMoveLikeThat();
                    continue;
                }
                break;


            }
            if(checkStatus.isMate(gameBoard, currPlayer, scoreBoard) && checkStatus.isCheck(gameBoard, currPlayer)){
                break;
            }
            move.move(gameBoard, start, end, scoreBoard);
            gameBoard.printBoard();
            
        }
        System.out.println(queue.poll().getName() + " has won the game!");
    }


    //the move function simply moves figures from x to y, but it doesnt check if the move is legal, also sets piece
    //moved status to true, which is initialized to false.
    private static void move(Board gameBoard, Coordinates s, Coordinates e) {
        Piece movedPiece = gameBoard.getBoard()[s.getX()][s.getY()].getPieceOnSquare();
        gameBoard.getBoard()[s.getX()][s.getY()].deletePieceOnSquare();
        gameBoard.getBoard()[e.getX()][e.getY()].setPieceOnSquare(movedPiece);
        movedPiece.setMoved();
    }

    private static String getStringInput(String input) {
        Scanner getPlayerName = new Scanner(System.in);
        System.out.println(input);
        return getPlayerName.nextLine();
    }

    private static boolean inputInCorrectSize(String imp){ //input of the
        return imp.length() != 2;
    }

    private static boolean coordinatesNotOnBoard(Coordinates coo){
        return 0 > coo.getX() || coo.getX() >= 8 || 0 > coo.getY() || coo.getY() >= 8;

    }

    private static void throwInputAndOutputIsTheSame(){
        System.out.println("Can not move a piece onto the same square it started on!");
    }

    private static void throwFriendlyPieceOnDestination(){
        System.out.println("Cannot capture your own piece!");
    }
    private static void throwPieceCantMoveLikeThat(){
        System.out.println("Your piece can't move like that!");
    }

    private static void throwColision(){
        System.out.println("Collision detected!");
    }

}
