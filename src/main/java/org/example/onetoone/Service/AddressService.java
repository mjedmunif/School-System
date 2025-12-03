package org.example.onetoone.Service;

import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIException;
import org.example.onetoone.DTO.AddressDTO;
import org.example.onetoone.Model.Address;
import org.example.onetoone.Model.Teacher;
import org.example.onetoone.Repository.AddressRepository;
import org.example.onetoone.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherId());
        if (teacher == null){
            throw new APIException("teacherId not found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Integer id , AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherId());
        Address oldAddress = addressRepository.findAddressById(id);
        if (oldAddress == null){
            throw new APIException("address not found");
        }
        if (teacher == null){
            throw new APIException("teacher not found");
        }
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        oldAddress.setStreet(addressDTO.getStreet());
        addressRepository.save(oldAddress);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if (address == null){
            throw new APIException("address not found");
        }
        addressRepository.delete(address);
    }
}
