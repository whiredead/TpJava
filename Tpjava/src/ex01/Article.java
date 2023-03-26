package ex01;

import java.io.*;
import java.util.StringTokenizer;

public class Article implements Serializable {

    private static final long serialVersionUID = 4888066205253553524L;

    String nom;
    int prix;


    public Article(String lignes) {
        StringTokenizer st = new StringTokenizer(lignes, " ");

        try {
            nom = st.nextToken();
            prix = Integer.parseInt(st.nextToken());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void serializer() throws Exception {
        Article a;
        boolean exist = false;
        File temp = new File("temp.txt");
        File fichier = new File("articles.txt");
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        out = new ObjectOutputStream(new FileOutputStream(temp)); //vide file
        try {
            in = new ObjectInputStream(new FileInputStream(fichier));
            a = (Article) in.readObject();
            while (a != null) {
                if (a.nom.equals(this.nom)) {
                    System.out.println("first if");
                    out.writeObject(this); //write the new article
                    exist = true;
                }
                else {
                    out.writeObject(a); //write the old one
                }
                a = (Article) in.readObject();
            }
        } catch (FileNotFoundException e) {

        } catch (EOFException ex) {
            in.close();
        }
        if (!exist) {
            System.out.println("second if");
            out.writeObject(this);
        }
        out.close();
        fichier.delete();
        temp.renameTo(fichier);
    }

    public void deserialiser() throws IOException, ClassNotFoundException {
        Article a;
        File fichier = new File("Tpjava/articles.txt");
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(fichier));
            while (in.available() > 0) {
                a = (Article) in.readObject();
                System.out.println("nom : " + a.nom + ", prix : " + a.prix);
            }
        } catch (EOFException e) {
            // Ignore EOFException since it just means we reached the end of the file
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
    /*
    public void deserialiser() throws IOException, ClassNotFoundException {
        Article a;
        File fichier = new File("articles.txt");
        ObjectInputStream in = null;
        try{
            in =new ObjectInputStream(new FileInputStream(fichier));
            a = (Article) in.readObject();
            while (a != null) {
                System.out.println("noms : " + a.nom +
                        ", score : " + a.prix);
                a = (Article) in.readObject();
            }
        } catch (EOFException exc) {
            in.close();
            exc.printStackTrace();
        }


    }
    */

    void Read() throws Exception {
        Article article;
        File fichier = new File("articles.txt");
        ObjectInputStream in =new ObjectInputStream(new FileInputStream(fichier));
        System.out.println("contenu du fichier");
        try {

            article = (Article) in.readObject();
            while (article != null) {
                System.out.println("noms : " + article.nom + ", prix : " + article.prix);
                article = (Article) in.readObject();
            }
        }
        catch(Exception exc){
            in.close();
        }
        System.out.println();
    }
}


