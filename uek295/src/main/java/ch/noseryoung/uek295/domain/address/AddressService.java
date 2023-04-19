package ch.noseryoung.uek295.domain.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address addAddress(Address address){
        return  repository.save(address);
    }
    public Address getAddressById(int index) {
        return repository.findById(index).orElseThrow();
    }
    public List<Address> getAddress() {
        return repository.findAll();
    }
    public void updateAddress(int index, Address address){
        repository.save(address);
    }
    public void deleteAddressById(int index) {
        repository.deleteById(index);
    }


}

