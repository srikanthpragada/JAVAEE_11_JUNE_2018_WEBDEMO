package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener {
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("Session Created");
    }
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Session Destroyed");
    }
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("Context Destroyed");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("Context Initialized");
         String url = sce.getServletContext().getInitParameter("oraurl");
         System.out.println(url);
         sce.getServletContext().setAttribute("oracleurl", url);
    }
	
}
