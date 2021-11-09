package com.guzman.BeltExam_TvShows.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.guzman.BeltExam_TvShows.models.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface TvShowRepository extends CrudRepository<TvShow, Long> {

	TvShow save(TvShow tvShow);
	List <TvShow> findAll();
	
	@Query(value="select t.tv_show_id, t.title, t.network, t.created_at, t.updated_at, r.rating from tv_shows t inner join ratings r on t.tv_show_id = r.tv_show_id where t.tv_show_id = ?1",  nativeQuery=true)
	TvShow findTvShowById(Long id);
	
}