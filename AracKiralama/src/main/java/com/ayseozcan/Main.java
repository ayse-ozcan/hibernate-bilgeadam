package com.ayseozcan;

import com.ayseozcan.controller.AracController;
import com.ayseozcan.controller.KiralamaController;
import com.ayseozcan.controller.MusteriController;
import com.ayseozcan.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static AracController aracController = new AracController();
    private MusteriController musteriController = new MusteriController();
    private KiralamaController kiralamaController = new KiralamaController();

    public static void main(String[] args) throws ParseException {
        Main main = new Main();
        main.anaMenu();
        findByYakitAndYilStream();
    }

    private void anaMenu() throws ParseException {

        int input = 0;
        do {
            System.out.println("1- arac ekle");
            System.out.println("2- kisi ekle");
            System.out.println("3- arac arama");
            System.out.println("4- kiralama yap");
            System.out.println("5- raporlama menusu");
            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    aracEkle();
                    break;
                case 2:
                    kisiEkle();
                    break;
                case 3:
                    aracAra();
                    break;
                case 4:
                    kiralamaYap();
                    break;
                case 5:
                    raporlamaMenusu();
                    break;
            }
        } while (input != 0);
    }

    private void raporlamaMenusu() throws ParseException {

        int input = 0;
        do {
            System.out.println("1- su an kirada olan araclar");
            System.out.println("2- bosta olan araclar");
            System.out.println("3- herhangi bir musterinin kiraladigi araclar");
            System.out.println("4- yakit turune gore arama yap");
            System.out.println("5- girilen tarihe kadar olan kiralamalari getir");
            System.out.println("6- yakit turu ve yila gore filtrele");
            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    kiradakiAraclarList();
                    break;
                case 2:
                    bostaOlanAraclar();
                    break;
                case 3:
                    musteriyeGoreKiralananAraclar();
                    break;
                case 4:
                    yakitTuruneGoreAra();
                    break;
                case 5:
                    tarihineKadarOlanKiralamalar();
                case 6:
                    findByYakitAndYilStream();
                    break;

            }
        } while (input != 0);
    }

    private static void findByYakitAndYilStream() throws ParseException {
        System.out.println("yakit turunu girin: ");
        EYakitTuru eYakitTuru = EYakitTuru.valueOf(scanner.nextLine());


        SimpleDateFormat d = new SimpleDateFormat("YYYY-MM-DD");
        String date;
        System.out.println("Enter the string in this form: YYYY-MM-DD");
        date = scanner.nextLine();
        System.out.println(d.parse(date));
        aracController.findByYakitAndYilStream(eYakitTuru, LocalDate.parse(date)).
                forEach(arac -> System.out.println(arac.getMarka() + " " + arac.getModel()));

    }

    private void tarihineKadarOlanKiralamalar() {
        System.out.println("yil girin: ");
        int yil = Integer.parseInt(scanner.nextLine());
        System.out.println("ay girin: ");
        int ay = Integer.parseInt(scanner.nextLine());
        System.out.println("gun girin: ");
        int gun = Integer.parseInt(scanner.nextLine());

        LocalDate date = LocalDate.of(yil, ay, gun);

        kiralamaController.tarihineKadarOlanKiralamalar(date).
                forEach(kiralama -> System.out.println("son gunu: " + kiralama.getKiralamaBitis()
                        + "model: " + kiralama.getArac().getModel()));
    }

    private void yakitTuruneGoreAra() {
        System.out.println("aradiginiz aracin yakit turu ");
        EYakitTuru yakitTuru = EYakitTuru.valueOf(scanner.nextLine().toUpperCase());
        System.out.println(aracController.findByYakitTuru(yakitTuru));
    }

    private void musteriyeGoreKiralananAraclar() {
        System.out.println("musteri id: ");
        int musteriId = Integer.parseInt(scanner.nextLine());
        Optional<Musteri> optionalMusteri = musteriController.findById(musteriId);
        optionalMusteri.get().getKiralamaList().forEach(x -> System.out.println(x.getArac()));
    }

    private void kiradakiAraclarList() {
        aracController.findAllByDurum(true).forEach(x -> System.out.println(x.getMarka()));
    }

    private void bostaOlanAraclar() {
        aracController.findAllByDurum(false).forEach(x -> System.out.println(x.getMarka()));
    }

    private void kiralamaYap() {
        List<Arac> aracList = aracController.findAllByDurum(false);
        if (aracList != null) {
            aracList.forEach(x -> System.out.println("ID: " + x.getId() + " ---- " + x.getMarka() + " ---- " + x.getModel()));

            System.out.println("kiralamak istediginiz aracin id si: ");
            long aracId = Long.parseLong(scanner.nextLine());
            Optional<Arac> optionalArac = aracController.findById(aracId);

            System.out.println("id nizi girin: ");
            long musteriId = Long.parseLong(scanner.nextLine());
            Optional<Musteri> optionalMusteri = musteriController.findById(musteriId);

            if (optionalArac.isPresent() && optionalMusteri.isPresent()) {
                Arac arac = optionalArac.get();
                Musteri musteri = optionalMusteri.get();
                System.out.println("kac gun kiralamak istiyorsunuz? :");
                int days = Integer.parseInt(scanner.nextLine());
                Kiralama kiralama = Kiralama.builder().kiralamaBaslangic(LocalDate.now()).
                        kiralamaBitis(LocalDate.now().plusDays(days))
                        .arac(arac).musteri(musteri).build();
                kiralamaController.save(kiralama);
                musteri.getKiralamaList().add(kiralama);
                arac.setDurum(true);
                aracController.update(arac);
                musteriController.update(musteri);
                musteri.getKiralamaList().forEach(x -> System.out.println(x.getArac().getMarka()));
            }
        }
    }

    private void aracAra() {

        System.out.println("goruntulemek istediginiz aracin markasi:");
        String aracMarka = scanner.nextLine();
        System.out.println("goruntulemek istediginiz aracin modeli:");
        String aracModel = scanner.nextLine();
        //aracController.findByMarkaAndModel(aracMarka, aracModel).forEach(x -> System.out.println(x.getMarka() + " " + x.getModel()));
        aracController.findByMarkaAndModelStream(aracMarka, aracModel).forEach(x -> System.out.println(x.getMarka() + " " + x.getModel()));
    }

    private void aracEkle() {

        System.out.println("marka girin");
        String marka = scanner.nextLine();
        System.out.println("model girin");
        String model = scanner.nextLine();

        System.out.println("yil girin: ");
        int yil = Integer.parseInt(scanner.nextLine());
        System.out.println("ay girin: ");
        int ay = Integer.parseInt(scanner.nextLine());
        System.out.println("gun girin: ");
        int gun = Integer.parseInt(scanner.nextLine());

        LocalDate date = LocalDate.of(yil, ay, gun);

        System.out.println("vites tipi");
        EVitesTipi vitesTipi = EVitesTipi.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("yakit turu");
        EYakitTuru yakitTuru = EYakitTuru.valueOf(scanner.nextLine().toUpperCase());
        Arac arac = Arac.builder().marka(marka).model(model).yil(date).
                eVitesTipi(vitesTipi).eYakitTuru(yakitTuru).build();
        aracController.saveArac(arac);

    }

    private void kisiEkle() {

        System.out.println("name girin");
        String name = scanner.nextLine();
        System.out.println("surname girin");
        String surname = scanner.nextLine();
        System.out.println("adres girin");
        String adres = scanner.nextLine();
        System.out.println("telefon girin");
        String telefon = scanner.nextLine();
        System.out.println("mail girin");
        String mail = scanner.nextLine();
        Musteri musteri = Musteri.builder().name(name).surname(surname)
                .address(adres).telefon(telefon).email(mail).build();
        musteriController.saveKisi(musteri);
    }
}
