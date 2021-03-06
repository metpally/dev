package edu.neu.cs5200.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.*;

import edu.neu.cs5200.model.Developer;

public class DeveloperBasicDBObjectLoadAll {

	public static List<Developer> loadAll() throws UnknownHostException {
		Mongo mongoClient = new Mongo( "localhost" , 27017 );
		DB db = mongoClient.getDB("developers");
		DBCollection coll = db.getCollection("developers");
		
		DBCursor cursor = coll.find();
		ArrayList<Developer> developers = new ArrayList<Developer>();
		while(cursor.hasNext()) {
			DBObject developerDB = cursor.next();
			Developer developer = null;
			developer = new Developer(developerDB);
			developers.add(developer);
		}
		
		return developers;
	}
	
	public static void main(String[] args) throws UnknownHostException {
		List<Developer> developers = DeveloperBasicDBObjectLoadAll.loadAll();
		for(Developer developer : developers) {
			System.out.println(developer);
		}
	}
}
