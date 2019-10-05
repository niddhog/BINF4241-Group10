public  class player {

    private static int playernr;
    private static int position;
    private static String myName;


    public void setName(String myName) {
        player.myName = myName;                     //players name are player 1, 2, 3 or 4
    }
    public String getName(){
        return myName;
    }

    public static void setPosition(int position) {
        player.position = position;
    }


    public static int getPosition(){
        return position;
    }

    public void setPlayernr(int playernr) {
        player.playernr = playernr;
    }
    public int getPlaynernr() {
        return playernr;
    }

}
