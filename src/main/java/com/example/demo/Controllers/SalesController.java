package com.example.demo.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Sale;
import com.example.demo.Services.SalesService;

@RestController
@CrossOrigin
public class SalesController {
	
	//Constructor
	SalesService service;
	public SalesController(SalesService salesService) {
		this.service = salesService;
	}
	
	@GetMapping("/deleteRecord/{id}")
	public String deleteRecord(@PathVariable("id") int id) {
		String msg= service.deleteRecord(id);
		return msg;
	}
	
	@PostMapping("/addRecord")
		public ResponseEntity<Sale> addRecord(@RequestBody Sale saleRecord) {
			Sale created = service.storeRecord(saleRecord);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Sale>> listAllNotes() {
		List<Sale> found = service.listAllNotes();
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("/findByPrice/{price}")
		public ResponseEntity<List<Sale>> findByprice(@PathVariable("price") float price){
		List<Sale> found = service.FindbyPrice(price);
		return ResponseEntity.ok(found);
		
	}
	

}
