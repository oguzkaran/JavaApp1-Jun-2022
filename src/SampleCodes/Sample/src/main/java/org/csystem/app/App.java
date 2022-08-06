/*----------------------------------------------------------------------------------------------------------------------
    Yerel sınıflar (local classes): Bir metot içerisinde bildirilen sınıflara denir. Farklı faaliyet alanları (scope)
    içerisinde aynı isimde yerel sınıf bildirimi geçerlidir. Aynı faaliyet alanı içerisinde aynı isimde sınıf bildirimi
    geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class A {
    //...
}

class Sample {
    public  void foo()
    {
        class A {
            //...
        }
    }

    public  void bar()
    {
        class A {
            //...
        }
    }
}