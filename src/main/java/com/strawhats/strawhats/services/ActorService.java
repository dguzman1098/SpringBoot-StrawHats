package com.strawhats.strawhats.services;

import com.strawhats.strawhats.domain.Actor;
import com.strawhats.strawhats.repositories.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo; //an instance of our database to manipulate/modify data

    //Get all Actors
    public List<Actor> getVoiceCastList(){
        return actorRepo.findAll();
    }

    //add (POST) a voice cast member
    public void addVoiceCastMember(Actor actor){
        actorRepo.save(actor);

    }

    //edit (PUT) a voice cast member
    public void editActor(Actor actor, Long id){
        for (int i = 0; i < actorRepo.count(); i++) {
            Actor temp = actorRepo.findAll().get(i);
            if(temp.getId().equals(id)){
                actorRepo.save(actor);
            }
        }
    }

    //delete an actor
    public void deleteVoiceCastMember(Actor actor, Long id){
        for (int i = 0; i < actorRepo.count(); i++) {
            Actor temp = actorRepo.findAll().get(i);
            if(temp.getId().equals(id) && temp.getActorName().equals(actor.getActorName())){
                actorRepo.delete(actor);
            }
        }
    }

    //get one actor
    public Actor getActor(Long id){
        for (Actor actor : actorRepo.findAll()){
            if(actor.getId().equals(id)){
                return actor;
            }
        }
        return null;
    }










}
