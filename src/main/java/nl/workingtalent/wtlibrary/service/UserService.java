package nl.workingtalent.wtlibrary.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.wtlibrary.dto.UserLoginDto;
import nl.workingtalent.wtlibrary.model.User;
import nl.workingtalent.wtlibrary.repository.IUserRepository;

@Service
public class UserService {

	@Autowired 
	private IUserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}

	public void save(User user) {
		// Hash the password before saving the user
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repository.save(user);
	}

	public Optional<User> findById(long id){
		return repository.findById(id);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public void update(User user) {
		// to-do: Only hash if it is changed
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repository.save(user);
	}
	
	public Optional<User> authenticate(String email, String password) {
		Optional<User> optional = repository.findByEmailAndPassword(email, password);
		
		if (optional.isPresent()) {
			User user = optional.get();
			user.setToken(generateToken());
			repository.save(user);
		}

		return optional;
	}
	
	private String generateToken() {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 90;

	    Random random = new Random();

	    return random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	}

}
