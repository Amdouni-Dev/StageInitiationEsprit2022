package com.server.server.Service;


import com.server.server.Entity.Order;
import com.server.server.Entity.Notification;
import com.server.server.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import com.server.server.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.core.io.FileSystemResource;
import java.io.File;
import java.util.Optional;
import javax.mail.MessagingException;

@Service
public class NotificationService {
  @Autowired
  NotificationRepository notificationRepository;

  @Autowired
  OrderRepository orderRepository;
  @Autowired private JavaMailSender javaMailSender;

  @Value("${spring.mail.username}") private String sender;

  // Method 1
  // To send a simple email
  public ResponseEntity<Notification> sendSimpleMail(Notification notification, long id_commande)
  {
    if (notification == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    // Try block to check for exceptions
    try {

      // Creating a simple mail message
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      Optional<Order> commande  = orderRepository.findById(id_commande);
      // Setting up necessary details
      mailMessage.setFrom(sender);
      mailMessage.setTo(commande.get().getClient().getEmail());
      mailMessage.setText(notification.getMsgBody());
      mailMessage.setSubject(notification.getSubject());

      // Sending the mail
      javaMailSender.send(mailMessage);
      System.out.println("Mail Sent Successfully...");
    }

    // Catch block to handle the exceptions
    catch (Exception e) {
      System.out.println("Error while Sending Mail") ;
    }
    return ResponseEntity.ok(notification);
  }

  // Method 2
  // To send an email with attachment
  public ResponseEntity<Notification>  sendMailWithAttachment(Notification notification,long id_commande)
  { if (notification == null) {
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    // Creating a mime message
    Optional<Order> commande  = orderRepository.findById(id_commande);
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;

    try {

      // Setting multipart as true for attachments to
      // be send
      mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
      mimeMessageHelper.setFrom(sender);
      mimeMessageHelper.setTo(commande.get().getClient().getEmail());
      mimeMessageHelper.setText(notification.getMsgBody());
      mimeMessageHelper.setSubject(notification.getSubject());

      // Adding the attachment
      FileSystemResource file
              = new FileSystemResource(
              new File(notification.getAttachment()));

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
    return ResponseEntity.ok(notification);
  }
}
