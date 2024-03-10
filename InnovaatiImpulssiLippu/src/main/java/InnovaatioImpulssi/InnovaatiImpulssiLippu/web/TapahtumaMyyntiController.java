package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuTyyppi;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.OstoTapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuService;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.OstotapahtumaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TapahtumaMyyntiController {

    @Autowired
    private OstotapahtumaService ostotapahtumaService;

    @PostMapping("/myynti")
    public ResponseEntity<?> purchaseLippu(@RequestBody OstoTapahtumaData ostoTapahtumaData){
        try {
            OstoTapahtuma tt = ostotapahtumaService.buyLippu(ostoTapahtumaData);
            return ResponseEntity.ok(tt);
        } catch (RuntimeException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
