package com.mahendra.employees;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Main application class that starts an embedded Jetty server.
 * This allows the application to run as a standalone JAR without requiring
 * an external servlet container.
 */
public class Application {
    
    private static final int DEFAULT_PORT = 8080;
    
    public static void main(String[] args) throws Exception {
        int port = DEFAULT_PORT;
        
        // Allow port to be specified via command line argument
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number: " + args[0] + ". Using default port " + DEFAULT_PORT);
            }
        }
        
        Server server = new Server(port);
        
        // Create WebAppContext for JSP and static resources
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        
        // Set the resource base to the webapp directory in the JAR
        URL webappUrl = Application.class.getClassLoader().getResource("webapp");
        if (webappUrl == null) {
            throw new RuntimeException("Could not find webapp resources in classpath");
        }
        
        String webappDir = webappUrl.toExternalForm();
        webAppContext.setResourceBase(webappDir);
        
        // Configure for annotation scanning to find @WebServlet
        webAppContext.setConfigurations(new Configuration[] {
            new AnnotationConfiguration(),
            new org.eclipse.jetty.webapp.WebXmlConfiguration(),
            new org.eclipse.jetty.webapp.WebInfConfiguration(),
            new org.eclipse.jetty.webapp.FragmentConfiguration(),
            new org.eclipse.jetty.webapp.MetaInfConfiguration(),
            new org.eclipse.jetty.webapp.JettyWebXmlConfiguration()
        });
        
        // Set the class loader and enable annotation processing
        webAppContext.setParentLoaderPriority(true);
        webAppContext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/.*");
        webAppContext.setClassLoader(Application.class.getClassLoader());
        
        server.setHandler(webAppContext);
        
        System.out.println("Starting Employee Management Application on port " + port);
        System.out.println("Access the application at: http://localhost:" + port);
        
        server.start();
        server.join();
    }
}