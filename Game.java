import java.util.ArrayList;
public class Game {
    private int[][] road = new int[23][60];
    private int time=0;
    private Car car;
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    private double move=0;
    private int move1=0;
    
    public Game(Car car){
        boolean line =false;
        for(int i=0;i<road.length;i++){
            for(int j=0;j<road[i].length;j++){
                
                road[i][j]=0;
                if(i<6){
                    road[i][j]=-1;
                }
                if(i>16){
                    road[i][j]=-2;
                }
                if((j+time)%5==0){
                    line = !(line);
                }
                if(((i==11||i==8||i==14)&&line)){
                    road[i][j]=1;
                    
                }
            }
        }
        this.car = car;
        for(int k=0;k<5;k++){
            obstacles.add(new Obstacle(60+(k*18), 6+((int)(Math.random()*(4)))*3, 2));
            obstacles.add(new Obstacle(60+(k*18), 6+((int)(Math.random()*(4)))*3, 2));
        }
    }
    public void step(String input){
        time+=1;
        move+=1/((double)car.getSpeed());
        
        if((int)move!=move1){
            move1=(int)move;
            moveBack();
        }
        if(input.equals("w")){
            car.move(-1);
        }
        if(input.equals("s")){
            car.move(1);
        }
        if(input.equals("a")){
            car.powerUp();
        }
        if(input.equals(" ")){
            for(int i=0;i<car.getBoost();i++){
                moveBack();
            }
        }
        
        printScreen();
        
    }
    public void printScreen(){
        if(checkHit()){
            System.out.println("You lose");
        }else{
            System.out.println("Time: "+time);
            String print = "";
           
            for(int i=0;i<road.length;i++){
                for(int j=0;j<road[i].length;j++){
                    
                    if(road[i][j]==-1){
                        print="\u001B[32m\u001B[42m█\u001B[0m";
                    }
                    if(road[i][j]==-2){
                        print = "\u001B[32m\u001B[42m█\u001B[0m";
                    }
                    if(road[i][j]==0){
                        print="\u001B[30m\u001B[40m█\u001B[0m";
                    }
                    if(road[i][j]==1){
                        print="\u001B[30m\u001B[47m \u001B[0m";
                    }
                    if((i==car.getY()||i==car.getY()+1)&&(j>26&&j<33)){
                        print=car.getColor()+"█\u001B[0m";
                    }
                    for(int z=0;z<obstacles.size();z++){
                        if((i==obstacles.get(z).getY()||i==obstacles.get(z).getY()+1)&&(j>obstacles.get(z).getX()-3&&j<obstacles.get(z).getX()+4)){
                            print="\u001B[31m\u001B[41m█\u001B[0m";
                        }
                    }
                    
                    System.out.print(print);
                }
                System.out.println();
            }
        }
    }
    public void moveBack(){
        int start_place1=road[11][0];
        for(int i=0;i<road[11].length-1;i++){
            road[11][i]=road[11][i+1];
            road[8][i]=road[8][i+1];
            road[14][i]=road[14][i+1];
        }
        road[11][road[11].length-1]=start_place1;
        road[8][road[8].length-1]=start_place1;
        road[14][road[14].length-1]=start_place1;
        
        for(int j=0;j<obstacles.size();j++){
            obstacles.get(j).move();
        }
    }
    public boolean checkHit(){
        for(int i=0;i<obstacles.size();i++){
            
            if(false){
                
                return true;
                
            }
        }
        return false;
    }
}
