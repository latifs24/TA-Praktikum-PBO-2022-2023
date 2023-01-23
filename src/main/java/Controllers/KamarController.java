package Controllers;

public class KamarController {
    public Boolean getStatusKamar(int index)
    {
        return AllObjModels.kamar.getStatusKamar(index);
    }
    public String getNamaKamar (int index) {
        return AllObjModels.kamar.getNamaKamar(index);
    }
    public String getDetailKamar (int index) {
        return AllObjModels.kamar.getDetailKamar(index);
    }
    public void setCheckKamar(int index)
    {
        AllObjModels.kamar.setCheckKamar(index);
    }
    public void unCheckKamar(int index) {
        AllObjModels.kamar.unCheckKamar(index);
    }
    public void initialize()
    {
        AllObjModels.kamar.initialize();
    }
    public Integer getSizeData() { return AllObjModels.kamar.getSizeData(); }
}
