package ch.noseryoung.uek295.domain.address;

import ch.noseryoung.uek295.domain.exception.AddressNotFoundException;
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
    @Operation(summary = "Retrieves a list of all addresses from the database", description = "Retrieves a list of all addresses currently stored in the database. Returns a 200 status code with a list of addresses if the query is successful. Access to this endpoint requires the 'READ' authority.")
    public ResponseEntity<Object> getAddress() {
        log.info("The endpoint to retrieve all addresses was called and the data returned successfully.");
        return ResponseEntity.ok().body(service.getAddress());
    }

    @GetMapping("/{addressId}")
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "Retrieves an address from the database with a given ID", description = "Retrieves an existing address from the database with the given address ID. Returns a 200 status code with the address object if the ID is found in the database, or a 404 status code if the ID is not found. Access to this endpoint requires the 'READ' authority.")
    public ResponseEntity<Address> getAddressById(@PathVariable("addressID") Integer addressId) throws AddressNotFoundException {
        log.info("Endpoint to retrieve the address with the ID {} was called up", addressId);
        return ResponseEntity.ok().body(service.getAddressById(addressId));
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('CREATE')")
    @Operation(summary = "Adds a new address to the database", description = "Adds a new address to the database. Access to this endpoint requires the 'CREATE' authority.")
    public void postAddress(@Valid @RequestBody Address address) {
        log.info("Endpoint for adding a new address was called. Address: {}", address);
        service.addAddress(address);
    }

    @DeleteMapping("/{addressId}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes an address from the database with a given ID", description = "Deletes an existing address from the database with the given address ID. Returns a 204 status code if the address was successfully deleted, or a 404 status code if the ID is not found in the database. Access to this endpoint requires the 'ADMIN' role.")
    public ResponseEntity<Object> deleteAddress(@PathVariable("addressId") Integer addressId) throws AddressNotFoundException {
        log.info("Endpoint for deleting Address with ID {} was called.", addressId);
        service.deleteAddressById(addressId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{addressId}")
    @PreAuthorize("hasAuthority('UPDATE')")
    @Operation(summary = "Updates an address in the database with a given ID", description = "Updates an existing address in the database with the given address ID. Returns a 401 error code if the ID is not found in the database. Access to this endpoint requires the 'ADMIN' role.")
    public void updateAddress(@Valid @PathVariable("addressId") int addressId, @RequestBody Address address) throws AddressNotFoundException {
        log.info("Endpoint for updating address with ID {} was called.", addressId);
        service.updateAddress(addressId, address);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<String> handleAddressNotFoundException(AddressNotFoundException e) {
        log.info(e.getMessage());
        return ResponseEntity.status(404).body(e.getMessage());
    }

}
