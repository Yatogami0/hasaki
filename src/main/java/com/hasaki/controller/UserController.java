package com.hasaki.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hasaki.entity.Computer;
import com.hasaki.entity.Rent;
import com.hasaki.entity.Users;
import com.hasaki.service.ComputerService;
import com.hasaki.service.RentService;
import com.hasaki.service.UserService;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	private List<Users> users;

	@Autowired
	@Qualifier("computerService")
	private ComputerService computerService;
	private List<Computer> computer;

	@Autowired
	@Qualifier("rentService")
	private RentService rentService;
	private List<Rent> rent;

	 /*登录页面*/
	@RequestMapping(value = "login")
	public String login() throws Exception{
		return "login";
	}

	/*登录表单提交*/
	@RequestMapping(value= "toLogin",method=RequestMethod.POST)
	public String toLogin(String username,String password,HttpServletRequest req) throws Exception{
		users = userService.login(username, password);
		if (users.size()!=0) {
			req.getSession().setAttribute("users", users);
			String a=users.get(0).getUserroot();
			if(a.equals("user")) {
				return "redirect:toindex";
			}else {
				return "redirect:toadmin";
			}
		} else {
			return "login";
		}
	}

	/*主页*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="toindex")
	public String index(Model model,HttpServletRequest req) throws Exception{
		users = (List<Users>) req.getSession().getAttribute("users");
		model.addAttribute("users",users);
		computer = computerService.selectAll();
		model.addAttribute("computer",computer);
		req.getSession().setAttribute("computer", computer);
		return "index";
	}

	/*个人页*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="userpage")
	public String userlogo(HttpServletRequest req,Model model) {
		users = (List<Users>) req.getSession().getAttribute("users");
		model.addAttribute("users",users);
		String username_1 = users.get(0).getUsername();
		rent = rentService.userRent(username_1);
		model.addAttribute("userRent",rent);
		return "userpage";
	}

	/*改密码*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="updatePassword",method=RequestMethod.POST)
	public String updatePassword(String oldPassword,String password,String password1,HttpServletRequest req) {
		users = (List<Users>)req.getSession().getAttribute("users");
		Integer userid=users.get(0).getUserid();
		String oldPassword1 = users.get(0).getPassword();
		if(oldPassword1.equals(oldPassword)) {
			if(password.equals(password1)) {
				int num = 0;
				num = userService.updatePassword(password, userid);
				if(num>0) {
					return "redirect:toUserpage";
				}else {
					return "fail";
				}
			}else {
				return "fail";
			}

		}else {
			return "fail";
		}
	}

	/*改电话*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="updateTel",method=RequestMethod.POST)
	public String updateTel(String utel,HttpServletRequest req) {
		users = (List<Users>)req.getSession().getAttribute("users");
		Integer userid=users.get(0).getUserid();
		int num = 0;
		num = userService.updateTel(utel, userid);
		if(num>0) {
			return "redirect:toUserpage";
		}else {
			return "userpage";
		}
	}

	/*改邮件*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="updateEmail",method=RequestMethod.POST)
	public String updateEmail(String uemail,HttpServletRequest req) {
		users = (List<Users>)req.getSession().getAttribute("users");
		Integer userid=users.get(0).getUserid();
		int num = 0;
		num = userService.updateTel(uemail, userid);
		if(num>0) {
			return "redirect:toUserpage";
		}else {
			return "userpage";
		}
	}



	/*跳转userpage*/
	@RequestMapping(value="toUserpage")
	public String toUserpage() {
		return "userpage";
	}
	/*提示失败的临时页*/
	@RequestMapping(value="fail")
	public String fail() {
		return "fail";
	}

	/*注册*/
	@RequestMapping(value="register")
	public String register() {
		return "register";
	}

	/*注册提交*/
	@RequestMapping(value="toregister",method=RequestMethod.POST)
	public String toregister(String username,String utel,String uemail,String realname,String password,String password1) {
		if(password.equals(password1)) {
			int num = 0;
			num = userService.register(username,utel,uemail,realname,password);
			if(num>0) {
				return "redirect:login";
			}else {
				return "register";
			}
		}else {
			return "register";
		}
	}

	/*下订单页面*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="rent")
	public String rent(String cid,Model model,HttpServletRequest req) {
		model.addAttribute("cid",cid);
		users = (List<Users>)req.getSession().getAttribute("users");
		String username = users.get(0).getUsername();
		model.addAttribute("username",username);
		return "rent";
	}

	/*订单提交*/
	@RequestMapping(value="toRent",method=RequestMethod.POST)
	public String toRent() {
		return "";
	}



	/*转后台*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="toadmin")
	public String toadmin(Model model,HttpServletRequest req) {
		users = (List<Users>) req.getSession().getAttribute("users");
		model.addAttribute("users",users);
		computer = computerService.selectAll();
		model.addAttribute("computer",computer);
		rent = rentService.selectRent();
		model.addAttribute("selectRent",rent);
		req.getSession().setAttribute("computer", computer);
		req.getSession().setAttribute("users", users);
		return "admin";
	}
}
