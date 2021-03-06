package com.revature.ormnl;

import com.revature.ormnl.model.UserAccount;
import com.revature.ormnl.service.ObjectService;
import com.revature.ormnl.util.ClassObjectInspector;

import java.lang.reflect.Field; // remove in final
import java.util.ArrayList;
import java.util.HashMap;

public class Driver {
    public static ObjectService objectService = new ObjectService();
    public static void main(String[] args){
        ClassObjectInspector clazzInspect = new ClassObjectInspector(ClassObjectInspector.class);
        ClassObjectInspector objectInspect = new ClassObjectInspector(clazzInspect);

//        for (String name : fieldNames) {
//            System.out.println(name);
//        }
        ArrayList<?> fieldContents = objectInspect.getClazzFieldContents();
//        for (Object name : fieldContents) {
//            System.out.println(name);
//        }
        ArrayList<HashMap<String,String>> outputList = null;
        try {
            outputList = objectService.get(ClassObjectInspector.class.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (HashMap<String,String> output : outputList) {
            output.forEach((key, value) -> System.out.println(key + ":" + value));
        }
        UserAccount me = null;
        try {
            me = (UserAccount) objectService.getObject("com.revature.ormnl.model.UserAccount",1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Account Id: " + me.getUserId() + "\n" +
                "Username: " + me.getUsername() + "\n" +
                "Password: " + me.getPassword() + "\n" +
                "First Name: " + me.getFirstName() + "\n" +
                "Last Name: " + me.getLastName());
    }
}
