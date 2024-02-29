package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/liput")
public class TapahtumaMyyntiController {

    @Autowired
    private LippuService lippuService;

    @PostMapping("/myynti")
    public ResponseEntity<Lippu> purchaseLippu(){

    }
}
