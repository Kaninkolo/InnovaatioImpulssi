//package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;
//
//import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;
//import java.math.BigDecimal;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class LippuTyyppi {
//
//    @Id
//    private long tyyppi_id;
//
//    // @ManyToOne
//    // @JoinColumn(name = "tapahtuma_id")
//    private long tapahtuma_id;
//
//    private String kuvaus;
//
//    private BigDecimal hinta;
//    // TODO: Pitäisikö lisätä boolean joka riippuu maksaako asiakas käteisellä? (Pyöristys lähimpään 5 senttiin?)
//
//    public long getTyyppi_id() {
//        return tyyppi_id;
//    }
//
//    public void setTyyppi_id(long tyyppi_id) {
//        this.tyyppi_id = tyyppi_id;
//    }
//
//    public long getTapahtuma() {
//        return tapahtuma_id;
//    }
//
//    public void setTapahtuma(long tapahtuma) {
//        this.tapahtuma_id = tapahtuma;
//    }
//
//    public String getKuvaus() {
//        return kuvaus;
//    }
//
//    public void setKuvaus(String kuvaus) {
//        this.kuvaus = kuvaus;
//    }
//
//    public BigDecimal getHinta() {
//        return hinta;
//    }
//
//    public void setHinta(BigDecimal hinta) {
//        this.hinta = hinta;
//    }
//
//    @Override
//    public String toString() {
//        return "LippuTyyppi [tyyppi_id=" + tyyppi_id + ", tapahtuma=" + tapahtuma_id + ", kuvaus=" + kuvaus + ", hinta="
//                + hinta + "]";
//    }
//
//
//}
