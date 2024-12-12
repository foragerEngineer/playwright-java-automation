package m.sierra.Pages;

import m.sierra.Asserts.PlayAsserts;

public class SignInPage extends BasePage {

    public SignInPage() {
        super();
    }

    private static final String emailField = "input[name='email']";


    // TODO: Implement the following methods
    public void getEmailField() {
        page.locator(emailField).textContent().toLowerCase().trim();
    }

    public void setEmailField(String email) {
        if (1 <= email.length() && email.length() <= 50) {
            page.locator(emailField).type(email);
        }
        PlayAsserts playAsserts = new PlayAsserts();
        playAsserts.assertEmail(email);
    }

}
