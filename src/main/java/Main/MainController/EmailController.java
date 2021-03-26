package Main.MainController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import Main.Model.Email;
import Main.Services.EmailService;



@Controller
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	 @PostMapping("/send")
	 public String bookSubmit(@ModelAttribute Email email, BindingResult bindingResult) {
		 

			emailService.sendEmail( email.getTo(), email.getSubject(), email.getBodytext());

		    return "index";
	  }
	 
	 @GetMapping("/")
	 public String bookSubmit(Model model) {
		 
		 	model.addAttribute("Email", new Email());
		
			return "emailInterface";
	  }
}
