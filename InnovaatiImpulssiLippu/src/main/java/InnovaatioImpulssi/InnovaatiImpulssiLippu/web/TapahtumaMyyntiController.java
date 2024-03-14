package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.OstoTapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuService;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.OstotapahtumaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> purchaseLippu(@RequestBody OstoTapahtumaDTO ostoTapahtumaDTO){
        try {
            OstoTapahtuma uusiOstotapahtuma = ostotapahtumaService.buyLippu(ostoTapahtumaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(uusiOstotapahtuma);
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

//    @GetMapping("/liput/{ostotapahtumaid}")
//    public OstoTapahtuma getLippuByOstotapahtuma(@PathVariable("ostotapahtumaid") Long ostotapahtumaid){
//        return ostotapahtumaService.getLippuByOstotapahtuma(ostotapahtumaid).orElseThrow(() -> new RuntimeException("ostotapahtumaa ei löydy"));
//    }
}
