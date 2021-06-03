
package yazlab;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import java.io.*;
import javax.swing.JOptionPane;
public class yazlab extends JFrame {
	public static int matris[][];// normal matris
	public static ArrayList<Integer> matx = new ArrayList();// altınların x koordinatı
	public static ArrayList<Integer> maty = new ArrayList();// altınların y koordinati
	public static ArrayList<Integer> altin = new ArrayList();// altın miktarı
	public static int gmatris[][];// gizli altınların olduğu matris
	public static ArrayList<Integer> galtin = new ArrayList();// gizli altın miktarı
	public static ArrayList<Integer> gx = new ArrayList();// gizli altının x koordinatı
	public static ArrayList<Integer> gy = new ArrayList();// gizli altının y koordinatı
	public static _A A;
	public static _B B;
	public static _C C;
	public static _D D;
        public static int v;
        public static boolean konta;
        public static boolean kontb;
        public static boolean kontc;
        public static boolean kontd;
	
	

	public yazlab() {
		
		setTitle("Altın Toplama Oyunu");
		setSize(1000, 1000);
		setVisible(true);
                setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		int x =30;
		int y =30;
		int i;
                g.setColor(Color.BLACK);
                g.fillRect((A.y*x+100),(A.x*y+100),15,15);
                
                g.setColor(Color.BLUE);
                g.fillRect((x*C.y+100),(C.x*y+100),15,15);
                
                g.setColor(Color.YELLOW);
                g.fillRect((B.y*x+100),(y*B.x+100),15,15);
               
                g.setColor(Color.PINK);
                g.fillRect((D.y*x+100),(D.x*y+100),15,15);
                
                for(int k=0;k<galtin.size();k++){
                g.setColor(Color.RED);
                g.fillRect((gy.get(k)*x+100),(gx.get(k)*y+100),30,30);
                }

                for(int k=0;k<altin.size();k++){
                g.setColor(Color.ORANGE);
                g.fillRect((maty.get(k)*x+100),(matx.get(k)*y+100),30,30);
                }
                               
		for (i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
                                g.setColor(Color.GRAY);
				g.drawRect(x*i+100, y*j+100, 30, 30);
				
			}
			
		}
                
                
	}
        public static void yaz(String veri) throws IOException{
                File file = new File("a.txt");
               if(konta==false){
                if (file.exists()) {
                    file.delete();
                 
                  }}
                

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        
        bWriter.write(veri);
        bWriter.flush();
        bWriter.close();
        
        }
        public static void yazb(String veri) throws IOException{
                File file = new File("b.txt");
               if(kontb==false){
                if (file.exists()) {
                    file.delete();
                 
                  }}
                

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        
        bWriter.write(veri);
        bWriter.flush();
        bWriter.close();
        
        }
         public static void yazc(String veri) throws IOException{
                File file = new File("c.txt");
               if(kontc==false){
                if (file.exists()) {
                    file.delete();
                 
                  }}
                

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        
        bWriter.write(veri);
        bWriter.flush();
        bWriter.close();
        
        }
        
         public static void yazd(String veri) throws IOException{
               File file = new File("d.txt");
               if(kontd==false){
                if (file.exists()) {
                    file.delete();
                 
                  }}
                
                
        FileWriter fileWriter = new FileWriter(file, true);        
        BufferedWriter bWriter=new BufferedWriter(fileWriter);
        bWriter.write(veri);
        bWriter.flush();
        bWriter.close();
        
        }
	public static void main(String[] args) throws IOException {
            
		Scanner s = new Scanner(System.in);
		int tempa=0;
                int tempga=0;
		int g;
                String soru;
                A = new _A();
		B = new _B();
		C = new _C();
		D = new _D();
                System.out.println("Parametreleri kendiniz girmek ister misiniz? (E/H)\n'H' seçerseniz oyun varsayılan değerler ile başlayacak :");
                soru=s.next();
                while(!soru.equals("e")&&!soru.equals("E")&&!soru.equals("h")&&!soru.equals("H")){
                    System.out.println("Hatalı giriş yaptınız tekrar deneyin.");
                    System.out.println("Parametreleri kendiniz girmek ister misiniz? (E/H)\n'H' seçerseniz oyun varsayılan değerler ile başlayacak :");
                soru=s.next();
                }
                if(soru.equals("E")||soru.equals("e")){
                    System.out.println("Matris boyutlarını girin:(NxN)");
                 v = s.nextInt();
		//v = 20;
                System.out.println("Altin yüzdesi girin:%");
                tempa=s.nextInt();
                System.out.println("Gizli Altin yüzdesi girin:%");
                tempga=s.nextInt();
                System.out.println("A oyuncusu altin sayısı:");
                A.altin=s.nextInt();
                System.out.println("A oyuncusu hamle maliyeti:");
                A.hamlem=s.nextInt();
                System.out.println("A oyuncusu hedef maliyeti:");
                A.hedefm=s.nextInt();
                System.out.println("B oyuncusu altin sayısı:");
                B.altin=s.nextInt();
                System.out.println("B oyuncusu hamle maliyeti:");
                B.hamlem=s.nextInt();
                System.out.println("B oyuncusu hedef maliyeti:");
                B.hedefm=s.nextInt();
                System.out.println("C oyuncusu altin sayısı:");
                C.altin=s.nextInt();
                System.out.println("C oyuncusu hamle maliyeti:");
                C.hamlem=s.nextInt();
                System.out.println("C oyuncusu hedef maliyeti:");
                C.hedefm=s.nextInt();
		System.out.println("D oyuncusu altin sayısı:");
                D.altin=s.nextInt();
                System.out.println("D oyuncusu hamle maliyeti:");
                D.hamlem=s.nextInt();
                System.out.println("D oyuncusu hedef maliyeti:");
                D.hedefm=s.nextInt();
                }
                else if(soru.equals("H")||soru.equals("h")){
                v=20;
                tempa=20;
                tempga=10;
                A.altin=200;
                A.hedefm=5;
                A.hamlem=5;
                B.altin=200;
                B.hedefm=10;
                B.hamlem=5;
                C.altin=200;
                C.hedefm=15;
                C.hamlem=5;
                D.altin=200;
                D.hedefm=20;
                D.hamlem=5;
                }
                
                int a = (v * v);
		a = (int)((a*tempa)/100);
                g=(int)((a*tempga)/100);
                System.out.println("a:"+a);
                System.out.println("g:"+g);
		matris = new int[v][v];
		
		A.x = 0;
		A.y = 0;
		B.x = 0;
		B.y = v - 1;
		C.x = v - 1;
		C.y = 0;
		D.x = v - 1;
		D.y = v - 1;
               konta=false;
               kontb=false;
               kontc=false;
               kontd=false;      
                
		Random rand = new Random();
		for (int i = 0; i < a; i++) {
			altin.add(rand.nextInt(21));
			while (altin.get(i) % 5 != 0 || altin.get(i) == 0) {
				altin.set(i, rand.nextInt(21));
			}
		}

		for (int i = 0; i < a; i++) {

			matx.add(rand.nextInt(v));
			maty.add(rand.nextInt(v));

		}

		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				matris[i][j] = 0;
			}
		}

		for (int i = 0; i < a; i++) {
			if (matris[matx.get(i)][maty.get(i)] != altin.get(i)) {
				matris[matx.get(i)][maty.get(i)] = altin.get(i);
			} else {
				matx.set(i, rand.nextInt(v));
				maty.set(i, rand.nextInt(v));
				matris[matx.get(i)][maty.get(i)] = altin.get(i);
			}
		}

		int kontrol = 0;
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (matris[i][j] != 0) {
					kontrol++;
				}
			}
		}
		
		while (kontrol < a) {
			matx.set(kontrol, rand.nextInt(v));
			maty.set(kontrol, rand.nextInt(v));
			matris[matx.get(kontrol)][maty.get(kontrol)] = altin.get(kontrol);
			kontrol = 0;
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					if (matris[i][j] != 0) {
						kontrol++;
					}
				}
			}
		}
		// *************gizli altın
		//g = a / 10;
		
		gmatris = new int[v][v];

		for (int i = 0; i < g; i++) {
			galtin.add(rand.nextInt(21));
			while (galtin.get(i) % 5 != 0 || galtin.get(i) == 0) {
				galtin.set(i, rand.nextInt(21));
			}
		}
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				gmatris[i][j] = 0;
			}
		}
		for (int i = 0; i < g; i++) {
			gx.add(rand.nextInt(v));
			gy.add(rand.nextInt(v));
			
		}
                boolean kontrolaltin=true;
                while (kontrolaltin==true){
                    kontrolaltin=false;
                    System.out.println("false mu");
		for (int i = 0; i < gx.size(); i++) {
			for (int j = 0; j < matx.size(); j++) {
				while (gx.get(i) == matx.get(j) && gy.get(i) == maty.get(j)) {
					gx.set(i,rand.nextInt(v));
					gy.set(i, rand.nextInt(v));
                                        kontrolaltin=true;
				}
			}
		}
                }
                System.out.println(gx + "\n" + gy);
                //System.out.println(matx +"\n" +maty);
		for (int i = 0; i < gx.size(); i++) {
			gmatris[gx.get(i)][gy.get(i)] = galtin.get(i);
			// System.out.println(gx[i]+","+gy[i]);
		}
                System.out.println("Oluşturulan Matris");
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(matris[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                System.out.println("----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                System.out.println("Oluşturulan Gizli Matris");
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(gmatris[i][j] + "  ");
			}
			System.out.println();
		}

		guncelle(v);
		
		
		
		yazlab y=new yazlab();
                JButton button = new JButton("OYNA");
                button.setBounds(5,100, 80, 30);
                y.add(button);
                
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        y.repaint();
                        System.out.println("\n----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                        if(A.altin>0)
                        A.ilerle();
                        System.out.println("A konum=" + A.x + "," + A.y);
                        System.out.println("A altın miktarı " + A.altin);
                        System.out.println("A hedef" + A.hedefx + "," + A.hedefy);
                        String k=" A mevcut konum:"+A.x+","+A.y;
                        String k1=" A altin miktari "+A.altin;
                        String k2="A hedef:"+A.hedefx+","+A.hedefy;
                        String k3=k2+k1+k+"\n";
                        try {     
                            yaz(k3);
                        } catch (IOException ex) {
                            Logger.getLogger(yazlab.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        konta=true;
                        System.out.println("\n----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                        if(B.altin>0)
                            B.ilerle();
                        System.out.println(" B mevcut konum=" + B.x + "," + B.y);
                        System.out.println(" B altın miktarı" + B.altin);
                        System.out.println("B hedef" + B.hedefx + "," + B.hedefy);
                        String b="B konum:"+B.x+","+B.y;
                        String b1="B altın:"+B.altin;
                        String b2="B hedef:"+B.hedefx+","+B.hedefy;
                        String b3=b2+b1+b+"\n";
                        try {
                            yazb(b3);
                        } catch (IOException ex) {
                            Logger.getLogger(yazlab.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        kontb=true;
                        System.out.println("\n----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                        if(C.altin>0)
                            C.ilerle();
                        System.out.println(" C mevcut konum=" + C.x + "," + C.y);
                        System.out.println(" C altın miktarı" + C.altin);
                        System.out.println("C hedef" + C.hedefx + "," + C.hedefy);
                        String c="C konum:"+C.x+","+C.y;
                        String c1="C altın:"+C.altin;
                        String c2="C hedef:"+C.hedefx+","+C.hedefy;
                        String c3=c2+c1+c+"\n";
                        try {
                            yazc(c3);
                        } catch (IOException ex) {
                            Logger.getLogger(yazlab.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        kontc=true;
                        System.out.println("\n----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                        if(D.altin>0)
                            D.ilerle();
                        System.out.println(" D mevcut konum=" + D.x + "," + D.y);
                        System.out.println(" D altın miktarı " + D.altin);
                        System.out.println("D hedef" + D.hedefx + "," + D.hedefy);
                        String d="D konum:"+D.x+","+D.y;
                        String d1="D altın:"+D.altin;
                        String d2="D hedef:"+D.hedefx+","+D.hedefy;
                        String d3=d2+d1+d+"\n";
                        try {
                           yazd(d3);
                            
                        } catch (IOException ex) {
                            Logger.getLogger(yazlab.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        kontd=true;
                        System.out.println("\n----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                        System.out.println("\n----x-x----x-x----x-x----x-x----x-x----x-x----x-x----");
                        
                if ((A.altin==0&&B.altin==0&&C.altin==0&&D.altin==0)||altin.size()==0) {
                    
                System.out.println("A nın mevcut altını= "+A.altin+" Toplanan Toplam Altin= "+A.topAltin+"  toplamAdim= "+A.topAdim+"  toplamHedef= "+A.topHedef);
		System.out.println("B nın mevcut altını= "+B.altin+" Toplanan Toplam Altin= "+B.topAltin+"  toplamAdim= "+B.topAdim+"  toplamHedef= "+B.topHedef);
		System.out.println("C nın mevcut altını= "+C.altin+" Toplanan Toplam Altin= "+C.topAltin+"  toplamAdim= "+C.topAdim+"  toplamHedef= "+C.topHedef);
		System.out.println("D nın mevcut altını= "+D.altin+" Toplanan Toplam Altin= "+D.topAltin+"  toplamAdim= "+D.topAdim+"  toplamHedef= "+D.topHedef);
                System.out.println("Son Hal Matris");
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(matris[i][j] + "  ");
			}
			System.out.println();
		}
              
              button.setVisible(false);
              JOptionPane.showMessageDialog(null, "OYUN BİTTİ");
              //label.setVisible(true);
	}
               
        }
	}
                    
                );
		
               
        }
        
	public static void guncelle(int v) {
		altin.clear();
		matx.clear();
		maty.clear();
		galtin.clear();
		gx.clear();
		gy.clear();
		
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if(matris[i][j]!=0) {
					altin.add(matris[i][j]);
					matx.add(i);
					maty.add(j);
				}
			}
		}
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if(gmatris[i][j]!=0) {
					galtin.add(gmatris[i][j]);
					gx.add(i);
					gy.add(j);
				}
			}
		}
		
		
		//System.out.println(altin+"\n"+matx+"\n"+maty);
		
		//System.out.println("\n\n"+galtin+"\n"+gx+"\n"+gy);
	}
}
