package Models;
import Entity.AkunEntity;
import java.util.ArrayList;
public class AkunModel
{
    private ArrayList <AkunEntity> ArrListAkun;
    private final String ID_Admin = "Shinota";
    private final String PW_Admin = "WWW";
    private int index_login;
    public AkunModel()
    { ArrListAkun = new ArrayList<>(); }
    public void addAkun(AkunEntity entityAkun)
    { ArrListAkun.add(entityAkun); }
    public void updateByAdmin(int index, AkunEntity entityAkun) throws IndexOutOfBoundsException
    { ArrListAkun.set(index, entityAkun); }
    public void updateByStaff(int index, String password )
    { ArrListAkun.get(index).setPassword(password); }
    public void delete_Akun(int index)
    { ArrListAkun.remove(index); }
    public String getID_Admin() { return ID_Admin; }
    public String getPW_Admin() { return PW_Admin; }
    public String getUsernameStaff(int index) { return ArrListAkun.get(index).getUsername(); }
    public String getPasswordStaff(int index) { return ArrListAkun.get(index).getPassword(); }
    public void setIndexlogin(int index_login) { this.index_login = index_login; }
    public int getIndexLogin() { return this.index_login; }
    public int getSize() { return this.ArrListAkun.size(); }
    public ArrayList<AkunEntity> getArrListAkun() { return ArrListAkun; }
}