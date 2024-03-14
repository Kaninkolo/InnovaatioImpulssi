package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LippuService {


    @Autowired
    private LippuRepository lippuRepository;

    // Luodaan uusi lippu
    public Lippu saveLippu(Lippu lippu){
        return lippuRepository.save((lippu));
    }

    //Haetaan lippu Id:llä
    public Optional<Lippu> getLippuById(Long lippu_id){
        return lippuRepository.findById(lippu_id);
    }

    //Haetaan kaikki liput repositorysta
    public List<Lippu> getAllLippu(){
        return lippuRepository.findAll();
    }


    public Lippu updateLippu(Long lippu_id, Lippu lippudetails){
        Lippu lippu = lippuRepository.findById(lippu_id).orElseThrow(() -> new RuntimeException("Lippua ei löytynyt tietokannasta"));
        lippu.setLipputyyppi(lippudetails.getLipputyyppi());

        return lippuRepository.save(lippu);
    }

    public void deleteLippu(Long lippu_id){
        lippuRepository.deleteById(lippu_id);
    }
    //TODO: Placeholderit poies: saveLippu, updateLippu, deleteLippu


}
