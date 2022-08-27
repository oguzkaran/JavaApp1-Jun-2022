/*----------------------------------------------------------------------------------------------------------------------
    Annotation:
    Annotation'lar modern programlama dillerine gittikçe daha fazla girmeye başlamıştır. Java'ya annotation'lar Java 5 ile
    eklenmiştir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

class App {
    public static void main(String[] args)
    {
        var s1 = new Student("Barış", "Er", LocalDate.of(1982, Month.JULY, 20));
        var s2 = new Student("Ceyhun", "Ersin", "Eğrek", LocalDate.of(1989, Month.AUGUST, 3));

        Console.writeLine(s1);
        Console.writeLine(s2);
    }
}

class Student {
    private String m_firstName;
    private Optional<String> m_middleNameOpt;
    private String m_lastName;
    private LocalDate m_birthDate;

    public Student(String firstName, String lastName, LocalDate birthDate)
    {
        this(firstName, null, lastName, birthDate);
    }

    public Student(String firstName, String middleName, String lastName, LocalDate birthDate)
    {
        m_firstName = firstName;
        m_middleNameOpt = Optional.ofNullable(middleName);
        m_lastName = lastName;
        m_birthDate = birthDate;
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public Optional<String> getMiddleName()
    {
        return m_middleNameOpt;
    }

    public String getLastName()
    {
        return m_lastName;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public String getFullName()
    {
        return String.format("%s%s %s", m_firstName, m_middleNameOpt.map(n -> " " + n).orElse(""), m_lastName);
    }

    public void setMiddleName(String middleName)
    {
        m_middleNameOpt = Optional.of(middleName);
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        m_lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }

    public String toString()
    {
        return String.format("%s %s", getFullName(), DateTimeFormatter.ofPattern("dd/MM/yyyy").format(m_birthDate));
    }
}
