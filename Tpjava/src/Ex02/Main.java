package Ex02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("############ donner le chemin du fichier ##########");
        Scanner sc = new Scanner(System.in);
        String file = sc.next();
        LireFichier a = new LireFichier(file);
        try {
            System.out.println("############ Scanner ##########");
            a.lireScanner();
            System.out.println("############ buffer ##########");
            a.lireBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }
