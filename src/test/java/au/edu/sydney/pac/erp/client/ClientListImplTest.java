package au.edu.sydney.pac.erp.client;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientListImplTest {
    @Test
    public void addClientTest1(){
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = "jeff";
        String last = "lai";
        String number = "123";
        cl.addClient(id, first, last, number);

        assertEquals(id, cl.findOne(20).getID());
        assertEquals(first, cl.findOne(20).getFirstName());
        assertEquals(last, cl.findOne(20).getLastName());
        assertEquals(number, cl.findOne(20).getPhoneNumber());
    }

    @Test
    public void addClientNegativeIDTest(){
        ClientList cl = new ClientListImpl();
        int id = -20;
        String first = "jeff";
        String last = "lai";
        String number = "123";
        try {
            cl.addClient(id, first, last, number);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientEmptyStringTest1(){
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = "";
        String last = "lai";
        String number = "123";
        try {
            cl.addClient(id, first, last, number);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientEmptyStringTest2(){
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = "name";
        String last = "";
        String number = "123";
        try {
            cl.addClient(id, first, last, number);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientEmptyStringTest3(){
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = "jeff";
        String last = "lai";
        String number = "";
        try {
            cl.addClient(id, first, last, number);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientNullStringTest1(){
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = null;
        String last = "lai";
        String number = "123";
        try {
            cl.addClient(id, first, last, number);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientNullStringTest2(){
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = "jeff";
        String last = null;
        String number = "123";
        try {
            cl.addClient(id, first, last, number);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientNullStringTest3() {
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = "jeff";
        String last = "lai";
        String number = null;
        try {
            cl.addClient(id, first, last, number);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientDuplicateTest() {
        ClientList cl = new ClientListImpl();
        int id = 20;
        try {
            cl.addClient(id, "Jeff", "Lai", "123");
            cl.addClient(id, "Peter", "Last", "321");

            fail("Exception not thrown");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void clearTest() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123");
        cl.addClient(3, "Peter", "Last", "321");
        cl.addClient(24, "Dave", "Name", "333");
        cl.clear();
        assertEquals(0, cl.findAll().size());
    }

    @Test
    public void clearTestEmpty() {
        ClientList cl = new ClientListImpl();
        cl.clear();
        assertEquals(0, cl.findAll().size());
    }

    @Test
    public void findAllTest() {
        try {
            ClientList cl = new ClientListImpl();
            Client c1 = cl.addClient(20, "Jeff", "Lai", "123");
            Client c2 = cl.addClient(3, "Peter", "Last", "321");
            Client c3 = cl.addClient(24, "Dave", "Name", "333");
            List<Client> expectedList = new ArrayList<Client>();
            expectedList.add(c1);
            expectedList.add(c2);
            expectedList.add(c3);
            assertEquals(cl.findAll(), expectedList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllNullTest() {
        ClientList cl = new ClientListImpl();
        assertNotNull(cl.findAll());
    }

    @Test
    public void findAllEmptyTest(){
        ClientList cl = new ClientListImpl();
        assertEquals(0, cl.findAll().size());
    }

    @Test
    public void findAllBooleanTest() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123").assignDepartment("math");
        cl.addClient(3, "Peter", "Last", "321");
        cl.addClient(24, "Dave", "Name", "333");

        assertEquals(1, cl.findAll(true).size());
    }

    @Test
    public void findAllBooleanTest2() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123").assignDepartment("math");
        cl.addClient(3, "Peter", "Last", "321");
        cl.addClient(24, "Dave", "Name", "333");

        assertEquals(2, cl.findAll(false).size());
    }

    @Test
    public void findAllBooleanNullTest() {
        ClientList cl = new ClientListImpl();
        assertNotNull(cl.findAll(false));
        assertNotNull(cl.findAll(true));
    }
    @Test
    public void findAllBooleanEmptyTest() {
        ClientList cl = new ClientListImpl();
        assertNotNull(cl.findAll(false));
        assertNotNull(cl.findAll(true));
        assertEquals(0, cl.findAll(true).size());
        assertEquals(0, cl.findAll(false).size());
    }

    @Test
    public void findAllBooleanEmptyTest2() {
        ClientList cl = new ClientListImpl();
        cl.addClient(3, "Peter", "Last", "321");
        cl.addClient(24, "Dave", "Name", "333");
        assertEquals(0, cl.findAll(true).size());
    }

    @Test
    public void findAllCodesTest() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123").assignDepartment("math");
        cl.addClient(3, "Peter", "Last", "321");
        cl.addClient(24, "Dave", "Name", "333");

        assertEquals(1, cl.findAll("math").size());
    }

    @Test
    public void findAllCodesTest2() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123").assignDepartment("math");
        cl.addClient(3, "Peter", "Last", "321").assignDepartment("physics");
        cl.addClient(24, "Dave", "Name", "333");

        assertEquals(2, cl.findAll("math", "physics").size());
    }

    @Test
    public void findAllCodesTest3() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123").assignDepartment("math");
        cl.addClient(3, "Peter", "Last", "321").assignDepartment("physics");
        cl.addClient(24, "Dave", "Name", "333");
        cl.addClient(4, "Peter", "Last", "321").assignDepartment("physics");
        cl.addClient(42, "Dave", "Name", "333");
        assertEquals(2, cl.findAll("chemistry", "physics").size());
    }

    @Test
    public void findAllCodesEmptyTest() {
        ClientList cl = new ClientListImpl();
        assertEquals(0, cl.findAll("chemistry", "physics").size());
    }

    @Test
    public void findAllCodesNullTest() {
        ClientList cl = new ClientListImpl();
        assertNotNull(cl.findAll("chemistry", "physics", "math"));
    }

    @Test
    public void findAllCodesNoMatchTest() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123").assignDepartment("math");
        cl.addClient(3, "Peter", "Last", "321").assignDepartment("physics");
        cl.addClient(24, "Dave", "Name", "333");
        cl.addClient(4, "Peter", "Last", "321").assignDepartment("physics");
        cl.addClient(42, "Dave", "Name", "333");
        assertEquals(0, cl.findAll("chemistry").size());
    }

    @Test
    public void findOneTest() {
        ClientList cl = new ClientListImpl();
        Client c1 = cl.addClient(20, "Jeff", "Lai", "123");
        cl.addClient(42, "Dave", "Name", "333");
        Client c2 = cl.findOne(20);
        assertEquals(c1, c2);
    }

    @Test
    public void findOneTest2() {
        ClientList cl = new ClientListImpl();
        Client c1 = cl.addClient(20, "Jeff", "Lai", "123");
        cl.addClient(22, "Dave", "Name", "333");
        assertNull(cl.findOne(123));
    }

    @Test
    public void findOneTest3() {
        ClientList cl = new ClientListImpl();
        assertNull(cl.findOne(123));
    }

    @Test
    public void removeTest() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123");
        cl.remove(20);
        assertNull(cl.findOne(20));
    }

    @Test
    public void removeTest2() {
        ClientList cl = new ClientListImpl();
        try {
            cl.remove(0);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void removeTest3() {
        ClientList cl = new ClientListImpl();
        cl.addClient(20, "Jeff", "Lai", "123");
        assertFalse(cl.remove(19));
    }
}