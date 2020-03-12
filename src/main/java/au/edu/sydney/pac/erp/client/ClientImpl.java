package au.edu.sydney.pac.erp.client;

public class ClientImpl implements Client {

    private String departmentCode;
    private boolean isAssigned;
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public ClientImpl(int id, java.lang.String firstName, java.lang.String lastName, java.lang.String phoneNumber) {
        this.departmentCode = null;
        this.isAssigned = false;
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void assignDepartment(String departmentCode) throws IllegalStateException, IllegalArgumentException {
        if (this.departmentCode != null) {
            throw new IllegalStateException();
        }
        if (departmentCode == null) {
            throw new IllegalArgumentException();
        }
        this.departmentCode = departmentCode;
        this.isAssigned = true;
    }

    @Override
    public boolean isAssigned() {
        return isAssigned;
    }

    @Override
    public String getDepartmentCode() {
        return departmentCode;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
