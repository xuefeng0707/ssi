package test.ssi.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.ssi.model.Result;
import test.ssi.model.ResultCode;
import test.ssi.model.User;
import test.ssi.service.UserService;

@Controller
@RequestMapping("/")
public class LoginAction {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="username", required = false)String username, 
			@RequestParam(value="password", required = false)String password) {
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return Result.valueOfError(ResultCode.PARAMETER_ERROR.getCode(), "username、password缺一不可!").toString();
		}
		
		User user = userService.getUserByUsername(username);
		if(user == null) {
			return Result.valueOfError(ResultCode.USER_NOT_EXISTS).toString();
		}
		if(!password.equals(user.getPassword())) {
			return Result.valueOfError(ResultCode.USER_PASSWORD_ERROR).toString();
		}
		
		return Result.valueOfOK("Login success!").toString();
	}
}
