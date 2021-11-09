package com.guzman.BeltExam_TvShows.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.guzman.BeltExam_TvShows.models.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface RatingRepository extends CrudRepository<Rating, Long> {

		List <Rating> findAll(); 
	    @Query(value="SELECT Case count(rating) When 0 then 0 else SUM(rating) / count(rating) end \r\n"
	    		+ "From ratings \r\n"
	    		+ "Where tv_show_id = ?1", nativeQuery=true)
	     double getAverage(double tv_show_id);
	    @Modifying
	    @Query (value="Insert INTO ratings (created_at, rating, updated_at, tv_show_id, user_id)\r\n"
	    		+ "value (NOW(), ?1, NOW(), ?2, ?3)", nativeQuery=true)
	    double save(double rate, Long tv_show_id, Long currentUserId);
}
