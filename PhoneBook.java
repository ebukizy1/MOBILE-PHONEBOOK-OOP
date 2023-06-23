package phonebook;

import mobilePhone.WrongInputException;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private boolean isLock = true;
    private final String password;
    private final String userName;


    private final List<Contact> contacts = new ArrayList<>();

    public PhoneBook(String userName, String password) {
        this.password = password;
        this.userName = userName;
    }
    public boolean isLock() {
        return isLock;
    }
    public void unLock(String password) {
        boolean isPasswordCorrect = this.password.equals(password);
        if (isPasswordCorrect) isLock = false;
        else throw new WrongInputException("Wrong password inputted");
    }

    public String generateID() {
        return "00" + checkSizeOfContact();
    }


    public void createContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(contact);
        contact.setID(generateID());
    }

    public int checkSizeOfContact() {
        return contacts.size();
    }

    public String searchForId(String ID) {
        for (Contact contact : contacts)
            if (contact.getId().equals(ID)) return contact.getFirstName() + " " + contact.getLastName();
        throw new WrongInputException("ID Doest Not exist");
    }

    public List<Contact> findContactByIndex(String index) {
        int index1 = validateIndex(index);
        List<Contact> uniqueValue = new ArrayList<>();
        Contact selectContact = contacts.get(index1 - 1);
        checkForContactWithSame(uniqueValue, selectContact);
        displayUniqueContact(uniqueValue);
        return uniqueValue;
    }

    public Contact pickOne(String choice, List<Contact> foundName) {
        int index1 = validateIndexInput(choice, foundName, "invalid input entered");
        return foundName.get(index1 - 1);
    }

    public void deleteChoice(Contact foundNames) {
        for (Contact contact : contacts) {
            boolean isIdEqualToSelectedId = contact.getId().equals(foundNames.getId());
            if (isIdEqualToSelectedId) {
                contacts.remove(contact);
                break;
            }
        }
        System.out.println(foundNames.getFirstName() + " " + foundNames.getLastName() + " " + foundNames.getPhoneNumber() + " Successful deleted from the list");
    }

    private static int validateIndexInput(String choice, List<Contact> foundNames, String invalid_input_entered) {
        int index1 = validateIndexInput(choice);
        if (index1 <= 0 || index1 > foundNames.size()) throw new WrongInputException(invalid_input_entered);
        return index1;
    }

    private int validateIndex(String index) {
        int index1 = validateIndexInput(index);
        if (index1 <= 0 || index1 > contacts.size()) throw new WrongInputException("wrong input inputted");
        return index1;
    }

    private static void displayUniqueContact(List<Contact> uniqueValue) {
        for (int i = 0; i < uniqueValue.size(); i++) {
            Contact contact = uniqueValue.get(i);
            System.out.println((i + 1) + " : " + contact.displayContact());
        }
    }

    private void checkForContactWithSame(List<Contact> uniqueValue, Contact selectContact) {
        for (Contact contact : contacts) {
            boolean isContactEqualSelectedContact = contact.getFirstName().equals(selectContact.getFirstName());
            if (isContactEqualSelectedContact) uniqueValue.add(contact);
        }
    }

    public void updateFirstContact(String firstName, Contact foundNames) {
        for (Contact contact : contacts) {
            boolean isIdEqualToSelectedId = contact.getId().equals(foundNames.getId());
            if (isIdEqualToSelectedId) {
                contact.setFirstName(firstName);
            }
            displayUpdate(firstName, foundNames);
        }

    }

    public void updateBothNames(String firstName, String lastName, Contact foundName) {
        for (Contact contact : contacts) {
            boolean isIdEqualToSelectedId = contact.getId().equals(foundName.getId());
            if (isIdEqualToSelectedId) {
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
            }
        }
        displayUpdate(firstName, foundName);
    }

    public void updateLastName(String lastName, Contact foundName) {
        for (Contact contact : contacts) {
            boolean isIdEqualToSelectedId = contact.getId().equals(foundName.getId());
            if (isIdEqualToSelectedId) contact.setLastName(lastName);
        }
        displayUpdate(lastName, foundName);
    }

    public void updatePhoneNumber(String phoneNumber, Contact foundName) {
        for (Contact contact : contacts) {
            boolean isIdEqualToSelectedId = contact.getId().equals(foundName.getId());
            if (isIdEqualToSelectedId) contact.setPhoneNumber(phoneNumber);
        }
        displayUpdate(phoneNumber, foundName);
    }

    private static void displayUpdate(String phoneNumber, Contact foundName) {
        System.out.printf("""
                            ===============================
                            FIRST NAME %s : 
                            LAST NAME %s :
                            PHONE NUMBER %s : 
                            !! SUCCESSFULLY UPDATED !!!!
                            ===============================
                            """, foundName.getFirstName(), foundName.getLastName(), phoneNumber);
    }


    public void updateAllContact(String firstName, String lastName, String phoneNumber, Contact foundName) {
        for (Contact contact : contacts) {
            boolean isIdEqualToSelectedId = contact.getId().equals(foundName.getId());
            if (isIdEqualToSelectedId) {
                contact.setFirstName(firstName);
                     contact.setLastName(lastName);
                     contact.setPhoneNumber(phoneNumber);
            }
        }
       displayUpdate(firstName, foundName);

    }

    

    private static int validateIndexInput(String choice) {
        int index1 = 0;
        try {
            index1 = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");

        }
        return index1;
    }


    public void displayContact1(){
        if(contacts.isEmpty()){
            System.out.println("""
        ======================
        ZERO  CONTACT 
          
          create contact""");
        }else System.out.println("""
                 ========================
                 C-E PHONEBOOKS DATABASE"
                 ========================
                """);
        for(int i = 0; i < contacts.size(); i++){
            Contact contact = contacts.get(i);
            System.out.println((i +1) + ": " + contact.getFirstName() + " " + contact.getLastName());
        }
    }
    public String getUserName() {
        return userName;
    }

}