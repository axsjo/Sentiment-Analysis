package com.analysis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import com.analysis.dao.ReportDao;
import com.analysis.entity.Reportdata;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

@Service
public class TwitterServiceImplementation implements TwitterService {
	
	@Autowired
	private ReportDao reportDao;

	@Value("${consumer.key}")
	private String consumerKey;

	@Value("${Consumer.secret}")
	private String consumerSecret;

	@Value("${consumer.accesstoken}")
	private String apiKey;

	@Value("${consumer.accesstokensecret}")
	private String apiAccessToken;

	public void processTwitterData(String itemcategory, String itemname) {
		StanfordCoreNLP pipeline = new StanfordCoreNLP("nlp.properties");

		// As of now put the
		Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret);
		// Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret);
		SearchParameters params = new SearchParameters(itemcategory +" "+itemname);
		//params.lang("EN");
		//params.resultType(SearchParameters.ResultType.RECENT);
		
		params.count(1000);
		SearchResults results = twitter.searchOperations().search(params);
		List<Tweet> tweets = results.getTweets();
		int rating1Counter=0;
		int rating2Counter=0;
		int rating3Counter=0;
		int rating4Counter=0;
		int rating5Counter=0;
		
		Reportdata data=new Reportdata();
		data.setFromsite("Twitter");
		data.setItemcategory(itemcategory);
		data.setItemname(itemname);
		data.setUpdatedDate(new Date()+"");
		// Try to iterate the Tweets

		if (tweets != null && tweets.size() > 0) {
			for (Tweet tweet : tweets) {

				int mainSentiment = 0;
				if (tweet != null) {
					String tweetedText = tweet.getText();
					if (tweetedText != null) {

					}
					int longest = 0;
					Annotation annotation = pipeline.process(tweetedText);
					for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
						Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
						int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
						String partText = sentence.toString();
						if (partText.length() > longest) {
							mainSentiment = sentiment;
							if(mainSentiment==1){
							++rating1Counter;	
							}else if(mainSentiment==2){
								++rating2Counter;
							}
							else if(mainSentiment==3){
								++rating3Counter;
							}
							else if(mainSentiment==4){
								++rating4Counter;
							}else if(mainSentiment==5){
								++rating5Counter;
							}
							
							longest = partText.length();
							
						}

					}
				}
			}
			data.setRating1(rating1Counter);
			data.setRating2(rating2Counter);
			data.setRating3(rating3Counter);
			data.setRating4(rating4Counter);
			data.setRating5(rating5Counter);
		}
		//call here
		// if count >0 report data object
		List<Reportdata> reportData=reportDao.findByItemnameAndItemcategory(itemname, itemcategory);
		if(reportData!=null)
		{
			reportDao.delete(reportData);
		}
			
		reportDao.save(data);
	}

}
