package com.server.server.Controller;


import com.server.server.Dto.NotificationDto;

import com.server.server.Entity.Notification;

import com.server.server.Service.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RequestMapping("/oauth")
@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    public final static String FOUND = "FOUND";
    public final static String BAD_REQUEST = "BAD_REQUEST";
    public final static String NOT_FOUND = "NOT_FOUND";
    public final static String NULL = "ID NULL DETECTED";


    @Autowired
    private ModelMapper modelMapper;

    // Sending a simple Email
    @PostMapping("/sendMail/{id_commande}")
    public ResponseEntity<Object> sendMail(@RequestBody NotificationDto notificationDto,@PathVariable("id_commande") long id_commande)
    {
        Notification notifReq = modelMapper.map(notificationDto,Notification.class);
        ResponseEntity<Notification> notification = notificationService.sendSimpleMail(notifReq,id_commande);
        if (notification.getStatusCodeValue() == 200) {
            NotificationDto notifRes = modelMapper.map(notification.getBody(),NotificationDto.class);
            return new ResponseEntity<>(notifRes, HttpStatus.OK);
        } else if (notification.getStatusCodeValue() == 400) {
            return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
        }
    }



    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment/{id_commande}")
    public ResponseEntity<Object> sendMailWithAttachment(@RequestBody NotificationDto notificationDto,@PathVariable("id_commande") long id_commande)
    {  Notification notifReq = modelMapper.map(notificationDto,Notification.class);
        ResponseEntity<Notification> notification = notificationService.sendMailWithAttachment(notifReq,id_commande);
        if (notification.getStatusCodeValue() == 200) {
            NotificationDto notifRes = modelMapper.map(notification.getBody(),NotificationDto.class);
            return new ResponseEntity<>(notifRes, HttpStatus.OK);
        } else if (notification.getStatusCodeValue() == 400) {
            return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
        }

    }

}
