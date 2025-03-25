public class Ferrari extends Car {
    public Ferrari(){
        super(1.1, 1.5, 5, "\u001B[35m\u001B[45m");
    }
    public void powerUp(){
        super.move(-1);
        super.move(-1);
        super.move(-1);
        super.move(-1);
        
    }
}
