package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Myyja;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.MyyjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myyja")
public class MyyjaController {

    @Autowired
    MyyjaService myyjaService;

    @GetMapping
    public List<Myyja> getAllMyyja(){
        return myyjaService.getAllMyyja();
    }

    @GetMapping("/{myyja_id}")
    public Myyja getMyyja(@PathVariable("myyja_id") Long myyja_id){
        return myyjaService.getMyyjaById(myyja_id).orElseThrow(() -> new RuntimeException("Myyjaa ei löydy"));
    }

    @PostMapping
    public ResponseEntity<Myyja> saveMyyja(@RequestBody Myyja myyja){
        Myyja savedMyyja = myyjaService.saveMyyja(myyja);

        return ResponseEntity.status((HttpStatus.CREATED)).body(savedMyyja);
    }

    @PutMapping("/{myyja_id}")
    public ResponseEntity<Myyja> updateMyyja(@PathVariable Long myyja_id, @RequestBody Myyja myyjaBody){
        Myyja updateMyyja = myyjaService.updateMyyja(myyja_id, myyjaBody);
        return ResponseEntity.ok(updateMyyja);
    }

    @DeleteMapping("/{myyja_id}")
    public ResponseEntity<Void> deleteMyyja(@PathVariable("myyja_id") Long myyja_id){
        myyjaService.deleteMyyja(myyja_id);
        return ResponseEntity.ok().build();
    }
}
