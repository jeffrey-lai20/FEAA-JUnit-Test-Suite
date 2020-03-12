package au.edu.sydney.pac.erp.client;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ClientImplTest {

    @Test
    public void assignedDepartmentTest1() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "0451932393");
        try {
            testClient.assignDepartment(null);
        } catch (IllegalArgumentException e) {}
    }
    @Test
    public void assignedDepartmentTest2() {
        Client testClient = new ClientImpl(2, "Jeffrey", "Lai", "0451932393");
        String input = "Math";
        testClient.assignDepartment(input);
        assertEquals(input, testClient.getDepartmentCode());
    }
}