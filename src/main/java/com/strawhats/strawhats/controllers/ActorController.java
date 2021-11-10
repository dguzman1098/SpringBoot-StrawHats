package com.strawhats.strawhats.controllers;

import com.strawhats.strawhats.domain.Actor;
import com.strawhats.strawhats.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    //create an endpoint

    //dependency injection
    @Autowired
    ActorService actorService;

    @GetMapping("/cast")
    public List<Actor> getCast(){
        return actorService.getVoiceCastList();
    }


    @PostMapping("/cast")
    public void addCast(@RequestBody Actor actor){
        actorService.addVoiceCastMember(actor);
    }

    //Edit
    @PutMapping("cast/{id}")
    public void updateActor(@RequestBody Actor actor, @PathVariable Long id){
        actorService.editActor(actor,id);
    }

    @DeleteMapping("cast/{id}")
    public void deleteActor(@RequestBody Actor actor, @PathVariable Long id){
        actorService.deleteVoiceCastMember(actor, id);

    }

    @GetMapping("cast/{id}")
    public Actor getActor(@PathVariable Long id){
        return actorService.getActor(id);
    }



}
