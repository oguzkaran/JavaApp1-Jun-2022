/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden aşağıdaki formatta girilen bilgiyi ayrıştırarak ekrana sonuçları yazdıran programı yazınız:
		<ad soyad>:<ders adı>:<gg/aa/yyyy>:<gg/aa/yyyy>:<arasınav notu>:<final notu>
		Oğuz Karan:Programlamaya Giriş:31/12/2022:15/01/2023:97:98
		Ali Erdem Güngör:Felsefe:29/12/2022:16/01/2023:65:64
		Bengisu Uzun Yenigün:Java ile Uygulama Geliştirme:23/12/2022:10/01/2023:89:100
		Cemil Aksel:Abap Programlama:22/12/2022:17/01/2023:89:90
		Oğuz Karan:Genel Topoloji:31/12/2022:15/01/2023:34:40

		Açıklamalar:
			- Format geçerlilik kontrolü yapılmayacaktır

			- Formatta vize ve final notlarına göre vize * 0.4 + final * 0.6 formülü ile geçme notu hesaplanacak ve sınav
			tarihleri hangi güne geldiği de eklenerek ekrana yazdırılacaktır

			- Ekran çıktısında "Geçti" ya da "Kaldı" bilgisi de olacaktır. Geçme notu 50 ve üstünde ise öğrenci dersi
			geçmiş sayılacaktır

			- Geçme notu round işlemi ile tam sayı olarak elde edilecektir

			- İleride daha iyisi yazılacaktır

			Örnek Çıktı:
				-----------------------------------------------------------------------
				Ad Soyad: Oğuz Karan
				Ders Adı: Programlamaya giriş
				Arasınav Tarihi: 31 Aralık 2022 Cumartesi
				Final Tarihi: 15 Ocak 2023 Pazar
				Arasınav Notu: 97
				Final Notu: 98
				Geçme Notu: 98
				Sonuç: Geçti
				-----------------------------------------------------------------------

		Not: Örnekte parse işlemi için ayrı bir sınıf yazılmış ve bu sınıfın ctor'u içerisinde parse işlemi yapılmıştır.
		Bu bir yaklaşımdır. Başka yaklaşımlar da söz konusu olabilir. Dikkat edilirse örnek bir uygulamanın parçası
		olacak şekilde düşünülerek yazılmıştır. Şüphesiz bazı detaylar göz ardı edilmiştir
-----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.school.student.lecture.test;


import org.csystem.app.school.student.lecture.LectureInfoParser;
import org.csystem.app.school.student.lecture.LectureParserAppConsoleUtil;

import java.util.Scanner;

public class LectureInfoParserTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if ("elma".equals(str))
                break;

            LectureInfoParser parser = new LectureInfoParser(str);

            LectureParserAppConsoleUtil.printLectureInfo(parser.getLectureInfo());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
