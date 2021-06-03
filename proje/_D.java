
package yazlab;

public class _D {
	int indis = 0;
	int altin;
	int x;
	int y;
	boolean hedef=false;
	int hedefx;
	int hedefy;
	int hedefm ;
        int hamlem;
	int hedefaltin;
	int topAdim=0;
	int topHedef=0;
	int topAltin=0;
	public int ilerle() {
		
		
		int adim = 0;
		if ((hedef == false||yazlab.matris[hedefx][hedefy]==0)&&yazlab.altin.size()>0) {
			if(altin>0) {
				hedefle();
		       }
		 
		}
		if(hedef==true){
		System.out.println("D ilerliyor");
		for (int i = 0; i < 3; i++) {
			if(altin<=0) {
				altin=0;
		    	   break;
		       }
			if (x < hedefx && adim <= 3) {
				adim++;
				x += 1;
				altin -= hamlem;
				topAdim++;
			} else if (x > hedefx && adim <= 3) {
				adim++;
				x -= 1;
				altin -= hamlem;
				topAdim++;
			} else if (y < hedefy && adim <= 3) {
				adim++;
				y += 1;
				altin -= hamlem;
				topAdim++;
			} else if (y > hedefy && adim <= 3) {
				adim++;
				y -= 1;
				altin -= hamlem;
				topAdim++;
			}
			
			
		}
		if (x == hedefx && y == hedefy) {
			   if(yazlab.matris[x][y]!=0) {
		    	   System.out.println("D hedefe ulaştı");
		    	   topAltin+=yazlab.matris[hedefx][hedefy];  
		           altin+=yazlab.matris[hedefx][hedefy];  
		           yazlab.matris[x][y]=0;
		           yazlab.guncelle(yazlab.v);        
		                       
		    	   }
			   hedef=false; 
		}

		// System.out.println("güncel konum"+x+","+y);
		adim = 0;
		}
		
		// System.out.println("en yakın
		// nokta:"+yazlab.matx[indis]+","+yazlab.maty[indis]);
		return 0;
	}

	public void hedefle() {
		if(yazlab.A.altin<=0&&yazlab.B.altin<=0||yazlab.C.altin<=0) {
			yenihedef();
			return ;
		}
		boolean hedefbulundu=false;
		System.out.println("D hedef arıyor");
		int A_uzaklik = Math.abs(yazlab.A.hedefx - yazlab.A.x) + Math.abs(yazlab.A.hedefy - yazlab.A.y);
		int B_uzaklik = Math.abs(yazlab.B.hedefx - yazlab.B.x) + Math.abs(yazlab.B.hedefy - yazlab.B.y);
		int C_uzaklik = Math.abs(yazlab.C.hedefx - yazlab.C.x) + Math.abs(yazlab.C.hedefy - yazlab.C.y);
boolean kontrol=true;
		if (A_uzaklik > Math.abs((x - yazlab.A.hedefx) + Math.abs(y - yazlab.A.hedefy))||yazlab.A.altin<=0) {
			System.out.println("burda1");
			kontrol=true;
			if(yazlab.A.hedefx==yazlab.B.hedefx&&yazlab.A.hedefy==yazlab.B.hedefy||yazlab.B.altin<=0) {
				if(A_uzaklik>B_uzaklik) {
					kontrol=false;
				}
			}
			if(yazlab.A.hedefx==yazlab.C.hedefx&&yazlab.A.hedefy==yazlab.C.hedefy||yazlab.C.altin<=0) {
				if(A_uzaklik>B_uzaklik) {
					kontrol=false;
				}
			}
			if(kontrol==true) {
				hedefx = yazlab.A.hedefx;
				hedefy = yazlab.A.hedefy;
				hedefaltin = yazlab.A.hedefaltin;
			}
		} else if (B_uzaklik > Math.abs(x - yazlab.B.hedefx) + Math.abs(y - yazlab.B.hedefy)||yazlab.B.altin<=0) {
			kontrol=true;
			if(yazlab.B.hedefx==yazlab.C.hedefx&&yazlab.B.hedefy==yazlab.C.hedefy||yazlab.C.altin<=0) {
				if(B_uzaklik>C_uzaklik) {
					kontrol=false;
				}
			}
			if(kontrol==true) {
				hedefx = yazlab.B.hedefx;
				hedefy = yazlab.B.hedefy;
				hedefaltin = yazlab.B.hedefaltin;
			}
		} else if (C_uzaklik > Math.abs(x - yazlab.C.hedefx) + Math.abs(y - yazlab.C.hedefy)||yazlab.C.altin<=0) {
			System.out.println("burda3");
			hedefx = yazlab.C.hedefx;
			hedefy = yazlab.C.hedefy;
			hedefaltin = yazlab.C.hedefaltin;
		} else {
			int uzak[] = new int[yazlab.altin.size()];
			int max;
			int temp = 0;
			int temp2 = 0;
			int kar[] = new int[yazlab.altin.size()];
			for (int i = 0; i < yazlab.altin.size(); i++) {
				temp = Math.abs(yazlab.matx.get(i) - x);
				temp2 = Math.abs(yazlab.maty.get(i) - y);
				uzak[i] = temp + temp2;
			}
			for (int i = 0; i < yazlab.altin.size(); i++) {
				kar[i] = yazlab.altin.get(i) - ((uzak[i] * hamlem) + hedefm);

			}
			max = -9999;
			for (int i = 0; i < yazlab.altin.size(); i++) {
				if (max < kar[i]) {
					if ((yazlab.matx.get(i) != yazlab.A.hedefx)&&(yazlab.maty.get(i) != yazlab.A.hedefy)) {
						if ((yazlab.matx.get(i) != yazlab.B.hedefx)&&(yazlab.maty.get(i) != yazlab.B.hedefy)) {
							if ((yazlab.matx.get(i) != yazlab.C.hedefx)&&(yazlab.maty.get(i) != yazlab.C.hedefy)) {
								max = kar[i];
								indis = i;
								hedefbulundu=true;
								
							}
						}
					}

				}
			}
			
			if(hedefbulundu==true) {
				 topHedef+=1;
			hedef = true;
			altin -= hedefm;
			hedefaltin = yazlab.altin.get(indis);
			// System.out.println("hedef altin:"+hedefaltin);
			hedefx = yazlab.matx.get(indis);
			hedefy = yazlab.maty.get(indis);
			System.out.println("hedefim"+hedefx+"  "+hedefy);
			}
		}

	}
	public void yenihedef() {
		boolean hedefbulundu=false;
		 System.out.println("B hedef arıyor");
	        int uzak[]=new int[yazlab.altin.size()];
	        int max;
	        int temp=0;
	        int temp2=0;
	        int kar[]=new int[yazlab.altin.size()];
	        for(int i=0;i<yazlab.altin.size();i++){
	        temp=Math.abs(yazlab.matx.get(i)-x);
	        temp2=Math.abs(yazlab.maty.get(i)-y);
	        uzak[i]=temp+temp2;
	    }
	    for(int i=0;i<yazlab.altin.size();i++){
	        kar[i]=yazlab.altin.get(i)-((uzak[i]*hamlem)+hedefm);
	        
	    }
	    max=-9999;   
	       for(int i=0;i<yazlab.altin.size();i++){
	           if(max<kar[i]){
	           max=kar[i];
	           indis=i;
	           hedefbulundu=true;
	           }
	       }
	     if(hedefbulundu==true) {
	    	 topHedef+=1;
	        hedef=true;
	        altin-=hedefm;
	        hedefaltin=yazlab.altin.get(indis);
	        //System.out.println("hedef altin:"+hedefaltin);
	        hedefx=yazlab.matx.get(indis);
	        hedefy=yazlab.maty.get(indis);
	     }
	}

}
