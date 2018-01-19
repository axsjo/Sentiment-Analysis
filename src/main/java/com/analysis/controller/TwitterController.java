package com.analysis.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analysis.service.TwitterService;

@RestController
public class TwitterController {

	private Logger logger = Logger.getLogger(TwitterController.class);

	@Autowired
	private TwitterService twitterService;

	@RequestMapping(value = "/tweets/{itemcategory}/{itemname}")
	public void getTweets(@PathVariable final String itemcategory, @PathVariable final String itemname) {
		
		twitterService.processTwitterData(itemcategory, itemname);

	}
	

}
