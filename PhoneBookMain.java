package phonebook;

import mobilePhone.WrongInputException;

import java.util.List;
import java.util.Scanner;

public class PhoneBookMain {
    private static final Scanner userInputs = new Scanner(System.in);
    private static final PhoneBook phoneBook = new PhoneBook("emmanuel", "1234567");

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        display("""
                =======================
                  WELCOME C-E PHONEBOOK 
                =======================
                1 -> UNLOCK PHONEBOOK
                2 -> EXIT  
                """);

        String userInput = input(userInputs);
        switch (userInput.charAt(0)) {
            case '1' -> loginPhoneBook();
            case '2' -> exist();
            default -> menu();
        }


    }

    private static void exist() {
        System.out.println(404);
    }

    private static void loginPhoneBook() {
        try {
            display("ENTER YOUR LOGIN USERNAME");
            String userName = input(userInputs).toUpperCase();
            display("ENTER YOUR PASSWORD ");
            String passWord = input(userInputs);
            PhoneBook phoneBook1 = new PhoneBook(userName, passWord);
            phoneBook1.unLock(passWord);
            display(userName + " " + "PHONEBOOK SUCCESSFULLY!! UNLOCK");
        } catch (WrongInputException e) {
            e.getMessage();
            display("invalid input entered");
            loginPhoneBook();
        }
        displayPhoneBookContact();

    }

    private static void displayPhoneBookContact() {
        phoneBook.displayContact1();
        phonebookPrompt();
    }

    private static void displayPhoneBookContact2() {
        phoneBook.displayContact1();

    }

    private static void phonebookPrompt() {
        display("""
                                
                1 -> CREATE CONTACT
                2 -> OPEN MENU
                3 -> EXIT
                """);
        String userInput = input(userInputs);
        switch (userInput.charAt(0)) {
            case '1' -> createContact();
            case '2' -> contactCreatedPrompt();
            case '3' -> exist();
            default -> contactCreatedPrompt();

        }
    }

    private static void createContact() {
        try {
            display("ENTER YOUR FIRST NAME");
            String firstName = input(userInputs).toUpperCase();
            display("ENTER YOUR LAST NAME");
            String lastName = input(userInputs).toUpperCase();
            display("ENTER YOUR PHONE NUMBER");
            String phoneNumber = input(userInputs);
            phoneBook.createContact(firstName, lastName, phoneNumber);
            display(firstName + " " + lastName + " SUCCESSFULLY!! ADDED TO THE CONTACT LIST");
        } catch (WrongInputException e) {
            e.getMessage();
            display("invalid input entered");
            phonebookPrompt();
        }
        contactCreatedPrompt();
    }

    private static void contactCreatedPrompt() {
        display("""
                1 -> CREATE CONTACT
                2 -> DISPLAY CONTACT
                3 -> DELETE CONTACT
                4 -> SEARCH FOR CONTACT
                5 -> UPDATE CONTACT 
                6 -> EXIT
                """);
        String userInput = input(userInputs);
        switch (userInput.charAt(0)) {
            case '1' -> createContact();
            case '2' -> displayPhoneBookContact();
            case '3' -> deletePhoneBookContact();
            case '4' -> createPhoneBookSearch();
            case '5' -> createUpdateContact();
            case '6' -> exist();
            default -> contactCreatedPrompt();
        }


    }

    private static void createUpdateContact() {
        displayPhoneBookContact2();
        try {
            display("""

                     -> ENTER THE SELECTED CONTACT

                     -> press 0 TO GO BACK 
                    """);

            String userInput = input(userInputs);
            if(userInput.charAt(0) == '0'){
                switch (userInput.charAt(0)){
                    case '0' -> contactCreatedPrompt();
                }
            }
            List<Contact> contact = phoneBook.findContactByIndex(userInput);
            display("ENTER THE SELECTED CONTACT TO BE SEARCH");
            String inputted = input(userInputs);
            Contact foundName = phoneBook.pickOne(inputted, contact);
            display("""
                     
                     1 -> UPDATE FIRST NAME
                     2 -> UPDATE LAST NAME
                     3 -> UPDATE FIRSTNAME AND LASTNAME
                     4 -> UPDATE PHONE NUMBER
                     5 -> UPDATE ALL
                     6 -> EXIT
                     
                          
                    """);

            String inputte = input(userInputs);
            switch (inputte.charAt(0)) {
                case '1' -> updateFirstName(foundName);
                case '2' -> updateLastName(foundName);
                case '3' -> updateBothName(foundName);
                case '4' -> updatePhoneBookNumber(foundName);
                case '5' -> updateAll(foundName);
                case '6' -> exist();
                default -> contactCreatedPrompt();
            }
        } catch (WrongInputException e) {
            e.getMessage();
            createUpdateContact();
        }
        contactCreatedPrompt();
    }


    private static void createPhoneBookSearch() {
        displayPhoneBookContact2();
        try {
            display("""
                    
                    ENTER THE SELECTED CONTACT
                    
                    > press 0 TO GO BACK 
                    """);
            String userInput = input(userInputs);
            if(userInput.charAt(0) == '0'){
                switch (userInput.charAt(0)){
                    case '0' -> contactCreatedPrompt();
                }}
            List<Contact> contact = phoneBook.findContactByIndex(userInput);
            display("ENTER THE SELECTED CONTACT TO BE SEARCH");
            String inputted = input(userInputs);
            Contact foundName = phoneBook.pickOne(inputted, contact);
            display("""
                     
                     1 -> DO YOU WANT TO DELETE CONTACT
                     2 -> UPDATE FIRST NAME
                     3 -> UPDATE LAST NAME
                     4 -> UPDATE FIRSTNAME AND LASTNAME
                     5 -> UPDATE PHONE NUMBER
                     6 -> UPDATE ALL
                     7 -> EXIT
                     
                          
                    """);

            String inputte = input(userInputs);
            switch (inputte.charAt(0)) {
                case '1' -> phoneBook.deleteChoice(foundName);
                case '2' -> updateFirstName(foundName);
                case '3' -> updateLastName(foundName);
                case '4' -> updateBothName(foundName);
                case '5' -> updatePhoneBookNumber(foundName);
                case '6' -> updateAll(foundName);
                case '7' -> exist();
                default -> contactCreatedPrompt();
            }
        }catch (WrongInputException e){
            e.getMessage();
            createUpdateContact();
        }
        contactCreatedPrompt();
    }

    private static void deletePhoneBookContact() {
        try {
            displayPhoneBookContact2();
            display("""
                    
                    ENTER THE SELECTED CONTACT
                    
                    > press 0 TO GO BACK 
                    """);
            String userInput = input(userInputs);
            if(userInput.charAt(0) == '0'){
                switch (userInput.charAt(0)){
                    case '0' -> contactCreatedPrompt();
                }}
            List<Contact> contact = phoneBook.findContactByIndex(userInput);
            display("SELECT CONTACT TO BE DELETED");
            String inputted = input(userInputs);
            Contact foundName = phoneBook.pickOne(inputted, contact);
            phoneBook.deleteChoice(foundName);
        }catch (WrongInputException e){
            e.getMessage();
            deletePhoneBookContact();
        }
        contactCreatedPrompt();

    }


    private static void updateFirstName(Contact foundName){
        display("ENTER YOUR FIRST NAME");
        String firstName = input(userInputs).toUpperCase();
        phoneBook.updateFirstContact(firstName, foundName);
    }
    private static void updateLastName(Contact foundName){
        display("ENTER YOUR LAST NAME");
        String lastName = input(userInputs).toUpperCase();
        phoneBook.updateLastName(lastName, foundName);
    }
    private static void updatePhoneBookNumber(Contact foundName){
        display("ENTER YOUR PHONE NUMBER");
        String phoneNumber = input(userInputs);
        phoneBook.updatePhoneNumber(phoneNumber, foundName);
    }
    private static void updateBothName(Contact foundName){
        display("ENTER YOUR FIRST NAME");
        String firstName = input(userInputs).toUpperCase();
        display("ENTER YOUR LAST NAME");
        String lastName = input(userInputs).toUpperCase();
        phoneBook.updateBothNames(firstName,lastName, foundName);
    }
    private static  void updateAll(Contact foundName){
        display("ENTER YOUR FIRST NAME");
        String firstName = input(userInputs).toUpperCase();
        display("ENTER YOUR LAST NAME");
        String lastName = input(userInputs).toUpperCase();
        display("ENTER YOUR PHONE NUMBER");
        String phoneNumber = input(userInputs);
        phoneBook.updateAllContact(firstName, lastName, phoneNumber, foundName);

    }






    public static String input(Scanner input){
        return userInputs.nextLine();
    }
    public static void  display(String message){
        System.out.println(message);
    }




}
