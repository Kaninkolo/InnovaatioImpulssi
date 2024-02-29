//package InnovaatioImpulssi.InnovaatiImpulssiLippu.domain;
//
//import java.util.Date;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//@Entity
//public class OstoTapahtuma {
//    @Id
//    private long tilausnumero_id;
//    private long myyja_id;
//    private Date myynti_pvm;
//
//    public OstoTapahtuma(long tilausnumero_id, long myyja_id, Date myynti_pvm) {
//        this.tilausnumero_id = tilausnumero_id;
//        this.myyja_id = myyja_id;
//        this.myynti_pvm = myynti_pvm;
//    }
//
//    public long getTilausnumero_id() {
//        return tilausnumero_id;
//    }
//
//    public void setTilausnumero_id(long tilausnumero_id) {
//        this.tilausnumero_id = tilausnumero_id;
//    }
//
//    public long getMyyja_id() {
//        return myyja_id;
//    }
//
//    public void setMyyja_id(long myyja_id) {
//        this.myyja_id = myyja_id;
//    }
//
//    public Date getMyynti_pvm() {
//        return myynti_pvm;
//    }
//
//    public void setMyynti_pvm(Date myynti_pvm) {
//        this.myynti_pvm = myynti_pvm;
//    }
//
//    @Override
//    public String toString() {
//        return "OstoTapahtuma [tilausnumero_id=" + tilausnumero_id + ", myyja_id=" + myyja_id + ", myynti_pvm="
//                + myynti_pvm + "]";
//    }
//
//}
