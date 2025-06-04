package mocks;

public class MockTicketService {
    private boolean fieldsFilled = false;
    private double enteredPrice = 110.0;
    private double originalPrice = 100.0;
    private String uploadedFileName = "ticket_valid.pdf";
    private String ticketStatus = "active"; // "active" or "expired"

    public boolean areFieldsFilled() {
        return fieldsFilled;
    }

    public void setFieldsFilled(boolean value) {
        this.fieldsFilled = value;
    }

    public void setEnteredPrice(double price) {
        this.enteredPrice = price;
    }

    public double getEnteredPrice() {
        return enteredPrice;
    }

    public void setOriginalPrice(double price) {
        this.originalPrice = price;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setUploadedFileName(String fileName) {
        this.uploadedFileName = fileName;
    }

    public String getUploadedFileName() {
        return uploadedFileName;
    }

    public void setTicketStatus(String status) {
        this.ticketStatus = status;
    }

    public boolean isTicketExpired() {
        return ticketStatus.equals("expired");
    }

    public boolean isPriceTooHigh(double entered, double original) {
        return entered > original * 1.3;
    }

    public boolean isTicketValid(String fileName) {
        return !fileName.contains("invalid");
    }
}
