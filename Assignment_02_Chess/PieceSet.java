public class PieceSet {
    private Pieces[] list;
    private PieceColor coloredSet;

    public PieceSet(PieceColor coloredSet){
        list = new Pieces[16];
        this.coloredSet = coloredSet;
    }

    public void setList(Pieces[] list) {
        this.list = list;
    }
    /*
    public void removePiece(Pieces capturedPiece){
        for(int i=0; i<16; i++){
            if(list[i] == capturedPiece){
                list[i] = null;
            }
        }
    }
*/
    public void setColoredSet(PieceColor coloredSet) { this.coloredSet = coloredSet; }

    public PieceColor getColoredSet() {
        return coloredSet;
    }

    public Pieces[] getList(){
        return list;
    }
}

