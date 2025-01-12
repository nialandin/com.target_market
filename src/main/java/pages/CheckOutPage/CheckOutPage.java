package pages.CheckOutPage;

import org.openqa.selenium.By;
import pages.BasePage.BasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ShoppingCartPage.ShoppingCartPage;
import pages.TargetMarketHomePage.TargetMarketHomePage;
import pages.TargetMarketLoginPage.LoginPage;

import java.util.List;
import java.util.Objects;

public class CheckOutPage extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "address")
    private WebElement addressElement;

    @FindBy(id = "cardNumber")
    private WebElement cardNumberElement;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberElement;

    @FindBy(css = "button[type='submit']")
    private WebElement placeOrderElement;

    @FindBy(css = "ul > li")
    private List<WebElement> itemsList;

    @FindBy(css = ".invalid-feedback")
    private List<WebElement> alertMessagesList;
    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logoutButton;

    @FindBy(css = "button.mx-3:nth-child(2)")
    private WebElement shoppingButton;


    public void enterFirstName(String firstName) {
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameElement.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        addressElement.sendKeys(address);
    }

    public void enterCardNumber(String cardNumber) {
        cardNumberElement.sendKeys(cardNumber);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberElement.sendKeys(phoneNumber);
    }

    public TargetMarketHomePage clickOnPlaceOrder() {
        placeOrderElement.click();
        return new TargetMarketHomePage();
    }

    public void enterAllInformation(String firstName, String lastName, String address, String cardNumber, String phoneNumber) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterCardNumber(cardNumber);
        enterPhoneNumber(phoneNumber);
    }

    private WebElement getItem(String itemName) {
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i).findElement(By.cssSelector(".d-flex > span:nth-child(1)")).getText().contains(itemName)) {
                return itemsList.get(i);
            }
        }
        return null;
    }

    public String getAlertMessageText(int index) {
        return alertMessagesList.get(index - 1).getText();
    }

    public boolean isItemOnCartItemsList(String itemName) {
        return !Objects.isNull(getItem(itemName));
    }
    public LoginPage clickOnLogoutButton(){
        logoutButton.click();
        return new LoginPage();
    }
    public ShoppingCartPage clickOnShoppingButton(){
        shoppingButton.click();
        return new ShoppingCartPage();
    }
}
