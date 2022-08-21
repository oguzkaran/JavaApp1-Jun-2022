/*----------------------------------------------------------------------------------------------------------------------
    Java 8 ile birlikte java.util.function paketine bir grup fonksiyonel arayüz eklenmiştir. Bu arayüzler özellikle
    yine Java 8 ile birlikte eklenen "Stream API" tarafından kullanılmaktadır. Stream API Java'da programlama modelini
    geliştirmiştir ve kullanılbildiği yerde kesinlikle kullanılmalıdır. Stream API ileride ele alınacaktır. Şüphesiz
    bu arayüzler yalnızca Stream API ile kullanılmaz. Programcı kendi tasarladığı sınıflarda ve metotlarda da kullanabilir.
    Ayrıca Java 8 ile birlikte bu arayüzlere başka sınıflar tarafından da kullanılmaktadır:
    java.util.function paketi altında bulunan arayüzler basitçe şu şekilde gruplanabilir:
    1. Function arayüzleri: Bu arayüzler bir ya da iki tane giriş (input) alan ve bir sonuç üretilmesi işleminde kullanılır.
    Bu arayüzlerin en geneli Function ve BiFunction arayüzleridir. Bu arayüzlerin metotları applyXXX biçimindedir.

    2. Operatör arayüzleri: Bu arayüzler bir ya da iki girişe göre bi işlem yapan ve üreten durumlarda kullanılır. Bunların
    bir çoğu Function ve BiFunction arayüzlerinden türetilmiştir. Bu arayüzler genel olarak BinaryOperator ve UnaryOperator
    olarak iki gruba ayrılabilir. Bu arayüzlerin metotları applyXXX biçimindedir.

    3. Consumer arayüzleri: Bu arayüzler bir ya da iki girişe göre sadece işlem yapan, bir sonuç üretmeyen durumlarda
    kullanılır. Bu arayüzlerin metotları acceptXXX biçimindedir.

    4. Supplier arayüzleri: Bu arayüzler bir giriş almadan bir değer üretmek için kullanılır. Bu arayüzlerin metotları
    getXXX biçimindedir. getXXX metotlarının geri dönüş değeri ilgili türdendir

    5. Predicate arayüzleri: Bu arayüzler bir veya iki giriş alan ve sonucunda boolean türden bir değer üretilmesi
    gereken durumlarda kullanılır. Bu arayüzlerin test isimli metotları vardır

    Anahtar Notlar: Bu arayüzlerin temel tür karşılıkları her tür ve her işlem için bulunmaz. Bu arayüzler temel türler
    için çok kullanılan ve diğerlerinin bu türlere doğrudan (implicit) dönüşümlerinin geçerli olduğu için yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

