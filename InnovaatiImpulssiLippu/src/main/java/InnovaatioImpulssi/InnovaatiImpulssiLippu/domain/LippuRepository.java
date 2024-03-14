package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LippuRepository extends JpaRepository<Lippu, Long> {
// TODO: Hae liput ostotapahtumalla
 //   Optional<OstoTapahtuma> findByLippuAndOstotapahtuma_tilausnumeroId(Long ostotapahtumaId);

}
