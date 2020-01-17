/** 
 * 
 *  @author Selim Güzelsoy - selim.guzelsoy@ogr.sakarya.edu.tr // Eda Nur Tokmak - eda.tokmak@ogr.sakarya.edu.tr
 *  @since 15.03.2019
 *  <p>
 *  Programlama Dili Prensipleri dersi 2. Ödevi * 
 *  </p>
 */

package test;
import Rastgele.RastgeleKarakter;

public class Test 
{    
    // parantez icerisinde ilk sayi islemi, ikinci sayi ise miktari belirtiyor
    public static void main(String[] args) 
    {
        RastgeleKarakter kutup=new RastgeleKarakter();//kutuphanenin okundugu yer        
        
        // 1 - rastgele sayida karakter uretme.... burada miktar uretilecek karakter adedi
        kutup.rastgeleIslemler(1, 1);
        kutup.rastgeleIslemler(1, 3);
        // 2 - iki karakter arasi rastgele sayida karakter uretme.... burada miktar uretilecek karakter adedi
        kutup.rastgeleIslemler(2, 1);
        kutup.rastgeleIslemler(2, 3);
        // 3 - alti karakter icerisinden rastgele sayida karakter uretme.... burada miktar uretilecek karakter adedi
        kutup.rastgeleIslemler(3, 1);
        kutup.rastgeleIslemler(3, 3);
        // 4 - rastgele cumle uretme.... burada miktar kelime sayisini belirtiyor
        kutup.rastgeleIslemler(4, 6);
        
        // rastgele 100 karakter uretme
        kutup.rastgeleIslemler(1, 100);
        
    }
    
}
