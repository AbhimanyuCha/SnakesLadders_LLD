public class Player {
    int id;
    String name;
    int currPos;
    Player(String name){
        currPos = 0;
        this.name = name;
    }
    int getPos(){
        return this.currPos;
    }
    void setPos(int newPos){
        this.currPos = newPos;
    }
    String getName(){
        return name;
    }
}
