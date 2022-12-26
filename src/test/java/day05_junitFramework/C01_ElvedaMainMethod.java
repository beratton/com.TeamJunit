package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {
    @Test
    public void test01(){
        System.out.println("test01 calisti");
        // Test notasyonu sayesinde her bir test metodu bagimsiz olarak calistirilabilir.
        // Eger testin icerisinde bir assertion (iddia/test) yoksa
        // kod problem yasanmadan biter ve Junit Test Passed olarak raporlar.
    }
    @Test @Ignore // Ignore notasyonu test metodunun calistirilmamasini saglar.
    public void test02(){
        System.out.println("test02 calisti");
    }
    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }
}
