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
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorBlankTest2() {
        try {
            Client testClient = new ClientImpl(2, "John", "", "000");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorBlankTest3() {
        try {
            Client testClient = new ClientImpl(2, "John", "John", "");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorBlankTest4() {
        try {
            Client testClient = new ClientImpl(2, "", "", "");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void constructorNegativeID() {
        try {
            Client testClient = new ClientImpl(-2, "John", "John", "0123");
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
    public void assignedDepartmentTest1() {
        Client testClient = new ClientImpl(2, "John", "Smith", "000");
        try {
            testClient.assignDepartment(null);
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
    public void assignedDepartmentTest3() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "000");
        String input = "";

        try {
            testClient.assignDepartment(input);
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void isAssignedTest() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "123");
        assertFalse(testClient.isAssigned());
    }
}