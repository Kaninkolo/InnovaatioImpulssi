package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import jakarta.persistence.*;

@Entity
public class Lippu {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long lippu_id;

    @ManyToOne
    @JoinColumn(name = "tyyppi_id")
    private LippuTyyppi lipputyyppi;

    @ManyToOne
    @JoinColumn(name = "tilausnumero_id")
    private OstoTapahtuma ostotapahtuma;

    public Lippu() {}

    public Lippu(Long lippu_id, LippuTyyppi lipputyyppi, OstoTapahtuma ostotapahtuma) {
        this.lippu_id = lippu_id;
        this.lipputyyppi = lipputyyppi;
        this.ostotapahtuma = ostotapahtuma;
    }

    public Long getLippu_id() {
        return lippu_id;
    }

    public void setLippu_id(Long lippu_id) {
        this.lippu_id = lippu_id;
    }

    public LippuTyyppi getLipputyyppi() {
        return lipputyyppi;
    }

    public void setLipputyyppi(LippuTyyppi lipputyyppi) {
        this.lipputyyppi = lipputyyppi;
    }

    public OstoTapahtuma getOstoTapahtuma() {
        return ostotapahtuma;
    }

    public void setOstoTapahtuma(OstoTapahtuma ostotapahtuma) {
        this.ostotapahtuma = ostotapahtuma;
    }

    @Override
    public String toString() {
        return "Lippu [lippu_id=" + lippu_id + ", lipputyyppi=" + lipputyyppi + ", ostoTapahtuma=" + ostotapahtuma
                + "]";
    }

    
}
