package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import java.util.*;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LippuTyyppiService {

    @Autowired
    private LippuTyyppiRepository lippuTyyppiRepository;

    // Luodaan  uusi lipputyyppi
    public LippuTyyppi saveLippuTyyppi(LippuTyyppi lipputyyppi) {
        return lippuTyyppiRepository.save(lipputyyppi);
    }

    //Haetaan lipputyyppi Idllä
    public Optional<LippuTyyppi> getLippuTyyppiById(Long tyyppi_id) {
        return lippuTyyppiRepository.findById(tyyppi_id);
    }

    //Haetaan kaikki lipputyypit
    public List<LippuTyyppi> getAllLippuTyyppi() {
        return lippuTyyppiRepository.findAll();
    }

    public LippuTyyppi updateLippuTyyppi(Long lippuTyyppi_id, LippuTyyppi lippuTyyppiDetails) {
        LippuTyyppi lippuTyyppi = lippuTyyppiRepository.findById(lippuTyyppi_id)
                .orElseThrow(() -> new RuntimeException("Lipputyyppiä ei löytynyt tietokannasta"));
        lippuTyyppi.setTapahtuma(lippuTyyppiDetails.getTapahtuma());
        lippuTyyppi.setLiput(lippuTyyppiDetails.getLiput());
        lippuTyyppi.setKuvaus(lippuTyyppiDetails.getKuvaus());
        lippuTyyppi.setHinta(lippuTyyppiDetails.getHinta());

        return lippuTyyppiRepository.save(lippuTyyppi);
    }

    public void deleteLippuTyyppi(Long lippuTyyppi_id) {
        lippuTyyppiRepository.deleteById(lippuTyyppi_id);
    }

    //TODO: Haetaan tapahtuman lipputyypit
}
