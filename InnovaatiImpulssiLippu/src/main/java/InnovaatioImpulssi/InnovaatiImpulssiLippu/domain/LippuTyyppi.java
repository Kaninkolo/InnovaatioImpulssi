package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class LippuTyyppi {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long tyyppiId;

    @ManyToOne
    @JoinColumn(name = "tapahtuma_id")
    @JsonBackReference
    private Tapahtuma tapahtuma;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lipputyyppi")
    @JsonBackReference
    private List<Lippu> liput;

    @NotBlank
    private String kuvaus;

    @Min(value = 0, message="Lipun hinnan on oltava 0 tai suurempi")
    private BigDecimal hinta;
    // TODO: Pitäisikö lisätä boolean joka riippuu maksaako asiakas käteisellä? (Pyöristys lähimpään 5 senttiin?)


    public LippuTyyppi() {}

    public LippuTyyppi(Long tyyppiId, Tapahtuma tapahtuma, List<Lippu> liput, String kuvaus, BigDecimal hinta) {
        this.tyyppiId = tyyppiId;
        this.tapahtuma = tapahtuma;
        this.liput = liput;
        this.kuvaus = kuvaus;
        this.hinta = hinta;
    }

    public Long getTyyppiId() {
        return tyyppiId;
    }


    public void setTyyppiId(Long tyyppiId) {
        this.tyyppiId = tyyppiId;
    }


    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }


    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }


    public List<Lippu> getLiput() {
        return liput;
    }


    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }


    public String getKuvaus() {
        return kuvaus;
    }


    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }


    public BigDecimal getHinta() {
        return hinta;
    }


    public void setHinta(BigDecimal hinta) {
        this.hinta = hinta;
    }


    @Override
    public String toString() {
        return "LippuTyyppi [tyyppi_id=" + tyyppiId + ", tapahtuma=" + tapahtuma + ", liput=" + liput + ", kuvaus="
                + kuvaus + ", hinta=" + hinta + "]";
    }

    

}
