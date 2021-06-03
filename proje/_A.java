package yazlab;

public class _A {
    int indis=0;
    int altin;
    int x=0;
    int y=0;
    boolean hedef=false;
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
				hedefle();
		       }
		 
		}
       if(hedef==true){
       System.out.println("A ilerliyor");
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
        	   System.out.println("A hedefe ulaştı");
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
    	 System.out.println("A hedef arıyor");
        int uzak[]=new int[yazlab.altin.size()];
        int min;
        int temp=0;
        int temp2=0;
        for(int i=0;i<yazlab.altin.size();i++){
       temp=Math.abs(yazlab.matx.get(i)-x);
       temp2=Math.abs(yazlab.maty.get(i)-y);
       uzak[i]=temp+temp2;
    }
       min=uzak[0];
       for(int i=0;i<yazlab.altin.size();i++){
           if(min>=uzak[i]){
           min=uzak[i];
           }
       }
       for(int i=0;i<uzak.length;i++){
       if(min==uzak[i]){
       indis=i;
       hedefbulundu=true;
       }
       }
       if(hedefbulundu==true) {
    	   topHedef+=1;
    	  //System.out.println("burda");
        hedef=true;
        altin-=hedefm;
        hedefaltin=yazlab.altin.get(indis);
        hedefx=yazlab.matx.get(indis);
        hedefy=yazlab.maty.get(indis);
       }
    }
    
}
