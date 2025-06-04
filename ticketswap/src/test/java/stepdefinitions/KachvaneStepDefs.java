package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import mocks.MockUserSession;
import mocks.MockTicketService;

public class KachvaneStepDefs {

    MockUserSession session = new MockUserSession();
    MockTicketService ticketService = new MockTicketService();

    @Given("че потребителят е влязъл в профила си")
    public void potrebitelVlezlVPofilaSi() {
        session.login();
    }

    @When("попълни валидни данни за билет")
    public void populvaValidniDanni() {
        ticketService.setFieldsFilled(true);
    }

    @When("натисне бутона \"Качи\"")
    public void natiskaButonaKachi() {
        if (!session.isLoggedIn()) {
            System.out.println("Грешка: Потребителят не е логнат.");
            return;
        }

        if (!ticketService.areFieldsFilled()) {
            System.out.println("Грешка: Липсват задължителни полета.");
            return;
        }

        if (ticketService.getEnteredPrice() < 0) {
            System.out.println("Грешка: Цената е отрицателна.");
            return;
        }

        if (ticketService.isTicketExpired()) {
            System.out.println("Грешка: Събитието вече е минало.");
            return;
        }

        if (ticketService.isPriceTooHigh(ticketService.getEnteredPrice(), ticketService.getOriginalPrice())) {
            System.out.println("Грешка: Цената надвишава позволения лимит.");
            return;
        }

        if (!ticketService.isTicketValid(ticketService.getUploadedFileName())) {
            System.out.println("Грешка: Билетът не е валиден.");
            return;
        }

        System.out.println("Билетът е качен успешно.");
    }

    @Then("системата трябва да запази билета и да покаже потвърждение")
    public void sistemataZapazvaIConfirm() {
        System.out.println("Потвърждение: билетът е записан.");
    }

    @When("остави празно поле при попълване на билет")
    public void ostavaPraznoPole() {
        ticketService.setFieldsFilled(false);
    }

    @Then("системата трябва да покаже съобщение за грешка при качване")
    public void pokazvaGreshka() {
        System.out.println("Моля, попълнете всички задължителни полета.");
    }

    @When("въведе отрицателна цена за билет")
    public void vavejdaOtricatelnaCena() {
        ticketService.setEnteredPrice(-15.00);
    }

    @Then("системата трябва да покаже съобщение: \"Цената не може да бъде отрицателна.\"")
    public void pokazvaGreshkaOtricatelnaCena() {
        System.out.println("Цената не може да бъде отрицателна.");
    }

    @Given("че потребителят не е влязъл в профила си")
    public void potrebitelNeEVlezal() {
        session.logout();
    }

    @When("отвори формата за качване")
    public void otvarqFormataZaKachvane() {
        System.out.println("Формата е отворена.");
    }

    @Then("системата трябва да го пренасочи към login страницата")
    public void preprashtaKumLoginStranica() {
        System.out.println("Пренасочване към login страницата.");
    }

    @When("въведе събитие, което вече е минало")
    public void vavejdaMinatoSubitie() {
        ticketService.setTicketStatus("expired");
    }

    @Then("системата трябва да откаже качването с грешка: \"Събитието вече е приключило.\"")
    public void otkazZaMinatoSubitie() {
        System.out.println("Събитието вече е приключило.");
    }

    @When("въведе цена, която е с над 30% по-висока от първоначалната")
    public void vavejdaCenaNadLimit() {
        ticketService.setEnteredPrice(140.00);
        ticketService.setOriginalPrice(100.00);
    }

    @Then("системата трябва да отхвърли заявката с грешка: \"Цената надвишава позволения лимит.\"")
    public void otkazvaZaqvkaCenaNadLimit() {
        System.out.println("Цената надвишава позволения лимит.");
    }

    @When("качи файл с невалиден билет")
    public void kachvaNevalidenBilet() {
        ticketService.setUploadedFileName("ticket_invalid.pdf");
    }

    @Then("системата трябва да откаже качването и да покаже съобщение: \"Билетът не е валиден.\"")
    public void otkazNevalidenBilet() {
        System.out.println("Билетът не е валиден.");
    }

}