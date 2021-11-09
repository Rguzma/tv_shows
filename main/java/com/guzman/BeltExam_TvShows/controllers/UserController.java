package com.guzman.BeltExam_TvShows.controllers;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guzman.BeltExam_TvShows.models.Rating;
import com.guzman.BeltExam_TvShows.models.TvShow;
import com.guzman.BeltExam_TvShows.models.User;
import com.guzman.BeltExam_TvShows.services.AppServices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;


@Controller
public class UserController {
	
private final AppServices appServices;
	
	public UserController( AppServices appServices ) {
		this.appServices = appServices;
	}
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String index(@ModelAttribute("newuser")User user, @ModelAttribute("login")User login) {
		return "Index.jsp";
	}
	
	@RequestMapping("/list/tvShows")
	public String toHome( Model model) {
		List<TvShow> tvShowList = appServices.findAllTvShows();
		List<Rating> ratingList = appServices.findAllRating();
		
		for (TvShow tvs : tvShowList)
		{
			double average = appServices.findAverage(tvs.getTvShow_id()); 
			
			tvs.setRating(average);
		}
		
		
		model.addAttribute("tvShows", tvShowList);
		model.addAttribute("ratings", ratingList);
		return "Home.jsp";
	}
	
	@RequestMapping(value = "/register/user" , method = RequestMethod.POST )
	public String createUser(@ModelAttribute ("newuser") User user, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
            return "/";
        } else {
            appServices.createUser(user);
            return "redirect:/list/tvShows";
        }

	 }
	
	
	@RequestMapping(value = "/create/show" , method = RequestMethod.GET )
	public String createShow(@ModelAttribute ("newTvShow") TvShow tvShow) {
		return "CreateNewTvShow.jsp";	
	}
	
	@RequestMapping(value = "/create/show" , method = RequestMethod.POST )
	public String createShow(@ModelAttribute ("newTvShow") TvShow tvShow, BindingResult result) {
		if (result.hasErrors()) {
            return "/";
        } else {
            appServices.createTvShow(tvShow);
            return "redirect:/list/tvShows";
        }

	 }
	
	@RequestMapping(value = "/validate/user" , method = RequestMethod.POST )
	public String login(@ModelAttribute ("login") User user, BindingResult result, HttpSession session) {
		List<User> users = appServices.getUserByEmail(user.getEmail());
		if( users.size() == 0 ) {

			return "redirect:/";
		}
		else {
				User currentUser = users.get(0);
			
			 
				session.setAttribute( "userName", currentUser.getUser() );
				session.setAttribute( "userId", currentUser.getUser_id() );
				return "redirect:/list/tvShows";
			}

		}
	 

	
	@RequestMapping(value = "/details/show/{tv_show_id}" , method = RequestMethod.GET )
	public String detailsShow(@PathVariable("tv_show_id")Long id, Model model, @ModelAttribute ("rate") double rate) {
		List<User>usersAndRates = appServices.findUsersRates(id);
		TvShow tvs = appServices.findTvShowsById(id);
		model.addAttribute("users", usersAndRates);		
		model.addAttribute("tvs", tvs);
		return "DetailsShow.jsp";	
	}
	
	@RequestMapping(value = "/add/rate/{tv_show_id}" , method = RequestMethod.POST )
	public String detailsShow(@ModelAttribute ("rate") double rate, @RequestParam("tv_show_id")Long tv_show_id, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
            return "/details/show/{tv_show_id}";
        } else {
        	
        	Long currentUserId = Long.parseLong(session.getAttribute("userId").toString());
            appServices.addRating(rate, tv_show_id, currentUserId );
            return "redirect:/list/tvShows";
        }

	 }
	
//	@RequestMapping( value = "/details/show/{tv_show_id}", method = RequestMethod.GET )
//	public String prueba(@ModelAttribute("tv_show_id")User id, @ModelAttribute("rate")User login) {
//		return "DetailsShow.jsp";
//	}
//	
}


