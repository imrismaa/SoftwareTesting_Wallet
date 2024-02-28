package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void testSetOwner() {
        Wallet wallet = new Wallet("Minji");
        wallet.setOwner("Karina");

        Assertions.assertAll(
                () -> Assertions.assertNotNull(wallet.owner),
                () -> Assertions.assertEquals("Karina", wallet.owner),
                () -> Assertions.assertTrue(wallet.owner.length() <= 255, String.valueOf(wallet.owner.length()))
        );
    }

    @Test
    void tambahKartu() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahKartu("Kartu A");
        wallet.tambahKartu("Kartu B");

        Assertions.assertEquals("[Kartu A, Kartu B]", wallet.listKartu.toString());
    }

    @Test
    void ambilKartu1() {
        Wallet wallet = new Wallet("Minji");

        Assertions.assertNull(wallet.ambilKartu("Kartu A"));
    }

    @Test
    void ambilKartu2() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahKartu("Kartu X");
        wallet.tambahKartu("Kartu Y");
        Assertions.assertEquals("Kartu Y", wallet.ambilKartu("Kartu Y"));
    }

    @Test
    void tambahUangRupiah() {
        Wallet wallet = new Wallet("Minji");

        Assertions.assertThrows(Error.class, () -> wallet.tambahUangRupiah(-200));
    }

    @Test
    void tambahUangRupiah2() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(1000);

        Assertions.assertAll(
                () -> Assertions.assertEquals("[1000]", wallet.listUangLembaran),
                () -> Assertions.assertEquals("[]", wallet.listUangKoin)
        );
    }

    @Test
    void tambahUangRupiah3() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(2000);
        wallet.tambahUangRupiah(500);

        Assertions.assertAll(
                () -> Assertions.assertEquals("[2000]", wallet.listUangLembaran.toString()),
                () -> Assertions.assertEquals("[500]", wallet.listUangKoin.toString())
        );
    }

    @Test
    void ambilUangRupiah() {
        Wallet wallet = new Wallet("Minji");

        Assertions.assertNotNull(wallet.ambilUangRupiah(3000));
    }

    @Test
    void ambilUangRupiah2() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(200);

        Assertions.assertEquals( 5000, wallet.ambilUangRupiah(5000));
        Assertions.assertEquals(200, wallet.ambilUangRupiah(200));
    }

    @Test
    void tampilkanUang() {
        Wallet wallet = new Wallet("Minji");

        Assertions.assertEquals(0, wallet.tampilkanUang());
    }

    @Test
    void tampilkanUang2() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(200);

        Assertions.assertEquals(5200, wallet.tampilkanUang());
    }
}