public class App {

    Board board;
    App(){
        board = new Board();
    }

    void addSnake(int start, int end){
        assert(start > end);
        board.addSnake(start, end);
    }

    void addLadder(int start, int end){
        assert(start < end);
        board.addLadder(start, end);
    }

    void addPlayer(String name){
        board.addPlayer(name);
    }

    void start(){
        while(!board.isGameOver){
            board.makeMove();
        }
    }

    void setup(){

    }

    public static void main(String[] args) {
        App game = new App();
        game.setup();
        game.start();
    }
}
