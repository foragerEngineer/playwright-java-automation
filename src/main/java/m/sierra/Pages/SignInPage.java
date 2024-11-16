package m.sierra.Pages;

public class SignInPage extends BasePage {

    public SignInPage() {
        super();
    }

    private final String emailField = "input[name='email']";

    public void getEmailField() {
        page.locator(emailField).textContent().toLowerCase().trim();
    }

}
