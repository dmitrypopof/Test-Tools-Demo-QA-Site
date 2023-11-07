import com.demoqa.model.MainPageForm;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestWebForm extends BaseTest{

    private final String INPUT_SUBJECTS;// ввод в поле Subjects
    private final String MOBILE_NUMBER;// ввод номера в поле Mobile Number
    private final String FIRST_NAME;// ввод номера в поле First Name
    private final String LAST_NAME; // ввод номера в поле Last Name
    private final String EMAIL;// ввод номера в поле Email
    private final String YEAR;// год рождения
    private final String CURRENT_ADDRESS;// ввод адреса в поле Current Address
    private final String PATH_FOR_UPLOAD_FILE;// путь к файлу для загрузки

    public TestWebForm(String INPUT_SUBJECTS, String MOBILE_NUMBER, String FIRST_NAME, String LAST_NAME, String EMAIL, String YEAR, String CURRENT_ADDRESS, String PATH_FOR_UPLOAD_FILE) {
        this.INPUT_SUBJECTS = INPUT_SUBJECTS;
        this.MOBILE_NUMBER = MOBILE_NUMBER;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.YEAR = YEAR;
        this.CURRENT_ADDRESS = CURRENT_ADDRESS;
        this.PATH_FOR_UPLOAD_FILE = PATH_FOR_UPLOAD_FILE;
    }
    // Получение абсолютного пути к директории проекта
    private static String projectPath = System.getProperty("user.dir");

    // Конвертация относительного пути в абсолютный путь
    private static String relativePath = "src/main/resources/data/test_picture.png";
    private static final String absolutePath = projectPath + "/" + relativePath;

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"English","8002000700","Федор","Достоевский","dostoevsky@mail.com","1992","Санкт-Петербург, Набережная Фонтанки, 103", absolutePath},
        };
    }

    @Test
    @DisplayName("Заполнение формы")
    @Description("Проверка успешной отправки формы")
    public void testForm(){
        MainPageForm page = new MainPageForm(driver);

        page.open();
        page.clickButtonForms();
        page.clickButtonPracticeForm();
        page.inputFirstName(FIRST_NAME);
        page.inputLastName(LAST_NAME);
        page.inputEmail(EMAIL);
        page.inputGender();
        page.inputMobNumber(MOBILE_NUMBER);
        page.inputDateOfBirth(YEAR);
        page.inputSubjects(INPUT_SUBJECTS);
        page.inputHobbies();
        page.inputPictures(PATH_FOR_UPLOAD_FILE);//падение теста
        page.inputCurrentAddress(CURRENT_ADDRESS);
        page.inputState();
        page.inputCity();
        page.clickSubmitButton();
        String expected = "Thanks for submitting the form";
        String actual = page.getTextOk();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);

    }
}
