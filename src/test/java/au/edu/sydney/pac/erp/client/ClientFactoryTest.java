package au.edu.sydney.pac.erp.client;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientFactoryTest {

    @Test
    public void firstTest() {
        ClientFactory cf2 = new ClientFactory();
        ClientList clist = cf2.makeClientList();
        ClientList emptyList = new ClientListImpl();
        assertEquals(clist.findAll(), emptyList.findAll());
    }

//    @Test
//    public void firstTest2() {
//        ClientFactoryImpl cf = new ClientFactoryImpl();
//        ClientList cList = cf.createSaslClient();
//
//    }
}