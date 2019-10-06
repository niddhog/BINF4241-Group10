public class Player {

    private int playernr;
    private int position;
    private String myName;


    public void setName(String myName) {
        this.myName = myName;
    }
    public String getName(){
        return myName;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public int getPosition(){
        return position;
    }

    public void setPlayernr(int playernr) {
        this.playernr = playernr;
    }

    public int getPlaynernr() {
        return playernr;
    }

}