package com.pj.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ClientExecution {

	public static void main(String[] args) {
		testcase1();
		testcase2();
		testcase3();
		testcase4();
		testcase5();
		testcase6();
		testcase7();

	}
	
	private static void testcase1(){
		String url="http://localhost:8182/api/register";
		RestTemplate template=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("username", "sc");
		map.add("password", "123");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = template.postForEntity( url, request , String.class );
		
		//System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
	}

	private static void testcase2(){
		String url="http://localhost:8182/api/login";
		RestTemplate template=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("username", "sc");
		map.add("password", "123");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = template.postForEntity( url, request , String.class );
		
		//System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
	}
	
	private static void testcase3(){
		String url="http://localhost:8182/api/getbanklist";
		RestTemplate template=new RestTemplate();
		String message=	template.getForObject(url, String.class);
		System.out.println(message);
	}

	private static void testcase4(){
		String bankName="sbi";
		String url="http://localhost:8182/api/getbankdata/bankname/"+bankName;
		RestTemplate template=new RestTemplate();
		String message=	template.getForObject(url, String.class);
		System.out.println(message);
	}
	
	private static void testcase5(){
		String url="http://localhost:8182/api/getbankdata/bankname";
		RestTemplate template=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("username", "sc");
		map.add("password", "123");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = template.postForEntity( url, request , String.class );
		
		//System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
	}

	private static void testcase6(){
		String bankName="sbi";
		String url="http://localhost:8182/api/getaccounts/bankname/"+bankName;
		RestTemplate template=new RestTemplate();
		String message=	template.getForObject(url, String.class);
		System.out.println(message);
	}

	private static void testcase7(){
		String accountNo="123456";
		String url="http://localhost:8182/api/gettransactiondata/"+accountNo;
		RestTemplate template=new RestTemplate();
		String message=	template.getForObject(url, String.class);
		System.out.println(message);
	}

}
