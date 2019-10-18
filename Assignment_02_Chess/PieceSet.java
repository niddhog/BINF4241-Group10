public class PieceSet {
    private Pieces[] list;
    private PieceColor coloredSet;

    public void setList(Pieces[] list) {
        this.list = list;
    }

    public void removePiece(Pieces capturedPiece){
        for(int i=0; i<16; i++){
            if(list[i] == capturedPiece){
                list[i] = null;
            }
        }
    }

    public PieceColor getColoredSet() {
        return coloredSet;
    }

    public Pieces[] getList(){
        return list;
    }
}

