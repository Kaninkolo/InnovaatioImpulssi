package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.TapatumaRepository;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.TapahtumaService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/tapahtuma")
public class TapahtumaController {

    @Autowired
    TapahtumaService tapahtumaService;
//    private final AtomicLong counter = new AtomicLong();
//
//    @GetMapping
//    public Tapahtuma tapahtuma(
//            @RequestParam(value = "kuvaus", defaultValue = "Kuvaus") String kuvaus,
//            @RequestParam(value = "pvm", defaultValue = "01.01.01") @DateTimeFormat(pattern = "dd.MM.yy") Date pvm
//    ) {
//        return new Tapahtuma(counter.incrementAndGet(), pvm, "sijainti", kuvaus);
//    }

    @GetMapping
    public List<Tapahtuma> getAllTapahtuma(){
        return tapahtumaService.getAllTapahtuma();
    }

    @GetMapping("/{tapahtuma_id}")
    public Tapahtuma getTapahtuma(@PathVariable("tapahtuma_id") Long tapahtuma_id){
        return tapahtumaService.getTapahtumaById(tapahtuma_id).orElseThrow(() -> new RuntimeException("tapahtumaa ei löydy"));
    }

    @PostMapping
    public ResponseEntity<Tapahtuma> saveTapahtuma(@Valid @RequestBody Tapahtuma tapahtuma){
        Tapahtuma savedTapahtuma = tapahtumaService.saveTapahtuma(tapahtuma);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTapahtuma);
    }

    @PutMapping("/{tapahtuma_id}")
    public ResponseEntity<Tapahtuma> updateTapahtuma(@PathVariable Long tapahtuma_id, @Valid @RequestBody Tapahtuma tapahtumaBodi){
        Tapahtuma updateTapahtuma = tapahtumaService.updateTapahtuma(tapahtuma_id, tapahtumaBodi);
        return ResponseEntity.ok(updateTapahtuma);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{tapahtuma_id}")
    public ResponseEntity<Void> deleteTapahtuma(@PathVariable("tapahtuma_id") Long tapahtuma_id){
        tapahtumaService.deleteTapahtuma(tapahtuma_id);
        return ResponseEntity.ok().build();
    }
}


