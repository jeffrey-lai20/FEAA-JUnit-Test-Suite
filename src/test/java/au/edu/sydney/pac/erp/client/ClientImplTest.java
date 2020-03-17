package au.edu.sydney.pac.erp.client;

import org.junit.Test;

import static org.junit.Assert.*;


public class ClientImplTest {

//    @Before
//    public void objectInit() {
//        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "0451932393");
//    }

    @Test
    public void constructorBlankTest1() {
        try {
            Client testClient = new ClientImpl(2, "", "John", "000");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorBlankTest2() {
        try {
            Client testClient = new ClientImpl(2, "John", "", "000");
<<<<<<< HEAD
            fail("Exception not thrown");
=======
            fail("Yeah nah didn't work");
>>>>>>> 69ac3231f64b11e74b786c5e9c0f10cec72e7c16
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorBlankTest3() {
        try {
            Client testClient = new ClientImpl(2, "John", "John", "");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorBlankTest4() {
        try {
            Client testClient = new ClientImpl(2, "", "", "");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorNullTest1() {
        try {
            Client testClient = new ClientImpl(2, null, "Last", "123");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorNullTest2() {
        try {
            Client testClient = new ClientImpl(2, "first", null, "123");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorNullTest3() {
        try {
            Client testClient = new ClientImpl(2, "first", "last", null);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorNegativeID() {
        try {
            Client testClient = new ClientImpl(-2, "John", "John", "0123");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorMaxID() {
        try {
            Client testClient = new ClientImpl(Integer.MAX_VALUE, "John", "John", "0123");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void constructorZeroID() {
        try {
            Client testClient = new ClientImpl(0, "John", "John", "0123");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorInvalidPhone() {
        try {
            Client testClient = new ClientImpl(2, "John", "John", "Hello");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorBigID() {
        try {
            Client testClient = new ClientImpl(123456, "John", "John", "Hello");
        } catch (IllegalArgumentException e) {
            fail("Exception thrown");
        }
    }

    @Test
    public void assignedDepartmentNullTest() {
        Client testClient = new ClientImpl(2, "John", "Smith", "000");
        try {
            testClient.assignDepartment(null);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void assignedDepartmentTest2() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "000");
        String input = "Math";
        testClient.assignDepartment(input);
        assertEquals(input, testClient.getDepartmentCode());
    }

    @Test
    public void assignedDepartmentEmptyStringTest() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "000");
        String input = "";
        try {
            testClient.assignDepartment(input);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void isAssignedTest1() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "123");
        assertFalse(testClient.isAssigned());
    }
<<<<<<< HEAD

    @Test
    public void isAssignedTest2() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "123");
        testClient.assignDepartment("Math");
        assertTrue(testClient.isAssigned());
    }

    @Test
    public void getDepartmentCodeTest1() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "123");
        String departmentCode = "Math";
        testClient.assignDepartment(departmentCode);
        assertEquals(departmentCode, testClient.getDepartmentCode());
    }

    @Test
    public void getDepartmentCodeNullTest() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "123");
        assertNull(testClient.getDepartmentCode());
    }

    @Test
    public void getIDTest() {
        int id = 2;
        Client testClient = new ClientImpl(id, "Jeffrey", "Lai", "123");
        assertEquals(id,testClient.getID());
    }

    @Test
    public void getIDBigTest() {
        int id = 654321;
        Client testClient = new ClientImpl(id, "Jeffrey", "Lai", "123");
        assertEquals(id,testClient.getID());
    }

    @Test
    public void getIDMaxTest() {
        int id = Integer.MAX_VALUE;
        Client testClient = new ClientImpl(id, "Jeffrey", "Lai", "123");
        assertEquals(id,testClient.getID());
    }

    @Test
    public void getFirstNameTest() {
        String firstName = "first";
        Client testClient = new ClientImpl(2, firstName, "Lai", "123");
        assertEquals(firstName,testClient.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        String lastname = "last";
        Client testClient = new ClientImpl(2, "first", lastname, "123");
        assertEquals(lastname,testClient.getLastName());
    }

    @Test
    public void getPhoneNumberTest() {
        String phoneNumber = "123";
        Client testClient = new ClientImpl(2, "first", "last", phoneNumber);
        assertEquals(phoneNumber, testClient.getPhoneNumber());
    }

    @Test
    public void getPhoneNumberBigTest() {
        String phoneNumber = "1321654897624332123";
        Client testClient = new ClientImpl(2, "first", "last", phoneNumber);
        assertEquals(phoneNumber, testClient.getPhoneNumber());
    }
}
=======
}
>>>>>>> 69ac3231f64b11e74b786c5e9c0f10cec72e7c16
