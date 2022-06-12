/*----------------------------------------------------------------------------------------------------------------------
    Aslında bilgisayar sistemlerinde ekrana (ya da daha genel haliyle stdout'a) sayı yazdırmak diye birşey yoktur. Ekrana
    yalnızca karakterler yazdırılabilir. Örneğin System.out.println metodu int türden bir tamsayıyı yazdırırken sayıyı
    basamaklarına ayrıştırıp herbir basamapa karşılık gelen karakterleri ekrana basmaktadır veya bu işlemi bir metodu
    doğrudan ya da dolaylı olarak çağırmaktadır.

    Java'da ekrana basma işlemi yüksek seviyeli bir işlemdir. Burada PrintStream sınıfının int parametreli write metodu
    kullanılarak anlatılan algoritmalar gerçekleştirilecektir. Bu metot bir karakteri ekrana basmak için kullanılır. Tüm
    diğer ekrana basan metotlar "bu metodu doğrudan ya da dolaylı olarak çağırır" biçiminde düşünülebilir. Buradaki
    parametrenin int türden olması sizi yanıltmasın. write metodu parametresi ile aldığı int türden bir sayıyı karakter
    sıra numarası kabul ederek karşılık gelen karakteri ekrana basar.

    Anahtar Notlar:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.recursion.test.RecursiveWriteNumberTest;

class App {
    public static void main(String[] args)
    {
        RecursiveWriteNumberTest.run();
    }
}

