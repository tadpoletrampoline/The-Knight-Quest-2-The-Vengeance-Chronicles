import java.util.*;
import java.io.*;

public class Knight {

    // instance variables (knight features)
    private String name;
    private int score;
    private int health; 
    
    // Create an ArrayList object of type Item
    ArrayList<Item> inventory = new ArrayList<Item>(); 

    // constructors (if given name or not)

    public Knight(String name) {
        
        if (name.length() < 1) {
            this.name = "Lancelot";
        } else {
            this.name = name;
        }

        this.health = 0; // health level of player which can be changed
        this.score = 0;
        
        this.inventory = new ArrayList<>();
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
    
    // picking up items
    public void pickUpItem(Item item) {
        
        if (!item.isPickedUp()) {
            item.pickUp();
            inventory.add(item);
            System.out.println(name + " picked up " + item.getName() + "!");
        } 
        
        else {
            System.out.println(item.getName() + " has already been picked up.");
        }
    }
    
    // showing the player's inventory
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: ");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

}
