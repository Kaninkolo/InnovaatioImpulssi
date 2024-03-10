package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LippuTyyppiRepository extends JpaRepository<LippuTyyppi, Long> {

  //  Optional<LippuTyyppi> findByLippuTyyppi_AndTapahtuma_TapahtumaId(Long tyyppi_id, Long tapahtumaId);

}
