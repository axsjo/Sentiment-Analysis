package com.analysis.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.analysis.dao.ReportDao;
import com.analysis.dao.UserDao;
import com.analysis.entity.Reportdata;
//import com.analysis.entity.Reportdata;
import com.analysis.entity.User;

@RestController
public class query {

		@Autowired
		UserDao usd;
		
		@Autowired
		ReportDao rep;
	
		@RequestMapping("/jsondata/{userdata}")
		public String jsondata(@PathVariable("userdata") String userdata) throws JSONException{
			System.out.print(userdata);
			//User k = usd.findByUserId("admin");
			List<Reportdata> r = rep.findByItemname(userdata);
			
			JSONArray jsr = new JSONArray();
			for(Reportdata rt : r){
			JSONObject jsb = new JSONObject();
			
			jsb.put("Reportdata",rt.getItemname());
			jsb.put("ratings1", rt.getRating1());
			jsb.put("ratings2", rt.getRating2());
			jsb.put("ratings3", rt.getRating3());
			jsr.put(jsb);
			}
			
			//jsb.put("user", k.getName());
			
			
			return jsr.toString();
			//return jsb.toString();
		}
}