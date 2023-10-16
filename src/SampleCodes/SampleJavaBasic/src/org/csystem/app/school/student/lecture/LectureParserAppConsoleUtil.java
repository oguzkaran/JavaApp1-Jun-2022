package org.csystem.app.school.student.lecture;

public class LectureParserAppConsoleUtil {
    public static void printLectureInfo(LectureInfo lectureInfo)
    {
        int grade = lectureInfo.getGrade();

        System.out.printf("Ad Soyad:%s%n", lectureInfo.getStudentName());
        System.out.printf("Ders Adı:%s%n", lectureInfo.getName());
        System.out.printf("Arasınav Tarihi:%s%n", lectureInfo.getMidtermDate());
        System.out.printf("Final Tarihi:%s%n", lectureInfo.getFinalDate());
        System.out.printf("Arasınav Notu:%d%n", lectureInfo.getMidtermGrade());
        System.out.printf("Final Notu:%d%n", lectureInfo.getFinalGrade());
        System.out.printf("Geçme Notu:%d%n", grade);
        System.out.printf("Sonuç:%s%n", grade >= 50 ? "Geçti" : "Kaldı");
    }

    //...
}
