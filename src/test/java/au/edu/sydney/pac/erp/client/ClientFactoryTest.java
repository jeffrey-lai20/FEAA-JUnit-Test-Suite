package au.edu.sydney.pac.erp.client;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientFactoryTest {

    @Test
    public void makeClietListTest1() {
        ClientFactory cf = new ClientFactory();
        ClientList clist = cf.makeClientList();
        ClientList emptyList = new ClientListImpl();
        assertEquals(clist.findAll(), emptyList.findAll());
    }

    @Test
    public void makeClietListTest2() {
        ClientFactory cf = new ClientFactory();
        assertTrue(cf.makeClientList() instanceof ClientList);
    }
}