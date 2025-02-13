package nl.workingtalent.wtlibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import nl.workingtalent.wtlibrary.model.Review;
import nl.workingtalent.wtlibrary.repository.IReviewRepository;


@Service
public class ReviewService {

	@Autowired 
	private IReviewRepository repository;
	
	public List<Review> findAll(){
		return repository.findAll();
	}
	
	public void save(Review review) {
		repository.save(review);
	}
	
	public Optional<Review> findById(@PathVariable long id){
		return repository.findById(id);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public void update(Review review) {
		repository.save(review);
	}
	
}
