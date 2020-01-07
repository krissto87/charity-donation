package krissto87.charity.services;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
