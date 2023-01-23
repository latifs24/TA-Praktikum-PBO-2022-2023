package Controllers;
import Entity.TamuEntity;
import Utils.Utils;
public class TamuController
{
    public void registerTamuOTS(String nama, String noktp, String notelp, Integer nokamar )
    { AllObjModels.tamu.registerTamu(new TamuEntity(nama,noktp,notelp,nokamar,Utils.getDate(), Utils.dateOut(),2)); }
    public void updateTamu(int index, String nama, String noktp, String notelp, Integer nokamar)
    {
        AllObjModels.tamu.updateTamu(index, new TamuEntity(nama, noktp, notelp, nokamar, AllObjModels.tamu.getDateIn(index),
                AllObjModels.tamu.getDateOut(index), AllObjModels.tamu.getStatusTamu(index)) );
    }
    public void checkInTamu(int index)
    { AllObjModels.tamu.checkInTamuReservasi(index, Utils.getDate(), Utils.dateOut()); }
    public void checkOutTamu(int index)
    {
        AllObjModels.tamu.checkOutTamu(index, Utils.getDate());
    }
    public void deleteTamu(int index)  { AllObjModels.tamu.deleteDataTamu(index); }
    public String getNama(int index)
    {
        return AllObjModels.tamu.getNama(index);
    }
    public String getNoKtp(int index)
    {
        return AllObjModels.tamu.getNoKtp(index);
    }
    public String getNotelp(int index)
    {
        return AllObjModels.tamu.getNoTelp(index);
    }
    public Integer getNoKamar(int index)
    {
        return AllObjModels.tamu.getNoKamar(index);
    }
    public String getDateIn(int index)
    {
        return AllObjModels.tamu.getDateIn(index);
    }
    public String getDateOut(int index)
    {
        return AllObjModels.tamu.getDateOut(index);
    }
    public Integer getStatusTamu(int index)
    {
        return AllObjModels.tamu.getStatusTamu(index);
    }
    public Integer getSizeData()
    {
        return AllObjModels.tamu.getSizeData();
    }
}