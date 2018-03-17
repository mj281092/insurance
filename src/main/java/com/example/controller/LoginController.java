package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Order;
import com.example.model.User;
import com.example.model.Vehicle;
import com.example.service.OrderService;
import com.example.service.UserService;
import com.example.service.VehicleService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value={"/", "/ipHome"}, method = RequestMethod.GET)
	public ModelAndView ipHome(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ipHome");
		return modelAndView;
	}
	
	@RequestMapping(value={"/visitor", "/visitor/home"}, method = RequestMethod.GET)
	public ModelAndView vHome(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("visitor/home");
		return modelAndView;
	}
	


	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getUserEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("userEmail", "error.userEmail",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {

			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}

	
	@RequestMapping(value= {"/admin","/admin/home"}, method = RequestMethod.GET)
	public ModelAndView aHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getUserLastName() + " (" + user.getUserEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value= {"/user","/user/home"}, method = RequestMethod.GET)
	public ModelAndView uHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getUserLastName() + " (" + user.getUserEmail() + ")");
		modelAndView.addObject("userMessage","Content Available Only for Users with access");
		modelAndView.setViewName("user/home");
		return modelAndView;
	}
	
	@RequestMapping(value="/user/vehicleRegistration", method = RequestMethod.GET)
	public ModelAndView vehicleRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		Vehicle vehicle = new Vehicle();;
		modelAndView.addObject("vehicle", vehicle);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getUserLastName() + " (" + user.getUserEmail() + ")");
		modelAndView.setViewName("vehicleRegistration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/vehicleRegistration", method = RequestMethod.POST)
	public ModelAndView createNewVehicle(@Valid Vehicle vehicle, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getUserLastName() + " (" + user.getUserEmail() + ")");
		Vehicle vehicleExists = vehicleService.findVehiclebyRegno(vehicle.getVehicleRegno());
		if (vehicleExists != null) {
			bindingResult
					.rejectValue("vehicleRegExists", "error.vehicle",
							"There is already a vehicle registered with this registration number");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("vehicleRegistration");
		} else {

			vehicleService.saveVehicle(user,vehicle);
			modelAndView.addObject("successMessage", "Vehicle has been registered successfully");
			modelAndView.addObject("vehicle", new Vehicle());
			modelAndView.setViewName("vehicleRegistration");
			
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value="/user/orderPage", method = RequestMethod.GET)
	public ModelAndView orderRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		Order order = new Order();;
		modelAndView.addObject("order", order);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getUserLastName() + " (" + user.getUserEmail() + ")");
		modelAndView.setViewName("orderRegistration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/orderPage", method = RequestMethod.POST)
	public ModelAndView createNewOrder(@Valid Order order,@RequestParam("vRegno") String vRegno, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getUserLastName() + " (" + user.getUserEmail() + ")");
		///////////////////
		/*vehicleExists = vehicleService.findVehiclebyRegno(vehicle.getVehicleRegno());
		if (vehicleExists != null) {
			bindingResult
					.rejectValue("vehicleRegExists", "error.vehicle",
							"There is already a vehicle registered with this registration number");
		}*/
		
		Vehicle vehicleExists = vehicleService.findVehiclebyRegno(vRegno);
		if (vehicleExists == null) {
			bindingResult
					.rejectValue("vRegno", "error.vRegno",
							"There is no vehicle registered with this registration number");
		}
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("orderPage");
		} else {

			orderService.saveOrder(user,order,vehicleExists);
			modelAndView.addObject("successMessage", "Vehicle has been registered successfully");
			modelAndView.addObject("order", new Order());
			modelAndView.setViewName("orderPage");
			
		}
		return modelAndView;
	}

}
