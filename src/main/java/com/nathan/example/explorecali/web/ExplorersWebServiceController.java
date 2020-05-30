package com.nathan.example.explorecali.web;

import com.nathan.example.explorecali.busniess.service.ExplorerNotFoundException;
import com.nathan.example.explorecali.data.entity.Explorer;
import com.nathan.example.explorecali.data.repo.ExplorerRepository;
import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
public class ExplorersWebServiceController {
    private final ExplorerRepository explorerRepository;

    @Autowired
    public ExplorersWebServiceController(ExplorerRepository explorerRepository) {
        super();
        this.explorerRepository = explorerRepository;
    }

    @GetMapping("/explorers")
    CollectionModel<EntityModel<Explorer>> all() {
        List<EntityModel<Explorer>> explorers = this.explorerRepository.findAll().stream()
                .map(explorer -> new EntityModel<>(explorer, linkTo(methodOn(ExplorersWebServiceController.class).one(explorer.getId())).withSelfRel(),
                        linkTo(methodOn(ExplorersWebServiceController.class).all()).withRel("explorers")))
                .collect(Collectors.toList());
        return new CollectionModel<>(explorers, linkTo(methodOn(ExplorersWebServiceController.class).all()).withSelfRel());
    }

    @PostMapping("/explorers")
    Explorer newExplorer(@RequestBody Explorer explorer) {
        return this.explorerRepository.save(explorer);
    }

    // Single item
    @GetMapping("/explorers/{id}")
    EntityModel<Explorer> one(@PathVariable int id) {
        Explorer explorer = this.explorerRepository.findById(id)
                .orElseThrow(() -> new ExplorerNotFoundException(id));

        return new EntityModel<>(explorer,
                linkTo(methodOn(ExplorersWebServiceController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ExplorersWebServiceController.class).all()).withRel("explorers"));
    }

    @PutMapping("/explorers{id}")
    Explorer replaceExplorer(@RequestBody Explorer explorer, @PathVariable int id) {
        return this.explorerRepository.findById(id).map(explorer1 -> {
            explorer1.setPerson(explorer.getPerson());
            explorer1.setState(explorer.getState());
            explorer1.setUserName(explorer.getUserName());
            explorer1.setPassword(explorer.getPassword());
            explorer1.setTours(explorer.getTours());
            explorer1.setBio(explorer.getBio());
            return this.explorerRepository.save(explorer1);
        }).orElseGet(() -> {
            explorer.setId(id);
            return this.explorerRepository.save(explorer);
        });
    }

    @DeleteMapping("/explorers/{id}")
    void deleteExplorer(@PathVariable int id) {
        this.explorerRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
