package org.example;

import org.junit.jupiter.api.*;

class WalletTest {

    public Wallet wallet;
    @BeforeEach
    void setupMethod() {
        wallet = new Wallet("Minji");
    }

    @AfterEach
    void cleanMethod(){
        wallet = null;
    }


    @Test
    void testSetOwner() {
        wallet.setOwner("Karina");

        Assertions.assertAll(
                () -> Assertions.assertNotNull(wallet.owner),
                () -> Assertions.assertEquals("Karina", wallet.owner)
        );
    }

    @Test
    void testTambahKartu() {
        wallet.tambahKartu("Kartu A");
        wallet.tambahKartu("Kartu B");

        Assertions.assertEquals(2, wallet.listKartu.size());
        Assertions.assertTrue(wallet.listKartu.contains("Kartu A"));
        Assertions.assertTrue(wallet.listKartu.contains("Kartu B"));
    }

    @Test
    void testAmbilKartu() {
        wallet.ambilKartu("Kartu X");

        Assertions.assertNull(wallet.ambilKartu("Kartu X"));
    }

    @Test
    void testAmbilKartu2() {
        wallet.tambahKartu("Kartu X");
        wallet.tambahKartu("Kartu Y");

        Assertions.assertEquals("Kartu Y", wallet.ambilKartu("Kartu Y"));
        Assertions.assertEquals(1, wallet.listKartu.size());
    }

    @Test
    void testTambahUangRupiah() {
        Assertions.assertThrows(Error.class, () -> wallet.tambahUangRupiah(-200));
    }

    @Test
    void testTambahUangRupiah2() {
        wallet.tambahUangRupiah(900);

        Assertions.assertTrue(wallet.listUangKoin.contains(900));
        Assertions.assertEquals(0, wallet.listUangLembaran.size());
    }

    @Test
    void testTambahUangRupiah3() {
        wallet.tambahUangRupiah(1000);

        Assertions.assertTrue(wallet.listUangKoin.contains(1000));
        Assertions.assertEquals(0, wallet.listUangLembaran.size());
    }

    @Test
    void testTambahUangRupiah4() {
        wallet.tambahUangRupiah(50000);

        Assertions.assertTrue(wallet.listUangLembaran.contains(50000));
        Assertions.assertEquals(0, wallet.listUangKoin.size());
    }

    @Test
    void testAmbilUangRupiah() {
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(200);

        wallet.ambilUangRupiah(5000);
        wallet.ambilUangRupiah(200);

        Assertions.assertEquals(1, wallet.listUangLembaran.size());
        Assertions.assertFalse(wallet.listUangKoin.contains(200));
        Assertions.assertTrue(wallet.listUangLembaran.contains(5000));
    }

    @Test
    void testTampilkanUang1() {
        Assertions.assertEquals(0, wallet.tampilkanUang());
    }

    @Test
    void testTampilkanUang2() {
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(200);

        Assertions.assertEquals(5200, wallet.tampilkanUang());
    }
}