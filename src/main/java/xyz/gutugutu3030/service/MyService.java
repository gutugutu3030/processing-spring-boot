package xyz.gutugutu3030.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.gutugutu3030.domain.Customer;
import xyz.gutugutu3030.repository.MyRepository;

@Service
@Transactional
public class MyService {
	@Autowired
	MyRepository repository;
	public List<Customer> findAll(){
		return repository.findAllOrderByName1();
	}
	public Page<Customer> findAll(Pageable page){
		return repository.findAllOrderByName1(page);
	}
	public Customer findOne(Integer id){
		return repository.findOne(id);
	}
	public Customer create(Customer customer){
		return repository.save(customer);
	}
	public Customer update(Customer customer){
		return repository.save(customer);
	}
	public void delete(Integer id){
		repository.delete(id);
	}

}
