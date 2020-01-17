/** 
 * 
 *  @author Selim Güzelsoy - selim.guzelsoy@ogr.sakarya.edu.tr // Eda Nur Tokmak - eda.tokmak@ogr.sakarya.edu.tr
 *  @since 15.03.2019
 *  <p>
 *  Programlama Dili Prensipleri dersi 2. Ödevi * 
 *  </p>
 */

package Rastgele;

import java.util.ArrayList;
import java.util.List;

public class RastgeleKarakter 
{  
    private long time;
    
    List<Character> secilenKarakter = new ArrayList<Character>();
    public enum harfler //harflerin tanimlandigi fonksiyon... toplam 52 karakter
    {
        a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;               
    }
    
    
    public void rastgeleIslemler(int secim, int miktar)//timer ile rastgele islemlerin yapildigi fonksiyon
    {        
        int random;
        int harfsayac1, harfsayac2, tmp;
        int kelimesayac1;
        int kelimesayac2;
        String harf1, harf2;
        
        switch(secim)
        {
            //rastgele sayida karakter uretme
            case 1:
                //miktar 1 iken sadece rastgele karakter yaziyor
                if(miktar == 1)
                {
                    System.out.print("Rastgele karakter: ");
                    time=System.nanoTime();//zamani nano olarak aliyor
                    time = time/100;//her seferinde ayni karakteri vermemesi icin bolme islemi
                    random=modAl(time,52);                    
                    System.out.print(harfler.values()[random].toString());//rastgele cikti
                    System.out.println();
                }
                //miktar 1den fazla iken miktar bilgisinide veriyor
                else
                {
                        System.out.print("Rastgele "+miktar+ " karakter: ");
                        for(int i=0; i < miktar; i++)//belirlenen miktarda rastgele cikti
                        {
                        time = System.nanoTime();
                        time = time/100;
                        harfsayac1 = modAl(time,52);                                                
                        System.out.print(harfler.values()[harfsayac1].toString());
                    }
                System.out.println();
                }
                break;
            //rastgele 2 karakter uretim arasindan harf cikartiyor    
            case 2:
                //iki sayinin secim islemi
                time = System.nanoTime();
                time = time/100;
                harfsayac1 = modAl(time,26);
                time = System.nanoTime();
                time = time/100;
                harfsayac2 = modAl(time,26);
                //ilk sayinin 2.den buyuk olma durumu
                if(harfsayac1>harfsayac2)
                {
                    tmp = harfsayac1;
                    harfsayac1 = harfsayac2;
                    harfsayac2 = tmp;
                }
                // timer ile bulunan sayilarin karakter olarak karsiligi
                harf1=harfler.values()[harfsayac1].toString();
                harf2=harfler.values()[harfsayac2].toString();
                //aralik bulma islemi                
                secilenAralik(harf1.charAt(0),harf2.charAt(0));
                System.out.print("Verilen 2 karakter ("+harf1+","+harf2+"): ");
                //belirlenen miktarda rastgele karakterin ciktisi             
                for(int i=0;i<miktar;i++)
                {                    
                    time=System.nanoTime();
                    time=time/100;                    
                    random=modAl(time, secilenKarakter.size());                                       
                    System.out.print(secilenKarakter.get(random).toString());//arraylist icerisinden rastgele secim yapiyor
                }
                System.out.println();
                break;
            //belirlenen 6 karakter arasindan secim islemi    
            case 3:
                //arraylist temizleniyor
                secilenKarakter.clear();
                //rastgele 6 karakter uretiliyor
                for(int i=0; i < 6; i++)
                {
                    time=System.nanoTime();
                    time=time/100;
                    random=modAl(time,52);
                    harf1=harfler.values()[random].toString();
                    //secilen karakterler array list ataniyor
                    secilenKarakter.add(harf1.charAt(0));
                }
                System.out.print("Belirtilen karakterler "+secilenKarakter.subList(0,secilenKarakter.size())+": ");
                // secilen karakterler icerisinden rastgele belirlenen sayida harf cekiliyor
                for(int i=0;i<miktar;i++)
                {                    
                    time=System.nanoTime();
                    time=time/100;
                    random=modAl(time, secilenKarakter.size());                                      
                    System.out.print(secilenKarakter.get(random).toString());
                }
                System.out.println();                
                break;
            // Belirlenen kelime sayisina gore rastgele cumle uret    
            case 4:
                System.out.print("Rastgele cumle uret:");                
                for(int i=0; i < miktar; i++)
                {
                    //belirlenen kelime uzunlugu en az 3 harf ayarlandi
                    time=System.nanoTime();
                    time=time/100;
                    kelimesayac1=modAl(time,10);
                    if(kelimesayac1 < 3)
                    {
                        kelimesayac1=3;
                    }
                    System.out.print(" ");
                    //her bir harf icin cikti
                    for(int j=0;j<kelimesayac1;j++)
                    {
                        time=System.nanoTime();
                        time=time/100;
                        kelimesayac2=modAl(time,52);
                        System.out.print(harfler.values()[kelimesayac2].toString());                        
                    }         
                }
                System.out.print(".");
                System.out.println();
            break;
                
        }
    }
    
     public int modAl(long deger,int mod)//elde bulunan karakter miktarina gore mod alma islemi
    {        
        int tmp=(int)(deger)%mod;            
        if(tmp<0)//degerin negatif cikmasi durumunda + olmasi icin 
        {
            tmp*=-1;
        }
        return tmp;
    }
    
    //aralik secimi esnasinda ilk karakterin dah buyuk olma ihtamaline karsi yer degistirme islemi ve atama
    public void secilenAralik(char ik, char sk)
    {
        int tmp;
        if((int)ik > (int)sk)
        {
            tmp = sk;
            sk = ik;
            ik = sk;
        }
        secilenKarakter.clear();
        ++sk;
        for(;ik!=sk;ik++)
        {
            secilenKarakter.add(ik);
        }
        
    }
    
}
