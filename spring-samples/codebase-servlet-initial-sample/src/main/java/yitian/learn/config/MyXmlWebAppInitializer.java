package yitian.learn.config;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/*public class MyXmlWebAppInitializer extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("classpath:applicationContext.xml");
        return context;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("classpath:dispatcher-servlet.xml");
        return context;
    }

}*/
