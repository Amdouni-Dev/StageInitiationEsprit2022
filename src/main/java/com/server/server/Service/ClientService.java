package com.server.server.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.server.server.Entity.Client;
import com.server.server.Entity.Employee;
import com.server.server.Entity.Promotion;
import com.server.server.Repository.ClientRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class ClientService {

  @Autowired
  ClientRepository clientRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JavaMailSender mailSender;



  public ResponseEntity<Client> register(Client client) throws UnsupportedEncodingException, MessagingException {
    if (client == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Optional<Client> existingUser = clientRepository.findByEmail(client.getEmail());
    if (existingUser.isPresent()) {
      return new ResponseEntity<>(HttpStatus.FOUND);
    }
    if (client.getEmail() == null || client.getPassword() == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
      String encodedPassword = passwordEncoder.encode(client.getPassword());
      client.setPassword(encodedPassword);

      String randomCode = RandomString.make(64);
      client.setVerificationCode(randomCode);
      client.setEnabled(false);
      clientRepository.save(client);
      sendVerificationEmail(client);
      return ResponseEntity.ok(client);
    }
  }


  private void sendVerificationEmail(Client client) throws MessagingException, UnsupportedEncodingException {

    String toAddress = client.getEmail();
    String fromAddress = "c2oufcompte@gmail.com";
    String senderName = "C2ouf.com";
    String subject = "Please verify your registration";
    String content = "Dear Mr/Madame,<br>"
        + "Please click the link below to verify your registration:<br>"
        + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
        + "Thank you,<br>"
        + "C2ouf.com";

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    helper.setFrom(fromAddress, senderName);
    helper.setTo(toAddress);
    helper.setSubject(subject);

    String verifyURL = "http://localhost:4200/verify?code=" + client.getVerificationCode();

    content = content.replace("[[URL]]", verifyURL);

    helper.setText(content, true);

    mailSender.send(message);

    System.out.println("Email has been sent");
  }


  public ResponseEntity<Client> verify(String verificationCode) {
    if (verificationCode == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Optional<Client> client = clientRepository.findByVerificationCode(verificationCode);

    if (client.isPresent()) {
      client.get().setVerificationCode(null);
      client.get().setEnabled(true);
      clientRepository.save(client.get());
      return ResponseEntity.ok(client.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

  public boolean existsEmail(String email) {

    return clientRepository.existsByEmail(email);
  }


  //get client by id
  public ResponseEntity<Client> getClient(long id) {
    Optional<Client> optionalClient = clientRepository.findById(id);
    if (optionalClient.isPresent()) {
      return ResponseEntity.ok(optionalClient.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  //update client profile
  public ResponseEntity<Client> editProfileClient(long id, Client client) {
    if (client == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Optional<Client> optionalClient = clientRepository.findById(id);
    if (optionalClient.isPresent()) {
      client.setId(id);
      String encodedPassword = passwordEncoder.encode(client.getPassword());
      client.setPassword(encodedPassword);
      clientRepository.save(client);
      return ResponseEntity.ok(optionalClient.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }



}

