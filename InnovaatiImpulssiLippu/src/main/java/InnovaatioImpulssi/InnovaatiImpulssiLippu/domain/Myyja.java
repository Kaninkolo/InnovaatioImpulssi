package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Myyja {
    @Id
    private Long myyja_id;

    private String nimi;

    public Myyja(){

    }
    public Myyja(Long myyja_id, String nimi) {
        this.myyja_id = myyja_id;
        this.nimi = nimi;
    }

    public long getMyyja_id() {
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

    @Override
    public String toString() {
        return "Myyja [myyja_id=" + myyja_id + ", nimi=" + nimi + "]";
    }

}
