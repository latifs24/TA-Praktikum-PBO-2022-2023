package Models;
import Entity.KamarEntity;
import java.util.ArrayList;

public class KamarModel implements interfaceModels
{
    private ArrayList<KamarEntity> kamarArrayList = new ArrayList<>();

    private final String [] detail = { "Kamar Solo", "Kamar DUO", "Kamar TRIO" };
    private final String [] nama = {"Hyperion " , "Teyvat ", "Osakana " };
    public void initialize()
    {
        String temp;
        for (int i=0; i<=30; i++)
        {
            if (i<10) {
                temp = nama[0] + (i+1) ;
                kamarArrayList.add(new KamarEntity(detail[0], temp, true));
            }
            else if (i>=10 && i<21)
            {
                temp = nama[1] + Integer.toString(i);
                kamarArrayList.add(new KamarEntity(detail[1], temp, false));
            }
            else if (i>=21)
            {
                temp = nama[2] + Integer.toString(i);
                kamarArrayList.add(new KamarEntity(detail[2],temp, true));
            }
        }
    }

    public Boolean getStatusKamar(int index)
    {
        return kamarArrayList.get(index).getStatus();
    }
    public String getNamaKamar (int index) {
        return kamarArrayList.get(index).getNama();
    }
    public String getDetailKamar (int index) {
        return kamarArrayList.get(index).getDetail();
    }
    public void setCheckKamar(int index)
    {
        kamarArrayList.get(index).setStatus(false);
    }
    public void unCheckKamar(int index) {
        kamarArrayList.get(index).setStatus(true);
    }
    public Integer getSizeData() { return kamarArrayList.size(); }
}