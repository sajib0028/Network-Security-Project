package com.login.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.login.service.LoginService;
import com.login.service.Logininfo;

import entity.Client;
import entity.ClinetEntity;
import entity.Notification;

import com.login.nodatabase.JDBCClient;
import entity.Activity;
import entity.ActivityEntity;
import com.login.nodatabase.JDBCActivity;

import entity.Activity1;
import entity.ActivityEntity1;
import com.login.nodatabase.JDBCActivity1;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
//
//        boolean isValidUser = service.validateUser(name, password);
//        boolean isValidAdmin = service.validateadmin(name, password);
//
//        if (isValidAdmin) {
//            
//            return "AdminDashboard";
//        } else if (isValidUser) {
//        	return "ClientDashboard";
//        }
//
//        if(!isValidUser || !isValidAdmin) {
//        	model.put("errorMessage", "Invalid Credentials");
//        	System.out.println(name + password);
//        	return "login";
//        }
//        
//        model.put("error message", "Invalid Credentials");
//
//
//        return "login";
//    }
    
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		int isValidUser = service.validateUser(name, password);

		if (isValidUser == 3) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		model.put("name", name);
		model.put("password", password);

		if (isValidUser == 1) {
			return "ClientDashboard";
		} else {
			return "AdminDashboard";
		}
	}
    
    
    
//    @GetMapping(value="/forgot-password")
//    public String showForgotPage (ModelMap model) {
//    return "forgot-password";
//      
//    }
    
    
    @GetMapping(value="/activity")
    public String showActivityPage (ModelMap model) throws ClassNotFoundException, SQLException {
    	List<Notification> abcd= Logininfo.loginfo();
        model.addAttribute("abcd", abcd);
    return "ManageActivity";
      
    }
//    @GetMapping(value="/client")
//    public String showclinetPage (ModelMap model) {
//    return "client_details";
//      
//    }
    @RequestMapping("/client")
    public String viewclients(@ModelAttribute(name = "client") Client u, Model model) throws SQLException, ClassNotFoundException {
        List<ClinetEntity> list= JDBCClient.getallclient();
        model.addAttribute("list", list);
        return "/client_details";
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ModelAndView addclient (@ModelAttribute(name = "client") Client u, Model model) throws SQLException, ClassNotFoundException {
        System.out.println("Added Successfully");
        JDBCClient.save(u);
        return new ModelAndView(new RedirectView("/client"));
    }

    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addclient1 (@ModelAttribute(name = "register") Client u, Model model) throws SQLException, ClassNotFoundException {
        System.out.println("Register Successfully");
        JDBCClient.save(u);
        return new ModelAndView(new RedirectView("/register"));
    }

    
//    @GetMapping(value="/brainstorm")
//    public String showbrainstormPage (ModelMap model) {
//    return "AddBrainstorm";
//      
//    }
    
    
    @RequestMapping("/brainstorm")
    public String viewactivity(@ModelAttribute(name = "brainstorm") Activity u, Model model) throws SQLException, ClassNotFoundException {
        List<ActivityEntity> list= JDBCActivity.getallclient();
        model.addAttribute("list", list);
        return "/AddBrainstorm";
    }
    @RequestMapping(value = "/brainstorm", method = RequestMethod.POST)
    public ModelAndView addactivity (@ModelAttribute(name = "brainstorm") Activity u, Model model) throws SQLException, ClassNotFoundException {
        System.out.println("Added Successfully");
        JDBCActivity.save(u);
        return new ModelAndView(new RedirectView("/brainstorm"));
    }
    
    
    @RequestMapping(value="/deleteactivity/{Id}",method = RequestMethod.GET)
    public ModelAndView deleteActivity(@PathVariable int Id) throws SQLException, ClassNotFoundException {
    	System.out.println("Deleted Successfully");
        JDBCActivity.delete(Id);
        
        return new ModelAndView(new RedirectView("/brainstorm"));
    }
    
    
    
    
    @RequestMapping(value="/deleteclient/{Id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int Id) throws SQLException, ClassNotFoundException {
    	System.out.println("Deleted Successfully");
        JDBCClient.delete(Id);
        
        return new ModelAndView(new RedirectView("/client"));
    }
    @RequestMapping(value="/editclient/{Id}",method = RequestMethod.GET)
    public ModelAndView updated(@PathVariable Client Id) throws SQLException, ClassNotFoundException {
    	System.out.println("Deleted Successfully");
        JDBCClient.update(Id);
        
        return new ModelAndView(new RedirectView("/client"));
    }
    
    @GetMapping(value="/admin-dashboard")
    public String shoadminPage (ModelMap model) {
    return "AdminDashboard";
      
    }
    
    @GetMapping(value="/ClientDashboard")
    public String shoclientPage (ModelMap model) {
    return "ClientDashboard";
      
    }
    
    @RequestMapping("/activityclient")
    public String viewactivityc(@ModelAttribute(name = "activityclient") Activity1 u, Model model) throws SQLException, ClassNotFoundException {
    	System.out.println("shown Successfully");
        List<ActivityEntity1> list= JDBCActivity1.getallclient1();
        model.addAttribute("list", list);
        return "ActivityClient";
    }
    
    @RequestMapping(value = "/activityclient", method = RequestMethod.POST)
    public ModelAndView addactivity(@ModelAttribute(name = "activityclient") Activity1 u, Model model) throws SQLException, ClassNotFoundException {
        System.out.println("Added Successfully");
        JDBCActivity1.save(u);
        return new ModelAndView(new RedirectView("/activityclient"));
    }
    
    @GetMapping(value="/invitation")
    public String shoinvitationPage (ModelMap model) {
    return "invitation";
      
    }
    @GetMapping(value="/register")
    public String showregesternPage (ModelMap model) {
    return "register";
      
    }

 
}
