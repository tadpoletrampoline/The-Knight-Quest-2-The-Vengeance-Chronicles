import java.util.*;

public class Main {
static Scanner options = new Scanner(System.in); //player options for the menu
    
static void menu(){
    
    System.out.println("menu ramble... press one to start");
    String menu = options.nextLine();
        
        switch(menu) {  
            case "p": //starting the game
                System.out.println("Start game:");
                //menu = false;
                break;

            case "i":
                instructions();
                menu();
                break;
                
            }
        }

    static void instructions(){
        System.out.println("these are the very cool instructions");
        System.out.println("if you want to do this then blah blah blah...");
        
    }
        
    public static void main(String[] args) {

        menu();
        //Boolean menu = true;
        //Scanner c = new Scanner(System.in);  // Create a Scanner object
        String userName = myObj.nextLine();
        

      
    }
}
