package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Myyja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myyja_id;

    private String nimi;

    public Myyja(String nimi) {

        this.nimi = nimi;
    }

    public long getMyyja_id() {
        return myyja_id;
    }

    public void setMyyja_id(long myyja_id) {
        this.myyja_id = myyja_id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return "Myyja [myyja_id=" + myyja_id + ", nimi=" + nimi + "]";
    }

}
