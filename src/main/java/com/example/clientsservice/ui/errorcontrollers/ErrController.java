package com.example.clientsservice.ui.errorcontrollers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class ErrController implements ErrorController {

	@RequestMapping(value = "error")
	public ModelAndView handleError(HttpServletRequest request){
		Integer statusAttr = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//		Enumeration<String> enumeration =request.getAttributeNames();
//		String name;
		if (statusAttr == null)
			return new ModelAndView("error");
			HttpStatus status = HttpStatus.valueOf(statusAttr);
//			if (status == HttpStatus.FORBIDDEN)
//				return new ModelAndView("redirect:");

		return  new ModelAndView("error", new ModelMap().addAllAttributes(Map.of(
		"timestamp", LocalDate.now(),
		"error", request.getAttribute(RequestDispatcher.ERROR_MESSAGE),
		"message", request.getAttribute(RequestDispatcher.ERROR_MESSAGE),
		"status", statusAttr,
		"path", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI),
		"exception",
			request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE) == null ?
		 "" : request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE),
		"trace", request.getAttribute(RequestDispatcher.FORWARD_CONTEXT_PATH)
		)));
	}



}
