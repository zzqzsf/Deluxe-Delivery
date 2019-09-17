package org.lanqiao.Conf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")

public class ZfbController {
	@RequestMapping("toindex")
	public String toindex() {
		return "list";
	}
}
