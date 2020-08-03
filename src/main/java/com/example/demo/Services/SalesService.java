package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Sale;
import com.example.demo.Repositories.SalesRepo;

@Service
public class SalesService {
	
	//Service is a separate class to handle logic

	@Autowired
	SalesRepo salerepo;
	
	public Sale storeRecord(Sale saleRecord) {
		return salerepo.saveAndFlush(saleRecord);	
	}
	
	public String deleteRecord(int id) {
		String message = "";
		Optional<Sale> record = salerepo.findById(id);
		if (record.isPresent()) {
			salerepo.deleteById(id);
			 message= "Record has been deleted";
		}else {
			 message = "The id: " + id + " Does not exists in the databse";
		}
		return message;
		
	}
	
	public List<Sale> listAllNotes() {
		return salerepo.findAll();
	}
	
	
	public List<Sale> FindbyPrice(float price){
		return salerepo.findByPrice(price);
	}
	
	
}
