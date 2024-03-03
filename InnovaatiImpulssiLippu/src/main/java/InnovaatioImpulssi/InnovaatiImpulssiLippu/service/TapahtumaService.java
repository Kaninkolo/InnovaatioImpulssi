package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.TapatumaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TapahtumaService {

    @Autowired
    private TapatumaRepository tapatumaRepository;

    public Tapahtuma saveTapahtuma(Tapahtuma tapahtuma){
        return tapatumaRepository.save(tapahtuma);
    }

    public Optional<Tapahtuma> getTapahtumaById(Long tapahtuma_id){
        return tapatumaRepository.findById(tapahtuma_id);
    }

    public List<Tapahtuma> getAllTapahtuma() {
        return tapatumaRepository.findAll();
    }

    public Tapahtuma updateTapahtuma(Long tapahtuma_id, Tapahtuma tapahtumaDetails){
        Tapahtuma tapahtuma = tapatumaRepository.findById(tapahtuma_id).orElseThrow(() -> new RuntimeException("Tapahtumaa ei löytynyt tietokannasta"));
        tapahtuma.setKuvaus(tapahtumaDetails.getKuvaus());
        tapahtuma.setPvm(tapahtumaDetails.getPvm());
        tapahtuma.setSijainti(tapahtumaDetails.getSijainti());

        return tapatumaRepository.save(tapahtuma);
    }

    public void deleteTapahtuma(Long tapahtuma_id){
        tapatumaRepository.deleteById(tapahtuma_id);
    }
}
