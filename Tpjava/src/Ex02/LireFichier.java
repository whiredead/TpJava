package Ex02;

import java.io.*;
import java.util.Scanner;

public class LireFichier {
    File fichier;
    public LireFichier(){};
    public LireFichier(String f){
        fichier=new File(f);
    }
    public void lireScanner() throws FileNotFoundException {
        Scanner sc = new Scanner(fichier);
        int nbrligne=0;
        int nbrchaine=0;
        int nbrcaractères=0;
        String ligne;

        System.out.println("############ start of file ##########");
        while(sc.hasNextLine()){
            ligne = sc.nextLine();
            System.out.println(ligne);
            nbrligne+=1;
            nbrcaractères+=ligne.length();
            nbrchaine+=ligne.split(" ").length;
        }
        System.out.println("######### end of file #######");

        System.out.println("nombre de ligne = "+nbrligne);
        System.out.println("nombre caractere= "+nbrcaractères);
        System.out.println("nombre de chaine= "+nbrchaine);
    }
    public void lireBuffer() throws IOException {
        BufferedReader bfr=new BufferedReader(new FileReader(fichier));
        int nbrligne=0;
        int nbrchaine=0;
        int nbrcaractères=0;
        String ligne;
        System.out.println("############ start of file ##########");
        while ((ligne = bfr.readLine()) != null) {
            System.out.println(ligne);
            nbrligne+=1;
            nbrcaractères += ligne.length(); // Add the length of the line to the character count
            nbrchaine += ligne.split(" ").length;
        }
        System.out.println("######### end of file #######");

        System.out.println("nombre de ligne = "+nbrligne);
        System.out.println("nombre caractere= "+nbrcaractères);
        System.out.println("nombre de chaine= "+nbrchaine);

    }
}
