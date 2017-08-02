package yitian.study.vertxwebclienetstudy;

import org.junit.Test;
import yitian.study.vertxwebclientstudy.WebClientUsage;

public class WebClientTest {
    @Test
    public void testWebClient() {
        WebClientUsage webClientUsage = new WebClientUsage();
        webClientUsage.createWebClient();
        webClientUsage.makeRequests();
        webClientUsage.handleResponse();
    }
}
