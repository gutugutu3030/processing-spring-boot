package xyz.gutugutu3030.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xyz.gutugutu3030.domain.Customer;

public interface MyRepository extends JpaRepository<Customer,Integer>{
	@Query("select x from Customer x order by x.firstName, x.lastName")	//JPQL
	List<Customer> findAllOrderByName1();
	@Query("select x from Customer x order by x.firstName, x.lastName")
	Page<Customer> findAllOrderByName1(Pageable pageable);

	@Query(value="select * from customers order by first_name, last_name",nativeQuery=true)	//SQL
	List<Customer> findAllOrderByName2();
}
