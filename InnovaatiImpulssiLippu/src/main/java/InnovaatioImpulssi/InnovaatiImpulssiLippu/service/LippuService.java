package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LippuService {

    @Autowired
    private LippuRepository lippuRepository;


    //TODO: logiikka lippujen myynnille
    //TODO:
    public Lippu saveLippu(Lippu lippu){
        return lippuRepository.save((lippu));
    }

    public Optional<Lippu> getLippuById(Long lippu_id){
        return lippuRepository.findById(lippu_id);
    }

    public List<Lippu> getAllLippu(){
        return lippuRepository.findAll();
    }

    public Lippu updateLippu(Long lippu_id, Lippu lippudetails){
        Lippu lippu = lippuRepository.findById(lippu_id).orElseThrow(() -> new RuntimeException("Lippua ei löytynyt tietokannasta"));
        lippu.setLippuTyyppi(lippudetails.getLippuTyyppi());

        return lippuRepository.save(lippu);
    }

    public void deleteLippu(Long lippu_id){
        lippuRepository.deleteById(lippu_id);
    }
    //TODO:
    //TODO: metodit lipun palautukselle


}
