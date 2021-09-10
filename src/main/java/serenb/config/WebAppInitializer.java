package serenb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * this method tells to Spring, which classes are root (beans, but not controllers)
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    /**
     * this method tells to Spring, which classes are servlet (controllers bean)
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    /**
     * this method tells to Spring, default mapping for all our controllers
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
