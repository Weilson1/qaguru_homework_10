package ru.mail.galyavievai.test;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
        SelenideElement
            firstNameType = $("#firstName"),
            lastNameType = $("#lastName"),
            userEmailType = $("#userEmail"),
            userNumberType = $("#userNumber"),
            subjectType = $("#subjectsInput"),
            hobbiesType = $("#hobbiesWrapper"),
            uploadPictureType = $("#uploadPicture"),
            addressType = $("#currentAddress"),
            stateType = $("#stateCity-wrapper"),
            cityType = $("#stateCity-wrapper"),
            resultTable = $(".table-responsive");


    @Step ("Отркываем страницу с Practice Form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }
    @Step ("Вводим имя")
    public RegistrationPage inputFirstName(String value) {
        firstNameType.setValue(value);
        return this;
    }
    @Step ("Вводим фамилию")
    public RegistrationPage inputLastName(String value) {
        lastNameType.setValue(value);

        return this;
    }
    @Step ("Вводим Email")
    public RegistrationPage inputUserEmail(String value) {
        userEmailType.setValue(value);

        return this;
    }

    @Step ("Выбираем пол")
    public RegistrationPage inputGenderMale() {
        $("[for=gender-radio-1]").click();

        return this;
    }

    @Step ("Выбираем пол")
    public RegistrationPage inputGenderFemale() {
        $("[for=gender-radio-2]").click();

        return this;
    }

    @Step ("Выбираем пол")
    public RegistrationPage inputGenderOther() {
        $("[for=gender-radio-3]").click();

        return this;
    }

    @Step ("Вводим номер телефона")
    public RegistrationPage inputUserNumber(String value) {
        userNumberType.setValue(value);

        return this;
    }

    @Step("Выбирем в календаре дату рождения")
    public RegistrationPage setDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datapicker__day--outside-month)").click();
        return new RegistrationPage();
    }

    @Step("Выбираем изучаемые предметы")
    public RegistrationPage inputSubject(String value) {
        subjectType.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage inputHobbies(String value) {
        hobbiesType.$(byText(value)).click();

        return this;
    }
    @Step("Загружаем картинку")
    public RegistrationPage uploadPicture(String value) {
        uploadPictureType.uploadFromClasspath("img/1.png");

        return this;
    }
    @Step("Вводим адрес жительства")
    public RegistrationPage inputAddress(String value) {
        addressType.setValue(value).scrollTo();

        return this;
    }
    @Step("Выбираем штат проживания")
    public RegistrationPage inputState(String value) {
        $("#state").click();
        stateType.$(byText(value)).click();

        return this;
    }

    @Step("Кликаем Submit")
    public RegistrationPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    @Step("Проверяем открылась ли форма с данными")
    public RegistrationPage checkForm () {
        $(byText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    @Step("Выбираем город проживания")
    public RegistrationPage inputCity(String value) {
        $("#city").click();
        cityType.$(byText(value)).click();

        return this;
    }
    @Step("Проверяем {value}")
    public RegistrationPage checkResult(String value){
        resultTable.shouldHave(text(value));

        return this;
}
}

