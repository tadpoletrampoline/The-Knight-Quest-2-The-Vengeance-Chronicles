import java.util.*;

public class Knight {

    // instance variables (knight features)
    private String name;
    private int score;

    // constructors (if given name or not)

    public Knight(String name) {
        
        if (name.equals("")) {
            this.name = "Lancelot";
        } else {
            this.name = name;
        }
        
        this.score = 0;
    }
  
    // getters 

    public String getName() {
        return this.name;
    }
    
    // setters

    public void increaseScore(int num) {
        
        this.score += num;
    
    } // increase score easily

    public void decreaseScore(int num) {

        this.score -= num;
        
    } // decrease score easily

}
