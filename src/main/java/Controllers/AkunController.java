package Controllers;
import Entity.AkunEntity;

public class AkunController
{
    public Boolean cekAdmin(String uname, String passw) {
        if (uname.equals(AllObjModels.akun.getID_Admin()) && passw.equals(AllObjModels.akun.getPW_Admin())) {
            AllObjModels.akun.setIndexlogin(-1);
            return true;
        }
        else
            return false;
    }
    public boolean cekStaff(String uname, String passw)
    {
        for (int i = 0; i< AllObjModels.akun.getSize(); i++)
        {
            if (uname.equals(AllObjModels.akun.getArrListAkun().get(i).getUsername()))
            {
                if (passw.equals(AllObjModels.akun.getArrListAkun().get(i).getPassword()))
                {
                    AllObjModels.akun.setIndexlogin(i);
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }
        return false;
    }
    public Boolean cekLogin(Boolean loginAs, String uname, String passw)
    {
        if (loginAs)
            return cekAdmin(uname, passw);
        else if (!loginAs)
            return cekStaff(uname, passw);
        return false;
    }
    public void createAkun(String uname, String passw)
    { AllObjModels.akun.addAkun(new AkunEntity(uname, passw)); }
    public void updateAkunByAdmin(int index, String uname, String passw)
    { AllObjModels.akun.updateByAdmin(index, new AkunEntity(uname, passw)); }
    public void updateAkunByStaff(int index, String passw)
    { AllObjModels.akun.updateByStaff(index, passw ); }
    public void deleteAkun(int index)
    { AllObjModels.akun.delete_Akun(index); }
    public int getIndexLogin()
    { return AllObjModels.akun.getIndexLogin(); }
    public String getUnameStaff(int index)
    { return AllObjModels.akun.getUsernameStaff(index); }
    public String getPasswStaff(int index)
    { return AllObjModels.akun.getPasswordStaff(index); }
    public Integer getSizeData() { return AllObjModels.akun.getSize(); }
    public void deleteAccount(int index)
    { AllObjModels.akun.delete_Akun(index); }
    public String getUsernameStaff(int index)
    { return AllObjModels.akun.getUsernameStaff(index); }
    public String getPasswordStaff(int index)
    { return AllObjModels.akun.getPasswordStaff(index); }

}