package au.edu.sydney.pac.erp.client;

import java.util.List;

public class ClientFactory {

    private List ClientList;

    public ClientFactory(List newList) {
        ClientList = newList;
    }

    public ClientList makeClientList() {
        return (au.edu.sydney.pac.erp.client.ClientList) new java.awt.List();
    }
}
