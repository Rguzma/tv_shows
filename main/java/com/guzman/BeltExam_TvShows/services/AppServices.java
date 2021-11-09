package com.guzman.BeltExam_TvShows.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.guzman.BeltExam_TvShows.models.*;
import com.guzman.BeltExam_TvShows.repositories.TvShowRepository;
import com.guzman.BeltExam_TvShows.repositories.UserRepository;
import com.guzman.BeltExam_TvShows.repositories.RatingRepository;


@Service
public class AppServices {
	
    private final UserRepository userRepository;
    private final TvShowRepository tvShowRepository;
    private final RatingRepository ratingRepository;
    
    public AppServices (UserRepository userRepository, TvShowRepository tvShowRepository, RatingRepository ratingRepository) {
        this.userRepository = userRepository;
        this.tvShowRepository = tvShowRepository;
        this.ratingRepository = ratingRepository;
        
    }
	
	public User createUser(User user ) {
		return userRepository.save(user);
	}
	
	public List <User> findAllUsers(){
		return userRepository.findAll();
	}
	public List <User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List <Rating> findAllRating(){
		return ratingRepository.findAll();
	}
//	public boolean validateUser( User currentUser, String password ) {
//		return BCrypt.checkpw( password, currentUser.getPassword() );
//	}

	public List<TvShow> findAllTvShows() {
		return tvShowRepository.findAll();
	}
	
	public double findAverage(double tv_show_id) {
		return ratingRepository.getAverage(tv_show_id);
	}

	public TvShow createTvShow(TvShow tvShow) {
		return tvShowRepository.save(tvShow);
	}
	public double addRating(double rate, Long tv_show_id, Long currentUserId) {
		return ratingRepository.save(rate, tv_show_id, currentUserId);
	}

	public List<User> findUsersRates(Long id) {
		return userRepository.findUsersRates(id);
	}

	public TvShow findTvShowsById(Long id) {
		return tvShowRepository.findTvShowById(id);
	}
	
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail2(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
}
	
	
}
