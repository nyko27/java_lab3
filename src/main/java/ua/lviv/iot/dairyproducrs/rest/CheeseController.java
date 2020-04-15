package ua.lviv.iot.dairyproducrs.rest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
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
import ua.lviv.iot.dairyproducts.model.Cheese;

@RequestMapping("/cheeses")
@RestController
public class CheeseController {

  private Map<Integer, Cheese> cheeses = new HashMap<>();
  private AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<Cheese> getCheeses() {
    return new LinkedList<Cheese>(cheeses.values());
  }

  @GetMapping(path = "/{id}")
  public Cheese getCheese(final @PathVariable("id") Integer cheeseId) {
    return cheeses.get(cheeseId);
  }

  @PostMapping
  public Cheese createCheese(final @RequestBody Cheese cheese) {
    cheese.setId(idCounter.incrementAndGet());
    cheeses.put(cheese.getId(), cheese);
    return cheese;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Cheese> deleteCheese(@PathVariable("id") Integer cheeseId) {
    HttpStatus status = cheeses.remove(cheeseId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Cheese> updateCheese(final @PathVariable("id") Integer cheeseId,
      final @RequestBody Cheese cheese) {
    cheese.setId(cheeseId);

    Cheese oldCheese = cheeses.replace(cheeseId, cheese);
    ResponseEntity<Cheese> state = oldCheese == null ? new ResponseEntity<Cheese>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Cheese>(oldCheese, HttpStatus.OK);
    return state;
  }

}
