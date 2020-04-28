
package ua.lviv.iot.dairyproducts.dataaccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.dairyproducts.model.Cheese;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese, Integer> {

}
