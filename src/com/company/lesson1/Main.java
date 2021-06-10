package com.company.lesson1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("Arman", 24, false);
        user.setNumbers(Arrays.asList(new Phone(05523231, "Beeline"), new Phone(321313123, "Ucom")));

        // XML De/Serialize Example
        UserService.serializeToXML(user, new File("user"));
        User user1 = UserService.deSerializeXML(new File("user"));
        System.out.println(user1);

        // JSON Example
        Gson gson = new Gson();
        String json = gson.toJson(user);

        User user2 = gson.fromJson(json, User.class);
        System.out.println(user2);

        // List serialization example Example
        List<Phone> phoneList = Arrays.asList(new Phone(12312, "Beeline"), new Phone(23432, "Vodafone"));
        Type listPhoneObject1 = new TypeToken<List<Phone>>() {}.getType();

        String toJson1 = new Gson().toJson(phoneList, listPhoneObject1);
        System.out.println(toJson1);


        // List deserialization example Example
        String inputString = "[{\"number\":13242,\"operator\":\"Ucom\"},{\"number\":23132,\"operator\":\"Viva\"}]";
        Type listPhoneObject2 = new TypeToken<Phone>() {
        }.getType();

        List<Phone> outputList = new Gson().fromJson(inputString, listPhoneObject2);
        System.out.println(outputList);

//         XML Serialization / DeSerialization

        XStream xstream = new XStream(new StaxDriver());
        final String xml = xstream.toXML(user);

        User user3 = (User) xstream.fromXML(xml);
        System.out.println(user3);


    }
}
