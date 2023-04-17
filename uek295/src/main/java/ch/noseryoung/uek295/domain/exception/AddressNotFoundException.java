package ch.noseryoung.uek295.domain.exception;

public class AddressNotFoundException extends Exception{
    public AddressNotFoundException(String message){
        super(message);
    }
    public AddressNotFoundException(){super();}
}
