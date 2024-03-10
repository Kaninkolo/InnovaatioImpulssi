package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tapahtuma {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long tapahtumaId;

  private Date pvm;
  private String sijainti;
  private String kuvaus;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tapahtuma")
  @JsonManagedReference
  private List<LippuTyyppi> lipputyypit;

  private int lippumaara;



  public Tapahtuma(){}

  public Tapahtuma(Long tapahtumaId, Date pvm, String sijainti, String kuvaus, List<LippuTyyppi> lipputyypit) {
    this.tapahtumaId = tapahtumaId;
    this.pvm = pvm;
    this.sijainti = sijainti;
    this.kuvaus = kuvaus;
    this.lipputyypit = lipputyypit;
  }

  public int getLippumaara() {
    return lippumaara;
  }

  public void setLippumaara(int lippumaara) {
    this.lippumaara = lippumaara;
  }
  public Long getTapahtumaId() {
    return tapahtumaId;
  }

  public void setTapahtumaId(Long tapahtumaId) {
    this.tapahtumaId = tapahtumaId;
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

  public List<LippuTyyppi> getLipputyypit() {
    return lipputyypit;
  }

  public void setLipputyypit(List<LippuTyyppi> lipputyypit) {
    this.lipputyypit = lipputyypit;
  }

  @Override
  public String toString() {
    return "Tapahtuma [tapahtuma_id=" + tapahtumaId + ", pvm=" + pvm + ", sijainti=" + sijainti + ", kuvaus=" + kuvaus
        + ", lipputyypit=" + lipputyypit + "]";
  }

  
}
