public class CustomerInfo {
    //this class holds all of the customer info
    //instance variables
private String name;
private String phoneNum;
private String address;
private String paymentMethod;

//default constructor
public CustomerInfo() {}

//specific constructor 
public CustomerInfo(String name, String phoneNum, String address, String paymentMethod) {
    setName(name);
    setNum(phoneNum);
    setAddress(address);
    setPayment(paymentMethod);
}

//mutators
/* Making sure none of the user inputs are blank. */
public void setName(String name) {
if(name.equals("")&& name.isEmpty()) {
    throw new IllegalArgumentException("Error! Customer name cannot be blank.");
}
    this.name = name;
}
public void setNum(String phoneNum) {
    if(phoneNum.equals("") && phoneNum.isEmpty()) {
        throw new IllegalArgumentException("Error! Phone number cannot be blank.");
    }
    if(phoneNum.length() < 10 && phoneNum.length() > 10) {
        throw new IllegalArgumentException("Error! Phone number cannot be more or less than 10 numbers long.");
    }
    this.phoneNum = phoneNum;
}
public void setAddress(String address) {
    if(address.equals("") && address.isEmpty()) {
        throw new IllegalArgumentException("Error! Address cannot be blank");
    }
    this.address = address;
}
public void setPayment(String paymentMethod) {
    if(paymentMethod.equals("") && paymentMethod.isEmpty()) {
        throw new IllegalArgumentException("Error! Payment method must be given.");
    }

    /* Our bakery only accepts cash and card payments and makes sure the customer has paid by adding this mutator. As
    said in the error, if a user does not say they are paying by card or cash, the user must talk to the manager if there were
    any exceptions or previous arrangements made. */
    if(!paymentMethod.equalsIgnoreCase("Card") && !paymentMethod.equalsIgnoreCase("Cash")) {
        throw new IllegalArgumentException("Error! We only accept card or cash.\nPlease talk to manager if any exception has been\nmade beforehand.");
    }
    this.paymentMethod = paymentMethod;
}

//accessors
public String getName() {
    return this.name;
}
public String getNum() {
    return this.phoneNum;
}
public String getAddress() {
    return this.address;
}
public String getPayment() {
    return this.paymentMethod;
}

//special purpose methods
public String toString() {
    return this.getName() +  "      | " + this.getNum() + "      | " + this.getAddress();
}


}
