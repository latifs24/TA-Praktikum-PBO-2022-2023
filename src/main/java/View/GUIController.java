package View;
import Controllers.AkunController;
import Controllers.KamarController;
import Controllers.TamuController;

public class GUIController{
    protected AkunController akun = new AkunController();
    protected TamuController tamu = new TamuController();
    protected KamarController kamar = new KamarController();
    public Boolean cekLogin(Boolean loginAs, String uname, String passwd)
    { return akun.cekLogin(loginAs, uname, passwd); }
    public void createAccount(String uname, String passw)
    { akun.createAkun(uname, passw); }
    public void updateAccountbyAdmin(int index, String uname, String passw)
    { akun.updateAkunByAdmin(index, uname, passw); }
    public Integer getSizeData()
    { return akun.getSizeData(); }
    public void deleteAccount(int index)
    { akun.deleteAccount(index); }
    public String getUsername(int index)
    { return akun.getUsernameStaff(index); }
    public String getPassword(int index)
    { return akun.getPasswordStaff(index); }
}