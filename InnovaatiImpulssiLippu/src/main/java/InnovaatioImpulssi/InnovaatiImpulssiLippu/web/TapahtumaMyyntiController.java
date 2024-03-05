package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuTyyppi;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.OstoTapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/liput")
public class TapahtumaMyyntiController {

    @Autowired
    private LippuService lippuService;

    @PostMapping("/myynti")
    public ResponseEntity<?> purchaseLippu(@RequestBody OstoTapahtumaData ostoTapahtumaData){
        try {
            OstoTapahtuma tt = lippuService.buyLippu(ostoTapahtumaData);
            return ResponseEntity.ok(tt);
        } catch (RuntimeException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
