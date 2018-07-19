package com.spring.mongo.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/hello")
	String helloJPA() {
		return "<b style='color:green'> Hello From Spring Boot with MongoDB "
				+ "<br/> Here we will do DB Connection and CURD operation with MongoDB</b>";
		
	}
	
	@RequestMapping("/topics")
	List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	/**
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	**
	* Or if Pathvariable is different from method argument do as below -
	*/
	
	@RequestMapping("/topics/{tid}")
	public Topic getTopic(@PathVariable("tid") String id) {
		return topicService.getTopic(id);
	}

	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public String addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public String updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		return topicService.updateTopic(id,topic);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id);
		
	}
	
	@RequestMapping(method=RequestMethod.PATCH,value="/topics/{id}")
	public String updatePartialTopic(@RequestBody Topic topic,@PathVariable String id) {
		return topicService.updateTopic(id,topic);
		
	}
}
