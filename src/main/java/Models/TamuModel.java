package Models;
import Entity.TamuEntity;
import java.util.ArrayList;
public class TamuModel implements interfaceModels
{
    private ArrayList<TamuEntity> tamuArrayList = new ArrayList<>();
    public Integer registTamuReserv(TamuEntity tamuEntity)
    {
        tamuArrayList.add(tamuEntity);
        return tamuArrayList.indexOf(tamuEntity);
    }
    public void updateTamuReserv(int index, String nama, String noktp, String notelp, int nokamar, String dateIn, String dateOut, int status)
    { tamuArrayList.set(index, new TamuEntity(nama, noktp, notelp, nokamar, dateIn, dateOut, status)); }
    public void registerTamu(TamuEntity tamuEntity)  { tamuArrayList.add(tamuEntity); }
    public void checkInTamuReservasi(int index, String dateIn, String dateOut) {
        tamuArrayList.get(index).setStatus(3);
        tamuArrayList.get(index).setDateIn(dateIn);
        tamuArrayList.get(index).setDateOut(dateOut);
    }
    public void checkOutTamu(int index, String dateOut)  {
        tamuArrayList.get(index).setStatus(3);
        tamuArrayList.get(index).setDateOut(dateOut);
    }
    public void updateTamu(int index, TamuEntity tamuEntity)
    {
        tamuArrayList.set(index, tamuEntity);
    }
    public void deleteDataTamu(int index)  { tamuArrayList.remove(index); }

    public String getNama(int index)
    {
        return tamuArrayList.get(index).getNama();
    }
    public String getNoKtp(int index)
    {
        return tamuArrayList.get(index).getNoKtp();
    }
    public String getNoTelp(int index)
    {
        return tamuArrayList.get(index).getNoTelp();
    }
    public Integer getNoKamar(int index)
    {
        return tamuArrayList.get(index).getNoKamar();
    }
    public String getDateIn(int index) {
        return tamuArrayList.get(index).getDateIn();
    }
    public String getDateOut(int index)
    {
        return tamuArrayList.get(index).getDateOut();
    }
    public Integer getStatusTamu(int index)
    {
        return tamuArrayList.get(index).getStatus();
    }
    public Integer getSizeData()
    {
        return tamuArrayList.size();
    }
}