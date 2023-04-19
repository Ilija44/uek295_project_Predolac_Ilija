package ch.noseryoung.uek295.domain.address;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@Log4j2
public class AddressController {

    @Autowired

  AddressService service;

    @GetMapping("/")
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "Get all addresses", description = "Retrieves a list of all addresses currently stored in the database.")
    public ResponseEntity<Object> getAddress() {
        log.info("Endpoint for getting all Addresses was called.");
        return ResponseEntity.ok().body(service.getAddress());
    }

    @GetMapping("/{addressId}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<Address> getAddressById(@PathVariable("addressID") Integer addressId) {
        return ResponseEntity.ok().body(service.getAddressById(addressId));
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('CREATE')")
    public void postAddress(@Valid @RequestBody Address address) {
        service.addAddress(address);
    }

    @DeleteMapping("/{addressId}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<Object> deleteAddress(@PathVariable("addressId") Integer addressId) {
        service.deleteAddressById(addressId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{addressId}")
    @PreAuthorize("hasAuthority('UPDATE')")
    @Operation(summary = "Updates an address in the database with a given ID", description = "Updates an existing address in the database with the given address ID. Returns a 401 error code if the ID is not found in the database. Access to this endpoint requires the 'ADMIN' role.")
    public void updateAddress(@Valid @PathVariable("addressId") int addressId, @RequestBody Address address) {
        service.updateAddress(addressId, address);
    }


}
