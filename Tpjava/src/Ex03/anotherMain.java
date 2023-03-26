package Ex03;

import java.io.IOException;

public class anotherMain {
    public static void main(String[] args) throws IOException {
        Authentification a = new Authentification("hhhh","jjjj","authentification.txt");
        try {
            if(a.authentifier("hhh","123")){
                System.out.println("authentification reussite");
            }
            else System.out.println("echec d'authentification");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
