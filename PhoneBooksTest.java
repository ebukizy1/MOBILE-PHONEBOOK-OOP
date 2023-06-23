package phonebook;


import mobilePhone.WrongInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBooksTest{ PhoneBooks phoneBooks = new PhoneBooks( "lordEbukizy1 ",  "ebukizy4u");
@Test
public void testPhoneBookCanCreatePhone(){
    assertNotNull(phoneBooks);
}

@Test
    public void testPhoneCanCreatePhoneBook(){
    phoneBooks.createContact("emmanuel", "ebukizy4u");
    assertEquals(1, phoneBooks.getContactSize());
}
@Test
    public void testPhoneBookCanAddMoreThanOneContact(){
    phoneBooks.createContact("emmanuel", "ebukizy4u");
    phoneBooks.createContact("awal", "eebukizy1");
    assertEquals(2, phoneBooks.getContactSize());
}
@Test
    public void testPhoneBooksCanAddCannotAllowDuplicateName(){
    phoneBooks.createContact("emmanuel", "eebukizy1");
    assertThrows(WrongInputException.class,()->  phoneBooks.createContact("emmanuel", "2222"));
}
@Test
    public void testPhoneBookPasswordCannotShouldBeUpToEight(){
    assertThrows(WrongInputException.class,()->  phoneBooks.createContact("emmanuel", "1111") );
}
@Test
    public void testPhoneBookCanRemove(){
    phoneBooks.createContact("emmanuel", "ebukizy4u");
    phoneBooks.createContact("awal", "eebukizy1");
    phoneBooks.createContact("segun", "eebukizy1");
    assertEquals(3, phoneBooks.getContactSize());
    phoneBooks.removePhoneBook("segun", "ebukizy4u");
    assertEquals(2, phoneBooks.getContactSize());
}
    @Test
    public void testPhoneBookCannotAllowWordPassword(){
        phoneBooks.createContact("emmanuel", "ebukizy4u");
        phoneBooks.createContact("awal", "eebukizy1");
        phoneBooks.createContact("segun", "eebukizy1");
        assertEquals(3, phoneBooks.getContactSize());
       assertThrows(WrongInputException.class,()-> phoneBooks.removePhoneBook("segun", "ebukiUYzy1"));
    }
    @Test
    public void testPhoneBookCanSearchForPhone(){
        phoneBooks.createContact("emmanuel", "ebukizy4u");
        phoneBooks.createContact("awal", "eebukizy1");
        phoneBooks.createContact("segun", "eebukizy1");
        assertEquals(3, phoneBooks.getContactSize());
       PhoneBook phoneBook = phoneBooks.searchPhoneBook("awal");
        assertEquals("awal", phoneBook.getUserName());
    }
    @Test
    public void testPhoneBookCanSearchForPhoneBookAndDeleteIt(){
        phoneBooks.createContact("emmanuel", "ebukizy4u");
        phoneBooks.createContact("awal", "eebukizy1");
        phoneBooks.createContact("segun", "eebukizy1");
        assertEquals(3, phoneBooks.getContactSize());
        PhoneBook phoneBook = phoneBooks.searchPhoneBook("awal");
      //  assertEquals("awal", phoneBook.getUserName());
        phoneBooks.removePhoneBook( phoneBook);
        assertEquals(2, phoneBooks.getContactSize());

    }






    }




