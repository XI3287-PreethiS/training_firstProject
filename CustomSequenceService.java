package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomSequence;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@Service
public class CustomSequenceService {
	
	@Autowired
	private MongoOperations mongoOps;
	
	public int getNextSequence(String id) {
		
		CustomSequence count = mongoOps.findAndModify(query(where("_id").is(id)),
				new Update().inc("sequence",1), options().returnNew(true).upsert(true),CustomSequence.class);
		return count.getSequence();
	}

}
