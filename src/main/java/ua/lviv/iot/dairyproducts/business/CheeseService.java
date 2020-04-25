package ua.lviv.iot.dairyproducts.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dairyproducts.dataaccess.CheeseRepository;
import ua.lviv.iot.dairyproducts.model.Cheese;

@Service
public class CheeseService {

  @Autowired
  private CheeseRepository cheeseRepository;

  public Cheese createCheese(Cheese cheese) {
    return cheeseRepository.save(cheese);
  }

  public List<Cheese> findAllCheeses() {
    return cheeseRepository.findAll();
  }

  public Cheese findCheese(Integer cheeseId) {
    return cheeseRepository.findById(cheeseId).orElse(null);
  }

  public void deleteCheese(Integer cheeseId) {
    cheeseRepository.deleteById(cheeseId);
  }

  public void updateCheese(Integer cheeseId, Cheese newCheese) {
    newCheese.setId(cheeseId);
    cheeseRepository.save(newCheese);
  }
  
  

}
