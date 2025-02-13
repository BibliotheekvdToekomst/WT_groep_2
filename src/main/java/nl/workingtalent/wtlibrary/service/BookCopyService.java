package nl.workingtalent.wtlibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.wtlibrary.model.BookCopy;
import nl.workingtalent.wtlibrary.repository.IBookCopyRepository;

@Service
public class BookCopyService {
	@Autowired
	private IBookCopyRepository repository;
	
	public List<BookCopy> findAll(){
		return repository.findAll();
	}
	
	public void save(BookCopy bookCopy) {
		repository.save(bookCopy);
	}
	
	public Optional<BookCopy> findById(long id){
		return repository.findById(id);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public void update(BookCopy bookCopy) {
		repository.save(bookCopy);
	}
}
