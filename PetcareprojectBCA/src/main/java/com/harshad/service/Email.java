package com.harshad.service;
import javax.mail.MessagingException;
public interface Email {
    public void sendOtpMessage(String to, String subject, String message) throws MessagingException;
    
}
