package me.whiteship.accounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @Test
    public void getterSetter() {
        Account account = new Account();
        account.setUsername("whiteship");
        account.setPassword("password");
        assertThat(account.getUsername(), is("whiteship"));
    }

}