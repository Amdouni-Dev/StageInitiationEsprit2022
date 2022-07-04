package com.server.server.Controller;

import com.server.server.Dto.NotificationDto;
import com.server.server.Dto.ReclamationDto;
import com.server.server.Entity.Notification;
import com.server.server.Entity.Reclamation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.server.server.Service.ReclamationService;

@RequestMapping("/oauth")
@RestController
public class ReclamationController {
  @Autowired
  ReclamationService reclamationService;
  public final static String FOUND = "FOUND";
  public final static String BAD_REQUEST = "BAD_REQUEST";
  public final static String NOT_FOUND = "NOT_FOUND";
  public final static String NULL = "ID NULL DETECTED";


  @Autowired
  private ModelMapper modelMapper;

  // Sending a simple Email
  @PostMapping("/reclmationMail/{id_client}")
  public ResponseEntity<Object> reclamsendMail(@RequestBody ReclamationDto reclamationDto, @PathVariable("id_client") long id_client)
  {
    Reclamation reclReq = modelMapper.map(reclamationDto,Reclamation.class);
    ResponseEntity<Reclamation> reclamation = reclamationService.reclamMail(reclReq,id_client);
    if (reclamation.getStatusCodeValue() == 200) {
      NotificationDto notifRes = modelMapper.map(reclamation.getBody(),NotificationDto.class);
      return new ResponseEntity<>(notifRes, HttpStatus.OK);
    } else if (reclamation.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
    }
  }



  // Sending email with attachment
  @PostMapping("/reclmationMailWithAttachment/{id_client}")
  public ResponseEntity<Object> reclamMailWithAttachment(@RequestBody ReclamationDto reclamationDto, @PathVariable("id_client") long id_client)
  {
    Reclamation reclReq = modelMapper.map(reclamationDto,Reclamation.class);
    ResponseEntity<Reclamation> reclamation = reclamationService.reclamMailAttachement(reclReq,id_client);
    if (reclamation.getStatusCodeValue() == 200) {
      NotificationDto notifRes = modelMapper.map(reclamation.getBody(),NotificationDto.class);
      return new ResponseEntity<>(notifRes, HttpStatus.OK);
    } else if (reclamation.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
    }
  }

}
