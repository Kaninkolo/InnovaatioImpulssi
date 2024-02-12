package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import jakarta.persistence.*;

@Entity
public class Lippu {

    @Id
    private Long lippu_id;

    @ManyToMany
    @JoinColumn(name = lippu_id)
    private LippuTyyppi lippuTyyppi;

    /// @ManyToOne
    // @JoinColumn(name = tilausnumero)
    // private Tilausnumero tilausnumero;


    public Long getLippu_id() {
        return lippu_id;
    }

    public void setLippu_id(Long lippu_id) {
        this.lippu_id = lippu_id;
    }

    public LippuTyyppi getLippuTyyppi() {
        return lippuTyyppi;
    }

    public void setLippuTyyppi(LippuTyyppi lippuTyyppi) {
        this.lippuTyyppi = lippuTyyppi;
    }

    @Override
    public String toString() {
        return "Lippu{" +
                "lippu_id=" + lippu_id +
                ", lippuTyyppi=" + lippuTyyppi +
                '}';
    }
}
