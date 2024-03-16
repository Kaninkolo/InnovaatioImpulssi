package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Lippu;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.service.LippuService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/liput")
public class LippuController {

  @Autowired
  LippuService service;

  @GetMapping
  public List<Lippu> getAllLippu() {
    return service.getAllLippu();
  }

  @GetMapping("/{id}")
  public Optional<Lippu> getLippuById(Long id) {
    return service.getLippuById(id);
  }

  @PostMapping
  public ResponseEntity<Lippu> saveLippu(@Valid @RequestBody Lippu lippu) {
    Lippu uusiLippu = service.saveLippu(lippu);
    return ResponseEntity.status(HttpStatus.CREATED).body(uusiLippu);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Lippu> updateLippu(@Valid @PathVariable Long id,
      @RequestBody Lippu lippuBody) {
    Lippu updatedLippu = service.updateLippu(id, lippuBody);
    return ResponseEntity.ok(updatedLippu);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLippu(@PathVariable("id") Long id) {
    service.deleteLippu(id);
    return ResponseEntity.ok().build();
  }

}
