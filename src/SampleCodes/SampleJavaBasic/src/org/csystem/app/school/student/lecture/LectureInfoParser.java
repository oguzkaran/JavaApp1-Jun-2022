package org.csystem.app.school.student.lecture;

import org.csystem.app.date.DateUtil;

public class LectureInfoParser {
    private final LectureInfo m_lectureInfo;

    public static String getDateStr(String str)
    {
        String [] dateInfo = str.split("[/]");

        return DateUtil.getDateStrTR(Integer.parseInt(dateInfo[0]), Integer.parseInt(dateInfo[1]), Integer.parseInt(dateInfo[2]));
    }

    public LectureInfoParser(String str)
    {

        String [] lectureInfoStr = str.split("[:]+");

        //...

        m_lectureInfo = new LectureInfo();
        m_lectureInfo.setStudentName(lectureInfoStr[0]);
        m_lectureInfo.setName(lectureInfoStr[1]);
        m_lectureInfo.setMidtermDate(getDateStr(lectureInfoStr[2]));
        m_lectureInfo.setFinalDate(getDateStr(lectureInfoStr[3]));
        m_lectureInfo.setMidtermGrade(Integer.parseInt(lectureInfoStr[4]));
        m_lectureInfo.setFinalGrade(Integer.parseInt(lectureInfoStr[5]));
    }

    public LectureInfo getLectureInfo()
    {
        return m_lectureInfo;
    }
}
