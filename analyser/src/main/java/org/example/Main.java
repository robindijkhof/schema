package org.example;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.bcel.Repository;
import org.apache.bcel.util.ClassLoaderRepository;
import org.springframework.boot.loader.jar.NestedJarFile;
import org.springframework.boot.loader.launch.LaunchedClassLoader;
import org.springframework.boot.loader.net.protocol.jar.JarUrl;

import org.apache.bcel.classfile.Attribute;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;


public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    String stepInterfaceName = "com.example.demo.schemas.IStep";
    String procesStepInterfaceName = "com.example.demo.schemas.IProcesStep";
    String conditionalStepInterfaceName = "com.example.demo.schemas.IConditionalStep";


    String diagram = "flowchart\n";


    File jar = new File("target/demo-0.0.1-SNAPSHOT.jar");
    System.out.println(jar.getAbsolutePath());


    NestedJarFile jarFile = new NestedJarFile(jar, "BOOT-INF/classes/");
    Enumeration<JarEntry> e = jarFile.entries();
    ArrayList<JarEntry> jarEntries = Collections.list(e);

//This is required to make URLs with `nested:` work
    org.springframework.boot.loader.net.protocol.Handlers.register();

    URL[] urls = {JarUrl.create(jar, "BOOT-INF/classes/")};

    LaunchedClassLoader launchedClassLoader = new LaunchedClassLoader(false, urls, Main.class.getClassLoader());

    Class stepInterface = launchedClassLoader.loadClass(stepInterfaceName);
    Class conditionalStepInterface = launchedClassLoader.loadClass(conditionalStepInterfaceName);
    Class procesStepInterface = launchedClassLoader.loadClass(procesStepInterfaceName);

//    Repository.setRepository(new ClassLoaderRepository(launchedClassLoader));
//
//    JavaClass javaClass = Repository.lookupClass("com.example.demo.schemas.schema1.AlVrij");


    for (JarEntry je : jarEntries) {


      if (je.isDirectory() || !je.getName().endsWith(".class") || !je.getName().contains("schema1")) {
        continue;
      }

      //Replaces slashes with dots and remove .class
      Class c = launchedClassLoader.loadClass(je.getName().replaceAll("/", ".").replaceFirst("\\.class$", ""));

      if (stepInterface.isAssignableFrom(c)) {
        Method nameMethod = c.getMethod("getStepName");
        nameMethod.setAccessible(true);

        Constructor constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object instance = constructor.newInstance();
        String stepName = (String) nameMethod.invoke(instance);

        if (procesStepInterface.isAssignableFrom(c)) {
          Method nextStepNameMethod = c.getMethod("getNextStepName");
          nextStepNameMethod.setAccessible(true);

          String nextStep = (String) nextStepNameMethod.invoke(instance);

          diagram += stepName + " --> " + nextStep + "\n";
        }else if(conditionalStepInterface.isAssignableFrom(c)){
          Method positiveStepNameMethod = c.getMethod("getPositiveStepName");
          positiveStepNameMethod.setAccessible(true);
          String positiveStep = (String) positiveStepNameMethod.invoke(instance);
          Method negativeStepNameMethod = c.getMethod("getNegativeStepName");
          negativeStepNameMethod.setAccessible(true);
          String negativeStep = (String) negativeStepNameMethod.invoke(instance);

          diagram += stepName + " -->|true| " + positiveStep + "\n";
          diagram += stepName + " -->|false| " + negativeStep + "\n";
        } else{
          diagram += stepName + " --> ???\n";
        }

      }


//      try (InputStream inputStream = jarFile.getInputStream(je);
//           ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//          outputStream.write(buffer, 0, bytesRead);
//        }
//
//        ByteArrayInputStream in = new ByteArrayInputStream(outputStream.toByteArray());
//        DataInputStream dis = new DataInputStream(in);
//
//        byte[] bytes = new byte[dis.available()];
//        dis.readFully(bytes);
//
//        String hexString = bytesToHex(bytes);
//
//        // Regular expression to match string literals
//        Pattern pattern = Pattern.compile("(\\\"[^\\\"]*\\\")");
//        Matcher matcher = pattern.matcher(hexString);
//
//        while (matcher.find()) {
//          String stringLiteral = matcher.group(1); //TODO is geen literal
//          System.out.println("String Literal: " + stringLiteral);
//        }
//      }

      System.out.println(diagram);

    }


  }

  private static String bytesToHex(byte[] bytes) {
    StringBuilder hexString = new StringBuilder();
    for (byte b : bytes) {
      hexString.append(String.format("%02X", b));
    }
    return hexString.toString();
  }
}




