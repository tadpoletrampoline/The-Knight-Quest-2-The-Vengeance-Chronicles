import java.util.*;

public class Main {

    // variables
    ArrayList<Item> items = new ArrayList<Item>(); // Create an ArrayList object of type Item

    //setting up the game
    int score = 0;
    boolean hasItem = false;
    int location = 1; // signifies location/level (we could use a while loop or something)

    Scanner controls = new Scanner(System.in); //let's user input their actions
    
    static Scanner options = new Scanner(System.in); //player options for the menu
    
    static void menu(){
        
        Boolean start = true; // control menu
        
        System.out.println("menu ramble... press s to start...press i for intructions");
        String menu = options.nextLine();

        switch(menu) {
            case "s": //starting the game
                System.out.println("\nstarting game... ... ... ...\n");
                start = false;
                gameIntro();
                loadLevel(1);
                Map(5);
                break;

            case "i":
                instructions();
                menu();
                break;
                
            case "0": //lets player exit game
                System.out.println("bye bye");
                System.exit(0);

            default: 
                System.out.println("how dare you, please type in one of the proper options");
                menu(); // recursion!!!
                break;
        }
    }

    //mapping
    static void Map(int size) {
        int Row,Col,Num1,Num2;
        int p1 = 0;
        int p2 = 0;
        char Move;
        boolean Running = true;
        Scanner input = new Scanner(System.in);
        int Array[][] = new int [size][size];
                    
        for(int i=0;i<size;i++) {
            for(int x=0;x<size;x++) {
                Array[i][x] = 0;
                Array[p1][p2] = 1;
                
                // creates patterns of making values 2 as borders
                if (((x+i)^5)/2 == 0 && x<size-1 && i<size-1) {
                    Array[i][x] = 2;
                    Array[p1][p2] = 1;
                }
            }
        }
        for(int i=0;i<size;i++) {
            for(int x=0;x<size;x++) {
                System.out.print(Array[i][x] + "\t");
            }
            System.out.println();
        }
        
                    
        while(Running) {
            Move = input.next().charAt(0);
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

static void instructions(){
        System.out.println("these are the very cool instructions");
        System.out.println("if you want to do this then blah blah blah...");

    }

    //i'm going to add all this stuff to a class soon maybe
    static void gameIntro(){
        System.out.println("Enter your username (default is Lancelot): ");
        String userName = options.nextLine();
    }


    static void loadLevel(int num){

        if (num == 1) {
        System.out.println("working yay");
        levelOne();
        }
        
    }

    static void levelOne(){
        System.out.println("this is level one");
    }

    public static void main(String[] args) {

        // lets player start the game
        menu();



    }
}
