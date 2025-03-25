public class Mustang extends Car {
    public Mustang(){
        super(1.1, 1.5, 5, "\u001B[34m\u001B[44m");
    }
    public void powerUp(){
        super.move(1);
        super.move(1);
        super.move(1);
        super.move(1);
        
    }
}
