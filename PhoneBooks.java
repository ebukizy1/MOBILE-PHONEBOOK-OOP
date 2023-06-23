package phonebook;

import mobilePhone.WrongInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneBooks {
    private final List<PhoneBook> phoneBooks = new ArrayList<>();
    private String userName;
    private String passWord;

    public PhoneBooks(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;


    }

    public void createContact(String userName, String password) {
        PhoneBook phoneBook = new PhoneBook(userName, password);
        validateDuplicateUserNameCannotExist(phoneBook);
        validateNamesEnter(password);
        phoneBooks.add(phoneBook);
    }

    public void validateDuplicateUserNameCannotExist(PhoneBook phoneBook1) {
        String userName = phoneBook1.getUserName();
        for (PhoneBook phoneBook : phoneBooks)
            if (phoneBook.getUserName().equals(userName)) {
                throw new WrongInputException("userName already exist in the list");
            }
    }

    public static void validateNamesEnter(String firstName) {
        if (firstName.length() >= 8) {
            String regex = "[a-zA-Z0-9]+";
            if (!Pattern.matches(regex, firstName))
                throw new WrongInputException("Invalid name. Only letters A-Z, a-z, and numbers 0-9 are allowed.");
        } else throw new WrongInputException("Invalid password, enter password  up to 8 digit");

    }

    public int getContactSize() {
        return phoneBooks.size();
    }

    public void removePhoneBook(String userName, String phoneBooksPassword) {
        boolean isPasswordValid = this.passWord.equals(phoneBooksPassword);
        if (isPasswordValid) {
            for (PhoneBook phoneBooks1 : phoneBooks) {
                boolean isUserNameFound = userName.equals(phoneBooks1.getUserName());
                if (isUserNameFound) {
                    phoneBooks.remove(phoneBooks1);
                    break;
                }
            }
        } else throw new WrongInputException("phoneBook password incorrect, enter correct password");
    }


    public PhoneBook searchPhoneBook(String userName) {
        for (PhoneBook phoneBook1 : phoneBooks) {
            boolean isUserNameFound = userName.equals(phoneBook1.getUserName());
            if (isUserNameFound) {
                return phoneBook1;
            }}
        throw new WrongInputException(userName + " " + "does not exist in the list");
    }

    public void removePhoneBook( PhoneBook phoneBook){
            for (PhoneBook phoneBooks1 : phoneBooks) {
                boolean isUserNameFound = phoneBooks1.getUserName().equals(phoneBook.getUserName());
                if (isUserNameFound) {
                    phoneBooks.remove(phoneBooks1);
                    break;}}
        }
    public void displayContact1(){
        if(phoneBooks.isEmpty()){
            System.out.println(" 0  contact ");
        }else System.out.println("""
                 ========================
                 C-E PHONEBOOKS DATABASE"
                 ========================
                """);
        for(int i = 0; i < phoneBooks.size(); i++){
            PhoneBook phoneBook = phoneBooks.get(i);
            System.out.println((i +1) + " : " + phoneBook.getUserName() );
        }
    }
        }




