package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LippuService {

    @Autowired
    private LippuRepository lippuRepository;

    @Autowired
    private OstoTapahtumaRepository ostoTapahtumaRepository;

    @Autowired
    private MyyjaRepository myyjaRepository;

    //TODO: logiikka lippujen myynnille
    //TODO: tarkistaa että lippuja on myytävänä ja lisää ostetun lipun repoon
    //TODO:
    public OstoTapahtuma buyLippu(Long lippu_id, int lippumaara, Long myyja_id){
        Myyja myyja = myyjaRepository.findById(myyja_id).orElseThrow(() -> new RuntimeException("Myyjää ei löydy tietokannasta"));
        Lippu lippuMaaraReposta = lippuRepository.findById(lippu_id).orElseThrow(() -> new RuntimeException("tapahtumaa ei löytynyt"));
        if (lippuMaaraReposta.getLippujenMaara() >= lippumaara){
            lippuMaaraReposta.setLippujenMaara(lippuMaaraReposta.getLippujenMaara() - lippumaara);
            lippuRepository.save(lippuMaaraReposta);

            OstoTapahtuma ostoTapahtuma = new OstoTapahtuma();
            ostoTapahtuma.setMyynti_pvm(new Date());
            ostoTapahtuma.setLiput(Collections.singletonList(lippuMaaraReposta));
            ostoTapahtuma.setMyyja(myyja);
            ostoTapahtumaRepository.save(ostoTapahtuma);
            return ostoTapahtuma;
        } else {
            throw new RuntimeException("Ei tarpeeksi lippuja saatavilla");
        }

    }

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
    //TODO: metodit lipun palautukselle


}
