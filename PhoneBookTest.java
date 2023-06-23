package phonebook;

import BankAccount2.WrongPinException;
import mobilePhone.WrongInputException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    PhoneBook phoneBook = new  PhoneBook("09037488890", "1111");

    @Test
    public void testPhoneBookExist(){
        assertNotNull(phoneBook);
    }

    @Test
    public void testPhoneBookCanBeLock(){
        assertTrue(phoneBook.isLock());
    }
    @Test
    public void testPhoneBookCanBeUnlock(){
        assertTrue(phoneBook.isLock());
        phoneBook.unLock("1111");
        assertFalse(phoneBook.isLock());
    }
//   @Test
//    public void testPhoneBookCanCheckWrongPasswordCannotBeAllowed(){
//       phoneBook.isLock();
//     assertThrows(WrongPinException.class, ()->  phoneBook.unLock("1121"));
//   }
   @Test public void testPhoneCanCreateContact(){
       assertTrue(phoneBook.isLock());
       phoneBook.unLock("1111");
       assertFalse(phoneBook.isLock());
       phoneBook.createContact("emmauel", "segun", "09073406000");
        assertEquals(1, phoneBook.checkSizeOfContact());
   }
   @Test
    public void testPhoneBookCanAddFourContact(){
       phoneBook.createContact("emmauel", "segun", "09073406000");
       phoneBook.createContact("lekan", "sola", "07038243709");
       phoneBook.createContact("samuel", "david", "08141221934");
       phoneBook.createContact("emmauel", "emeka", "09037488890");
       assertEquals(4, phoneBook.checkSizeOfContact());
   }
   @Test
    public void PhoneBooKCanGenerateUniqueValue(){
       phoneBook.createContact("emmanuel", "segun", "09073406000");
       phoneBook.createContact("lekan", "sola", "07038243709");
       assertEquals("emmanuel segun", phoneBook.searchForId("001"));
   }
   @Test
    public void PhoneBookCannotSearchForIDNotFoundInTheList(){
       phoneBook.createContact("emmanuel", "segun", "09073406000");
       phoneBook.createContact("lekan", "sola", "07038243709");
       assertThrows(WrongInputException.class,()-> phoneBook.searchForId("003"));
   }
   @Test
    public void testPhoneBookCanSortForContactWithDuplicateValue(){
       phoneBook.createContact("emmauel", "ola", "09073406000");
       phoneBook.createContact("lekan", "sola", "07038243709");
       phoneBook.createContact("samuel", "david", "08141221934");
       phoneBook.createContact("emmauel", "ola", "09037488890");
       List<Contact> actual = phoneBook.findContactByIndex("4");
   }
    @Test
    public void testPhoneBookCannotFindForContactWithWrongInput(){
        assertTrue(phoneBook.isLock());
        phoneBook.unLock("1111");
        assertFalse(phoneBook.isLock());
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        assertThrows(WrongInputException.class,()->  phoneBook.findContactByIndex("5"));
    }
    @Test
    public void testPhoneBookCanRemoveContact(){
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        List<Contact> actual = phoneBook.findContactByIndex("4");
        Contact contact = phoneBook.pickOne("1", actual);
        phoneBook.deleteChoice(contact);
        assertEquals(3, phoneBook.checkSizeOfContact());
        System.out.println(contact);
    }

    @Test
    public void testUpdateContact(){
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        List<Contact> actual = phoneBook.findContactByIndex("4");
        Contact contact = phoneBook.pickOne("1", actual);
       phoneBook.updateFirstContact("david", contact);
       assertEquals("david", contact.getFirstName());
    }
    @Test
    public void testPhoneBookCanUpdateFirstNameAndLastName(){
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        List<Contact> actual = phoneBook.findContactByIndex("4");
        Contact contact = phoneBook.pickOne("1", actual);
        phoneBook.updateBothNames("segun", "yinka", contact);
        assertEquals("segun", contact.getFirstName());
        assertEquals("yinka", contact.getLastName());
        assertEquals("09073406000", contact.getPhoneNumber());
    }
    @Test
    public void testPhoneBookCanUpdateLastName(){
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        List<Contact> actual = phoneBook.findContactByIndex("4");
        Contact contact = phoneBook.pickOne("1", actual);
        phoneBook.updateLastName("joseph", contact);
        assertEquals("joseph", contact.getLastName());
    }

    @Test
    public void testPhoneBookCanUpdatePhoneName(){
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        List<Contact> actual = phoneBook.findContactByIndex("4");
        Contact contact = phoneBook.pickOne("1", actual);
        phoneBook.updateLastName("joseph", contact);
        assertEquals("joseph", contact.getLastName());
    }
    @Test
    public void testPhoneCanUpdatePhoneNumber(){
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        List<Contact> actual = phoneBook.findContactByIndex("4");
        Contact contact = phoneBook.pickOne("1", actual);
        phoneBook.updatePhoneNumber("08138243709", contact);
        assertEquals("08138243709", contact.getPhoneNumber());
    }
    @Test
    public void testPhoneCanUpdateAllContact() {
        phoneBook.createContact("emmauel", "ola", "09073406000");
        phoneBook.createContact("lekan", "sola", "07038243709");
        phoneBook.createContact("samuel", "david", "08141221934");
        phoneBook.createContact("emmauel", "ola", "09037488890");
        List<Contact> actual = phoneBook.findContactByIndex("4");
        Contact contact = phoneBook.pickOne("1", actual);
        phoneBook.updateAllContact("segun", "dele", "08068331068", contact);
        assertEquals("segun", contact.getFirstName());
        assertEquals("dele", contact.getLastName());
        assertEquals("08068331068", contact.getPhoneNumber());

    }
  @Test
  public void testPhonebookCannotALLowWrongInput() {
      phoneBook.createContact("emmauel", "ola", "09073406000");
      phoneBook.createContact("lekan", "sola", "07038243709");
      List<Contact> actual = phoneBook.findContactByIndex("2");
      assertThrows(WrongInputException.class, () -> phoneBook.pickOne("3", actual));
  }
@Test
    public void testPhoneBookCannotAllowNumberEnterInFirstName(){
        assertThrows(WrongInputException.class,()->  phoneBook.createContact("emm44auel", "ola", "09073406000"));
}
    @Test
    public void testPhoneBookCannotAllowNumberEnterInFirstLastName(){
        assertThrows(WrongInputException.class,()->  phoneBook.createContact("emmauel", "ola54", "09073406000"));
    }
    @Test
    public void testPhoneBookCannotAllowLetterEnterInPhoneNumber(){
        assertThrows(WrongInputException.class,()->  phoneBook.createContact("emmauel", "ola", "09073ffe406000"));
    }
    @Test
    public void testPhoneNumberCannotStartWithAnyOtherDigitApartFromZERO(){
        assertThrows(WrongInputException.class,()->  phoneBook.createContact("emmauel", "ola", "9073406000"));
    }



}
