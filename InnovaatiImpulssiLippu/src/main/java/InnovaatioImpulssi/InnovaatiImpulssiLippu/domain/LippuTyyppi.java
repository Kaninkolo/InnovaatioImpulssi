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

@Entity
public class LippuTyyppi {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long tyyppi_id;

    @ManyToOne
    @JoinColumn(name = "tapahtuma_id")
    @JsonBackReference
    private Tapahtuma tapahtuma;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lipputyyppi")
    @JsonBackReference
    private List<Lippu> liput;

    private String kuvaus;

    private BigDecimal hinta;
    // TODO: Pitäisikö lisätä boolean joka riippuu maksaako asiakas käteisellä? (Pyöristys lähimpään 5 senttiin?)


    public LippuTyyppi() {}

    public LippuTyyppi(Long tyyppi_id, Tapahtuma tapahtuma, List<Lippu> liput, String kuvaus, BigDecimal hinta) {
        this.tyyppi_id = tyyppi_id;
        this.tapahtuma = tapahtuma;
        this.liput = liput;
        this.kuvaus = kuvaus;
        this.hinta = hinta;
    }

    public Long getTyyppi_id() {
        return tyyppi_id;
    }


    public void setTyyppi_id(Long tyyppi_id) {
        this.tyyppi_id = tyyppi_id;
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
        return "LippuTyyppi [tyyppi_id=" + tyyppi_id + ", tapahtuma=" + tapahtuma + ", liput=" + liput + ", kuvaus="
                + kuvaus + ", hinta=" + hinta + "]";
    }

    

}
