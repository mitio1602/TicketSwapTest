package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import mocks.MockPurchaseService;

public class PokupkaStepDefs {

    MockPurchaseService service = new MockPurchaseService();

    @Given("че потребителят е влязъл в системата")
    public void potrebitelVlezal() {
        service.login();
    }

    @Given("че съществува билет с наличност")
    public void sushtestvuvaBiletSNalichnost() {
        service.setTicketAvailable(true);
    }

    @When("потребителят избере билет и потвърди покупка")
    public void potrebitelqtIzbereBiletIPotvardi() {
        if (!service.isLoggedIn()) {
            System.out.println("Грешка: Не сте влезли в системата.");
        } else if (!service.isTicketAvailable()) {
            System.out.println("Грешка: Билетът вече е продаден.");
        } else if (!service.isEventActive()) {
            System.out.println("Грешка: Събитието вече е минало.");
        } else if (!service.isCardValid()) {
            System.out.println("Грешка: Невалидни картови данни.");
        } else if (!service.hasEnoughFunds()) {
            System.out.println("Грешка: Недостатъчна сума по картата.");
        } else if (service.getTicketPrice() <= 0) {
            System.out.println("Грешка: Цена на билета невалидна.");
        } else {
            System.out.println("Покупката е успешна!");
        }
    }

    @Then("системата трябва да регистрира покупката")
    public void sistemataRegistriraPokupkata() {
        System.out.println("Транзакцията е записана.");
    }

    @Then("да добави билета в профила му")
    public void dobavqBiletaVProfila() {
        System.out.println("Билетът е добавен в профила.");
    }


    @Given("че билетът вече е продаден")
    public void biletutVecheProdaden() {
        service.setTicketAvailable(false);
    }

    @When("потребител се опита да го закупи")
    public void potrebitelSeOpitvaDaKupuva() {
        System.out.println("Потребител се опитва да закупи билет.");
    }

    @Then("системата трябва да покаже съобщение за грешка")
    public void sistemataPokazvaGreshka() {
        System.out.println("Билетът вече не е наличен.");
    }

    @Given("че потребителят не е влязъл в системата")
    public void potrebitelNeEVlezal() {
        service.logout();
    }

    @When("се опита да закупи билет")
    public void opitZaPokupkaBezVhod() {
        System.out.println("Покупка без вход.");
    }

    @Then("системата трябва да го пренасочи към страницата за вход")
    public void preprashtaneKumVhod() {
        System.out.println("Пренасочване към login страницата.");
    }

    @Given("че събитието за избрания билет вече е минало")
    public void subitietoVecheEMinalo() {
        service.setEventActive(false);
    }

    @When("потребителят се опита да закупи билета")
    public void potrebitelSeOpitvaDaKupiMinatBilet() {
        System.out.println("Опит за покупка на просрочен билет.");
    }

    @Then("системата трябва да откаже покупката и да покаже съобщение")
    public void otkazPokupkaZaMinatoSubitie() {
        System.out.println("Събитието вече е приключило.");
    }

    @Given("че потребителят е въвел валидни картови данни")
    public void validniKartoviDanni() {
        service.setCardValid(true);
    }

    @Given("наличната сума по картата е по-малка от цената на билета")
    public void nqmaDostatuchnoSredstva() {
        service.setFundsEnough(false);
    }

    @When("се опита да извърши транзакция")
    public void opitZaTransakcia() {
        System.out.println("Опит за транзакция...");
    }

    @Then("системата трябва да откаже покупката и да покаже съобщение за отказана трансакция")
    public void pokazvaOtkazTransakcia() {
        System.out.println("Трансакцията е отказана – недостатъчно средства.");
    }

    @Given("че потребителят е въвел невалидни картови данни")
    public void greshniKartoviDanni() {
        service.setCardValid(false);
    }

    @Then("системата трябва да откаже покупката")
    public void otkazvaPokupkata() {
        System.out.println("Покупката е отказана.");
    }

    @Then("да го върне обратно към формата за въвеждане на данни")
    public void vurhstaKumForma() {
        System.out.println("Връщане към формата за картови данни.");
    }

    @Given("че избраният билет има стойност 0 поради грешка")
    public void biletSNullCena() {
        service.setTicketPrice(0.0);
    }

    @When("потребителят се опита да го закупи")
    public void pokupkaBiletSCenaNula() {
        System.out.println("Опит за покупка на билет със стойност 0.");
    }

    @Then("системата трябва да откаже покупката и да уведоми администратора")
    public void otkazvaIPratiNaAdmina() {
        System.out.println("Администраторът е уведомен за грешката със стойността.");
    }

}