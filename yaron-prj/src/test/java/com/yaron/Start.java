package com.yaron;

import org.apache.log4j.Logger;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.resource.ResourceCollection;

import java.util.Map;


public class Start {

    private static final Logger logger = Logger.getLogger(Start.class);

    public static void main(String[] args) {
        Server server = new Server();
        SocketConnector connector = new SocketConnector();
        // Set some timeout options to make debugging easier.
        connector.setMaxIdleTime(1000 * 60 * 60);
        connector.setSoLingerTime(-1);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});


        WebAppContext webAppContext = new WebAppContext()   {
            @Override
                public String getResourceAlias(String alias) {

                    @SuppressWarnings("unchecked")
                    Map<String, String> resourceAliases =
                        (Map<String, String>) getResourceAliases();

                    if (resourceAliases == null) {
                        return null;
                    }

                    for (Map.Entry<String, String> oneAlias :
                        resourceAliases.entrySet()) {

                        if (alias.startsWith(oneAlias.getKey())) {
                            return alias.replace(
                                oneAlias.getKey(), oneAlias.getValue());
                        }
                    }

                    return null;
                }

        };

        webAppContext.setServer(server);
        webAppContext.setContextPath("/yaron");
        webAppContext.setBaseResource(
                new ResourceCollection(
                        new String[]{"./src/main/webapp", "./target"}));
        webAppContext.setResourceAlias("/WEB-INF/classes/", "/classes/");

        server.addHandler(webAppContext);

        try {
            logger.info(">>> STARTING EMBEDDED JETTY SERVER");
            server.start();

        } catch (Exception e) {
            logger.error(e);

        }
    }
}