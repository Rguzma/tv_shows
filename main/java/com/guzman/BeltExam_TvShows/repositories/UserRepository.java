package com.guzman.BeltExam_TvShows.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.guzman.BeltExam_TvShows.models.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	

	User save(User user);
	List <User> findAll();
	List <User> findByEmail(String email);
	
//	@Query(value="select u.user_id, u.user, u.created_at, u.email, u.password, u.updated_at, r.rating from users u inner join ratings r on u.user_id = r.user_id where r.tv_show_id = ?1", nativeQuery=true)
//	List<User> findUsersRated(Long id);
	
	@Query (value= "SELECT \r\n"
			+ "r.rating, r.id, t.title, t.tv_show_id, u.user\r\n"
			+ "FROM ratings r\r\n"
			+ "LEFT JOIN users u\r\n"
			+ "ON u.user_id = r.user_id\r\n"
			+ "LEFT JOIN tv_shows t\r\n"
			+ "ON r.tv_show_id = t.tv_show_id \r\n"
			+ "where t.tv_show_id = ?1", nativeQuery=true)
	List<User> findUsersRates(Long id);
	
	
	    User findByEmail2(String email);
	}
	
}
