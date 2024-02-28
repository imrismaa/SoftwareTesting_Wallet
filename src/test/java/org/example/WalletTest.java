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
    void testTambahKartu() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahKartu("Kartu A");
        wallet.tambahKartu("Kartu B");

        Assertions.assertEquals("[Kartu A, Kartu B]", wallet.listKartu.toString());
    }

    @Test
    void testAmbilKartu1() {
        Wallet wallet = new Wallet("Minji");

        Assertions.assertNull(wallet.ambilKartu("Kartu A"));
    }

    @Test
    void testAmbilKartu2() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahKartu("Kartu X");
        wallet.tambahKartu("Kartu Y");
        Assertions.assertEquals("Kartu Y", wallet.ambilKartu("Kartu Y"));
    }

    @Test
    void testTambahUangRupiah1() {
        Wallet wallet = new Wallet("Minji");

        Assertions.assertThrows(Error.class, () -> wallet.tambahUangRupiah(-200));
    }

    @Test
    void testTambahUangRupiah2() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(1000);

        Assertions.assertAll(
                () -> Assertions.assertEquals("[1000]", wallet.listUangLembaran),
                () -> Assertions.assertEquals("[]", wallet.listUangKoin)
        );
    }

    @Test
    void testTambahUangRupiah3() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(2000);
        wallet.tambahUangRupiah(500);

        Assertions.assertAll(
                () -> Assertions.assertEquals("[2000]", wallet.listUangLembaran.toString()),
                () -> Assertions.assertEquals("[500]", wallet.listUangKoin.toString())
        );
    }


    @Test
    void testAmbilUangRupiah() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(200);

        Assertions.assertEquals( 5000, wallet.ambilUangRupiah(5000));
        Assertions.assertEquals(200, wallet.ambilUangRupiah(200));
    }

    @Test
    void testTampilkanUang1() {
        Wallet wallet = new Wallet("Minji");

        Assertions.assertEquals(0, wallet.tampilkanUang());
    }

    @Test
    void testTampilkanUang2() {
        Wallet wallet = new Wallet("Minji");
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(200);

        Assertions.assertEquals(5200, wallet.tampilkanUang());
    }
}