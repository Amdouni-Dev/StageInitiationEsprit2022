package com.server.server.Service;

import com.server.server.Entity.Client;

import com.server.server.Entity.Reclamation;
import com.server.server.Repository.ClientRepository;

import com.server.server.Repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Optional;

@Service
public class ReclamationService {
    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired private JavaMailSender javaMailSender;

    /*@Value("${spring.mail.username}") private String sender;*/

    // Method 1
    // To send a simple email
    public ResponseEntity<Reclamation> reclamMail(Reclamation reclamation, long id_client)
    {
        if (reclamation == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            Optional<Client> client  = clientRepository.findById(id_client);
            // Setting up necessary details
            mailMessage.setFrom(client.get().getEmail());
            mailMessage.setTo("benrjebferiel@gmail.com");
            mailMessage.setText(reclamation.getMsgBody());
            mailMessage.setSubject(reclamation.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            System.out.println("Mail Sent Successfully...");
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            System.out.println("Error while Sending Mail") ;
        }
        return ResponseEntity.ok(reclamation);
    }

    // Method 2
    // To send an email with attachment
    public ResponseEntity<Reclamation> reclamMailAttachement (Reclamation reclamation,long id_client)
    { if (reclamation == null) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        // Creating a mime message
        Optional<Client> client  = clientRepository.findById(id_client);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(client.get().getEmail());
            mimeMessageHelper.setTo("benrjebferiel@gmail.com");
            mimeMessageHelper.setText(reclamation.getMsgBody());
            mimeMessageHelper.setSubject(reclamation.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(reclamation.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            System.out.println("Mail Sent Successfully...");
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            System.out.println("Error while Sending Mail") ;
        }
        return ResponseEntity.ok(reclamation);
    }

}
