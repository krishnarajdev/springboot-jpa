package com.mappings.mappings.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.mappings.Domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
