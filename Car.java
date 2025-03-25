
public class Car {
    private double speed;
    private double turnTime;
    private int boosts;
    private String color;
    private int y;
    private double y_place;
    
    public Car(double speed, double turn, int boosts, String color){
        this.speed = speed;
        this.turnTime = turn;
        this.boosts = boosts;
        this.color = color;
        
        this.y=11;
        this.y_place = 11;
        
        
    }
    public int getY(){
        return y;
    }
    public double getSpeed(){
        return speed;
    }
    public int getBoost(){
        return boosts;
    }
    public String getColor(){
        return color;
    }
    public void move(int move){
        if(y_place>7&&move<0){
            y_place+=move/turnTime;
        }
        if(y_place<15&&move>0){
            y_place+=move/turnTime;
        }
        y=(int)y_place;
        
        
        
    }
    public void powerUp(){
        
    }
}
