package com.lab3;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();

        System.out.println("This is server app, you should run it with wildfly");

        System.out.println("This app was launched with following vm arguments:");

        arguments.forEach(System.out::println);
    }
}
