package com.mailservice.controller;

import com.mailservice.dto.EmailMessageDto;
import com.mailservice.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/mailcontroller")
public class MailController {

    @Autowired
    MailService mailService;
    /**
     * The Logger
     */
    final Logger logger = LoggerFactory.getLogger(MailController.class);

    @PostMapping(value="/send")
    public String sendEmail(@RequestBody EmailMessageDto emailmessage) throws IOException, MessagingException {
        logger.info("sendEmail is started ");
        mailService.sendmail(emailmessage);
        logger.info("sendEmail is end ");
        return "Email sent successfully Please Activate you account";
    }
}
