package br.com.viplist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		Iterable<Guest> guests = guestRepository.findAll();
		model.addAttribute("guests", guests);
		return "guestlist";
	}

}
