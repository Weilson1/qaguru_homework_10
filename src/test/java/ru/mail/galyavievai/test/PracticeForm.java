package ru.mail.galyavievai.test;

import org.junit.jupiter.api.Test;

public class PracticeForm extends TestBase {
    TestDate testDate = new TestDate();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {
        registrationPage
                .openPage()
                .inputFirstName(testDate.randomFirstName)
                .inputLastName(testDate.randomLastName)
                .inputUserEmail(testDate.randomEmail)
                .inputGenderMale()
                .inputUserNumber(testDate.randomPhoneNumber)
                .setDate("09", "2", "1994")
                .inputSubject("Maths")
                .inputSubject("Economics")
                .inputHobbies("Sports")
                .inputHobbies("Reading")
                .uploadPicture("img/1.png")
                .inputAddress(testDate.randomAddress)
                .inputState("NCR")
                .inputCity("Delhi")
                .clickSubmit();


        registrationPage
                .checkForm()
                .checkResult(testDate.randomFirstName + " " + testDate.randomLastName)
                .checkResult(testDate.randomEmail)
                .checkResult("Male")
                .checkResult(testDate.randomPhoneNumber)
                .checkResult("09 March,1994")
                .checkResult("Maths, Economics")
                .checkResult("Sports, Reading")
                .checkResult("1.png")
                .checkResult(testDate.randomAddress)
                .checkResult("NCR Delhi");
    }
}
