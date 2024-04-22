package pet.store.controller.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

public class PetStoreEmployee {
	
	@Entity
	@Data

	public class Employee {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private String employeePhone;
		private String employeeJobTitle;
		
		@EqualsAndHashCode.Exclude
		@ToString.Exclude
		@ManyToOne(cascade = CascadeType.ALL)
		private PetStore petStore;
		
		
	}

}
