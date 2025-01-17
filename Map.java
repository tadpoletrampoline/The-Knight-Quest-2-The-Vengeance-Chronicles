import java.util.*;
import java.io;
import java.random;

// class to create mapping gample including movement and inserting puzzles
    
    public class Map {
        
    //instance variables
        
        // delete private int Row,Col,Num1,Num2;
        private int p1 = 0;
        private int p2 = 0;
        private String Move;
        private boolean Running = true;
        int Array[][];
        private int size = 7; // map size hard coded (change maybe later) 
        private int level; 
        String key; // key name, not object (in item class)
        
        // constructor !!!
        public Map(int level) {
        
        this.level = level;
        this.Array = new int [this.size][this.size];
        
        // assigning key names per level
        if (this.level == 1) {
            key = "key";
        } else if (this.level == 2) {
            key = "axe";
        } else if (level == 3) {
            key = "magic wand";
        }
        
        // create grid             
        for(int i=0;i<size;i++) {
            for(int x=0;x<size;x++) {
                this.Array[i][x] = 0;
                this.Array[p1][p2] = 1;
                
                // creates patterns of making values 2 as borders * will edit later to be a complex path
                if( level == 1) {
                    if (((x+i)^5)/2 == 0 && x<size-1 && i<size-1  && i<size-1 && x>0 && i>0) {
                        this.Array[i][x] = 2;
                        this.Array[this.p1][this.p2] = 1;
                    }
                }
                
                // adds the key in a random spot on the map
                //this.Array[p1][p2] = rand.NextInt(7);
                //(Math.random() * 7.00); //(changed this to randint) hard coded random range

            }
        }
        
        // print grid for debugging purposed
        for(int i=0;i<size;i++) {
            for(int x=0;x<size;x++) {
                System.out.print(this.Array[i][x] + "\t");
            }
            System.out.println();
        }
        
        }
        
    public void move() {
        
        while(Running) {
            
            Scanner input = new Scanner(System.in);
            this.Move = input.next(). substring(0,2);
            
            switch(Move) {
            case "so":
            case "So":
                
            if (p1 < size-1 && Array[p1+1][p2] != 2) { //prevents out of bounds
                Array[p1][p2] = 0;
                Array[p1+=1][p2] = 1;
                break;
            } else {
                System.out.println("Your path here is blocked, try another way.");
                break;
                }
                
            case "no":
            case "No":
                
                if (p1 > 0 && Array[p1-1][p2] != 2) { //prevents out of bounds
                    Array[p1][p2] = 0;
                    Array[p1-=1][p2] = 1;
                    break;
                } else {
                    System.out.println("Your path here is blocked, try another way.");
                    break;
                }
            case "ea":
            case "Ea":
                
            if (p2 < size-1 && Array[p1][p2+1] != 2) {   
                Array[p1][p2] = 0;
                Array[p1][p2+=1] = 1;
                break;
            } else {
                    System.out.println("Your path here is blocked, try another way.");
                    break;
                }
                
            case "we":
            case "We":
            
            if (p2 > 0 && Array[p1][p2-1] != 2) { 
                Array[p1][p2] = 0;
                Array[p1][p2-=1] = 1;
                break;
            } else {
                    System.out.println("Your path here is blocked, try another way.");
                    break;
                }
            
            case "le":
            case "Le":
                System.out.println("You have exited the game...");
                Running = false;
                input.close();
                break;
            default:
                System.out.println("I don't understand that.");
                break;
        }
        
        for(int i=0;i<size;i++) {
            for(int x=0;x<size;x++) {
                System.out.print(Array[i][x] + "\t");
        }
            System.out.println(); // temporary printing of map for debugging
                }
            }
            
        }

      // getters

      // setters
      
    }
    
