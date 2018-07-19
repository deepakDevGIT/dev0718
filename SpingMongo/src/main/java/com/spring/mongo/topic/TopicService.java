package com.spring.mongo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public String addTopic(Topic topic) {
		topicRepository.save(topic);
		return topic.getId()+" added in DB successfully";
		
	}

	public String updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		return id+" updated successfully";
	}

	public String deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
		return id+" deleted successfully";
	}
	
}
