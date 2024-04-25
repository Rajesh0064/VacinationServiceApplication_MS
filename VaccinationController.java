package com.vaccination.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vaccination.Entity.Citizen;
import com.vaccination.Entity.RequiredResponse;
import com.vaccination.Repo.VaccinationRepo;
import com.vaccination.model.Vaccination;

@RestController 
@RequestMapping("/vaccination") 
public class VaccinationController { 
	
    @Autowired 
    private RestTemplate restTemplate; 
   @Autowired 
     private VaccinationRepo repo; 

  @GetMapping("/test") 
public String testMethod() 
{ 
return "Welcome To Vaccination-Center-Service"; 
} 
@PostMapping("/add") 
public Vaccination addVacinationCenterDetails(@RequestBody Vaccination newVacination) 
{ 
Vaccination add=repo.save(newVacination); 
return add; 
} 
@GetMapping("/get/{id}")
@HystrixCommand(fallbackMethod = "handleCitizenDownTime")
public ResponseEntity<RequiredResponse> getdata(@PathVariable int id)
{
	RequiredResponse requiredResponse=new RequiredResponse();
	
	// This is for Vaccination Center Details
	Vaccination center=repo.findById(id).get();
	requiredResponse.setCenter(center);
	
// Then Get citizen registered to Vaccination Details
List<Citizen> listOfCitizens=restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id,List.class);
requiredResponse.setCitizens(listOfCitizens); 
return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
	
	
}
public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable int id)
{
	RequiredResponse requiredResponse=new RequiredResponse();
	// 1st Get  Vaccination Center Details
	Vaccination center=repo.findById(id).get();
	requiredResponse.setCenter(center);
	return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK); 	
}

@GetMapping("/getVacc/{id}")
public ResponseEntity<Vaccination> getOne(@PathVariable int id)
{
	RequiredResponse requiredResponse =new RequiredResponse();
	
	// This is for Vaccination Center Details
	Vaccination center=repo.findById(id).get();
	return new ResponseEntity<Vaccination>(center,HttpStatus.OK); 
}
}