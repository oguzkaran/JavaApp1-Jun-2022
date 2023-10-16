/*----------------------------------------------------------------
	FILE		: StringUtil.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 24.06.2023

	Utility class for string operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.string;

import org.csystem.util.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public final class StringUtil {
	private StringUtil()
	{}

	private static final String ALPHABET_TR;
	private static final String ALPHABET_EN;
	private static final String ALPHABET_CAPITAL_TR;
	private static final String ALPHABET_CAPITAL_EN;
	private static final String ALPHABET_ALL_TR;
	private static final String ALPHABET_ALL_EN;

	static {
		ALPHABET_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
		ALPHABET_EN = "abcdefghijklmnopqrstuwvxyz";
		ALPHABET_CAPITAL_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
		ALPHABET_CAPITAL_EN = "ABCDEFGHIJKLMNOPQRSTUWVXYZ";
		ALPHABET_ALL_TR = ALPHABET_TR + ALPHABET_CAPITAL_TR;
		ALPHABET_ALL_EN = ALPHABET_EN + ALPHABET_CAPITAL_EN;
	}

	public static String capitalize(String s)
	{
		return s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
	}

	public static String changeCase(String s)
	{
		char [] chars = new char[s.length()];

		for (int i = 0; i < chars.length; ++i) {
			char c = s.charAt(i);

			chars[i] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
		}

		return String.valueOf(chars);
	}
	
	public static int countString(String s1, String s2)
	{
		int count = 0;		
		
		for (int i = -1; (i = s1.indexOf(s2, i + 1)) != -1; ++count)
			;
		
		return count;
	}
	
	public static int countStringIgnoreCase(String s1, String s2)
	{
		return countString(s1.toLowerCase(), s2.toLowerCase());
	}

	public static void fillRandomTexts(RandomGenerator randomGenerator, String [] texts, int n, String sourceText)
	{
		for (int i = 0; i < texts.length; ++i)
			texts[i] = getRandomText(randomGenerator, n, sourceText);
	}

	public static void fillRandomTexts(RandomGenerator randomGenerator, String [] texts, int min, int bound, String sourceText)
	{
		for (int i = 0; i < texts.length; ++i)
			texts[i] = getRandomText(randomGenerator, randomGenerator.nextInt(min, bound), sourceText);
	}

	public static void fillRandomTextsTR(RandomGenerator randomGenerator, String [] texts, int n)
	{
		fillRandomTexts(randomGenerator, texts, n, ALPHABET_ALL_TR);
	}

	public static void fillRandomTextsTR(RandomGenerator randomGenerator, String [] texts, int min, int bound)
	{
		fillRandomTexts(randomGenerator, texts, min, bound, ALPHABET_ALL_TR);
	}

	public static void fillRandomTextsEN(RandomGenerator randomGenerator, String [] texts, int n)
	{
		fillRandomTexts(randomGenerator, texts, n, ALPHABET_ALL_EN);
	}

	public static void fillRandomTextsEN(RandomGenerator randomGenerator, String [] texts, int min, int bound)
	{
		fillRandomTexts(randomGenerator, texts, min, bound, ALPHABET_ALL_EN);
	}

	public static String getRandomText(RandomGenerator randomGenerator, int n, String sourceText)
	{
		char [] c = new char[n];
		int len = sourceText.length();
		
		for (int i = 0; i < n; ++i)
			c[i] = sourceText.charAt(randomGenerator.nextInt(len));
		
		return String.valueOf(c);
	}

	public static String [] getRandomTexts(RandomGenerator randomGenerator, int count, int min, int bound, String sourceText)
	{
		String [] texts = new String[count];

		fillRandomTexts(randomGenerator, texts, min, bound, sourceText);

		return texts;
	}

	public static String [] getRandomTexts(RandomGenerator randomGenerator, int count, int n, String sourceText)
	{
		String [] texts = new String[count];

		fillRandomTexts(randomGenerator, texts, n, sourceText);

		return texts;
	}
	
	public static String getRandomTextEN(int n)
	{
		return getRandomTextEN(new Random(), n);
	}
	
	public static String getRandomTextEN(RandomGenerator randomGenerator, int n)
	{
		return getRandomText(randomGenerator, n, ALPHABET_ALL_EN);
	}	
	
	public static String getRandomTextTR(int n)
	{
		return getRandomTextTR(new Random(), n);
	}	
	
	public static String getRandomTextTR(RandomGenerator randomGenerator, int n)
	{
		return getRandomText(randomGenerator, n, ALPHABET_ALL_TR);
	}

	public static String [] getRandomTextsTR(RandomGenerator r, int count, int min, int bound)
	{
		return getRandomTexts(r, count, min, bound, ALPHABET_ALL_TR);
	}

	public static String [] getRandomTextsTR(RandomGenerator randomGenerator, int count, int n)
	{
		return getRandomTexts(randomGenerator, count, n, ALPHABET_ALL_TR);
	}

	public static String [] getRandomTextsEN(RandomGenerator randomGenerator, int count, int min, int bound)
	{
		return getRandomTexts(randomGenerator, count, min, bound, ALPHABET_ALL_EN);
	}

	public static String [] getRandomTextsEN(RandomGenerator randomGenerator, int count, int n)
	{
		return getRandomTexts(randomGenerator, count, n, ALPHABET_ALL_EN);
	}

	public static String getShortestPangramEN(String s)
	{
		String result = s;
		
		int end = s.length();
		
		while (end != 0) {
			int begin = 0;
			
			while (begin != end) {
				String str = s.substring(begin++, end);
				
				if (str.length() >= 26 && isPangramEN(str) && str.length() < result.length())
					result = str;
			}
			
			--end;
		}
		
		return result;
	}
	
	public static String getShortestPangramTR(String s)
	{
		String result = s;
		
		int end = s.length();
		
		while (end != 0) {
			int begin = 0;
			
			while (begin != end) {
				String str = s.substring(begin++, end);
				
				if (str.length() >= 29 && isPangramTR(str) && str.length() < result.length())
					result = str;
			}
			
			--end;
		}
		
		return result;
	}

	public static boolean isIdentifier(String s)
	{
		if (s.isBlank() || s.equals("_"))
			return false;

		if (!Character.isJavaIdentifierStart(s.charAt(0)))
			return false;

		int len = s.length();

		for (int i = 1; i < len; ++i)
			if (!Character.isJavaIdentifierPart(s.charAt(i)))
				return false;

		return true;
	}
	
	public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;
		boolean cLeftSelected = false, cRightSelected = false;
		char cLeft = '\0', cRight;
		
		while (left < right) {			
			if (!cLeftSelected) {
				cLeft = Character.toLowerCase(s.charAt(left));
				
				if (!Character.isLetter(cLeft)) {
					++left;
					continue;
				}
				cLeftSelected = true;
			}
			
			if (!cRightSelected) {
				cRight = Character.toLowerCase(s.charAt(right));
				
				if (!Character.isLetter(cRight)) {
					--right;
					continue;
				}
				
				if (cLeft != cRight)
					return false;
				
				cRightSelected = true;
			}			
			
			++left;
			--right;			
			
			cLeftSelected = cRightSelected = false;
		}
		
		return true;
	}
	
	public static boolean isPangram(String s, String alphabet)
	{
		int len = alphabet.length();
		
		for (int i = 0; i < len; ++i)
			if (s.indexOf(alphabet.charAt(i)) == -1)
				return false;
		
		return true;
	}
	
	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
	}
	
	public static boolean isPangramTR(String s)
	{
		return isPangram(s.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
	}

	public static String join(String [] s, char delimiter)
	{
		return join(s, String.valueOf(delimiter));
	}

	public static String join(String [] s, String delimiter)
	{
		StringBuilder sb = new StringBuilder();

		for (String str : s)
			sb.append(str).append(delimiter);

		return sb.substring(0, sb.length() - delimiter.length());
	}


	public static String join(ArrayList<String> list, char delimiter)
	{
		return join(list, String.valueOf(delimiter));
	}
	public static String join(ArrayList<String> list, String delimiter)
	{
		StringBuilder sb = new StringBuilder();

		for (String str : list)
			sb.append(str).append(delimiter);

		return sb.substring(0, sb.length() - delimiter.length());
	}
	
	public static String padLeading(String s, int len, char ch)
	{
		int length  = s.length();
		
		return len <= length ? s : repeat(len - length, ch) + s;
	}
	
	public static String padLeading(String s, int len)
	{
		return padLeading(s, len, ' ');
	}
	
	public static String padTrailing(String s, int len, char ch)
	{
		int length  = s.length();
		
		return len <= length ? s : s + repeat(len - length, ch);
	}
	
	public static String padTrailing(String s, int len)
	{
		return padTrailing(s, len, ' ');
	}

	public static void print(ArrayList<String> list)
	{
		for (String s : list)
			System.out.println(s);
	}
	
	public static String repeat(int count, char ch)
	{
		return String.format("%0" + count + "d", 0).replace('0', ch);
	}	
	
	public static String reverse(String s)
	{
		char [] c = s.toCharArray();

		ArrayUtil.reverse(c);
		return String.valueOf(c);
	}

	public static String [] split(String str, String delimiters)
	{
		return split(str, delimiters, false);
	}

	public static String [] split(String str, String delimiters, boolean removeEmptyEntries)
	{
		StringBuilder patternBuilder = new StringBuilder();
		int len = delimiters.length();


		for (int i = 0; i < len; ++i) {
			char c = delimiters.charAt(i);
			patternBuilder.append((c == '[' || c == ']') ? ("\\" + c) : c);
		}

		return str.split(patternBuilder.append("]").append(removeEmptyEntries ? "+" : "").toString());
	}

	public static String squeeze(String s1, String s2)
	{
		StringBuilder sb = new StringBuilder();
		int len = s1.length();

		for (int i = 0; i < len; ++i) {
			char c = s1.charAt(i);

			if (!s2.contains(String.valueOf(c)))
				sb.append(c);
		}

		return sb.toString();
	}
	
	public static String trimLeading(String s)
	{
		int i;		
		int len = s.length();
		
		for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
			;
		
		return s.substring(i);
	}
	
	public static String trimTrailing(String s)
	{
		int i;

		for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
			;
		
		return s.substring(0, i + 1);
	}

	public static String wrapWith(String s, char prefix, char suffix)
	{
		return wrapWith(s, String.valueOf(prefix), String.valueOf(suffix));
	}

	public static String wrapWith(String s, String prefix, String suffix)
	{
		return String.format("%s%s%s", prefix, s, suffix);
	}

	public static String wrapWithStrip(String s, char prefix, char suffix)
	{
		return wrapWithStrip(s, String.valueOf(prefix), String.valueOf(suffix));
	}

	public static String wrapWithStrip(String s, String prefix, String suffix)
	{
		return wrapWith(s.strip(), prefix, suffix);
	}

	public static String wrapWithBracesStrip(String s)
	{
		return wrapWithStrip(s, '(', ')');
	}

	public static String wrapWithBraces(String s)
	{
		return wrapWith(s, '(', ')');
	}

	public static String wrapWithCurlyBracesStrip(String s)
	{
		return wrapWithStrip(s, '{', '}');
	}

	public static String wrapWithCurlyBraces(String s)
	{
		return wrapWith(s, '{', '}');
	}
}


