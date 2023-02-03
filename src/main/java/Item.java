public class Item {
    int start, end;
    boolean isSnake;
    public Item(int st, int en, Boolean isSnake) {
        start = st;
        end = en;
        this.isSnake = isSnake;
    }
    public int getEnd(){
        return this.end;
    }
}

