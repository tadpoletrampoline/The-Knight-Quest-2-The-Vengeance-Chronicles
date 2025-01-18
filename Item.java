public class Item {

    // instance variables (item features)

    private String type; // there are type locks and type keys which can be used to perform their tasks
    private String name; // item name
    private int value; // i knid of forgot what i was going for with this in the uml but i feel like i'll remember eventually

    // constructor
    
    public Item(String type, String name, int value){
        this.type = type;
        this.name = name;
        this.value = value;
    }

  
    // getters 
    
    public String getType() {
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public int getValue(){
        return this.value;
    }
    
    // setters
    public void setType(String t) {
		type = t;
	}
}
