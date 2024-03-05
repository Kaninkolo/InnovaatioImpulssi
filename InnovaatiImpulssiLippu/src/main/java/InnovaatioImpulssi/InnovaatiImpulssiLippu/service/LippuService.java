package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.web.OstoTapahtumaData;
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

    @Autowired
    private TapatumaRepository tapatumaRepository;

    @Autowired
    private LippuTyyppiRepository lippuTyyppiRepository;

    //TODO: EI TOIMI KUNNOLLA VIELÄ KOITAN KATTOA KUNTOON ENNEN TUNTIA
    public OstoTapahtuma buyLippu(OstoTapahtumaData ostoTapahtumaData){

        Long myyja_id = ostoTapahtumaData.getMyyja_id_data();
        Long tapahtuma_id = ostoTapahtumaData.getTapahtuma_id_data();
        Long lipputyyppi_id = ostoTapahtumaData.getLipputyyppi_id_data();
        int lippumaara = ostoTapahtumaData.getLippumaara_data();

        Myyja myyja = myyjaRepository.findById(myyja_id).orElseThrow(() -> new RuntimeException("Myyjää ei löydy tietokannasta"));
        Tapahtuma lippuMaaraReposta = tapatumaRepository.findById(tapahtuma_id).orElseThrow(() -> new RuntimeException("tapahtumaa ei löytynyt"));
        LippuTyyppi lippuTyyppi = lippuTyyppiRepository.findById(lipputyyppi_id).orElseThrow(() -> new RuntimeException("tapahtumaa ei löytynyt"));

        if (lippuMaaraReposta.getLippumaara() >= lippumaara){
            lippuMaaraReposta.setLippumaara(lippuMaaraReposta.getLippumaara() - lippumaara);
            tapatumaRepository.save(lippuMaaraReposta);

            OstoTapahtuma uusiOstoTapahtuma = new OstoTapahtuma();
            uusiOstoTapahtuma.setMyynti_pvm(new Date());

            for (int i = 0; i < lippumaara; i++){
                Lippu lippu = new Lippu();
                lippu.setLipputyyppi(lippuTyyppi);
                lippuRepository.save(lippu);
            }
            ostoTapahtumaRepository.save(uusiOstoTapahtuma);
            return uusiOstoTapahtuma;
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
