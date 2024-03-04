package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.OstoTapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/liput")
public class TapahtumaMyyntiController {

    @Autowired
    private LippuService lippuService;

    @PostMapping("/myynti")
    public ResponseEntity<?> purchaseLippu(@RequestParam Long lippu_id, @RequestParam int maara, @RequestParam Long myyja_id){

        try {
            OstoTapahtuma tt = lippuService.buyLippu(lippu_id,maara,myyja_id);
            return ResponseEntity.ok(tt);
        } catch (RuntimeException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
