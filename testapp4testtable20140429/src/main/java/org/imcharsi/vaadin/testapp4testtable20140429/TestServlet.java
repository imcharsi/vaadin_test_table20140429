package org.imcharsi.vaadin.testapp4testtable20140429;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by KangWoo,Lee on 14. 4. 29.
 */
@WebServlet(urlPatterns = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = TestUI.class)
public class TestServlet extends VaadinServlet {
}
