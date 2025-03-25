public class Obstacle {
    private int x;
    private int y;
    private int speed;
    
    public Obstacle(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    public void move(){
        x-=speed;
        if(x<-1){
            x=18*5+x;
            y=6+((int)(Math.random()*(4)))*3;
        }
        
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
}
