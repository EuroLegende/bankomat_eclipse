
public class Druga_pretvorba_stringa_ime {//pretvorba imena i prezimena iz niza korisnika u string kako bi 
	//se mogao ispisati u textFiled
	static String potreban3 ="";//pohrana imena i prezimena u globalnu varijavlu
public static void pretvorba2 (String []ime,String []prezime, int sifra_osobe) {//pretvorba potrbne stvati
	StringBuffer pretvorba1= new StringBuffer();
	pretvorba1.append(ime[sifra_osobe]+" ");
	pretvorba1.append(prezime[sifra_osobe]);
	//naso na internetu, uglavnom buffer pohranjuje niz u sebe 
	potreban3 = pretvorba1.toString();
	//deklarianje globalnog stringa zbog lakseg koristenja te info
}
}
