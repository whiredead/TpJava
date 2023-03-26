package Ex03;

import java.io.*;
import java.util.StringTokenizer;

public class Authentification implements Serializable {
    String username;
    String password;
    String file;
    public Authentification(String u,String p, String f){
        username=u;
        password = p;
        file=f;
    }
    public void Serialiser() throws IOException {
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream object = new ObjectOutputStream(f);
        object.writeObject(this);
        object.close();
        f.close();
    }
    /*public boolean authentifier(String usr,String paswd) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream object = new ObjectInputStream(f);
        boolean find = false;
        Authentification a = (Authentification) object.readObject();
        while (a !=null){
            if(a.username == usr && a.password == paswd) {
                find = true;
                return find;
            }
            else a = (Authentification) object.readObject();
        }
        object.close();
        f.close();
        return find;
    }*/
    public boolean authentifier(String usr, String paswd) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream object = new ObjectInputStream(f);
        boolean find = false;
        try {
            while (true) {
                Authentification a = (Authentification) object.readObject();
                if (a.username.equals(usr) && a.password.equals(paswd)) {
                    find = true;
                    break;
                }
            }
        } catch (EOFException e) {
        }
        object.close();
        f.close();
        return find;
    }
}

