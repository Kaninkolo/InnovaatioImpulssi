package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.TapatumaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tapahtuma")
public class TapahtumaController {

    @Autowired
    TapatumaRepository tapatumaRepository;
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Tapahtuma tapahtuma(
            @RequestParam(value = "kuvaus", defaultValue = "Kuvaus") String kuvaus,
            @RequestParam(value = "pvm", defaultValue = "01.01.01") @DateTimeFormat(pattern = "dd.MM.yy") Date pvm
    ) {
        return new Tapahtuma(counter.incrementAndGet(), pvm, "sijainti", kuvaus);
    }
    @DeleteMapping("/{tapahtuma_id}")
    public ResponseEntity<Void> deleteTapahtuma(@PathVariable("tapahtuma_id") Long tapahtuma_id){
        if (tapatumaRepository.existsById(tapahtuma_id)){
            tapatumaRepository.deleteById(tapahtuma_id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
}

