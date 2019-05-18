package com.packt.cardatabase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest//Test only foncussed on jpa components
public class CarRepositoryTest {
		@Autowired
		private TestEntityManager entityManager;
		
		@Autowired
		private CarRepository crepository;
		
		@Test
		public void saveCar() {
			Owner owner1 = new Owner("Martin", "Scott");
			entityManager.persistAndFlush(owner1);
			Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, owner1);
			entityManager.persistAndFlush(car);
			assertThat(car.getId()).isNotNull();			
		}
		
		@Test
		public void deleteCar() {
			Owner owner1 = new Owner("Bobby", "Valantino");
			entityManager.persistAndFlush(owner1);
			entityManager.persistAndFlush(new Car("Tesla", "Model X", "White", "ABC-1234", 2014, 82000, owner1));
			crepository.deleteAll();
			assertThat(crepository.findAll()).isNotNull();
		}
}
