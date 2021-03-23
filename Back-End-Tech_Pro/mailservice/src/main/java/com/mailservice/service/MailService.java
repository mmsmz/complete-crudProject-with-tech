package com.mailservice.service;

import com.mailservice.dto.EmailMessageDto;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@Service
public interface MailService {
     void sendmail(EmailMessageDto emailmessage) throws AddressException, MessagingException, IOException;
}