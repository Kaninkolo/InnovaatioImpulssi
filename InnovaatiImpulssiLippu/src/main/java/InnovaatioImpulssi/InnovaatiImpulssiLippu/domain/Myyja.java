package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Myyja {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long myyja_id;
    private String nimi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myyja")
    @JsonBackReference
	private List<OstoTapahtuma> ostotapahtumat;

    public Myyja() {}

    public Myyja(String nimi) {
        this.nimi = nimi;
    }

    public Myyja(Long myyja_id, String nimi, List<OstoTapahtuma> ostotapahtumat) {
        this.myyja_id = myyja_id;
        this.nimi = nimi;
        this.ostotapahtumat = ostotapahtumat;
    }

    public Long getMyyja_id() {
        return myyja_id;
    }

    public void setMyyja_id(Long myyja_id) {
        this.myyja_id = myyja_id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public List<OstoTapahtuma> getOstotapahtumat() {
        return ostotapahtumat;
    }

    public void setOstotapahtumat(List<OstoTapahtuma> ostotapahtumat) {
        this.ostotapahtumat = ostotapahtumat;
    }

    @Override
    public String toString() {
        return "Myyja [myyja_id=" + myyja_id + ", nimi=" + nimi + ", ostotapahtumat=" + ostotapahtumat + "]";
    }

}
