package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuTyyppi;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.OstoTapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuService;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.OstotapahtumaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myynti")
public class TapahtumaMyyntiController {

    @Autowired
    private OstotapahtumaService ostotapahtumaService;

    @Autowired LippuService lippuService;

    @PostMapping
    public ResponseEntity<?> purchaseLippu(@RequestBody OstoTapahtumaData ostoTapahtumaData){
        try {
            OstoTapahtuma tt = ostotapahtumaService.buyLippu(ostoTapahtumaData);
            return ResponseEntity.ok(tt);
        } catch (RuntimeException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping
    public List<OstoTapahtuma> getAllOstotapahtuma(){
        return ostotapahtumaService.getAllOstotapahtuma();
    }

    @GetMapping("/liput")
    public  List<Lippu> getAllLippu(){
        return lippuService.getAllLippu();
    }
}
