import java.util.*;

public class Main {

    // variables
    ArrayList<Item> items = new ArrayList<Item>(); // Create an ArrayList object of type Item

    //setting up the game
    int score = 0;
    boolean hasItem = false;
    int location = 1; // signifies location/level (we could use a while loop or something)
    
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
                
                
                Map landscape = new Map(1); // initializing map object!!!
                landscape.move(); 
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

static void instructions(){
        System.out.println("these are the very cool instructions");
        System.out.println("if you want to do this then blah blah blah...");

    }

    //i'm going to add all this stuff to a class soon maybe
    static void gameIntro(){
        System.out.println("Enter your username (default is Lancelot): ");

        String username = options.nextLine();
        Knight person = new Knight(username);                  /// knight object created!!
        // System.out.println(person.getName()); // testing if name works
    }

    static void levelOne(){
        System.out.println("this is level one");
    }

    // Methods for cutscene
    //static void cutsene1() {System.out.println("hi)};

    public static void main(String[] args) {

        // lets player start the game
        menu();



    }
}
