package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.TapatumaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TicketGuruController {

  @Autowired
  private TapatumaRepository trepository;

  @GetMapping("/tapahtumat")
  public String haeTapahtumat(Model model) {
      model.addAttribute("tapahtumat", trepository.findAll());
      return "tapahtumat";
  }
  

}
