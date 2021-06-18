package com.company.lesson1;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class UserService {

    public static void serializeToXML(User user, File file) {

        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOutputStream))) {

            encoder.writeObject(user);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static User deSerializeXML(File file) {
        User user = null;
        try(FileInputStream fileInputStream = new FileInputStream(file);
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileInputStream))) {

            user = (User) decoder.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void serializeObject(User user, File file) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream)) {

            objectOutput.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User deSerializeObject(File file) {
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {

            return (User) inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
