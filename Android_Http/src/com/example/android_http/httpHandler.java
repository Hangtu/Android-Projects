package com.example.android_http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class httpHandler {
	
	
	public String post(String url){
		
		try{
		 HttpClient cliente=new DefaultHttpClient();
		 HttpPost post=new HttpPost(url); //direccion 
		
		 HttpResponse resp= cliente.execute(post);//respuesta del servidor
		 HttpEntity ent = resp.getEntity(); 
		 
		 String resultado = EntityUtils.toString(ent);
		
		 return resultado;
		
		}catch (Exception ex){
		  return ex.getMessage().toString();
		}
	}

}
