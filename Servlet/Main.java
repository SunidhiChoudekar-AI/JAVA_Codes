package com.employee;

import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.SimpleInstanceManager;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.plus.annotation.ContainerInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase("src/main/webapp");
        context.setParentLoaderPriority(false);

        // fix for InstanceManager error
        context.setAttribute(
            "org.apache.tomcat.InstanceManager",
            new SimpleInstanceManager()
        );

        // fix for JSP support
        List<ContainerInitializer> initializers = new ArrayList<>();
        initializers.add(new ContainerInitializer(
            new JettyJasperInitializer(), null));
        context.setAttribute(
            "org.eclipse.jetty.containerInitializers", initializers);

        context.setAttribute(
            "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
            ".*/.*jsp-api-[^/]*\\.jar$|.*/.*jsp-[^/]*\\.jar$|.*/.*jasper-[^/]*\\.jar$"
        );

        // manually register servlets
        context.addServlet(new ServletHolder(new EmployeeServlet()), "/register");
        context.addServlet(new ServletHolder(new ViewServlet()), "/view");

        server.setHandler(context);
        server.start();

        System.out.println("=================================");
        System.out.println("Server started!");
        System.out.println("Open: http://localhost:8080");
        System.out.println("Press Ctrl+C to stop");
        System.out.println("=================================");

        server.join();
    }
}