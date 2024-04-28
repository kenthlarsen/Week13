package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pet.store.entity.PetStore;

public class PetStoreCustomer {
	@Entity
	@Data
	public class Customer {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;

		@EqualsAndHashCode.Exclude
		@ToString.Exclude
		@ManyToMany(cascade = CascadeType.PERSIST)
		Set<PetStore> petStores = new HashSet<>();

	}

}

