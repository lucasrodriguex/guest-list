package br.com.viplist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.viplist.model.Guest;
import br.com.viplist.repository.GuestRepository;

@Controller
public class GuestController {
	
	@Autowired
	private GuestRepository guestRepository;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/guestlist")
	public String guestList(Model model){
		loadGuestList(model);
		return "guestlist";
	}

	private void loadGuestList(Model model) {
		Iterable<Guest> guests = guestRepository.findAll();
		model.addAttribute("guests", guests);
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phone") String phone, Model model) {
		
		Guest guest = new Guest(name, email, phone);
		guestRepository.save(guest);
				
		loadGuestList(model);
		return "guestlist";
	}

}
