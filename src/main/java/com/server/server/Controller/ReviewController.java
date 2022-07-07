package com.server.server.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.server.Dto.ReviewDto;
import com.server.server.Entity.Review;
import com.server.server.Service.ReviewService;


@RequestMapping("/oauth")
@RestController
public class ReviewController {

  public final static String FOUND = "FOUND";
  public final static String BAD_REQUEST = "BAD_REQUEST";
  public final static String NOT_FOUND = "NOT_FOUND";
  public final static String NULL = "ID NULL DETECTED";

  @Autowired
  private ReviewService reviewService;
  @Autowired
  private ModelMapper modelMapper;

  // insert Review ( for note or  comment)
  @PostMapping("/addReview/{id_product}/{id_client}")
  public ResponseEntity<Object> addReview(@RequestBody ReviewDto reviewDto, @PathVariable("id_product") long id_product, @PathVariable("id_client") long id_client) {
    Review reviewReq = modelMapper.map(reviewDto, Review.class);
    ResponseEntity<Review> review = reviewService.addReview(reviewReq,id_product,id_client);
    if (review.getStatusCodeValue() == 200) {
      ReviewDto avisRes = modelMapper.map(review.getBody(), ReviewDto.class);
      return new ResponseEntity<>(avisRes, HttpStatus.OK);
    } else if (review.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
    }
  }


// delete Review By id_product
  @DeleteMapping(value = "/deleteReviewByProduct/{id_product}")
  public  void deleteReviewByProduct(@PathVariable("id_product") long id_product) {

    reviewService.deleteReviewByProduct(id_product);

  }


  // delete Review By id_product AND id_client
  @DeleteMapping(value = "/deleteReviewByProductAndClient/{id_product}/{id_client}")
  public  void deleteReviewByProductAndClient(@PathVariable("id_product") long id_product,@PathVariable("id_client") long id_client) {

    reviewService.deleteReviewByProductAndClient(id_product,id_client);
  }


}
