package com.example.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> updateQuestion(Integer id, Question updatedQuestion) {
	    try {
	        Question existingQuestion = questionDao.findById(id).orElse(null);
	        if (existingQuestion == null) {
	            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
	        }

	        existingQuestion.setQuestion_title(updatedQuestion.getQuestion_title());
	        existingQuestion.setOption1(updatedQuestion.getOption1());
	        existingQuestion.setOption2(updatedQuestion.getOption2());
	        existingQuestion.setOption3(updatedQuestion.getOption3());
	        existingQuestion.setOption4(updatedQuestion.getOption4());
	        existingQuestion.setRight_Answer(updatedQuestion.getRight_Answer());
	        existingQuestion.setDifficulty_level(updatedQuestion.getDifficulty_level());
	        existingQuestion.setCategory(updatedQuestion.getCategory());

	        questionDao.save(existingQuestion);
	        return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>("Update failed", HttpStatus.BAD_REQUEST);
	    }
	}

	public ResponseEntity<String> deleteQuestion(Integer id) {
	    try {
	        if (!questionDao.existsById(id)) {
	            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
	        }
	        questionDao.deleteById(id);
	        return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
	    }
	}
}
