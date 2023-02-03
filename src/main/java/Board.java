import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Board {
    static final int TOTAL_CELLS = 101;

    int currTurn = 0;
    List<Dice> dices;
    List<Integer> cells;
    Map<Integer, Item> snakesStartingAt;
    Map<Integer, Item> laddersStartingAt;
    List<Player> players;

    boolean isGameOver;

    Board(){
        isGameOver = false;
        currTurn = 0;
        dices = new ArrayList<Dice>();
        snakesStartingAt = new HashMap<Integer,Item>();
        cells = new ArrayList<Integer>(TOTAL_CELLS);
        laddersStartingAt = new HashMap<Integer,Item>();
        players = new ArrayList<Player>();
    }

    public void addSnake(int st, int en){
        snakesStartingAt.put(st, new Item(st, en, Boolean.TRUE));
    }

    public void addLadder(int st, int en) {
        laddersStartingAt.put(st, new Item(st, en, Boolean.FALSE));
    }

    public void addDice(Dice dice){
        dices.add(dice);
    }

    public void addPlayer(String name){
        players.add(new Player(name));
    }

    public void makeMove(){
        Player p = players.get(currTurn);
        int sum = 0;
        for(Dice d : dices)
            sum += d.getRandomNumer();

        int newPos = p.getPos() + sum;
        if(newPos <= 100)
            p.setPos(newPos);

        if(newPos == 100) {
            System.out.println("Player : " + p.getName() + " won !!");
            this.isGameOver = true;
            return;
        }

        while(snakesStartingAt.containsKey(p.getPos())) {
            p.setPos(snakesStartingAt.get(newPos).getEnd());
        }

        while(laddersStartingAt.containsKey(p.getPos())) {
            p.setPos(laddersStartingAt.get(newPos).getEnd());
        }
    }

}
