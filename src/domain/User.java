package domain;


public class User {
    private int userId;
    private String name;
    private String email;
    private String contact;


    public User(int userId, String name, String email, String contact) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public User() {
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
