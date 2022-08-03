package com.server.server.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.server.Entity.Images;
import com.server.server.Entity.Product;
import com.server.server.Repository.ImagesRepository;
import com.server.server.Repository.ProductRepository;
import com.server.server.Repository.PromotionRepository;

@Service
public class ImagesService {

  @Autowired
  ImagesRepository imagesRepository;

  // get images by id-product
  public List<Images> findImagesByProduct_Id(long id_product) {

    return imagesRepository.findAllByProductId(id_product);

  }

}
