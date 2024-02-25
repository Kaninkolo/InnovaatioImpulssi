package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tapahtuma")
public class TapahtumaController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Tapahtuma tapahtuma(
            @RequestParam(value = "kuvaus", defaultValue = "Kuvaus") String kuvaus,
            @RequestParam(value = "pvm", defaultValue = "01.01.01") @DateTimeFormat(pattern = "dd.MM.yy") Date pvm
    ) {
        return new Tapahtuma(counter.incrementAndGet(), pvm, "sijainti", kuvaus);
    }
}

