package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPage {
    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            number = $("#userNumber"),
            fieldDOB = $("#dateOfBirthInput"),
            monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select"),
            dayOfBirth = $(".react-datepicker__month"),
            subject = $("#subjectsInput"),
            uploadFile = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city");

    public void fillForm(RegistrationFormData formData) {
        step("Открытие ссылки", () ->
                open("https://demoqa.com/automation-practice-form"));
        step("Ввод firstname", () ->
                firstName.val(formData.fn));
        step("Ввод lastname", () ->
                lastName.val(formData.ln));
        step("Ввод email", () ->
                email.val(formData.email));
        step("Выбор пола", () ->
                $(byText(formData.gender)).click());
        step("Ввод телефона", () ->
                number.val(formData.mobile));
        step("Клик по полю даты рождения", () ->
                fieldDOB.click());
        step("Выбор месяца рождения", () ->
                monthOfBirth.selectOption(formData.monthOfBirth));
        step("Выбор года рождения", () ->
                yearOfBirth.selectOption(formData.yearOfBirth));
        step("Выбор даты рождения", () ->
                dayOfBirth.$(byText(formData.dayOfBirth)).click());
        step("Выбор предмета", () ->
                subject.val(formData.subject).pressEnter());
        step("Выбор хобби", () ->
                $(byText(formData.hobby)).click());
        step("Загрузка файла", () ->
                uploadFile.uploadFromClasspath(formData.path + formData.file));
        step("Ввод текущего адреса", () ->
                currentAddress.val(formData.addr));
        step("Скролл до кнопки отправки", () ->
                $("#submit").scrollTo());
        step("Клик по полю штата", () ->
                state.click());
        step("Выбор штата", () ->
                $(byText(formData.state)).click());
        step("Клик по полю города", () ->
                city.click());
        step("Выбор города", () ->
                $(byText(formData.city)).click());
        step("Нажатие на кнопку отправки", () ->
                $("#submit").click());
    }

    public void checkForm(RegistrationFormData formData) {
        step("Проверка отображение таблицы", () ->
                $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")));
        step("Проверка firstname,lastname", () ->
                $x("//td[text()='Student Name']").parent().shouldHave(text(formData.fn + ' ' + formData.ln)));
        step("Проверка email", () ->
                $x("//td[text()='Student Email']").parent().shouldHave(text(formData.email)));
        step("Проверка пола", () ->
                $x("//td[text()='Gender']").parent().shouldHave(text(formData.gender)));
        step("Проверка телефона", () ->
                $x("//td[text()='Mobile']").parent().shouldHave(text(formData.mobile)));
        step("Проверка даты рождения", () ->
                $x("//td[text()='Date of Birth']").parent().shouldHave(text(formData.dayOfBirth + ' ' + formData.monthOfBirth + ',' + formData.yearOfBirth)));
        step("Проверка предметов", () ->
                $x("//td[text()='Subjects']").parent().shouldHave(text(formData.subject)));
        step("Проверка хобби", () ->
                $x("//td[text()='Hobbies']").parent().shouldHave(text(formData.hobby)));
        step("Проверка названия загруженного файла", () ->
                $x("//td[text()='Picture']").parent().shouldHave(text(formData.file)));
        step("Проверка адреса", () ->
                $x("//td[text()='Address']").parent().shouldHave(text(formData.addr)));
        step("Проверка штата и города", () ->
                $x("//td[text()='State and City']").parent().shouldHave(text(formData.state + " " + formData.city)));
    }
}


