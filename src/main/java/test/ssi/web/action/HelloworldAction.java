package test.ssi.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloworld")
public class HelloworldAction {
	
	private static final Logger logger = Logger.getLogger(HelloworldAction.class);

	@RequestMapping("hello")
	public void hello(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().write("hello world!");
		} catch (IOException e) {
			logger.error("hello ERROR", e);
		}
	}
}
