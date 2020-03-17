package au.edu.sydney.pac.erp.client;

import java.util.ArrayList;
import java.util.List;

public class ClientListImpl implements ClientList {

    private List<Client> clients;

    public ClientListImpl() {
        clients = new ArrayList<Client> ();
    }

    @Override
    public Client addClient(int id, String firstName, String lastName, String phoneNumber) throws IllegalStateException, IllegalArgumentException {
        Client newClient = new ClientImpl(id, firstName, lastName, phoneNumber);
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getID() == id) {
                throw new IllegalStateException();
            }
        }
        clients.add(newClient);
        return newClient;
    }

    @Override
    public void clear() {
        clients = new ArrayList<Client> ();
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public List<Client> findAll(boolean assigned) {
        List<Client> newClientsList = new ArrayList<Client> ();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).isAssigned() == assigned) {
                newClientsList.add(clients.get(i));
            }
        }
        return newClientsList;
    }

    @Override
    public List<Client> findAll(String... departmentCodes) {
        List<Client> newClientsList = new ArrayList<Client> ();
        for (int i = 0; i < clients.size(); i++) {
            for (int j = 0; j < departmentCodes.length; j++) {
                if (clients.get(i).getDepartmentCode() == null) {
                    continue;
                }
                if (clients.get(i).getDepartmentCode().equals(departmentCodes[j])) {
                    if (clients.get(i) != null) {
                        newClientsList.add(clients.get(i));
                    }
                }
            }

        }
        return newClientsList;
    }

    @Override
    public Client findOne(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getID() == id) return clients.get(i);
        }
        return null;
    }

    @Override
    public boolean remove(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getID() == id) {
                clients.remove(i);
                return true;
            }
        }
        return false;
    }
}
