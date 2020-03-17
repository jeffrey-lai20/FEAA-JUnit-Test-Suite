package au.edu.sydney.pac.erp.feaa;

import au.edu.sydney.pac.erp.client.Client;
import au.edu.sydney.pac.erp.client.ClientList;
import au.edu.sydney.pac.erp.client.ClientListImpl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

public class FEAAFacadeImplTest {

    private ClientList cl;
    private FEAAFacade feaa;
    @Before
    public void init() {
        cl = new ClientListImpl();
        feaa = new FEAAFacadeImpl();
        feaa.setClientProvider(cl);
    }
    @Test
    public void setClientProviderTest1() {
        int id = 20;
        String first = "jeff";
        String last = "lai";
        String number = "123";
        cl.addClient(id, first, last, number);
        assertEquals(id, feaa.getAllClients().get(0).getID());
        assertSame(first, feaa.getAllClients().get(0).getFirstName());
        assertSame(last, feaa.getAllClients().get(0).getLastName());
        assertSame(number, feaa.getAllClients().get(0).getPhoneNumber());
    }

    @Test
    public void setClientProviderTest2() {
        try {
            feaa.setClientProvider(null);
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void setClientProviderTest3() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.addAccount(20, 20, "some string", 20, 20);
        feaa.setClientProvider(cl);
        assertEquals(0, feaa.getAccounts().size());
    }

    @Test
    public void addClientTest1() {
        Client c1 = feaa.addClient("Jeff", "Lai", "123");
        Client c2 = feaa.getAllClients().get(0);
        assertEquals(c1, c2);
    }

    @Test
    public void addClientEmptyStringTest1() {
        try {
            feaa.addClient("", "Lai", "123");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientEmptyStringTest2() {
        try {
            feaa.addClient("Jeff", "", "123");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientEmptyStringTest3() {
        try {
            feaa.addClient("Jeff", "Lai", "");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientPhoneNumberTest() {
        try {
            feaa.addClient("Jeff", "Lai", "Not a number");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientNullTest() {
        try {
            feaa.addClient("Jeff", "Lai", "Not a number");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientNullTest2() {
        try {
            feaa.addClient(null, "Lai", "Not a number");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientNullTest3() {
        try {
            feaa.addClient("Jeff", null, "Not a number");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addClientNullTest4() {
        try {
            feaa.addClient("Jeff", "Lai", null);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void assignClientTest1() {
        feaa.addClient("Jeff", "Lai", "123");
        feaa.assignClient(1, "DOMESTIC");
        assertEquals(1, feaa.getAllClients().size());
    }

    @Test
    public void assignClientTest2() {
        feaa.addClient("Jeff", "Lai", "123");
        try {
            feaa.assignClient(2, "DOMESTIC");
            fail("Exception not thrown");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void assignClientTest3() {
        feaa.addClient("Jeff", "Lai", "123");
        try {
            feaa.assignClient(0, "DOMESTIC");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void assignClientTest4() {
        feaa.addClient("Jeff", "Lai", "123");
        try {
            feaa.assignClient(-1, "DOMESTIC");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void assignClientTest5() {
        feaa.addClient("Jeff", "Lai", "123");
        try {
            feaa.assignClient(1, "Random");
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void viewAllClientsTest1() {
        feaa.addClient("Jeff", "Lai", "123");
        feaa.addClient("Dad", "Mum", "123");
        assertEquals(2, feaa.viewAllClients().size());
    }

    @Test
    public void viewAllClientsTest2() {
        feaa.addClient("Jeff", "Lai", "123");
        feaa.addClient("Dad", "Mum", "123");
        assertEquals("Lai, Jeff", feaa.viewAllClients().get(0));
    }

    @Test
    public void viewAllClientsTest3() {
        assertNotNull(feaa.viewAllClients());
        assertEquals(0, feaa.viewAllClients().size());
    }

    @Test
    public void getAllClients1() {
        feaa.addClient("Jeff", "Lai", "123");
        feaa.addClient("Dad", "Mum", "123");
        assertEquals(2, feaa.getAllClients().size());
    }

    @Test
    public void getAllClients2() {
        Client c1 = feaa.addClient("Jeff", "Lai", "123");
        feaa.addClient("Dad", "Mum", "123");
        assertEquals(c1, feaa.getAllClients().get(0));
    }

    @Test
    public void getAllClients4() {
        assertNotNull(feaa.viewAllClients());
        assertEquals(0, feaa.getAllClients().size());
    }

    @Test
    public void getAllClients5() {
        feaa.addClient("Jeff", "Lai", "123");
        feaa.addClient("Dad", "Mum", "123");
        assertEquals("Jeff", feaa.getAllClients().get(0).getFirstName());
    }

    @Test
    public void addAccountTest1() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        assertNotNull(feaa.getAccounts());
    }

    @Test
    public void addAccountTest2() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        try {
            Integer x = feaa.addAccount(null, 20, "Jeff", 3, 5);
            int counter = 0;
            for (int i = 0; i < feaa.getAccounts().size(); i++) {
                if (feaa.getAccounts(i).equals(x)) {
                    counter++;
                }
            }
            if (counter == 1) {
                //passed;
            } else {
                fail("Did not create a unique account ID");
            }
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addAccountTest3() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        try {
            Integer x = feaa.addAccount(null, 20, "Jeff", 3, 5);
            Integer y = feaa.addAccount(null, 20, "Lai", 3, 5);
            int counter = 0;
            for (int i = 0; i < feaa.getAccounts().size(); i++) {
                if (feaa.getAccounts(i).equals(x) || feaa.getAccounts(i).equals(y)) {
                    counter++;
                }
            }
            if (counter == 2) {
                //passed;
            } else {
                fail("Did not create a unique account ID");
            }
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addAccountTest4() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        try {
            feaa.addAccount(123, 0, "Jeff", 3, 5);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addAccountTest5() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        try {
            feaa.addAccount(123, 20, "", 3, 5);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addAccountTest6() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        try {
            feaa.addAccount(123, 20, "Jeff", -3, 5);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void addAccountTest7() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        try {
            feaa.addAccount(123, 20, null, 3, 5);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getAccountsTest1() {
        assertNotNull(feaa.getAccounts());
        assertEquals(0, feaa.getAccounts().size());
    }

    @Test
    public void getAccountsTest2() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        assertEquals(1, feaa.getAccounts().size());
    }

    @Test
    public void getAccountsTest3() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        feaa.addAccount(321, 20, "Name", 3, 5);
        assertEquals(2, feaa.getAccounts().size());
    }

    @Test
    public void getAccountNameTest1() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        assertSame("Jeff", feaa.getAccountName(123));
    }

    @Test
    public void getAccountNameTest2() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        try {
            assertSame("Jeff", feaa.getAccountName(-1));
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void getAccountNameTest3() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        try {
            assertSame("Jeff", feaa.getAccountName(0));
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void getAccountNameTest4() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        try {
            assertSame("Jeff", feaa.getAccountName(21));
            fail("Exception not thrown");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void getAccountBalanceTest1() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 3, 5);
        assertEquals(-2, feaa.getAccountBalance(123));
    }

    @Test
    public void getAccountBalanceTes2() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 500);
        assertEquals(500, feaa.getAccountBalance(123));
    }

    @Test
    public void getAccountBalanceTes3() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 500);
        try {
            assertEquals(500, feaa.getAccountBalance(-123));
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getAccountBalanceTes4() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 500);
        try {
            assertEquals(500, feaa.getAccountBalance(321));
            fail("Exception not thrown");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void getAccountIncomingsTest1() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 500);
        assertEquals(1000, feaa.getAccountIncomings(123));
    }

    @Test
    public void getAccountIncomingsTest2() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 0, 500);
        assertEquals(0, feaa.getAccountIncomings(123));
    }

    @Test
    public void getAccountIncomingsTest3() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 500);
        try {
            assertEquals(500, feaa.getAccountIncomings(-123));
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }
    @Test
    public void getAccountIncomingsTest4() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 500);
        try {
            assertEquals(500, feaa.getAccountIncomings(0));
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getAccountOutgoingsTest1() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 321321);
        assertEquals(321321, feaa.getAccountOutgoings(123));
    }

    @Test
    public void getAccountOutgoingsTest2() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 0, 500);
        assertEquals(500, feaa.getAccountOutgoings(123));
    }

    @Test
    public void getAccountOutgoingsTest3() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 500);
        try {
            assertEquals(500, feaa.getAccountOutgoings(-123));
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }
    @Test
    public void getAccountOutgoingsTest4() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(123, 20, "Jeff", 1000, 123);
        try {
            assertEquals(123, feaa.getAccountBalance(0));
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void setAccountIncomingsTest1() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(1, 20, "Jeff", 123, 60);
        try {
            feaa.setAccountIncomings(1, 123123);
            assertEquals(123123, feaa.getAccountIncomings(1));
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void setAccountOutgoingsTest1() {
        cl.addClient(20, "Jeff", "Lai", "123");
        feaa.setClientProvider(cl);
        feaa.addAccount(1, 20, "Jeff", 123, 60);

        try {
            feaa.setAccountIncomings(1, 123123);
            assertEquals(123123, feaa.getAccountOutgoings(1));
        } catch (IllegalStateException e) {
        }
    }
}