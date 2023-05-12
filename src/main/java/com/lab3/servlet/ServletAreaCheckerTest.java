package com.lab3.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.Test;
import org.mockito.Mockito;
import org.testng.Assert;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ServletAreaCheckerTest extends Mockito {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher r = Mockito.mock(RequestDispatcher.class);

        ServletContext ctx = Mockito.mock( ServletContext.class );
        Mockito.when(ctx.getServletContextName()).thenReturn("mock");
        ServletConfig sc = Mockito.mock( ServletConfig.class );

        Mockito.when( sc.getServletContext()).thenReturn( ctx );

        // Initialization
        ServletAreaCheck s = new ServletAreaCheck();
//        WebAdminInterceptionServlet servlet = new WebAdminInterceptionServlet();
        s.init( sc );
//        s.karafEtc = "";

        Mockito.when(request.getRequestDispatcher(anyString())).thenReturn(r);
        Mockito.when(request.getParameter("x")).thenReturn("0");
        Mockito.when(request.getParameter("y")).thenReturn("0");
        Mockito.when(request.getParameter("r")).thenReturn("0");
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("points")).thenReturn(null);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        new ServletAreaCheck().doGet(request, response);

        Mockito.verify(request, Mockito.atLeast(1)).getParameter("x"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        String an = stringWriter.toString();
        Assert.assertTrue(stringWriter.toString().isEmpty());
//                equals("Value of R must be in range [2; 5]"));
    }

    @Test
    public void testServlet1() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher r = Mockito.mock(RequestDispatcher.class);

        ServletContext ctx = Mockito.mock( ServletContext.class );
        Mockito.when(ctx.getServletContextName()).thenReturn("mock");
        ServletConfig sc = Mockito.mock( ServletConfig.class );

        Mockito.when( sc.getServletContext()).thenReturn( ctx );

        // Initialization
        ServletAreaCheck s = new ServletAreaCheck();
//        WebAdminInterceptionServlet servlet = new WebAdminInterceptionServlet();
        s.init( sc );
//        s.karafEtc = "";

        Mockito.when(request.getRequestDispatcher(anyString())).thenReturn(r);
        Mockito.when(request.getParameter("x")).thenReturn("0");
        Mockito.when(request.getParameter("y")).thenReturn("0");
        Mockito.when(request.getParameter("r")).thenReturn("3");
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("points")).thenReturn(null);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        new ServletAreaCheck().doGet(request, response);

        Mockito.verify(request, Mockito.atLeast(1)).getParameter("x"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        String an = stringWriter.toString().substring(0, 58);
        String ex = "[{\"attampt\":0,\"x\":0.0,\"y\":0.0,\"r\":3.0,\"result\":true,\"time\":\"May, 12, 2023 15:18:58\",\"duration\":66.55527}]".substring(0, 58);
        Assert.assertTrue(stringWriter.toString().substring(0, 58).equals(ex));
    }
}