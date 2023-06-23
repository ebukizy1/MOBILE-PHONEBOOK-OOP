package phonebook;

import mobilePhone.WrongInputException;

import java.util.Scanner;



public class Main {
    private static Scanner userInputs = new Scanner(System.in);
    private static PhoneBooks phoneBooks = new PhoneBooks("lordEbukizy1", "ebukizy4u");

    public static void main(String[] args) {

menu();



    }
    public static void menu(){
        display("""
                =========================
                WELCOME TO C.E PHONEBOOKS
                =========================
                1 --> ADMIN LOGIN
                2 --> Exist 
                """);
        String userInput = input(userInputs);
        switch (userInput.charAt(0)){
            case '1' -> adminLogin();
            case '2' -> exist();
            default -> menu();
        }

    }

    private static void exist() {
        System.exit(404);
    }

    private static void adminLogin() {
        try {display("ENTER YOUR LOGIN USERNAME");
            String userName = input(userInputs).toUpperCase();
            display("ENTER YOUR PASSWORD ");
            String passWord = input(userInputs);
            PhoneBooks phoneBooks1 = new PhoneBooks(userName, passWord);
            display(userName + " " + "SUCCESSFULLY !!! LOGIN! ");
        }catch (WrongInputException e){
            e.getMessage();
            adminLogin();
        }
        phoneBooksMenu();

    }

    private static void phoneBooksMenu() {
        display("""
                ====================
                   WELCOME ADMIN 
                ====================
                1 -> CREATE PHONEBOOKS
                2 -> DELETE PHONEBOOKS
                3 -> SEARCH FOR PHONEBOOKS
                4 -> DISPLAY PHONEBOOKS IN DATABASE
                5 -> EXIST  
                """);
        String userInput = input(userInputs);
        switch (userInput.charAt(0)){
            case '1' -> createPhoneBooks();
            case '2' -> deletePhoneBooks();
            case '3' -> searchPhoneBooks();
            case '4' -> displayPhoneBooks();
            case '5' -> exist();
            default -> phoneBooksMenu();
        }
    }

    private static void displayPhoneBooks() {
        phoneBooks.displayContact1();
        prompt();
    }

    private static void searchPhoneBooks() {
        try {
            display(" ENTER THE PHONEBOOK USERNAME TO BE SEARCH  --> |character must be up to 8 letter|");
            String userName = input(userInputs).toUpperCase();
            PhoneBook foundPhoneBooK = phoneBooks.searchPhoneBook(userName);
            display(userName + " " + " EXIST IN THE LIST");
            display("""
                    1 -> DO YOU WANT TO DELETE FOUND CONTACT
                    2 -> GO BACK TO PHONEBOOKS MENU
                    """);
            String userInput = input(userInputs);
            switch (userInput.charAt(0)) {
                case '1' -> phoneBooks.removePhoneBook(foundPhoneBooK);
                case '2' -> phoneBooksMenu();
                default -> phoneBooksMenu();
            }
        }catch (WrongInputException e){
            e.getMessage();
            searchPhoneBooks();
        }

    }




    private static void deletePhoneBooks() {
        try {
            display(" ENTER YOUR PHONEBOOK USERNAME  --> |character must be up to 8 letter|");
            String userName = input(userInputs).toUpperCase();
            display("ENTER THE ADMIN PASSWORD");
            String passWord = input(userInputs);
            phoneBooks.removePhoneBook(userName, passWord);
            display(userName + " " + " SUCCESSFULLY DELETED FROM THE LIST");
        }catch (WrongInputException e){
            e.getMessage();
            deletePhoneBooks();
        }
            prompt();


    }

    private static void createPhoneBooks() {
        try {
            display(" ENTER YOUR PHONEBOOK USERNAME  --> |character must be up to 8 letter|");
            String userName = input(userInputs).toUpperCase();
            display("ENTER YOUR PHONEBOOK PASSWORD");
            String passWord = input(userInputs);
            phoneBooks.createContact(userName, passWord);
            display(userName + " " + " PHONEBOOK SUCCESSFULLY CREATED ");
        }catch (WrongInputException e){
            e.getMessage();
            createPhoneBooks();
        }
        prompt();
    }
    public static void prompt(){
        display("""
                
                
                1 -> DO YOU WANT TO ADD MORE PHONEBOOKS TO THE LIST
                2 -> DISPLAY PHONEBOOK IN THE DATABASE
                3 -> ADMIN MENU
                4 -> exit
                
                """);
        String userInput = input(userInputs);
        switch (userInput.charAt(0)){
            case '1' -> createPhoneBooks();
            case '2' -> displayPhoneBooks();
            case '3' -> phoneBooksMenu();
            case '4' -> exist();
            default -> phoneBooksMenu();
        }
    }

    public static void display(String message){
        System.out.println(message);
    }

    public static  String input(Scanner userInputs){
        return userInputs.nextLine();
    }
}
