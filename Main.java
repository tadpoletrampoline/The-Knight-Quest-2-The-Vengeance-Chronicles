import java.util.*;

public class Main {
    static Scanner options = new Scanner(System.in); //player options for the menu

    static void menu(){

        // variables
        Boolean start = true; // control menu
        ArrayList<String> items = new ArrayList<Item>(); // Create an ArrayList object of type Item

        System.out.println("menu ramble... press s to start...press i for intructions");
        String menu = options.nextLine();

        switch(menu) {
            case "s": //starting the game
                System.out.println("Start game:");
                start = false;
                game();
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

    //i'm going to make a class for all this stuff soon
    static void game(){
        System.out.println("Enter your username: ");
        String userName = options.nextLine();
    }


    public static void main(String[] args) {

        menu();



    }
}
