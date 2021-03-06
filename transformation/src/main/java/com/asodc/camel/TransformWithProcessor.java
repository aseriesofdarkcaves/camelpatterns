package com.asodc.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import com.asodc.camel.processor.PropertiesToCsvProcessor;

public class TransformWithProcessor {
    private static final String LOGGER = TransformWithProcessor.class.getCanonicalName();
    private static final String LOG_MESSAGE = "HEADERS:\r\n${headers}\r\nBODY:\r\n${body}";
    private static final String ROUTE_ID = TransformWithProcessor.class.getCanonicalName();
    private static final String PROPERTIES_INPUT = "FirstField=1\r\nSecondField=2\r\nThirdField=3\r\n";

    public static void main(String... args) throws Exception {
        Main main = new Main();
        CamelContext context = new DefaultCamelContext();
        context.setUseMDCLogging(true);

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:timer?repeatCount=1")
                        .id(ROUTE_ID)
                        .setBody().constant(PROPERTIES_INPUT)
                        .log(LoggingLevel.INFO, LOGGER, LOG_MESSAGE)
                        .process(new PropertiesToCsvProcessor())
                        .log(LoggingLevel.INFO, LOGGER, LOG_MESSAGE);
            }
        });

        context.start();
        main.getCamelContexts().add(context);
        main.run();
    }
}
