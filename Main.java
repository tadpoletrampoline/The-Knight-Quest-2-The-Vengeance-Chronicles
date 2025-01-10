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
                loadLevel();
                break;

            case "i":
                instructions();
                menu();
                break;
                
            case "0": //lets player exit game
                System.out.println("bye bye");
                System.exit(0);
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

    static void loadLevel(){

        System.out.println("working yay");
        levelOne();
    }

    static void levelOne(){
        System.out.println("this is level one");
    }

    public static void main(String[] args) {

        // let's player start the game
        menu();



    }
}
