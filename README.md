# Programming Laboratory-I : Week 4

Java ile ders ve öğrenci kayıt sistemi: **Course Registration System with Classrooms**.

## Özellikler

- En az 3 ders oluşturur; her ders için ad ve pozitif kapasite ister.
- Dersleri ve her derse kayıtlı öğrencileri ayrı listelerde saklar.
- Girilen ders adını ders listesinde arar; bulunamazsa kayıt yapmaz.
- Kapasitesi dolan derse öğrenci eklemez.
- Aynı öğrenci numarasının aynı derse ikinci kez kaydolmasını engeller.
- Aynı öğrencinin farklı derslere kaydolmasına izin verir.
- Birden fazla öğrenci için kayıt işlemi yapılabilir.
- Sonunda ders adı, toplam kapasite, kayıtlı öğrenci sayısı ve öğrenci bilgilerini gösterir.

## Dosyalar

```text
src/week4/
├── Student.java  # Öğrenci numarası, ad ve bilgi yazdırma
├── Course.java   # Ders bilgileri, kayıt kontrolleri ve listeleme
└── Week4.java    # Kullanıcı girdileri ve program akışı
```

## Çalıştırma

Bir JDK kurulmuş ve `java` / `javac` komutları PATH üzerinde erişilebilir olmalıdır.
Repo klasöründe aşağıdaki komutları çalıştırın:

```shell
javac -encoding UTF-8 -d build src/week4/Student.java src/week4/Course.java src/week4/Week4.java
java -cp build week4.Week4
```

Ders sayısı ve kapasite alanlarına tam sayı girin. Ders adları büyük/küçük harfe duyarlıdır.
Yeni bir kayıt için `e`, işlemi bitirip sonuçları görmek için `h` girin.

## Kodun mantığı

1. `Student`, bir öğrencinin numarasını ve adını tutar.
2. `Course`, toplam kapasiteyi ve kendi öğrenci listesini tutar. Kapasite azaltılmaz;
   doluluk `enrolledStudents.size() >= capacity` ile kontrol edilir.
3. `registerStudent`, doluluk ve öğrenci numarası kontrollerini yapar. Başarısız
   bir kontrolde `return` ile metottan çıkar; aksi durumda öğrenciyi listeye ekler.
4. `Week4`, ders adını bir kez alıp bütün listede arar. Ders bulunduğunda `break`
   yalnızca arama döngüsünü bitirir; dıştaki kayıt döngüsü devam edebilir.
5. Sayı okuyan `nextInt()` çağrısından sonra `nextLine()` ile kalan satır sonu
   tüketilir. Adlar `nextLine()` ile okunduğu için birden fazla kelime içerebilir.

## Kontrol edilen senaryolar

- 3'ten az ders sayısının ve pozitif olmayan kapasitenin tekrar sorulması
- Birden fazla kelimeden oluşan ders ve öğrenci adları
- Var olmayan derse kayıt girişimi
- Başarılı kayıt
- Aynı öğrenci numarasıyla aynı derse tekrar kayıt girişimi
- Dolu derse kayıt girişimi
- Aynı öğrenci numarasının farklı bir derse kaydolması
- Son listede kapasitenin korunması ve öğrenci sayılarının doğru gösterilmesi
