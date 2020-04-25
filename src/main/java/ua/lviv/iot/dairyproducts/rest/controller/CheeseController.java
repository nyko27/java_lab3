package ua.lviv.iot.dairyproducts.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

  private Map<Integer, Cheese> cheeses = new HashMap<>();
  private AtomicInteger idCounter = new AtomicInteger();

  @Autowired
  private CheeseService cheeseService;

  @GetMapping
  public List<Cheese> getCheeses() {
    cheeseService.findAllCheeses();
    return new LinkedList<Cheese>(cheeses.values());
  }

  @GetMapping(path = "/{id}")
  public Cheese getCheese(final @PathVariable("id") Integer cheeseId) {
    cheeseService.findCheese(cheeseId);
    return cheeses.get(cheeseId);
  }

  @PostMapping
  public Cheese createCheese(final @RequestBody Cheese cheese) {
    cheeseService.createCheese(cheese);
    cheese.setId(idCounter.incrementAndGet());
    cheeses.put(cheese.getId(), cheese);
    return cheese;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Cheese> deleteCheese(@PathVariable("id") Integer cheeseId) {
    HttpStatus status = cheeses.remove(cheeseId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    if (getCheese(cheeseId) != null) {
      cheeseService.deleteCheese(cheeseId);
      return new ResponseEntity<Cheese>(status);
    }
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Cheese> updateCheese(final @PathVariable("id") Integer cheeseId,
      final @RequestBody Cheese newCheese) {
    Cheese oldcheese = cheeses.get(cheeseId);

    if (oldcheese != null) {
      cheeseService.updateCheese(cheeseId, newCheese);
      cheeses.put(cheeseId, newCheese);
      return new ResponseEntity<Cheese>(oldcheese, HttpStatus.OK);
    }
    return new ResponseEntity<Cheese>(HttpStatus.NOT_FOUND);
  }

}
