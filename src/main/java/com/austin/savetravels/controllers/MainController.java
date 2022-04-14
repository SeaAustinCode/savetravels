package com.austin.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.austin.savetravels.models.Expense;
import com.austin.savetravels.services.ExpenseService;

@Controller
public class MainController {

	@Autowired
	private ExpenseService expenseService;
		
	// This one renders the page 
	@RequestMapping(value={"/expenses","/",""}) //this will make it so localhost8080:/expenses or localhost8080: will both take you to this page.
	public String createExpense(Model model) {
		List<Expense> allexpenses = expenseService.allExpenses();
		model.addAttribute("allexpenses", allexpenses);
		Expense expense = new Expense();
		model.addAttribute("expense", expense);
		return "expenses.jsp";
	}
	
	// This one executes the action from the form and passes in the "expense"
	@PostMapping("/expenses")
	public String createexpense(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "expenses.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	// This one renders the edit page 
	
	@RequestMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "update.jsp";
	}
	
	@PutMapping(value="/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if (result.hasErrors()) {
			return "update.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
    @DeleteMapping("/delete/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
    
    @GetMapping("/expenses/{id}/show")
	public String showOne(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "details.jsp";
	
}
    
}

