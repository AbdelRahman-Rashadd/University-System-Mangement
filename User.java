
public abstract class User {
    private String userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String contactInfo;
    private boolean loggedIn = false;

    public User(String userId, String username, String password, String name, String email, String contactInfo,boolean loggedIn) {
        this.userId = userId;
        this.username = username;
        setpassword(password);
        this.name = name;
        this.email = email;
        this.contactInfo = contactInfo;
        this.loggedIn=false;
    }
    public abstract String getRole();

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    private void setpassword(String password){
        if (password.length()>=6){this.password=password;}
        else{System.out.println("Password must be at least 6 characters long.");}
    }

    public String getPassword() {
        return this.password;
    }
    public void changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            setpassword(newPassword);
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Old password is incorrect.");
        }
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public abstract void displayDashboard();
    public void updateProfile(String name, String email, String contactInfo) {
        this.name = name;
        this.email = email;
        this.contactInfo = contactInfo;
        System.out.println("Profile updated successfully.");
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            loggedIn = true;
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
    public void logout() {
        System.out.println(name + " logged out.");
        this.loggedIn = false;
    }
}