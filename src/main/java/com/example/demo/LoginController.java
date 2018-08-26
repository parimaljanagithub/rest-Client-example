package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.to.Bank;
import com.pj.to.InputUser;
import com.pj.to.User;
import com.pj.to.inputBank;

@Controller
public class LoginController {
	
	@Autowired
	CommonDao dao;
	
	//1
	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	public @ResponseBody String register(@ModelAttribute InputUser user, ModelMap model)  {
        int result= dao.createUser(user.getUsername(),user.getPassword());
		if(result ==0){
			return "{\nerror:803 \n" 
					+ "message:user already exist \n registered:YES \n} ";
		}else{
			
			return "200";
		}
		
		

	}
	

	//2
		@RequestMapping(value = "/api/login", method = RequestMethod.POST)
		public @ResponseBody String login(@ModelAttribute InputUser user, ModelMap model) {
			
			 int result= dao.login(user.getUsername(),user.getPassword());
			if(result==0){
				
				return "{\nerror:803 \n" 
						+ "message:log in not possible please check credential \n registered:NO \n} ";
			}else{
				
				return "200";
			}
		}
			
//3
		@RequestMapping(value = "/api/getbanklist", method = RequestMethod.GET)
		public @ResponseBody String getBankList( ModelMap model) {
			
			String loginStatus=dao.loginStatusCheck();
			
			if(loginStatus.equals("N")){
				
				return "{\nerror:804 \n" 
						+ "message:please login with valid id \n registered:NO \n} ";
			}else{
				StringBuffer returnOutPut=new StringBuffer();
				List<Bank> out=	dao.getBankList();
				returnOutPut.append("bankName[");
				for(Bank b:out) {
					returnOutPut.append(b.getBank_name());
					returnOutPut.append(",");
				}
				String s=returnOutPut.substring(0, returnOutPut.length()-1)+"]";
			
				return s;
			}
		}
		
		
		//4
		@RequestMapping(value = "/api/getbankdata/bankname/{name}", method = RequestMethod.GET)
		public @ResponseBody String getBankMetadata(@PathVariable String name, ModelMap model) {
			
			String status =dao.bankStatuscheck(name);
			if(status.equalsIgnoreCase("N")){
				
				return "{\nerror:805 \n" 
						+ "message:No Bank Details present for bank name " + name+ "\n registered:NO \n} ";
			}else{
				List<User> out=dao.findAllUser();
				StringBuffer b=new StringBuffer();
				
				for(User u:out) {
					b.append("{");
					b.append("\n");
					b.append("userName :");	b.append(u.getUserName());
					b.append("\n");
					b.append("password:"); b.append(u.getPassword());
					b.append("\n");
					b.append("cropId: Yes");
					b.append("\n");
					b.append("}");
					b.append("\n");
				}
				
				
				return b.toString();
			}
		}	
		

		//5
		@RequestMapping(value = "/api/getbankdata/bankname", method = RequestMethod.POST)
		public @ResponseBody String getBanklognin(@ModelAttribute inputBank bank, ModelMap model) {
			
			int result= dao.login(bank.getUsername(),bank.getPassword());			
			if(result ==0){
			
				
				return "{\nerror:805 \n" 
						+ "message:no authorised to log into the bank \n registered:NO \n} ";

			}else{
				return "200";
			}
		}	
		
		//6 
		@RequestMapping(value = "api/getaccounts/bankname/{bankName}", method = RequestMethod.GET)
			public @ResponseBody  String getAccountDetails(@PathVariable String bankName ,ModelMap model) {
				String loginStatus=dao.loginStatusCheck();
				
				if(loginStatus.equals("N")){
					
					return "{\nerror:804 \n" 
							+ "message:please login with valid id \n registered:NO \n} ";
				}else{
					StringBuffer returnOutPut=new StringBuffer();
					List<Bank> out=	dao.getBankdetailsByName(bankName);
					returnOutPut.append("{");
					for(Bank b:out) {
						returnOutPut.append(" Account Type:"); returnOutPut.append(b.getAccount_type());

						returnOutPut.append(" Account no : "); returnOutPut.append(b.getAccount_no());
						returnOutPut.append(",\n");
					}
					String s=returnOutPut.substring(0, returnOutPut.length()-1)+"}";
				
					return s;
				}
			}
		
		
		
		@RequestMapping(value = "/api/gettransactiondata/{accountnumber}", method = RequestMethod.GET)
		public @ResponseBody String getTransactionData(@PathVariable String accountnumber, ModelMap model) {
			
			
				
				return "{account no: "+accountnumber+", time:"+new Date()+" type:dr} ";
			
		}		
		
}
