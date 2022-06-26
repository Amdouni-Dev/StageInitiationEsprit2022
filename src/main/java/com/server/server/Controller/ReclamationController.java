package com.server.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.server.Service.ReclamationService;

@RequestMapping("/oauth")
@RestController
public class ReclamationController {
  @Autowired
  ReclamationService reclamationService;
}
