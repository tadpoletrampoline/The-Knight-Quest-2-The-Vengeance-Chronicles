import java.util.*;

// class to create mapping gample including movement and inserting puzzles
    
    public class Map {
        
    //instance variables
        
        // delete private int Row,Col,Num1,Num2;
        private int p1 = 0;
        private int p2 = 0;
        private char Move;
        private boolean Running = true;
        int Array[][];
        private int size = 6; // map size hard coded (change maybe later)
        
        public Map() {
        
        this.Array = new int [this.size][this.size];
                    
        for(int i=0;i<size;i++) {
            for(int x=0;x<size;x++) {
                this.Array[i][x] = 0;
                this.Array[p1][p2] = 1;
                
                // creates patterns of making values 2 as borders * will edit later to be a complex path
                if (((x+i)^5)/2 == 0 && x<size-1 && i<size-1  && i<size-1 && x>0 && i>0) {
                    this.Array[i][x] = 2;
                    this.Array[this.p1][this.p2] = 1;
                }
            }
        }
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
            this.Move = input.next().charAt(0);
            
            switch(Move) {
            case 's':
            case 'S':
                
            if (p1 < size-1 && Array[p1+1][p2] != 2) { //prevents out of bounds
                Array[p1][p2] = 0;
                Array[p1+=1][p2] = 1;
                break;
            } else {
                System.out.println("Your path here is blocked, try another way.");
                break;
                }
                
            case 'n':
            case 'N':
                
                if (p1 > 0 && Array[p1-1][p2] != 2) { //prevents out of bounds
                    Array[p1][p2] = 0;
                    Array[p1-=1][p2] = 1;
                    break;
                } else {
                    System.out.println("Your path here is blocked, try another way.");
                    break;
                }
            case 'e':
            case 'E':
                
            if (p2 < size-1 && Array[p1][p2+1] != 2) {   
                Array[p1][p2] = 0;
                Array[p1][p2+=1] = 1;
                break;
            } else {
                    System.out.println("Your path here is blocked, try another way.");
                    break;
                }
                
            case 'w':
            case 'W':
            
            if (p2 > 0 && Array[p1][p2-1] != 2) { 
                Array[p1][p2] = 0;
                Array[p1][p2-=1] = 1;
                break;
            } else {
                    System.out.println("Your path here is blocked, try another way.");
                    break;
                }
            
            case 'l':
            case 'L':
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
    
