package net.javaguides.usermanagement.web;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class UserServletTest {
	@Spy
	private UserServlet servlet;
	@Mock
	private ServletConfig servletConfig;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private ServletOutputStream outputStream;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws IOException, ServletException {
//		 when(servlet.getServletConfig()).thenReturn(servletConfig); 
		when(response.getOutputStream()).thenReturn(outputStream);
		when(request.getParameter("name")).thenReturn("Vinod");
		when(request.getServletPath()).thenReturn("/new");
		RequestDispatcher rd = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher("user-form.jsp")).thenReturn(rd);
		when(request.getParameter("desciption")).thenReturn("desc");
//		    request.
		servlet.doGet(request, response);
		outputStream.println();
		verify(outputStream).println("Hello World!");
	}

}
