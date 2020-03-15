package au.edu.sydney.pac.erp.feaa;

import au.edu.sydney.pac.erp.client.ClientList;
import au.edu.sydney.pac.erp.client.ClientListImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class FEAAFacadeImplTest {

    @Test
    public void setClientProviderTest1() {
        ClientList cl = new ClientListImpl();
        int id = 20;
        String first = "jeff";
        String last = "lai";
        String number = "123";
        cl.addClient(id, first, last, number);
        FEAAFacade feaa = new FEAAFacadeImpl();
        feaa.setClientProvider(cl);
        assertEquals(id, feaa.getAllClients().get(0).getID());
        assertSame(first, feaa.getAllClients().get(0).getFirstName());
        assertSame(last, feaa.getAllClients().get(0).getLastName());
        assertSame(number, feaa.getAllClients().get(0).getPhoneNumber());
    }

    @Test
    public void setClientProviderTest2() {
        FEAAFacade feaa = new FEAAFacadeImpl();
        try {
            feaa.setClientProvider(null);
        } catch (IllegalStateException e) {
        }
    }
}