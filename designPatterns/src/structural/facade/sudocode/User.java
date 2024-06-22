package structural.facade.sudocode;

public class User {
    private String name;
    private String emailId;

    public User(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }
}
