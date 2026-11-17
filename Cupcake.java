public class Cupcake extends Dessert{
/* Summary : This is the Data Definition Class (Sub Class) extends to the dessert class for the bakery management. 
It contains all the necessary attributes like the filling, theme, and price calculation for the bakery order to handle 
these attributes. This includes the default and specific constructors for initializing the bakery objects, accessor methods, 
getFilling() and getTheme to retrieve attribute values, mutator methods, setFilling() and setTheme() to modify those values, 
and any additional methods required for specific functionality such as toString.
 */
    
    //instance variables
    private String cupcakeFilling;
    private String cupcakeTheme;
    private static final double PRICE = 4.50;
    
    //specific constructor
    public Cupcake(String flavor, int amount, String cupcakeFilling, String cupcakeTheme){
        super(flavor, amount);
        setFilling(cupcakeFilling);
        setTheme(cupcakeTheme);
    }

    //Accessors
    public String getFilling(){
        return cupcakeFilling;
    }
    public String getTheme(){
        return cupcakeTheme;
    }

    //Mutators
    /* Makes sure the cupcake filling and theme are specified by the user. */
    public void setFilling(String cupcakeFilling){
        if(cupcakeFilling == null|| cupcakeFilling.isEmpty()){
            throw new IllegalArgumentException("The cupcake filling must be provided");
        }
        if(!cupcakeFilling.equalsIgnoreCase("Caramel")&& !cupcakeFilling.equalsIgnoreCase("Chocolate")&& !cupcakeFilling.equalsIgnoreCase("Vanilla") && !cupcakeFilling.equalsIgnoreCase("None")){
            throw new IllegalArgumentException("The cupcake filling must be Caramel, Chocolate, None");
        }
        this.cupcakeFilling = cupcakeFilling;
    }
    public void setTheme(String cupcakeTheme){
        if(cupcakeTheme == null || cupcakeTheme.isEmpty()){
            throw new IllegalArgumentException("The cupcake theme must be provided");
        }
        if(!cupcakeTheme.equalsIgnoreCase("Holiday")&& !cupcakeTheme.equalsIgnoreCase("Animals")&& !cupcakeTheme.equalsIgnoreCase("None")){
            throw new IllegalArgumentException("The cupcake theme must be Holiday, Animals, None");
        }
        this.cupcakeTheme = cupcakeTheme;
    }

    //special purpose methods

    /*Calculates the price and overrides the superclass' abstract method. First, the method checks if the amount
is applicable for the discount and if yes then the discount price is given. If not, then the normal price is given. */
    public double calculatePrice(){
        if(getAmount()>30){
            double discountPrice = (PRICE - (PRICE * 0.15)) * getAmount();
            return discountPrice; 
        }
        else{
            return PRICE * getAmount();
        }
    }
   
     public String toString() {
        return "Cupcake Order: " + super.toString() + "      | " + this.getFilling() + "      | " + this.getTheme() + "      | $" + this.calculatePrice();
    }
}

