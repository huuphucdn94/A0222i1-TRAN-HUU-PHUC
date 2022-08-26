package model.bean;

public class User {
    private int id;
    private String username;
    private String passworld;
    private String role;

    public User() {
    }

    public User(int id, String username, String passworld, String role) {
        this.id = id;
        this.username = username;
        this.passworld = passworld;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
