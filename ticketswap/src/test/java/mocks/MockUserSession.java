package mocks;

public class MockUserSession {
    private boolean loggedIn = false;

    public void login() {
        loggedIn = true;
    }

    public void logout() {
        loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}