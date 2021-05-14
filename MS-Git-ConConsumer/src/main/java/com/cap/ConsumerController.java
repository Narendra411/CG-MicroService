package com.cap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsumerController {
	
	@Value("${rate}")
	String rate;
	
	@Value("${tollstart}")
	String tollStart;
	
	@Value("${lanecount}")
	String laneCount;
	
	@RequestMapping("/rate")
	public String getRate(Model m) {
		m.addAttribute("rate",rate);
		m.addAttribute("tollStart",tollStart);
		m.addAttribute("laneCount",laneCount);
		
		return "rateView";
	}

}
