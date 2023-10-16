package org.csystem.app.date;

public class DateUtil {
	public static int [] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static String [] dayOfWeeksTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
	public static String [] dayOfWeeksEN = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	public static String [] monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz",
										"Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
	public static String [] monthsEN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public static String getDateStrTR(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		return String.format("%d %s %04d %s", day, monthsTR[month], year, dayOfWeeksTR[dayOfWeek]);
	}

	public static void printDateTR(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);
		
		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}
		
		printDateByDayOfWeekTR(day, month, year, dayOfWeek);	
		
		System.out.println(isWeekend(day, month, year) ? "Bugün kurs var. Tekrar yaptınız mı?" : "Kurs günü yaklaşıyor. Tekrar yapmayı unutmayınız!...");		
	}

	public static void printDateEN(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		if (dayOfWeek == -1) {
			System.out.println("Invalid date");
			return;
		}

		printDateByDayOfWeekEN(day, month, year, dayOfWeek);

		System.out.println(isWeekend(day, month, year) ? "Today is a course day. Did you review?" : "Course day is coming. Do not forget to review!...");
	}

	public static void printDateByDayOfWeekTR(int day, int month, int year, int dayOfWeek)
	{
		System.out.printf("%d %s %04d %s%n", day, monthsTR[month], year, dayOfWeeksTR[dayOfWeek]);
	}

	public static void printDateByDayOfWeekEN(int day, int month, int year, int dayOfWeek)
	{
		System.out.printf("%d%s %s %04d %s%n", day, getDaySuffix(day), monthsEN[month], year, dayOfWeeksEN[dayOfWeek]);
	}

	public static String getLongDateTR(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);

		return String.format("%d %s %04d %s", day, monthsTR[month], year, dayOfWeeksTR[dayOfWeek]);
	}
	
	public static int getDayOfWeek(int day, int month, int year)
	{
		int totalDays;		
		
		return (year < 1900 || (totalDays = getDayOfYear(day, month, year)) == -1) ? -1 : (getTotalDays(year, totalDays) % 7);
	}
	
	public static int getTotalDays(int year, int totalDays)
	{
		for (int y = 1900; y < year; ++y)
			totalDays += isLeapYear(y) ? 366 : 365;		
		
		return totalDays;
	}

	public static String getDaySuffix(int day)
	{
		return switch (day) {
			case 1, 21, 31 -> "st";
			case 2, 22 -> "nd";
			case 3, 23 -> "rd";
			default -> "th";
		};
	}
	
	public static boolean isWeekend(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);
		
		return dayOfWeek == 0 || dayOfWeek == 6;
	}
	
	public static boolean isWeekday(int day, int month, int year)
	{
		return !isWeekend(day, month, year);
	}
	
	public static int getDayOfYear(int day, int month, int year)
	{
		if (!isValidDate(day, month, year))
			return -1;		

		int total = day;

		for (int m = month - 1; m >= 1; --m)
			total += daysOfMonths[m - 1];
		
		return month > 2 && isLeapYear(year) ? total + 1 : total;
	}
	
	public static boolean isValidDate(int day, int month, int year)
	{
		return 1 <= day && day <= 31 && 1 <= month && month <= 12 && day <= getDays(month, year);
	}
	
	public static int getDays(int month, int year)
	{
		return month == 2 && isLeapYear(year) ? 29 : daysOfMonths[month - 1];
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}