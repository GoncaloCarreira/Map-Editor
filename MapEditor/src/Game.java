public class Game {

    Grid grid = new Grid(50,20);;
    private Player player;


    //CONSTRUCTOR
    public Game(){
       this.player = new Player(grid);
    }

}

