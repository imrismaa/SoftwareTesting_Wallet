package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    public String owner;
    public ArrayList<String> listKartu;
    public ArrayList<Integer> listUangLembaran;
    public ArrayList<Integer> listUangKoin;

    public Wallet(String owner) {
        this.owner = owner;
        this.listKartu = new ArrayList<>();
        this.listUangLembaran = new ArrayList<>();
        this.listUangKoin = new ArrayList<>();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void tambahKartu(String namaKartu) {
        listKartu.add(namaKartu);
    }

    public String ambilKartu(String namaKartu) {
        boolean isDeleted = this.listKartu.remove(namaKartu);

        if (isDeleted) {
            return namaKartu;
        } else {
            return null;
        }
    }

    public void tambahUangRupiah(int jumlahUang) {
        if (jumlahUang < 0) {
            throw new Error("jumlahUang tidak boleh minus");
        }
        if (jumlahUang > 1000) {
            listUangLembaran.add(jumlahUang);
        } else {
            listUangKoin.add(jumlahUang);
        }
    }

    public int ambilUangRupiah(int jumlahUang) {
        boolean isUangLembaranTaken = this.listUangLembaran.remove(Integer.valueOf(jumlahUang));

        if (isUangLembaranTaken) {
            return jumlahUang;
        }

        boolean isUangKoinTaken = this.listUangKoin.remove(Integer.valueOf(jumlahUang));

        if (isUangKoinTaken) {
            return jumlahUang;
        }

        return 0;
    }

    public int tampilkanUang() {
        int totalUang = 0;

        for (Integer uang : listUangLembaran) {
            totalUang += uang;
        }

        for (Integer uang : listUangKoin) {
            totalUang += uang;
        }

        return totalUang;
    }
}
