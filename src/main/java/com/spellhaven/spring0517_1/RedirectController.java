package com.spellhaven.spring0517_1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController { // 제곧내. 15장 리다이렉트 내용을 연습해 보자.

	@RequestMapping(value = "/index")
	public String goGirlsDay() {
		return "index";
	}
	
	@RequestMapping(value = "/idCheck")
	public String idCheck(HttpServletRequest request) {
		
		String cid = request.getParameter("id");
		
		if(cid.equals("student")) {
			return "redirect:studentOk";
			// 이렇게 "redirect:"로 나오는 return문은 L13의 경우처럼 문자열을 반환하여 .jsp로 가는 게 아니다.
			// 새로운 요청을 또 반환할 뿐...(해줘충 극혐 ㅗㅗ) 그래서, 아래에 @RequestMapping을 또 해 줘야 함
		}		
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk() {
		return "student/studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg() {
		return "student/studentNg";
	}
	
	
	// 참고로, 이렇게 할 수도 있다.
	@RequestMapping("/test")
	public String redirectTest() {
		return "redirect:http://localhost:8181/spring0517_1/test2"; // 리디렉션할 때 절대 주소를 전부 써 줄 수도 있디.
	}
	
	@RequestMapping("/test2") // 근데 그래도 어차피 이렇게 받아서 .jsp로 한 번 더 보내 줘야 한다.
	public String redirectTest2() {
		return "redirectTest"; // 참내.
	}
	
	
	// 이렇게 하면 스프링 프레임워크의 views 밖에 있는 놈도 실행 가능하다는데... "왜난않되냐"
	@RequestMapping("/root")
	public String root() {
		return "redirect:http://localhost:8181/spring0517_1/rootTest.jsp";
	}
	
}

























