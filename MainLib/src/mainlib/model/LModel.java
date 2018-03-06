package mainlib.model;

public class LModel {

    protected LBoard lBoard = null;

    public LModel(){
    }

    public void setBoard(LBoard lBoard){
        this.lBoard = lBoard;
    }

    public LBoard getBoard(){
        return lBoard;
    }

    public void keyPressed(String key) { System.out.println(key); }
}
