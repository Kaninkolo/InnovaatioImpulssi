package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Lippu {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long lippuId;

   // @NotBlank Aiheuttaa Could not commit JPA transaction
    @ManyToOne
    @JoinColumn(name = "tyyppiId")
    @JsonManagedReference
    private LippuTyyppi lipputyyppi;


    @ManyToOne
    @JoinColumn(name = "tilausnumeroId")
    @JsonIgnore
    private OstoTapahtuma ostotapahtuma;

//    private int lippujenMaara;
//
//    public Integer getLippujenMaara() {
//        return lippujenMaara;
//    }
//
//    public void setLippujenMaara(Integer lippujenMaara) {
//        this.lippujenMaara = lippujenMaara;
//    }

    //TODO: Lisää mille tapahtumalle ostetaan lippuja
    @ManyToOne
    @JoinColumn(name = "tapahtumaId")
    private Tapahtuma tapahtuma;



    public OstoTapahtuma getOstotapahtuma() {
        return ostotapahtuma;
    }

    public void setOstotapahtuma(OstoTapahtuma ostotapahtuma) {
        this.ostotapahtuma = ostotapahtuma;
    }

    public Lippu() {}

    public Lippu(Long lippuId, LippuTyyppi lipputyyppi, OstoTapahtuma ostotapahtuma) {
        this.lippuId = lippuId;
        this.lipputyyppi = lipputyyppi;
        this.ostotapahtuma = ostotapahtuma;
    }

    public Long getLippuId() {
        return lippuId;
    }

    public void setLippuId(Long lippuId) {
        this.lippuId = lippuId;
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

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    @Override
    public String toString() {
        return "Lippu [lippu_id=" + lippuId + ", lipputyyppi=" + lipputyyppi + ", ostoTapahtuma=" + ostotapahtuma
                + "]";
    }

    
}
