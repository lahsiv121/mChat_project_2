package com.niit.mChatbackend.Dao;

import java.util.List;

import com.niit.mChatbackend.model.Job;


public interface JobDao {

	void saveJob(Job job);

	List<Job> getAllJobs();

	Job getJobById(int id);

}
