/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Bir okulda Fizik sınavı ortak olarak yapılıyor olsun. Kaç şube olduğu ve herbir şubede kaç öğrenci
	olduğu bilgileri klavyeden alınsın. Öğrencilerin notları rasgele olarak belirlensin. Tüm bu işlemlerden sonra Fizik
	sınavı için herbir şubenin ayrı ayrı not ortalamaları ile okulun not ortalamasını bulan simülasyonu yazınız.
	Açıklamalar:
		- Notlar int türü ile tutulacaktır
		- Programı mümkün olduğuca nesne yönelimkli ve genel düşünerek yazınız
	Not: İleride daha iyisi yazılacaktır
-----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.simulation.exam;

public class ExamSimulationApp {
    public static void run()
    {
        ExamSimulation physicsSimulation = new ExamSimulation("Fizik");
        ExamSimulation mathSimulation = new ExamSimulation("Matematik");

        physicsSimulation.run();
        physicsSimulation.printReport();
        mathSimulation.run();
        mathSimulation.printReport();
    }
}
