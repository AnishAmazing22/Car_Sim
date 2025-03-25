import java.util.Scanner;

public class MyProgram
{
    public static Game game;
    
    public static void main(String[] args)
    {
        Car car = new Ferrari();
        game = new Game(car);
        game.printScreen();
        Scanner in  = new Scanner(System.in);
        
        while(true){
            game.step(in.nextLine());
        }
    }
}
