package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Analizator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a valid .class file as input.");
            return;
        }

        String className = args[0];
        try {

            Class<?> clazz = Class.forName(className);

            Package pkg = clazz.getPackage();
            String packageName = pkg.getName();

            System.out.println("Class: " + clazz.getName());
            System.out.println("Package: " + packageName);

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("metode:");
            for (Method method : methods) {
                System.out.println(getMethodSignature(method));

            }
        } catch (ClassNotFoundException e) {
            System.out.println("eroare load clasa " + className);
        } catch (Exception e) {
            System.out.println("eroare methoad invocation " + e.getMessage());
        }
    }

    private static String getMethodSignature(Method method) {
        StringBuilder signature = new StringBuilder();
        signature.append(Modifier.toString(method.getModifiers()));
        signature.append(" ");
        signature.append(method.getReturnType().getSimpleName());
        signature.append(" ");
        signature.append(method.getName());
        signature.append("(");

        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            signature.append(parameterTypes[i].getSimpleName());
            if (i < parameterTypes.length - 1) {
                signature.append(", ");
            }
        }

        signature.append(")");
        return signature.toString();
    }
}
