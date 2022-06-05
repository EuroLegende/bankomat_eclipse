
public class Pretvorba_niza_u_string extends Algoritam_isplate{
	static String potreban ="";
	static String [] niz_novca_string= new String [24];
public static void pretvorba (int [] niz) {
	for (int i = 0; i < niz_novca.length; i++) {
		
		 niz_novca_string[i] = String.valueOf(niz[i]);
		 
    }
	StringBuffer pretvorba1= new StringBuffer();
    for(int i = 0; i < niz_novca_string.length; i++) {
    	if (niz_novca_string[i].equals("0")) {
    		break;
    	}
       pretvorba1.append(niz_novca_string[i]+", ");
    }
    potreban = pretvorba1.toString();
    System.out.println(potreban);
    
}
}
