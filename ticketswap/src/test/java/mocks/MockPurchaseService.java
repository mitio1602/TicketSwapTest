package mocks;

public class MockPurchaseService {

    private boolean isLoggedIn = false;
    private boolean ticketAvailable = true;
    private boolean eventIsActive = true;
    private boolean cardIsValid = true;
    private boolean hasEnoughFunds = true;
    private double ticketPrice = 25.00;

    public void login() {
        isLoggedIn = true;
    }

    public void logout() {
        isLoggedIn = false;
    }

    public void setTicketAvailable(boolean available) {
        this.ticketAvailable = available;
    }

    public void setEventActive(boolean active) {
        this.eventIsActive = active;
    }

    public void setCardValid(boolean valid) {
        this.cardIsValid = valid;
    }

    public void setFundsEnough(boolean enough) {
        this.hasEnoughFunds = enough;
    }

    public void setTicketPrice(double price) {
        this.ticketPrice = price;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean isTicketAvailable() {
        return ticketAvailable;
    }

    public boolean isEventActive() {
        return eventIsActive;
    }

    public boolean isCardValid() {
        return cardIsValid;
    }

    public boolean hasEnoughFunds() {
        return hasEnoughFunds;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean isTransactionValid() {
        return isLoggedIn && ticketAvailable && eventIsActive && cardIsValid && hasEnoughFunds && ticketPrice > 0;
    }
}
