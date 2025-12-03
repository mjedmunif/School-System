package org.example.onetoone.Repository;

import org.example.onetoone.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address , Integer> {
    Address findAddressById(Integer id);

    Address findAddressByTeacherId(Integer teacherId);
}
