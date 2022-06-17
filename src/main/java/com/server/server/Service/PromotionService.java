package com.server.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.server.Repository.PromotionRepository;

@Service
public class PromotionService {
  @Autowired
  PromotionRepository promotionRepository;
}
