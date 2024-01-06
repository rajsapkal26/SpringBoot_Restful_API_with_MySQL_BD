package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.Course;
import com.example.demo.repo.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	

	@Override
	public String upsert(Course course) {
		courseRepo.save(course);  // it will perform upsert(save and update) operation.
		return "Successfull";
	}

	
	@Override
	public Course getById(Integer cid) {
	Optional<Course> findById =  courseRepo.findById(cid); // it will find courses by id.
	
	if(findById.isPresent()) {
		return findById.get();
	}else {
		
		return null;
	}
	
		
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();  // it will return all Courses
	}

	
	
	
	@Override
	public String deletById(Integer cid) {
		if(courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete Successfull";
		} else {
			return "No Record Find";
		}
		
	}

}
