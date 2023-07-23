package com.demoqa.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageForm {
    private final WebDriver driver;

    public MainPageForm(WebDriver driver) {
        this.driver = driver;
    }
    private static final String URL = "https://demoqa.com"; // стартовая страница сайта

    private static final By BUTTON_FORMS = By.xpath("//div[@class = 'card-body']/h5[text()='Forms']"); // кнопка заполнения формы на главной странице
    private static final By BUTTON_PRACTICE_FORM = By.xpath("//span[text()='Practice Form']");
    private static final By FIRST_NAME_FIELD = By.xpath("//input[@placeholder='First Name']"); // поле ввода имени
    private static final By LAST_NAME_FIELD = By.xpath("//input[@placeholder='Last Name']");// поле ввода фамилии
    private static final By EMAIL_FIELD = By.xpath("//input[@placeholder='name@example.com']"); // поле ввода Email
    private static final By RADIOBUTTON_GENDER_MALE = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1)"); // радиокнопка Male
    private static final By MOBILE_NUMBER_FIELD = By.xpath("//input[@id='userNumber']");// поле ввода Mobile Number
    private static final By DATE_OF_BIRTH_FIELD = By.xpath("//div/input[@id='dateOfBirthInput']");// поле ввода
    private static final By SELECT_MONT_MENU = By.xpath("//select[@class='react-datepicker__month-select']");// меню выбора месяца
    private static final By SELECT_MONT = By.xpath("//select[@class='react-datepicker__month-select']/option[@value=0]"); // выбор месяца Январь
    public static final By SELECT_DAY = By.xpath("//div[1]/div[text()='1']");//выбор даты
    public static final By SELECT_YEAR_MENU = By.xpath("//select[@class='react-datepicker__year-select']");// меню выбора года
    public static final By SELECT_YEAR = By.xpath("//select/option[@value='1992']");// выбор года 1992
    public static final By SUBJECTS_FIELD_FOR_CLICK = By.cssSelector("#subjectsContainer > div > div.subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3");//выбор поля SUBJECTS по клику
    public static final By SUBJECTS_FIELD_FOR_INPUT = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div[2]/div/div/div[1]/div/div/input");// поле ввода SUBJECTS
    public static final By SUBJECTS_ENGLISH = By.xpath("//div/div[@id='react-select-2-option-0']");// выбор предмета English
    public static final By HOBBIES_CHECKBOX_SPORTS = By.xpath("//label[text()='Sports']"); // чек-бокс на Sports
    public static final By FILE_UPLOAD_BUTTON = By.xpath("//input[@id='uploadPicture']"); // кнапка загрузки файла
    public static final By CURRENT_ADDRESS_FIELD = By.xpath("//textarea[@placeholder='Current Address']"); // поле ввода Current Address
    public static final By STATE_DROP = By.cssSelector("#state > div > div.css-1wy0on6 > div"); // выбор выпадающего меню State
    public static final By STATE_SELECT = By.xpath("//div/div[@id='react-select-3-option-0']");// выбор State
    public static final By City_DROP = By.cssSelector("#city > div > div.css-1wy0on6 > div > svg");//выбор выпадающего City
    public static final By City_SELECT = By.cssSelector("#react-select-4-option-1"); // выбор City
    public static final By SUBMIT_BUTTON = By.cssSelector("#submit"); // кнопка SUBMIT



    @Step("Открытие страницы")
    public void open(){
        driver.get(URL);
    }

    @Step("Клик по кнопке Forms на стартовой странице")
    public void clickButtonForms(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.findElement(BUTTON_FORMS).click();
    }

    @Step("Клик по кнопке Practice Form")
    public void clickButtonPracticeForm(){
        driver.findElement(BUTTON_PRACTICE_FORM).click();
    }

    @Step("Ввод в поля First Name")
    public String inputFirstName(String firstName){
        driver.findElement(FIRST_NAME_FIELD).clear();
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        return firstName;
    }
    @Step("Ввод в поля Last Name")
    public String inputLastName(String lastName){
        driver.findElement(LAST_NAME_FIELD).clear();
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        return lastName;
    }

    @Step("Ввод в поле Email")
    public String inputEmail(String email){
        driver.findElement(EMAIL_FIELD).clear();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        return email;
    }

    @Step("Ввод в поле Gender")
    public void inputGender(){
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(RADIOBUTTON_GENDER_MALE));
        driver.findElement(RADIOBUTTON_GENDER_MALE).click();
    }

    @Step("Ввод поля Mobile Number")
    public String inputMobNumber(String mobileNumber){
        driver.findElement(MOBILE_NUMBER_FIELD).clear();
        driver.findElement(MOBILE_NUMBER_FIELD).sendKeys(mobileNumber);
        return mobileNumber;
    }

    @Step("Ввод Date of Birth")
    public void inputDateOfBirth(){
        driver.findElement(DATE_OF_BIRTH_FIELD).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(SELECT_MONT_MENU));
        driver.findElement(SELECT_MONT_MENU).click();
        driver.findElement(SELECT_MONT).click();

        driver.findElement(SELECT_YEAR_MENU).click();
        driver.findElement(SELECT_YEAR).click();
        driver.findElement(SELECT_DAY).click();
    }

    @Step("Ввод Subjects")
    public String inputSubjects(String inputSubjects){
        driver.findElement(SUBJECTS_FIELD_FOR_CLICK).click();

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(SUBJECTS_FIELD_FOR_INPUT));

        WebElement inputField = driver.findElement(SUBJECTS_FIELD_FOR_INPUT);
        inputField.sendKeys(inputSubjects);


        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(SUBJECTS_ENGLISH));
        driver.findElement(SUBJECTS_ENGLISH).click();
        return inputSubjects;

    }

    @Step("Выбор Hobbies")
    public void inputHobbies(){
        driver.findElement(HOBBIES_CHECKBOX_SPORTS).click();
    }

    @Step("Выбор Pictures.Upload")
    public String inputPictures(String pathForUploadPicture){
        driver.findElement(FILE_UPLOAD_BUTTON).sendKeys(pathForUploadPicture);
        return pathForUploadPicture;
    }

    @Step("Ввод Current Address")
    public String inputCurrentAddress(String currentAddress){
        driver.findElement(CURRENT_ADDRESS_FIELD).sendKeys(currentAddress);
        return currentAddress;
    }

    @Step("Выбор State")
    public void inputState(){
        WebElement scrollBut = driver.findElement(STATE_DROP);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",scrollBut);
        driver.findElement(STATE_DROP)
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(STATE_SELECT));
        driver.findElement(STATE_SELECT)
                .click();
    }

    @Step("Выбор City")
    public void inputCity(){
        WebElement scrollBut = driver.findElement(City_DROP);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",scrollBut);
        driver.findElement(City_DROP)
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(City_SELECT));
        driver.findElement(City_SELECT)
                .click();
    }

    @Step("Клик по кнопке Submit")
    public void clickSubmitButton(){
        WebElement SubmitBut = driver.findElement(SUBMIT_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", SubmitBut);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    @Step("Сообщение об успешной отправке формы")
    public String getTextOk(){
       WebElement element = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
       String expectedText = element.getText();
       return expectedText;
    }
}
