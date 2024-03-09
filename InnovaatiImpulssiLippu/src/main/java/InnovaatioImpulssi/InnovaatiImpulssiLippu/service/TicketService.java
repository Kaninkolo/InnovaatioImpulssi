package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuRepository;

@SuppressWarnings("null")
@Service
public class TicketService {

  @Autowired
  private LippuRepository repository;

  //Hae kaikki liput
  public List<Lippu> getAllLippu() {
    return repository.findAll();
  }

  //Hae lippu ID:llä
  public Optional<Lippu> getLippuById(Long id) {
    return repository.findById(id);
  }

  
}
