import java.util.*;
import java.io.*;

public class Knight {

    // instance variables (knight features)
    private String name;
    private int score;
    private int health; 
    
    // constructors (if given name or not)

    public Knight(String name) {
        
        if (name.length() < 1) {
            this.name = "Lancelot";
        } else {
            this.name = name;
        }

        this.health = 0; // health level of player which can be changed
        this.score = 0;

    }
  
    // getters 
    public String getName() {
        return this.name;
    } 

    public int getHealth() {
        return this.health;
    }
    
    // setters
    public void increaseScore(int num) {
        
        this.score += num;
    
    } // increase score easily

    public void decreaseScore(int num) {

        this.score -= num;
        
    } // decrease score easily

    public void increaseHealth(int num) {
        
        this.health += num;
    
    } // increase health easily

    public void decreaseHealth(int num) {

        this.health -= num;
        
    } // decrease health easily
    
}
