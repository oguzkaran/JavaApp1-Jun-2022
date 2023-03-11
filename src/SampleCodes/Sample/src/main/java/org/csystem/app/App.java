/*----------------------------------------------------------------------------------------------------------------------
    Test İşlemleri:
    Yazılımda test süreçleri ürün geliştirmenin önemli bir aşamasını oluşturmaktadır. Bazı yazılımlarda, ürünün herşeyiyle
    doğru olması kritik öneme sahip olabilmektedir. Bazı yazılımların hata toleransları olabilir. Gerektiğinde sonradan
    düzeltilebilir.

    Eskiden yazılım geliştirmede test süreçleri lüks olarak değerlendiriliyordu. Bu nedenle yalnızca büyük firmalar test
    bölümleri barındırıyorlardı. Ancak günümüzde yazılımda kalite (software quality) bilinci daha fazla artmış ve test
    süreçleri daha bilinir hale gelmiştir.

    Yazılımda test süreçleri için çeşitli stratejiler kullanılabilmektedir. Test işlemi en aşağı düzeyde programcının
    kendi yazdığı kodları test etmesi ile başlar. Buna "birim testi (unit testing)" denir. Programcı genel olarak, yazmış
    olduğu bir metodun doğru çalışıp çalışmadığını test eder (duruma göre burada "etmelidir" denebilir). İşte burada bir
    metot  bir "birim (unit)" olarak düşünülür. Bir yazılımda aslında parçalar bir araya getirilir. Yani metotlar
    çağrılarak yazılım geliştirilir. Bu bir araya getirme işlemi sonucunda genellikle parçalar yeniden test edilir. Buna da
    "entegrasyon testi (integration testing)" denir. Yazılımın önemli parçalarına "modül (module)" denir. Modüller de
    ayrı ayrı test edilebilir. Buna da "module testi (module testing)" denir. Nihayet tüm ürün oluşturulur ve ürün
    bir bütün olarak test edilir. Genellikle bu testlere "kabul testi (acceptance testing)" denir. Ürün bir bütün olarak
    önce kurumun test bölümleri tarafından test edilir. Genellikle bu testlere "alfa testi (alpha testing)" denir. Sonra
    ürün seçilmiş bazı son kullanıcılara dağıtılır ve gerçek hayat testine sokulur. Buna genellikle "beta testi (beta testing)"
    denir.

    Birim testi konusunda pratikte şu 3 yaklaşımdan biri uygulanır.
    - Hiç birim testi yapmamak: Bu durum yazılım geliştirmede tavsiye edilmese de bir takım özel durumlar dolayısıyla
    firmalar tarafından uygulanamabilmektedir. Örneğin geliştirici ekibin sayı olarak azlığı, projenin deadline'ının kısa
    olması, rakip firmalardan önce ürünü çıkarma kaygısı vb. durumlarda karşılaşılabilmektedir. Buradaki yaklaşım
    programcının hiç test yapmaması değil, programcıdan test beklentisi olmaması ya da test yapılmasının özellikle istenmemesi
    gibi düşünülebilir. Şüphesiz programcı geliştirme aşamasında belirli ölçüde zaten test yapacaktır.

    - Katı katıya birim testi yapmak: Bu durumda neredeyse her birim test edilir. Örneğin bir metodun basit ya da karmaşık
    olması durumlarına bakılmaz. Bu durumda zaman kaybı olmaması için test programcılarının ayrı olması idealdir. Şüphesiz
    herhangi zaman kısıtı yoksa da uygulanabilir.

    - Gereken birimler için birim testi yapmak: Aslında görünürde en ideal durum bu olmaktadır. Görece basit olan
    birimler test edilmez ya da detaylı test edilmez. Bu durumda hangi birimlerin test edileceğinin, hangilerinin belirli
    ölçüde test edileceğinin, hangilerinin test edilmeyeceğinin belirlenmesi önemlidir. Bu da geliştiriciler ve yöneticiler
    açısından tecrübe gerektirebilir.

    Birim testi kavramı genel olarak iki biçime ayrılabilir: manuel yapılan test, otomatik araçlar ile yapılan test.
    Pratikte duruma göre ikisi de tercih edilebilse de otomatik araçlar ile yapılan testler daha kullanışlıdır. Java'da
    temel birim tesi aracı "JUnit" olsa da Spring gibi framework'lere ait olan ya da olmayan bir çok araç söz konusudur.
    Birim testleri IDE programların ve build araçları ile çok daha kullanışlı hale getirilir. Aslında bu araçların temel
    amacı birim testini programcı için mümkün olduğunca otomatize etmektir. Bu araçlar ile her zaman yapılması gerekn
    kodlama programcıya bırakılmaz. Bu durumda programcı için önemli olan uygun test senaryolarını belirlemek ve yazmaktır.
    Bu senaryolaar her zaman genel durumlar söyelenemez. Test edilecek birimin ne olduğuna göre durum değişiklik
    gösterebilir.

    Genel olarak birim testi için setup, teardown, input, expected, actual vb. kavramlar söz konudur.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}


