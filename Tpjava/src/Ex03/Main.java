package Ex03;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("saisisser username");
        String username = sc.next();
        System.out.println("saisisser mot de passe");
        String password = sc.next();
        File fr = new File("authentification.txt");
        Scanner cs = new Scanner(fr);
        boolean find = false;
        String ligne;
        while (cs.hasNextLine()){
            StringTokenizer str = new StringTokenizer(cs.nextLine()," ");
            while(str.hasMoreTokens()) {
                String usr = str.nextToken();
                String psw = str.nextToken();
                if(username == usr && psw == password) {
                    find = true;
                }
            }
        }
        if (find) System.out.println(" Authentification réuss");
        else System.out.println("PB Authentification");
    }
}
