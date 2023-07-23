import com.demoqa.model.MainPageForm;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

@RunWith(Parameterized.class)
public class TestWebForm {
    private WebDriver driver;

    private final String INPUT_SUBJECTS;// ввод в поле Subjects
    private final String MOBILE_NUMBER;// ввод номера в поле Mobile Number
    private final String FIRST_NAME;// ввод номера в поле First Name
    private final String LAST_NAME; // ввод номера в поле Last Name
    private final String EMAIL;// ввод номера в поле Email
    private final String CURRENT_ADDRESS;// ввод адреса в поле Current Address
    private final String PATH_FOR_UPLOAD_FILE;// путь к файлу для загрузки

    public TestWebForm(String INPUT_SUBJECTS, String MOBILE_NUMBER, String FIRST_NAME, String LAST_NAME, String EMAIL, String CURRENT_ADDRESS, String PATH_FOR_UPLOAD_FILE) {
        this.INPUT_SUBJECTS = INPUT_SUBJECTS;
        this.MOBILE_NUMBER = MOBILE_NUMBER;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.CURRENT_ADDRESS = CURRENT_ADDRESS;
        this.PATH_FOR_UPLOAD_FILE = PATH_FOR_UPLOAD_FILE;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"English","8002000700","Федор","Достоевский","dostoevsky@mail.com","Санкт-Петербург, Набережная Фонтанки, 103","C:\\Users\\dmitr\\IdeaProjects\\ATOLLis\\Site-demo-qa\\src\\main\\resources\\test_picture.png"},
        };
    }

    @Test
    @DisplayName("Заполнение формы")
    @Description("Проверка успешной отправки формы")
    public void testForm(){
        ChromeDriverService service = new ChromeDriverService.Builder() // исправление  getLogOutput INFO: Driver logs no longer sent to console by default error using Selenium Java
                .withLogOutput(System.out) // вывод логов в консоль
                //.withLogLevel(ChromiumDriverLogLevel.INFO) // указываем уровень журнала ALL,INFO,DEBUG
                .build();

        driver = new ChromeDriver(service);
        driver.manage().window().setSize(new Dimension(1920,1080)); //

        MainPageForm page = new MainPageForm(driver);

        page.open();
        page.clickButtonForms();
        page.clickButtonPracticeForm();
        page.inputFirstName(FIRST_NAME);
        page.inputLastName(LAST_NAME);
        page.inputEmail(EMAIL);
        page.inputGender();
        page.inputMobNumber(MOBILE_NUMBER);
        page.inputDateOfBirth();
        page.inputSubjects(INPUT_SUBJECTS);
        page.inputHobbies();
        page.inputPictures(PATH_FOR_UPLOAD_FILE);
        page.inputCurrentAddress(CURRENT_ADDRESS);
        page.inputState();
        page.inputCity();
        page.clickSubmitButton();
        String expected = "Thanks for submitting the form";
        String actual = page.getTextOk();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);

    }

    @After
    public void setEnd(){
        driver.quit();
    }
}
