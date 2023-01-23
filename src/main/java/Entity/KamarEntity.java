package Entity;

public class KamarEntity {
    private String detail;
    private String nama;
    private Boolean status;

    public KamarEntity(String detail, String nama, Boolean status) {
        this.detail = detail;
        this.nama = nama;
        this.status = status;
    }
    public String getDetail() {
        return detail;
    }
    public String getNama() {
        return nama;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}