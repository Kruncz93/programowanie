package com.kruncz.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kruncz.spring.dao.ContactDAO;
import com.kruncz.spring.dao.PostDAO;
import com.kruncz.spring.model.Post;
import com.kruncz.spring.model.Users;

@Controller
public class MainController{
	
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private PostDAO postDAO;

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Users newContact = new Users();
		model.addObject("users", newContact);
		model.setViewName("reg");
		return model;
	}
	
	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public ModelAndView savePost(@ModelAttribute Post post) {
		postDAO.save(post);		
		return new ModelAndView("redirect:/forum");
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Users users) {
		contactDAO.save(users);		
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = "/UserPanel**")
	public ModelAndView listPost2(ModelAndView model) throws IOException{
		List<Post> listPost = postDAO.list();
		model.addObject("listPost", listPost);
		model.setViewName("UserPanel");
		
		return model;

	}
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public ModelAndView saveImage(@ModelAttribute Users users) {
		contactDAO.saveImg(users);		
		return new ModelAndView("redirect:/UserPanel");
	}
	
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage1() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Admin page");
		model.addObject("message", "Hello my Master!");
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value="/users**")
	public ModelAndView listUsers(ModelAndView model) throws IOException{
		List<Users> listUsers = contactDAO.list();
		model.addObject("listUsers", listUsers);
		model.setViewName("users");
		
		return model;
	}
	
	
	@RequestMapping(value="/forum")
	public ModelAndView listPost(ModelAndView model) throws IOException{
		List<Post> listPost = postDAO.list();
		model.addObject("listPost", listPost);
		model.setViewName("forum");
		
		return model;
	}
	
	@RequestMapping(value = "/newtext**", method = RequestMethod.GET)
	public ModelAndView post() {
		ModelAndView model = new ModelAndView();
		model.setViewName("newtext");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}

}