package org.example.onetoone.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIResponse;
import org.example.onetoone.DTO.AddressDTO;
import org.example.onetoone.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;
    
    @GetMapping("/get")
    public ResponseEntity<?> getAddress(){
        return ResponseEntity.status(200).body(addressService.getAddress());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new APIResponse("Added address To Teacher successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id , @RequestBody @Valid AddressDTO address){
        addressService.updateAddress(id , address);
        return ResponseEntity.status(200).body(new APIResponse("Updated Address successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new APIResponse("Deleted Address Successfully"));
    }
}
