package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OstoTapahtuma {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long tilausnumero_id;
    private Date myynti_pvm;

    @ManyToOne
    @JoinColumn(name = "myyja_id")
    private Myyja myyja;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ostotapahtuma")
    private List<Lippu> liput;

    public OstoTapahtuma() {}

    public OstoTapahtuma(Long tilausnumero_id, Date myynti_pvm, Myyja myyja, List<Lippu> liput) {
        this.tilausnumero_id = tilausnumero_id;
        this.myynti_pvm = myynti_pvm;
        this.myyja = myyja;
        this.liput = liput;
    }

    public Long getTilausnumero_id() {
        return tilausnumero_id;
    }

    public void setTilausnumero_id(Long tilausnumero_id) {
        this.tilausnumero_id = tilausnumero_id;
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
        return "OstoTapahtuma [tilausnumero_id=" + tilausnumero_id + ", myynti_pvm=" + myynti_pvm + ", myyja=" + myyja
                + ", liput=" + liput + "]";
    }
    
    
}
