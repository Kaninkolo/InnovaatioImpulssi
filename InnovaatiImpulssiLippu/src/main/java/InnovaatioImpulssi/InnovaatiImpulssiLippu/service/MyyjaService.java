package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Myyja;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.MyyjaRepository;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.TapatumaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyyjaService {

    @Autowired
    private MyyjaRepository myyjaRepository;

    public Myyja saveMyyja(Myyja myyja){
        return myyjaRepository.save(myyja);
    }

    public Optional<Myyja> getMyyjaById(Long myyja_id){
        return myyjaRepository.findById(myyja_id);
    }

    public List<Myyja> getAllMyyja(){
        return myyjaRepository.findAll();
    }

    public Myyja updateMyyja(Long myyja_id, Myyja myyjaDetails){
        Myyja myyja = myyjaRepository.findById(myyja_id).orElseThrow(() -> new RuntimeException("Myyjää ei löytynyt ID:llä tietokannasta"));
        myyja.setNimi(myyjaDetails.getNimi());

        return myyjaRepository.save(myyja);
    }

    public void deleteMyyja(Long myyja_id){
        myyjaRepository.deleteById(myyja_id);
    }

}
