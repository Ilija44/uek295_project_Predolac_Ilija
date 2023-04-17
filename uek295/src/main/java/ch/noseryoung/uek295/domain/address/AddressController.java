package ch.noseryoung.uek295.domain.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/")
    public ResponseEntity<Object> getAddress() {
        return ResponseEntity.ok().body(service.getAddress());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable("addressID") Integer addressId) {
        return ResponseEntity.ok().body(service.getAddressById(addressId));
    }

    @PostMapping("/")
    public void postAddress(@Valid @RequestBody Address address) {
        service.addAddress(address);
    }


}
