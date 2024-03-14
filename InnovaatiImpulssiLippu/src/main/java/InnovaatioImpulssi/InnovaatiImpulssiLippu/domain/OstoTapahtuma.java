package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class OstoTapahtuma {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long tilausnumeroId;
    private Date myynti_pvm;

    @ManyToOne
    @JoinColumn(name = "myyja_id")
    @JsonManagedReference
    private Myyja myyja;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ostotapahtuma", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Lippu> liput;

    public OstoTapahtuma() {}

    public OstoTapahtuma(Long tilausnumeroId, Date myynti_pvm, Myyja myyja, List<Lippu> liput) {
        this.tilausnumeroId = tilausnumeroId;
        this.myynti_pvm = myynti_pvm;
        this.myyja = myyja;
        this.liput = liput;
    }

    public Long getTilausnumeroId() {
        return tilausnumeroId;
    }

    public void setTilausnumeroId(Long tilausnumeroId) {
        this.tilausnumeroId = tilausnumeroId;
    }

    public Date getMyynti_pvm() {
        return myynti_pvm;
    }

    public void setMyynti_pvm(Date myynti_pvm) {
        this.myynti_pvm = myynti_pvm;
    }

    public Myyja getMyyja() {
        return myyja;
    }

    public void setMyyja(Myyja myyja) {
        this.myyja = myyja;
    }

    public List<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }

    @Override
    public String toString() {
        return "OstoTapahtuma [tilausnumero_id=" + tilausnumeroId + ", myynti_pvm=" + myynti_pvm + ", myyja=" + myyja
                + ", liput=" + liput + "]";
    }
    
    
}
