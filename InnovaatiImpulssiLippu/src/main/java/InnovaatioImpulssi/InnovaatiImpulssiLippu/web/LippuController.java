package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import org.springframework.web.bind.annotation.RestController;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.TicketService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/tickets")
public class LippuController {
  
  @Autowired
  TicketService service;

  @GetMapping
  public List<Lippu> getAllLippu() {
      return service.getAllLippu();
  }

  @GetMapping("/{id}")
  public Optional<Lippu> getLippuById(Long id) {
    return service.getLippuById(id);
  }
  

}
