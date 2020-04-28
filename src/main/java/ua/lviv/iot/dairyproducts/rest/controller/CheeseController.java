package ua.lviv.iot.dairyproducts.rest.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.dairyproducts.business.CheeseService;
import ua.lviv.iot.dairyproducts.model.Cheese;

@RequestMapping("/cheeses")
@RestController
public class CheeseController {

  private AtomicInteger idCounter = new AtomicInteger();

  @Autowired
  private CheeseService cheeseService;

  @GetMapping
  public List<Cheese> getCheeses() {
    return cheeseService.findAllCheeses();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Cheese> getCheese(final @PathVariable("id") Integer cheeseId) {
    Cheese thisCheese;
    thisCheese = cheeseService.findCheese(cheeseId);
    if (thisCheese != null) {
      return new ResponseEntity<Cheese>(thisCheese, HttpStatus.OK);
    }
    return new ResponseEntity<Cheese>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public Cheese createCheese(final @RequestBody Cheese cheese) {
    cheeseService.createCheese(cheese);
    cheese.setId(idCounter.incrementAndGet());
    return cheese;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Cheese> deleteCheese(@PathVariable("id") Integer cheeseId) {
    Cheese thisCheese;
    thisCheese = cheeseService.findCheese(cheeseId);
    if (thisCheese != null) {
      cheeseService.deleteCheese(cheeseId);
      return new ResponseEntity<Cheese>(HttpStatus.OK);
    }
    return new ResponseEntity<Cheese>(HttpStatus.NOT_FOUND);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Cheese> updateCheese(final @PathVariable("id") Integer cheeseId,
      final @RequestBody Cheese newCheese) {
    Cheese oldcheese = cheeseService.findCheese(cheeseId);
    if (oldcheese != null) {
      cheeseService.updateCheese(cheeseId, newCheese);
      return new ResponseEntity<Cheese>(oldcheese, HttpStatus.OK);
    }
    return new ResponseEntity<Cheese>(HttpStatus.NOT_FOUND);
  }

}
