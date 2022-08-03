package com.server.server.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.server.Dto.ImagesDto;
import com.server.server.Dto.ProductDto;
import com.server.server.Service.ImagesService;
import com.server.server.Service.ProductService;

@RequestMapping("/oauth")
@RestController
public class ImagesController {
  @Autowired
  ImagesService imagesService;

  @Autowired
  private ModelMapper modelMapper;

  // get Product by id-category
  @GetMapping(value = "/findImagesByProduct_Id/{id_product}")
  public List<ImagesDto> findImagesByProduct_Id(@PathVariable("id_product") long id_product) {
    return imagesService.findImagesByProduct_Id(id_product).stream().map(image -> modelMapper.map(image, ImagesDto.class))
        .collect(Collectors.toList());
  }
}
