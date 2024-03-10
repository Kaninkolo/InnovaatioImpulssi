package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.web.OstoTapahtumaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class LippuService {

    @Autowired
    private LippuRepository lippuRepository;

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
        lippu.setLipputyyppi(lippudetails.getLipputyyppi());

        return lippuRepository.save(lippu);
    }

    public void deleteLippu(Long lippu_id){
        lippuRepository.deleteById(lippu_id);
    }
    //TODO:


}
