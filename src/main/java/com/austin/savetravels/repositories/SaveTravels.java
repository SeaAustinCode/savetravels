package com.austin.savetravels.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.austin.savetravels.models.Expense;

@Repository
public interface SaveTravels extends CrudRepository<Expense, Long>{
	// this method retrieves all the books from the database
	List<Expense> findAll();
}
		    
		    
