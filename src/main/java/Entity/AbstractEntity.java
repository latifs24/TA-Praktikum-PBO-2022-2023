package Entity;

public abstract class AbstractEntity
{
    private String nama;
    private String noktp;
    private String notelp;
    private Integer nokamar;
    public AbstractEntity(String nama, String noktp, String notelp, Integer nokamar)
    {
        this.nama = nama;
        this.noktp = noktp;
        this.notelp = notelp;
        this.nokamar = nokamar;
    }
    public void setNama(String nama) { this.nama = nama; }
    public void setNoktp(String noktp) { this.noktp = noktp; }
    public void setNotelp(String notelp) { this.notelp = notelp; }
    public void setNokamar(Integer nokamar) { this.nokamar = nokamar; }

    public String getNama() { return this.nama; }
    public String getNoktp() { return noktp; }
    public String getNotelp() { return notelp; }
    public Integer getNokamar() { return nokamar; }
}