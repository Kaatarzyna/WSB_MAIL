package wsb.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mails")
public class MailController {

    final private MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping
    String getForm() {
        return "index";
    }

    @PostMapping
    String sendMail(@ModelAttribute Mail mail) {
        mailService.send(mail);
        return "index";
    }


}
