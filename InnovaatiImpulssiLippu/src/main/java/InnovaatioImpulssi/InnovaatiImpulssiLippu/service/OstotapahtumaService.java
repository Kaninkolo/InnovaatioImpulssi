package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.web.OstoTapahtumaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OstotapahtumaService {

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

    @Transactional
    public OstoTapahtuma buyLippu(OstoTapahtumaDTO ostoTapahtumaDTO){

        // Asetetaan DTO:sta tulleet tiedot muuttujiin
        Long myyja_id = ostoTapahtumaDTO.getMyyja_id_data();
        Long tapahtuma_id = ostoTapahtumaDTO.getTapahtuma_id_data();
        Long lipputyyppi_id = ostoTapahtumaDTO.getLipputyyppi_id_data();
        int lippumaara = ostoTapahtumaDTO.getLippumaara_data();

        //Tarkastetaan että myyjä, tapahtuma ja Lipputyyppi löytyy tietokannasta
        Myyja myyja = myyjaRepository.findById(myyja_id).orElseThrow(() -> new RuntimeException("Myyjää ei löydy tietokannasta"));
        Tapahtuma lippuMaaraReposta = tapatumaRepository.findById(tapahtuma_id).orElseThrow(() -> new RuntimeException("tapahtumaa ei löytynyt"));
        LippuTyyppi lippuTyyppi = lippuTyyppiRepository.findByTyyppiIdAndTapahtuma_tapahtumaId(lipputyyppi_id,tapahtuma_id).orElseThrow(() -> new RuntimeException("Lipputyyyppiä ei löytynyt"));

        // Tarkastetaan että tapahtumalle on lippuja
        if (lippuMaaraReposta.getLippumaara() >= lippumaara){
            //TODO: Validoi että ostettujen lippujen määrä on 1 tai enemmän.
            lippuMaaraReposta.setLippumaara(lippuMaaraReposta.getLippumaara() - lippumaara);
            tapatumaRepository.save(lippuMaaraReposta);

            OstoTapahtuma uusiOstoTapahtuma = new OstoTapahtuma();
            uusiOstoTapahtuma.setMyynti_pvm(new Date());
            uusiOstoTapahtuma.setMyyja(myyja);
            ostoTapahtumaRepository.save(uusiOstoTapahtuma);

            List<Lippu> liput = new ArrayList<>();
            for (int i = 0; i < lippumaara; i++){
                Lippu lippu = new Lippu();
                lippu.setLipputyyppi(lippuTyyppi);
                lippu.setOstotapahtuma(uusiOstoTapahtuma);
                lippu.setTapahtuma(lippuMaaraReposta);
                lippuRepository.save(lippu);
                liput.add(lippu);
            }
            uusiOstoTapahtuma.setLiput(liput);
            ostoTapahtumaRepository.save(uusiOstoTapahtuma);

            return uusiOstoTapahtuma;
        } else {
            throw new RuntimeException("Ei tarpeeksi lippuja saatavilla");
        }

    }

    public List<OstoTapahtuma> getAllOstotapahtuma() {
        return ostoTapahtumaRepository.findAll();
    }

    //TODO: Ostotapahtuman poistaminen -> lippujen poistaminen jotka liittyy kyseiseen ostotapahtumaan
    //TODO: Lippujen muokkaaminen -> ostotapahtuman poistaminen -> uuden ostotapahtuman luominen korjatuilla lipuilla.
    //TODO: Useamman eri lipputyypin ostaminen yhdellä ostotapahtumalla

//    public Optional<OstoTapahtuma> getLippuByOstotapahtuma(Long ostotapahtumaId){
//        return lippuRepository.findByLippuAndOstotapahtuma_tilausnumeroId(ostotapahtumaId);
//    }
}
