package com.austin.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.austin.savetravels.models.Expense;
import com.austin.savetravels.repositories.SaveTravels;

@Service
public class ExpenseService {

	// CRUD 
	@Autowired // a simpler and easier way to do dependency injection
	private SaveTravels saveTravelsRepo;


// READ ALL 
	public List<Expense> allExpenses() {
		return saveTravelsRepo.findAll();
	}
	
// CREATE 
	public Expense createExpense(Expense e) {
		
		return saveTravelsRepo.save(e);
	}
	
// READ ONE 
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = saveTravelsRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
// UPDATE 
	public Expense updateExpense(Expense e) {
		return saveTravelsRepo.save(e);
	}
	
// DELETE
	public void deleteExpense(Long id) {
		saveTravelsRepo.deleteById(id);
	}
}
