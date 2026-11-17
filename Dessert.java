public abstract class Dessert{
/*Summary : This abstract super class will help us have an inheritance type association with the 
other three desserts. This super class has default and specific constructors. It contains the 
necessary attributes of flavor and amount. It also has a method to calculate the price of the 
dessert if the customer will get a discount. The accessor methods would be getFlavor() and getAmount().
The mutator methods will be setFlavor and setAmount().
 */


//attributes
private String dessertFlavor;
private int dessertAmount;

//constructor
public Dessert(String dessertFlavor, int dessertAmount){
    setFlavor(dessertFlavor);
    setAmount(dessertAmount);
}

//Accessors
public String getFlavor(){
    return dessertFlavor;
}

public int getAmount(){
    return dessertAmount;
}


//Mutators
public void setFlavor(String dessertFlavor){
    
    if(dessertFlavor == null || dessertFlavor.isEmpty()){
       throw new IllegalArgumentException("Dessert Flavor is required");
    }
    if(!dessertFlavor.equalsIgnoreCase("Chocolate")&& !dessertFlavor.equalsIgnoreCase("Vanilla")&& !dessertFlavor.equalsIgnoreCase("Strawberry")){
            throw new IllegalArgumentException("The dessert flavor must be chocolate, vanilla, or strawberry");
        }
        this.dessertFlavor = dessertFlavor;
}

public void setAmount(int dessertAmount){
    if(dessertAmount <= 0 && dessertAmount > 100){
        
       throw new IllegalArgumentException("The amount must be greater than zero and less than 100.");
    }
    this.dessertAmount = dessertAmount;
}

//Special Purpose Methods
public abstract double calculatePrice(); //Will change depending on what each subclass has! This is used to calculate if the customer will receive a discount or not.

public String toString() {
    return this.getFlavor() + "      | " + this.getAmount();
} 
}
    
