package phonebook;

import BankAccount2.WrongNameException;
import BankAccount2.WrongPhoneNumberException;
import mobilePhone.WrongInputException;

import java.util.regex.Pattern;

public class Contact{
private  String phoneNumber;
private String firstName;
private String lastName;
private  String ID;


    public Contact(String firstName, String lastName, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String displayContact(){
        return firstName + "  " + lastName;
    }

    public void validatePhoneNumber(String phoneNumber) {
            if (phoneNumber.length() != 11 || !phoneNumber.matches("^0\\d{10}$")) {
                throw new WrongInputException("invalid phone number enter");
            }
        }

    public static  void validateNamesEnter(String firstName){
        String regex = "[a-zA-Z]+";
        if (!Pattern.matches(regex, firstName))
            throw  new WrongInputException("Invalid  names. Only letters A-Z and a-z are allowed.");
    }

    @Override
    public String toString() {
        return " FIRSTNAME = " + firstName + "\n" +
                " LASTNAME = " + lastName + "\n" +
                " PHONENUMBER = " + phoneNumber + "\n" +
                "";
    }
}
