package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	
@Autowired
private static PetStoreDao petStoreDao;

public static PetStoreData savePetStore(PetStoreData petStoreData) {
	Long petStoreId = petStoreData.getPetStoreId();
	PetStore petStore = findorCreatePetStore(petStoreId);
	copyPetStoreFields(petStore, petStoreData);
	
	return new PetStoreData(petStoreDao.save(petStore));
	
}

private static PetStore findorCreatePetStore(Long petStoreId) {
	
	if(Objects.isNull(petStoreId)) {
		return new PetStore();
	}else {
		return findPetStoreById(petStoreId);
	}

}

private static PetStore findPetStoreById(Long petStoreId) {
	return petStoreDao.findById(petStoreId).orElseThrow(() -> new NoSuchElementException("Pet Store with ID=" + petStoreId + "was not found."));
	
}

private static void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
	petStore.setPetStoreId(petStoreData.getPetStoreId());;
	petStore.setPetStoreName(petStoreData.getPetStoreName());
	petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
	petStore.setPetStoreCity(petStoreData.getPetStoreCity());
	petStore.setPetStoreState(petStoreData.getPetStoreState());
	petStore.setPetStoreZip(petStoreData.getPetStoreZip());
	petStore.setPetStorePhone(petStoreData.getPetStorePhone());
}

//@Autowired
//private EmployeeDao employeeDao;


	

}
