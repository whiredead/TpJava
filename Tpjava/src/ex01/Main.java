package ex01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Article article;
        Scanner sc = new Scanner(System.in);
        String ligne;
        System.out.println("####################");
        while(!(ligne=sc.nextLine()).isEmpty()){
            article=new Article(ligne);
            try {
                article.serializer();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            article.Read();
        }
    }
}