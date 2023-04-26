
package com.ayseozcan.repository.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 * Java icinde varlik olarak tanimlanan sinifimizin
 * ozelliklerini belirliyor ve bir Entity oldugunu belirtiyoruz.
 * Boylelikle hibernate bunu map edebiliyor.
 * 
 */

@Entity(name = "Musteri")

/**
 * Hibernate in java sinifimizi eslestirecegi veritabanindaki tablonun ozelliklerini
 * burada belirtiyoruz.
 */
@Table(name = "tblmuateri", schema = "public", catalog = "hibernateornek",
        uniqueConstraints = {@javax.persistence.UniqueConstraint(columnNames = "musterino")
        })
public class Musteri {
   
    /**
     * her varligin mutlaka bir id si olmalidir ve bu id @id ile isaretlenmelidir
     * hibernate tablo-class iliskisini kurarken bunlar uzerinden kuracaktir.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // her bir tablo icin ayri bir seq olusturur
    Long id;
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // HER BIR TABLO ICIN SEQUENCE OLUSTURUR
    Long other_id;
    @GeneratedValue(strategy = GenerationType.AUTO) // tek bir sayac uzerinden tum tablolarimizi numalandirir
    Long other2_id;
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long other3_id;
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID uuid;
    
    @SequenceGenerator(name = "sq_musterino", //java ici seq name
            sequenceName = "sq_musterino",//database uzerindeki name
            initialValue = 6000, // baslangic degeri
            allocationSize = 5 // atris sayisi 
    )
    @GeneratedValue(generator = "sq_musterino", strategy = GenerationType.SEQUENCE)        
    Long musteriNo;
    
    /**
     * KOLON BILGILERI EGER OZELLIKLE BELIRTILMEZ ISE
     * DEFAULT DEGERLER ILE YOLUNA DEVAM EDER
     */
    
    @Column(length = 100, //Default[255]
            name = "name",
            unique = false,
            insertable = true, //bu alan eger false yapilirsa buraya girilen kayitlar DB ye yansitilamaz.)
            updatable = false // bu alan false olur ise var olan kayit asla degistirilemez
            )
    String ad;
    
    /**
     * buyuk veriler tutacaksaniz kullanilir,
     * Bunlar genellikle base64 formatinda tutulan dosyalar seklinde karsimiza cikar.
     */
    @Lob
    String adres;
    
    Long kayitTarihi;
    
    /**
     * tarih degiskenlerini kullanabilmek icin kullanmak zorundasiniz
     * @Temporal
     * -> Date = TemporalType.DATE -- tarih - 01.05.2023 carsamba
     * -> Time = TemporalType.TIME -- zamani - 15:30:25.015
     * -> Timestamp = TemporalType.TIMESTAMP -- zaman damgasi - Çarşamba, 19 Nisan 2023 14:23:28 GMT+03:00
     */
    @Temporal(TemporalType.TIMESTAMP)
    Date dogumTarihi;
    
    /**
     * Embeddable, siniflarin entity icine dahil edilmesini saglar.
     */
    @Embedded
    BaseEntity baseEntity;
    
    /**
     * Koleksiyonlarin hibernate tarafindan yonetilebilmesi ve gerekli
     * tablolarin olusturulabilmesi icin kullnilir.
     * sistem soyle isliyor;
     * hobiler ayri bir tabloda tutluyor ve baglanilan tablonun id si bu yeni
     * tabloda foreign key olarak ekleniyor.
     */
    @ElementCollection
    /**
     * Eger hibernate tarafindan otomatik olarak olusturulan tablonun
     * ozellestirilmesini istiyorsak; bu duzenleyecegimiz @CollectionTable
     * kullaniriz.
     */
    @CollectionTable(name = "tblmusteri_hobileri", schema = "public", catalog = "hibernateornek",
            joinColumns = @JoinColumn(name = "musteri_id")) 
    List<String> hobileri;
    
    /**
     * EnumType.ORDINAL - secilen enum un sayisal degerini DB ye yazar
     * EnumType.STRING  - secilen enum un sTRING degerini DB ye yazar
     */
    @Enumerated(EnumType.STRING)
    Cinsiyet cinsiyet;
    
    @ElementCollection
    @CollectionTable(name = "tblmusteri_adresleri", joinColumns = @JoinColumn(name = "id")) 
    @MapKeyColumn(name = "adrestipi")
    @MapKeyEnumerated(EnumType.STRING)
    Map<AdresTipi, String> adresler;
    
    String soyad;
    /**
     * veritabaninda tutulmasini istemedigimiz ancak sinif icinde
     * bir konfsiyonu olan degisken turlerini asagidaki anotasyon ile isaretlemeliyiz.
     */
 
    @Transient
    String adsoyad;
    
    //--------------------------------------------------------------------------
    /**
     * Tablolar arasindaki iliskilerin hibernate uzerinden tanimlanmasi
     * Tablolar arasinda iliskiler su sekilde listelenir;
     * OneToOne
     * OneToMany
     * ManyToOne
     * ManyToMany
     */
    
    /**
     * ilk olarak kurguyu belirleyin ve buna gore
     * ilgili anatosyonu ekletin
     * CascadeType.ALL -> DBye eklene yapilirken belli kayitlar 
     * birbirlerine iliskilendirilir.
     * Bu nedenle iliskilendirilecek olan kayidin mutlaka bulunmasi gereklidir.
     * Yani is olmadan musteri tanimi yapmak mumkun olmayacaktir.
     * Burada alternatif olarak eger bir bagli yabanci anahtar mevcut degilse, 
     * cascade ile once ilgili tabloda o kayit olusturulur
     * sonra ana tabloya islenen bilgiler ile kayit tamamlanir.
     */
    @OneToMany(cascade = CascadeType.ALL)
    /**
     * asagida iozellestirilen bilgiler olmasa da olur.
     * Ancak biz olusacak bu cross tablonun ozelliklerini degistirmek istiyorsak 
     * asagidaki gibi parametre gecebiliriz.
     */
    @JoinTable(name = "tblmusteri_islistesi", 
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "is_id"))        
    List<Is> isListesi;
    
    
    
 }
