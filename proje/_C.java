
package yazlab;

public class _C {
    int indis=0;
    int altin;
    int x;
    int y;
    boolean hedef;
    int hedefx;
    int hedefy;
    int hedefm;
    int hamlem;
    int hedefaltin;
	int topAdim=0;
	int topHedef=0;
	int topAltin=0;
    public int ilerle(){
   
       int adim=0;

       if ((hedef == false||yazlab.matris[hedefx][hedefy]==0)&&yazlab.altin.size()>0) {
			if(altin>0) {
				gizliac();
				hedefle();
		       }
		 
		}
       if(hedef==true) {
    	System.out.println("C ilerliyor");
       for(int i=0;i<3;i++){
    	   if(altin<=0) {
				altin=0;
		    	   break;
		       }
       if(x<hedefx && adim<=3){
       adim++;
       x+=1;
       altin-=hamlem;
       topAdim++;
       }
       else if(x>hedefx && adim<=3){
        adim++;
        x-=1;
        altin-=hamlem;
        topAdim++;
       }
       else if(y<hedefy && adim<=3){
        adim++;
        y+=1;
        altin-=hamlem;
        topAdim++;
       }
       else if(y>hedefy && adim<=3){
       adim++;
       y-=1;
       altin-=hamlem;
       topAdim++;
       }
       
       }
       if(x==hedefx && y==hedefy){
    	   if(yazlab.matris[x][y]!=0) {
        	   System.out.println("C hedefe ulaştı");
        	   topAltin+=yazlab.matris[hedefx][hedefy]; 
               altin+=yazlab.matris[hedefx][hedefy];  
               yazlab.matris[x][y]=0;
               yazlab.guncelle(yazlab.v);        
              
        	   }
    	   hedef=false;     
       }
       
       
       //System.out.println("güncel konum"+x+","+y);
       adim=0;  
       }
       //System.out.println("en yakın nokta:"+yazlab.matx[indis]+","+yazlab.maty[indis]);
    return 0;
    }

    public void hedefle(){
    	boolean hedefbulundu=false;
    	 System.out.println("C hedef arıyor");
        int uzak[]=new int[yazlab.altin.size()];
        int kar[]=new int[yazlab.altin.size()];
        int max;
        int temp=0;
        int temp2=0;
         for(int i=0;i<yazlab.altin.size();i++){
       temp=Math.abs(yazlab.matx.get(i)-x);
       temp2=Math.abs(yazlab.maty.get(i)-y);
       uzak[i]=temp+temp2;
    }
         for(int i=0;i<yazlab.altin.size();i++){
             kar[i]=yazlab.altin.get(i)-((uzak[i]*5)+hedefm);
             
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
        hedef=true;
        altin-=hedefm;
        topHedef+=1;
        hedefaltin=yazlab.altin.get(indis);
        hedefx=yazlab.matx.get(indis);
        hedefy=yazlab.maty.get(indis);
            }
    }
    
    
    
    public void gizliac(){
    	if(yazlab.galtin.size()==0) {
    		return ;
    	}
    	int g=yazlab.galtin.size();
    	 System.out.println("C gizli altın açıyor");
        int gindis=0;
        int uzak[]=new int[g];
        int min;
        int temp=0;
        int temp2=0;
    for(int i=0;i<g;i++){
       temp=Math.abs(yazlab.gx.get(i)-x);
       temp2=Math.abs(yazlab.gy.get(i)-y);
       uzak[i]=temp+temp2;
    }
    min=uzak[0];
       for(int i=0;i<g;i++){
           if(min>=uzak[i]){
           min=uzak[i];
           gindis=i;
          
           }
       }
       
       yazlab.matris[yazlab.gx.get(gindis)][yazlab.gy.get(gindis)]=yazlab.gmatris[yazlab.gx.get(gindis)][yazlab.gy.get(gindis)];
       yazlab.gmatris[yazlab.gx.get(gindis)][yazlab.gy.get(gindis)]=0;
      // yazlab.gmatris[yazlab.gx[gindis]][yazlab.gy[gindis]]=0;
    }
    
    
}
