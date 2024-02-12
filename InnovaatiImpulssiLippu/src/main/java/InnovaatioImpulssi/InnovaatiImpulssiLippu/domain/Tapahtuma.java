package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name = "tapahtuma")
public class Tapahtuma {

  private long tapahtuma_id;
  private Date pvm;
  private String sijainti;
  private String kuvaus;

  public Tapahtuma(long tapahtuma_id, Date pvm, String sijainti, String kuvaus) {
    this.tapahtuma_id = tapahtuma_id;
    this.pvm = pvm;
    this.sijainti = sijainti;
    this.kuvaus = kuvaus;
  }

  public long getTapahtuma_id() {
    return tapahtuma_id;
  }

  public void setTapahtuma_id(long tapahtuma_id) {
    this.tapahtuma_id = tapahtuma_id;
  }

  public Date getPvm() {
    return pvm;
  }

  public void setPvm(Date pvm) {
    this.pvm = pvm;
  }

  public String getSijainti() {
    return sijainti;
  }

  public void setSijainti(String sijainti) {
    this.sijainti = sijainti;
  }
  public String getKuvaus() {
    return kuvaus;
  }

  public void setKuvaus(String kuvaus) {
    this.kuvaus = kuvaus;
  }

  @Override
  public String toString() {
    return "Tapahtuma [tapahtuma_id=" + tapahtuma_id + ", pvm=" + pvm + ", sijainti=" + sijainti + ", kuvaus=" + kuvaus
        + "]";
  }
  
}
