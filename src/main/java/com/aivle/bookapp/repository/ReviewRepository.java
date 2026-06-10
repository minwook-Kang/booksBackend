package com.aivle.bookapp.repository;

import com.aivle.bookapp.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}