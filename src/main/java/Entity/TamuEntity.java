package Entity;

public class TamuEntity extends AbstractEntity
{
    private String dateIn;
    private String dateOut;
    private Integer status;

    public TamuEntity(String nama, String noktp, String notelp, Integer nokamar, String dateIn, String dateOut, Integer status) {
        super(nama, noktp, notelp, nokamar);
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.status = status;
    }

    public String getNama()
    {
        return super.getNama();
    }
    public String getNoKtp()
    {
        return super.getNoktp();
    }
    public String getNoTelp()
    {
        return super.getNotelp();
    }
    public Integer getNoKamar ()
    {
        return super.getNokamar();
    }
    public String getDateIn() {
        return dateIn;
    }
    public String getDateOut() {
        return dateOut;
    }
    public Integer getStatus() {
        return status;
    }
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }


}