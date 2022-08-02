package com.wdtt.ttdw.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 메인 컨트롤러 
 */
@Controller
public class HomeController {
	
	/**
	 * HOME
	 */
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
