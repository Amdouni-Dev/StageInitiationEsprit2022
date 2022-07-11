package com.server.server.Service;

import java.sql.Timestamp;
import java.util.Optional;

import com.server.server.Entity.Product;
import com.server.server.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.server.server.Entity.Review;
import com.server.server.Entity.Client;
import com.server.server.Repository.ReviewRepository;
import com.server.server.Repository.ClientRepository;


@Service
public class ReviewService {
  @Autowired
  ReviewRepository reviewRepository;
  @Autowired
  ClientRepository clientRepository;

  @Autowired
  ProductRepository productRepository;


  // get Review by id-client
  public ResponseEntity<Review> findByClientId(long id_client) {

    Optional<Review> optionalReview = reviewRepository.getReviewByClientId(id_client);

    if (optionalReview.isPresent()) {
      return ResponseEntity.ok(optionalReview.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // get Review by id-product
  public ResponseEntity<Review> findByProduct_Id(long id_product) {

    Optional<Review> optionalReview = reviewRepository.findByProduct_Id(id_product);

    if (optionalReview.isPresent()) {
      return ResponseEntity.ok(optionalReview.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  //insert Review ( for note or comment )
  public ResponseEntity<Review> addReview(Review review, long id_product, long id_client) {
    if (review == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Optional<Client> client = clientRepository.findById(id_client);
    Optional<Product> product = productRepository.findById(id_product);

    // set columns
    review.setDate_review(new Timestamp(System.currentTimeMillis()));
    review.setProduct(product.get());
    review.setClient(client.get());
    reviewRepository.save(review);
    return ResponseEntity.ok(review);

  }


  // delete  review by idProduct

  public void deleteReviewByProduct(long id_product) {

    reviewRepository.deleteReviewByProduct(id_product);
  }

  // delete  review by idProduitANDidClient
  public void deleteReviewByProductAndClient(long id_product,long id_client) {
   reviewRepository.deleteReviewByProductAndClient(id_product,id_client);
 }



}
