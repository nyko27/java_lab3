
package ua.lviv.iot.dairyproducts.dataaccess;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.iot.dairyproducts.model.Cheese;


public interface CheeseRepository extends JpaRepository<Cheese, Integer> {

}
