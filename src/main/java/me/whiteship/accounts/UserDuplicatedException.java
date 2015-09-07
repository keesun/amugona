package me.whiteship.accounts;

/**
 * @author Keesun Baik
 */
public class UserDuplicatedException extends RuntimeException {

    String username;

    public UserDuplicatedException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
