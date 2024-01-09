package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UITest extends AbstractTest {
    @Test
    void testGBNotEmailLogin() {
        String username = "login";
        String password = "password";

        loginPage.login(username, password);

        Assertions.assertFalse(loginPage.checkEmailField());
    }

    @Test
    void testGBWithoutPassword() {
        String username = "login@login.ru";

        loginPage.typeEmailInField(username);
        loginPage.clickLoginButton();

        Assertions.assertFalse(loginPage.checkPasswordField());
    }
}
