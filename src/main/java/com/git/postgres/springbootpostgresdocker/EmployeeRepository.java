package com.git.postgres.springbootpostgresdocker;

import com.git.postgres.springbootpostgresdocker.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
