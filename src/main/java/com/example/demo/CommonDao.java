package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pj.to.Bank;
import com.pj.to.IConfig;
import com.pj.to.User;

import java.util.List;

@Repository
public class CommonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findUser(String userName) {
    	String query="SELECT user_id,user_name,password,login_status FROM T_intuit_user t where user_name='"+userName+"'";

        List<User> result = jdbcTemplate.query(query,
                
                (rs, rowNum) -> new User(rs.getInt(IConfig.USER_ID),rs.getString(IConfig.USER_STATUS),
                        rs.getString(IConfig.PASSWORD), rs.getString(IConfig.LOGIN_STATUS))
        );

        return result;

    }
    
    public List<User> findAllUser() {
    	String query="SELECT user_id,user_name,password,login_status FROM T_intuit_user t";

        List<User> result = jdbcTemplate.query(query,
                
                (rs, rowNum) -> new User(rs.getInt(IConfig.USER_ID),rs.getString(IConfig.USER_STATUS),
                        rs.getString(IConfig.PASSWORD), rs.getString(IConfig.LOGIN_STATUS))
        );

        return result;

    }

    
    public int  createUser(String userName,String password) {
    	
    	
    	List<User> outPut=	findUser(userName);
    	if(outPut ==null || outPut.isEmpty()) {
    	String query="INSERT INTO T_intuit_user VALUES( INTUIT_USER_SEQ.NEXTVAL ,'"+userName+"','"+password+"',"+"'N'"+")";
    	jdbcTemplate.execute(query);
    	return 1;
    	}else {
    		return 0;
    	}
    }
    
    public int  login(String userName,String password) {
    	String query="SELECT user_id,user_name,password,login_status FROM T_intuit_user t where user_name='"+userName+"' and password='"+password+"'";

        List<User> result = jdbcTemplate.query(query,
                
        		 (rs, rowNum) -> new User(rs.getInt(IConfig.USER_ID),rs.getString(IConfig.USER_STATUS),
                         rs.getString(IConfig.PASSWORD), rs.getString(IConfig.LOGIN_STATUS))
        );

        if(result.isEmpty()) {
        return 0;
        }else {
        	String updateQuery="UPDATE T_intuit_user SET login_status='Y' WHERE user_id="
                               +result.get(0).getUser_id();
        	jdbcTemplate.execute(updateQuery);

        return 1;
        }

    }
    
    public String loginStatusCheck() {
    	
    	String query="SELECT COUNT(1) FROM T_intuit_user WHERE login_status ='Y' ";
    	int result=jdbcTemplate.queryForObject(query, Integer.class);
    	if(result >0) {
    	return "Y";
    	}else {
    		return "N";
    	}
    	
    }
    
    public List<Bank>  getBankList() {
    	String query="SELECT bank_id,bank_name,account_type,account_no,corp_id from t_intuit_bank";
    	List<Bank> result = jdbcTemplate.query(query,
                
       		 (rs, rowNum) -> new Bank(""+rs.getInt(IConfig.BANK_ID),rs.getString(IConfig.BANK_NAME),
                        rs.getString(IConfig.ACCOUNT_TYPE), ""+rs.getInt(IConfig.ACCOUNT_NO),""+rs.getString(IConfig.CROP_ID))
       );
    	
    	return result;
    }
    
    public String bankStatuscheck(String bankName) {
    	String query="select count(1) from t_intuit_bank where bank_name= '" +bankName+"'";
    	int result=jdbcTemplate.queryForObject(query, Integer.class);
    	if(result >0) {
    	return "Y";
    	}else {
    		return "N";
    	}

    }
    
    public List<Bank>  getBankdetailsByName(String name) {
    	String query="SELECT bank_id,bank_name,account_type,account_no,corp_id from t_intuit_bank where bank_name ='" +name +"'";
    	List<Bank> result = jdbcTemplate.query(query,
                
       		 (rs, rowNum) -> new Bank(""+rs.getInt(IConfig.BANK_ID),rs.getString(IConfig.BANK_NAME),
                        rs.getString(IConfig.ACCOUNT_TYPE), ""+rs.getInt(IConfig.ACCOUNT_NO),""+rs.getString(IConfig.CROP_ID))
       );
    	
    	return result;
    }

    
}
