import javax.swing.JOptionPane;

public class BakeryImp {

    /*Summary : This class is responsible for handling the implementation class. It interacts with the user by taking its inputs, and creating instances
    of the Insurance Class based on the provided data, and displaying the results. This class manages the user interaction, handles the creation
    of the Insurance objects, and displays the insurance policy details, ensuring that the application is able to function properly. */

    /* This is our main class that holds the users menu, and allows the user pick which choice they want to pick. If the
    user picks and option that is not valid it will prompt a message.
     */
    public static void main(String[] args) {
        //holds the max amount of items which is 50
        final int MAX_ITEM = 50;

        //array of type BakeryShop which makes the output easier and cleaner.
        BakeryShop[] currentOrders = new BakeryShop[MAX_ITEM];

        //default user input until the user chooses a menu option.
        int userInput = -1;
    

        /*This do-while loop asks the user for a menu input that will then take the user to the corresponding method.
        We used a switch-case type to make it look cleaner. The entries are surrounded by a try catch to make sure the
        user puts in a valid type for user input (int instead of String)*/
        do{ 
         try {
            userInput = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the bakery shop! Choose any menu option to get started\n" +
                "1.) Add Order\n2.) Remove Order\n3.) Search order\n4.) Display Recepit\n5.) Exit"));
            
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "User input must be a number.");
                userInput = -1;
            }           
                        
            switch(userInput) {
                case 1:
                    addOrder(currentOrders);
                    break;
                case 2:
                    removeOrder(currentOrders);
                    break;
                case 3:
                    String searchKey = JOptionPane.showInputDialog("Enter the order ID you're looking for:");
                    searchOrder(currentOrders, searchKey);
                    break;
                case 4:
                    displayOrder(currentOrders);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Thank you for your order!");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Oops! Please choose a number 1-4 on the menu.\nThank you!");
                    break;
            }
        }
        while(userInput >= 1 && userInput <= 4); 
        
    }//end main
    
    //add order class
    /* This is the addOrder Dessert class which contains all of the user's interactions with my program. It contains
     all of the options in the users menu which is adding a order, removing an order, displaying all of the orders
     they have created, and searching for a order.
     The object creation is broken up by class. First it does the items needed for the Order class, then CustomerInfo, and
     finally for dessert depending on what type of dessert the user chooses to place an order for. It is also surrounded
     by a try catch method so if the user puts in a String instead of an int, they will be given an error message.
     */


    public static void addOrder(BakeryShop [] currentOrders) {


        try {
            //order information
            String orderID = JOptionPane.showInputDialog("Please enter your order ID:\n*Note Must be exactly 5 chracters long");            
            String occasion = JOptionPane.showInputDialog("Please enter the occasion for your order:\nBirthday, Baby Shower, Wedding, None");
        
            Order orderInfo = new Order(orderID, occasion);
        

             //customer info
            String name = JOptionPane.showInputDialog("Please enter your name");
            String phoneNum = JOptionPane.showInputDialog("Enter your phone number\n*Note Must be exactly 10 digits");
            String address = JOptionPane.showInputDialog("Enter your address");
            String payment = JOptionPane.showInputDialog("Enter your payment method\nCard or Cash");
            
            CustomerInfo customer = new CustomerInfo(name, phoneNum, address, payment);
            
            String type = JOptionPane.showInputDialog("Choose the type of dessert you would like to order:\n" + 
            "1. Cupcake (4.50)\n" + 
            "2. Cookie ($3.25)\n" + 
            "3. Cake ($11.50)");

            String flavor = JOptionPane.showInputDialog("Enter the Flavor\nOptions:Chocolate, Strawberry, or Vanilla");
            int amount = 0;
            if (type.equals("1")) {
                amount = Integer.parseInt(JOptionPane.showInputDialog("Enter the Amount\n15% Discount available for orders with " +
                "30+ Cupcakes\n*Note: Minimum amount is 1, maximum amount is 100."));
            }
            if (type.equals("2")) {
                amount = Integer.parseInt(JOptionPane.showInputDialog("Enter the Amount\n20% Discount available for orders with " +
            "40+ Cookies\n*Note: Minimum amount is 1, maximum amount is 100."));
            }
            if (type.equals("3")) {
                amount = Integer.parseInt(JOptionPane.showInputDialog("Enter the Amount\n10% Discount available for orders with " +
            "5+ Cakes\n*Note: Minimum amount is 1, maximum amount is 100."));
            }

            Dessert order = null;

            if(type.equals("1")) {
                String filling = JOptionPane.showInputDialog("Enter the Filling of Choice:\n" + "Caramel\n" + "Chocolate\n"+ "None");
                String theme = JOptionPane.showInputDialog("Enter the Theme:\n" + "Holiday\n" + "Animals\n"+ "None");

                order = new Cupcake(flavor, amount, filling, theme);
            } else if (type.equals("2")) {
                String topping = JOptionPane.showInputDialog("Enter the Topping:\n" + "Sprinkles\n" + "Chocolate Chips\n"+ "Frosting");
                String shape = JOptionPane.showInputDialog("Enter the Shape:\n" + "Heart\n" + "Circle\n"+ "Star");

                order = new Cookie(flavor, amount, topping, shape);
            } else if (type.equals("3")) {
                int layers = Integer.parseInt(JOptionPane.showInputDialog("Enter the Number of Layers\n*Note Must have at least 1 layer and no more than 5 layers"));
                String message = JOptionPane.showInputDialog("Enter the Message You Would Like on the Cake\n*If none desired, type 'none'");

                order = new Cake(flavor, amount, message, layers);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid dessert type selected.");
                return;
            }

            for (int i = 0; i < currentOrders.length; i++) {
                if (currentOrders[i] == null) {
                    currentOrders[i] = new BakeryShop(orderInfo, customer, order);
                    JOptionPane.showMessageDialog(null, "Order added successfully!");
                    return;
                }
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error! Please enter the correct type of input.");
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
        }//end add order

 
//remove order
/* This will remove an order depending on what the order ID is. It first asks for the order ID then loops through the
array to see if this order ID exists. If confirmed, it will then move to the next for loop which moves each object in
the array to the right by one and then deleting the final object in the array. The count for orders created is also
decreased since it is needed for other for loops. */
public static void removeOrder(BakeryShop [] currentOrders) {
    String orderID = JOptionPane.showInputDialog("Please type in the order ID you would like to remove.");
    int index = -1;

    //for loop to find order id so it can be removed
    for (int i = 0; i < currentOrders.length; i++) {
        if (currentOrders[i] != null && orderID != null && orderID.equalsIgnoreCase(currentOrders[i].getOrder().getOrderID())) {
            index = i;
            break;
        }
    }

    if (index > -1) {


        //this for loops moves everything one spot to the right after an order is deleted
        for (int i = index; i < BakeryShop.getCount(); i++) {
            currentOrders[i] = currentOrders[i+1];
        }

        /* Sets the last item to be removed after it is moved to the right. It goes based off how many orders have been made
        so if there is only one order, it only removes that order and doesn't crash the system.*/
        currentOrders[BakeryShop.getCount() - 1] = null;
        BakeryShop.decreaseCount();
        JOptionPane.showMessageDialog(null, "This order has been removed.");
    }

 }//end remove


//display order
/* This will display all current orders that the bakery has. It gets the toString() for each class and outputs
all the information about the order such as order ID, customer name, and dessert type. */
public static void displayOrder(BakeryShop [] currentOrders) {
    String output = "** Bakery Order Receipt **\n\n" +
    "Order ID     | Occasion     | Customer Name     | Details               | Price\n\n";

    for (int i = 0; i < BakeryShop.getCount(); i++) {
        output += currentOrders[i].toString() + "\n";
    }


    JOptionPane.showMessageDialog(null, output);    


 }//end display


 
 //Search Order
 /* This searches for an order in the array. It  loops through the array looking for the order ID to make sure
 it is a valid one. If found, the order will be displayed. If not, then an error will be shown instead.*/
    public static void searchOrder(BakeryShop [] currentOrders, String searchKey){

        if (searchKey == null || searchKey.isEmpty()){
            JOptionPane.showMessageDialog(null, "Invalid Order ID");
            return;
        }
        int searchIndex = -1;
        
        for (int i = 0; i<currentOrders.length; i++){
            if (searchKey.equalsIgnoreCase(currentOrders[i].getOrder().getOrderID())){
                searchIndex = i;
                break;

            }
        }
        if (searchIndex == -1) {
            JOptionPane.showMessageDialog(null, "Error! Order ID not found.\nPlease double check the order ID and try again.");
        }
        else {
            JOptionPane.showMessageDialog(null, "Order found!\nOrder ID     | Occasion     | Customer Name     | Details               | Price\n\n" +
            currentOrders[searchIndex].toString());
        }
    }   
}

//end search order