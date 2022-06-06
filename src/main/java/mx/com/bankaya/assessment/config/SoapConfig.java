package mx.com.bankaya.assessment.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import static mx.com.bankaya.assessment.util.Constants.SoapConstants.POKE_API_URI_NAMESPACE;

@EnableWs
@Configuration
public class SoapConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> servletRegistrationBean(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "soapPokeApiIntegration")
    public DefaultWsdl11Definition soapPokeApiIntegration(XsdSchema soapPokeApiIntegrationSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SoapPokeapiIntegrationPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(POKE_API_URI_NAMESPACE);
        wsdl11Definition.setSchema(soapPokeApiIntegrationSchema);
        return wsdl11Definition;
    }

    @Bean(name = "soapPokeApiIntegrationSchema")
    public XsdSchema soapPokeApiIntegrationSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/soap-poke-api-integration.xsd"));
    }

}
