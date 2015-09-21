package xyz.gutugutu3030.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import xyz.gutugutu3030.domain.Customer;
import xyz.gutugutu3030.service.MyService;

@RestController
@RequestMapping("api/customers")
public class MyRestController {
	@Autowired
	MyService service;

	@RequestMapping(method=RequestMethod.GET)
	List<Customer> getCustomers(){
		return service.findAll();
	}

	//ページネーション対応
	@RequestMapping(value="new",method=RequestMethod.GET)
	Page<Customer> getCustomersPage(@PageableDefault Pageable pageable){
		Page<Customer> customers=service.findAll(pageable);
		return customers;
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	Customer getCustomer(@PathVariable Integer id){
		return service.findOne(id);
	}

	//httoレスポンス　ヘッダのlocationの中に生成したURlを記述する
	@RequestMapping(method=RequestMethod.POST)
	ResponseEntity<Customer> postCustomer(@RequestBody Customer customer,UriComponentsBuilder uriBuilder){
		Customer created=service.create(customer);
		URI location=uriBuilder.path("api/customers/{id}").buildAndExpand(created.getId()).toUri();
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(location);
		return new ResponseEntity<>(created,headers,HttpStatus.CREATED);
	}

	@RequestMapping(value="{id}",method=RequestMethod.PUT)
	Customer putCustomer(@PathVariable Integer id,@RequestBody Customer customer){
		return service.update(customer);
	}

	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id){
		service.delete(id);
	}

}
