package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuTyyppi;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuTyyppiService;

import java.util.List;

@RestController
@RequestMapping("/api/lipputyyppi")
public class LippuTyyppiController {

    @Autowired
    LippuTyyppiService lippuTyyppiService;

    @GetMapping
    public List<LippuTyyppi> getAllLippuTyyppi() {
        return lippuTyyppiService.getAllLippuTyyppi();
    }

    @GetMapping("/{tyyppi_id}")
    public LippuTyyppi getLippuTyyppi(@PathVariable("tyyppi_id") Long tyyppi_id) {
        return lippuTyyppiService.getLippuTyyppiById(tyyppi_id)
                .orElseThrow(() -> new RuntimeException("Lipputyyppiä ei löydy"));
    }

    @PostMapping
    public ResponseEntity<LippuTyyppi> saveLippuTyyppi(@RequestBody LippuTyyppi lippuTyyppi) {
        LippuTyyppi savedLippuTyyppi = lippuTyyppiService.saveLippuTyyppi(lippuTyyppi);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLippuTyyppi);
    }

    @PutMapping("/{tyyppi_id}")
    public ResponseEntity<LippuTyyppi> updateLippuTyyppi(@PathVariable Long tyyppi_id,
            @RequestBody LippuTyyppi LippuTyyppiBodi) {
        LippuTyyppi updateLippuTyyppi = lippuTyyppiService.updateLippuTyyppi(tyyppi_id, LippuTyyppiBodi);
        return ResponseEntity.ok(updateLippuTyyppi);
    }

    @DeleteMapping("/{tyyppi_id}")
    public ResponseEntity<Void> deleteLippuTyyppi(@PathVariable("tyyppi_id") Long tyyppi_id) {
        lippuTyyppiService.deleteLippuTyyppi(tyyppi_id);
        return ResponseEntity.ok().build();
    }
}
