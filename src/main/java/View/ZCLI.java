package View;
import Controllers.AkunController;

import java.util.Scanner;
public class ZCLI
{
    private Scanner input = new Scanner(System.in);
    private AkunController akun = new AkunController();

    public void executor() {
        try {
            Boolean login;
            do {
                login = login(loginAs());
                if (login) {
                    System.out.println("Login berhasil..");
                    if (akun.getIndexLogin() != -1) {
                        System.out.println("Haloo.." + akun.getUnameStaff(akun.getIndexLogin()));
                        ActivityStaff();
                    }
                    else {
                        System.out.println("Hay Admint");
                        ActivityAdmin();
                    }
                } else
                    System.out.println("Login Gagal");
            } while (login != null);
        } catch (NullPointerException e) {
            System.out.println("Adiosss bruh");
        }
    }

    private Integer loginAs()
    {
        int pilihan = 0;
        while (pilihan!=3)
        {
            System.out.println("1.Login As Admin");
            System.out.println("2.Login As Staff");
            System.out.println("3.Exit program");
            try {
                System.out.print("Pilihan anda : ");
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pilihan tidak tepat");
            }
            switch (pilihan)
            {
                case 1 -> { return 1; }
                case 2 -> { return 2; }
                case 3 -> { return 3; }
                default -> System.out.println("Pilihan tidak tepat");
            }
        }
        return -1;
    }
    private Boolean login(int loginAs)
    {
        String uname, passw;
        Boolean hasilLogin = null;
        if (loginAs != 3)
        {
            System.out.print("Username : ");
            uname = input.nextLine();
            System.out.print("Password : ");
            passw = input.nextLine();
            switch (loginAs)
            {
                case 1 -> hasilLogin = akun.cekAdmin(uname, passw);
                case 2 -> hasilLogin = akun.cekStaff(uname, passw);
            }
        }
        return hasilLogin;
    }
    private void ActivityAdmin()
    {
        String pilihan;
        do
        {
            System.out.println("1.Menambahkan Staff baru");
            System.out.println("2.Lihat Daftar Staff");
            System.out.println("3.Update Akun Staff");
            System.out.println("4.Hapus Akun Staff");
            System.out.println("5.Logout");
            System.out.print("Pilihan anda : ");
            pilihan = input.nextLine();

            switch (pilihan)
            {
                case "1" -> tambahAkunStaff();
                case "2" -> viewAkun();
                case "3" -> updateAkunByAdmin();
                case "4" -> hapusAkun();
                case "5" -> System.out.println("Logout..");
            }
        } while (!pilihan.equalsIgnoreCase("5"));
    }

    private void tambahAkunStaff()
    {
        String uname, passw, konfirmasi;
        System.out.print("Username : ");
        uname = input.nextLine();
        System.out.print("Password : ");
        passw = input.nextLine();
        do {
            System.out.print("Yakin ingin menambahkan Akun? (y/n) : ");
            konfirmasi = input.nextLine();
            if (konfirmasi.equalsIgnoreCase("y")) {
                akun.createAkun(uname, passw);
                System.out.println("Akun berhasil ditambahkan..");
            }
            else if (konfirmasi.equalsIgnoreCase("n"))
                System.out.println("Menambahkan Akun dibatalkan...");
            else
                System.out.println("Pilihan tidak tepat..");
        } while (!konfirmasi.equalsIgnoreCase("y") && !konfirmasi.equalsIgnoreCase("n"));
    }
    private void viewAkun()
    {
        for (int i = 0; i<akun.getSizeData(); i++)
        {
            System.out.println((i+1)+".");
            System.out.println("Username : "+akun.getUnameStaff(i));
            System.out.println("Password : "+akun.getPasswStaff(i));
            System.out.println("-----------------------------------------");
        }
    }
    private void viewAkunByIndex(int index)
    {
        System.out.printf("------------------------------------------");
        System.out.println("Username : "+akun.getUnameStaff(index));
        System.out.println("Password : "+akun.getPasswStaff(index));
        System.out.println("-----------------------------------------");
    }
    private void updateAkunByAdmin()
    {
        int pilihan;
        String konfirmasi, uname, passw;
        viewAkun();
        System.out.print("Masukkan nomor Akun yang ingin diupdate : ");
        pilihan = Integer.parseInt(input.nextLine());
        do
        {
            System.out.println("----------------------------------");
            viewAkunByIndex(pilihan-1);
            System.out.println("----------------------------------");
            System.out.print("Yakin ingin mengupdate akun ini? (y/n) : ");
            konfirmasi = input.nextLine();
            if (konfirmasi.equalsIgnoreCase("y"))
            {
                System.out.print("Username baru : ");
                uname = input.nextLine();
                System.out.print("Masukkan Password baru : ");
                passw = input.nextLine();
                akun.updateAkunByAdmin(pilihan-1, uname, passw);
            }
            else if (konfirmasi.equalsIgnoreCase("n"))
                System.out.println("Update Akun dibatalkan..");
            else
                System.out.println("Pilihan tidak tepat..");
        } while (!konfirmasi.equalsIgnoreCase("y") && !konfirmasi.equalsIgnoreCase("n"));
    }

    private void updateAkunByStaff()
    {
        String passw, repassw, konfirmasi;
        int index = akun.getIndexLogin();
        do
        {
            System.out.print("Yakin ingin mengganti Password? (y/n) : ");
            konfirmasi = input.nextLine();
            if (konfirmasi.equals("y"))
            {
                System.out.print("Masukkan Password baru : ");
                passw = input.nextLine();
                System.out.print("Masukkan ulang Password baru : ");
                repassw = input.nextLine();
                if (passw.equalsIgnoreCase(repassw))
                {
                    akun.updateAkunByStaff( index, passw);
                    System.out.println("Password berhasil diperbarui! ");
                }
                else
                    System.out.println("Password tidak sama, harap ulangi input password!");
            }
            else
                System.out.println("Proses Update akun dibatalkan..");
        } while (!konfirmasi.equalsIgnoreCase("y") || !konfirmasi.equalsIgnoreCase("n"));
    }
    private void hapusAkun()
    {
        int pilihan;
        String konfirmasi;
        viewAkun();
        System.out.print("Masukkan nomor Akun yang ingin diupdate : ");
        pilihan = Integer.parseInt(input.nextLine());
        do
        {
            viewAkunByIndex(pilihan - 1);
            System.out.print("Yakin ingin mengupdate akun ini? (y/n) : ");
            konfirmasi = input.nextLine();
            if (konfirmasi.equalsIgnoreCase("y"))
            {
                akun.deleteAkun(pilihan-1);
                System.out.println("Akun terpilih berhasil dihapus! ");
            }
            else if (konfirmasi.equalsIgnoreCase("n"))
                System.out.println("Proses hapus akun dibatalkan...");
            else
                System.out.println("Input tidak sesuai.. harap pilih (y/n)");
        } while (!konfirmasi.equalsIgnoreCase("y") && !konfirmasi.equalsIgnoreCase("n"));
    }


    private void ActivityStaff()
    {
        System.out.println("0775.Ganti Password Akun");
        System.out.println("1.Reservasi");
        System.out.println("2.Check in");
        System.out.println("3.Check out");
        System.out.println("4.Adios");
        System.out.print("Pilihan anda : ");
        String pilihan = input.nextLine();

        switch (pilihan)
        {
            case "0775" -> updateAkunByStaff();
            case "1" -> menuReservasi();
            case "2" -> System.out.println();
            case "3" -> {
                System.out.println();
            }
            case "4" -> {
                System.out.println();
            }
            default -> System.out.println("Pilihan tidak tepat");
        }
    }

    private void menuReservasi()
    {
        System.out.println("1.Mendaftar Reservasi");
        System.out.println("2.Tampilkan Daftar Reservasi");
        System.out.println("3.Update data Reservasi");
        System.out.println("4.Hapus data Reservasi");
        System.out.println("5.Exit ke Menu Utama");
        System.out.print("Pilihan Anda : ");
        String pilihan = input.nextLine();

        switch (pilihan)
        {
            case "1" -> System.out.println("UYS");
            case "2" -> System.out.println();
            case "3" -> System.out.println();
            case "4" -> System.out.println();
            default -> System.out.println("Pilihan tidak tepat");
        }
    }
    private void registerReservasi()
    {
        System.out.println("Nama pemesan : ");
        System.out.println("No.KTP       : ");
        System.out.println("No.Telepon   : ");
        System.out.println("Jadwal Kamar : ");
        System.out.println("No.Kamar     : ");
    }
}
