/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin aşağıdaki açıklamalara
	göre haftanın hangi gününe geldiğini döndüren getDayOfWeek metodunu yazınız ve aşağıdaki kod ile test ediniz.,
	Açıklamalar:
		- Metot geçersiz bir tarih için -1 değerine geri dönecektir
		- 01.01.1900 öncesindeki tarihler geçersiz kabul edilecektir
		- Haftanın günü 01.01.1900 ile verilen tarih arasındaki (verilen tarih dahil) gün sayısının 7(yedi) ile
		bölümünden elde edilen kalan alınarak belirlenebilir. Buna göre değer sıfır ise "pazar", 1 ise "pazartesi", ...,
		6 ise "cumartesi" günlerine karşılık gelir
		- Bu metot ile birlikte verilen tarihin hafta sonu olup olmadığını test eden isWeekend ve hafta içi olup olmadığını
		test eden isWeekday metotlarını da yazınız. Bu metotlar tarih geçerlilik kontrolü yapmayacaktır
		- İleride daha iyisi yazılacaktır
-----------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app.date;

public class DateApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Gün ay ve yıl bilgilerini giriniz:");
			int day = kb.nextInt();
			int month = kb.nextInt();
			int year = kb.nextInt();
			
			if (day == 0)
				break;
			
			DateUtil.printDateTR(day, month, year);
			DateUtil.printDateEN(day, month, year);
		}
		
		System.out.println("Tekrar yapıyor munuz?");
	}
}