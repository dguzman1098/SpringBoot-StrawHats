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
    List<Actor> actorList = new ArrayList<>();


    //Business Logic
//    List<Actor> voiceCastList = new ArrayList<>(
//            Arrays.asList(
//                    new Actor(1L, "Monkey D. Luffy", "Mayumi Tanaka"),
//                    new Actor(2L, "Roronoa Zoro", "Kazuya Nakai"),
//                    new Actor(3L, "Nami", "Akemi Okamura")
//            )
//    );

    //Get all Actors
    public List<Actor> getVoiceCastList(){
        actorRepo.findAll().forEach(actorList:: add);
        return actorList;
    }

    //add a voice cast member
    public void addVoiceCastMember(Actor actor){
        actorRepo.save(actor);

    }

    //edit a voice cast member
    public void editActor(Actor actor, Long id){
        for (int i = 0; i < actorList.size(); i++) {
            Actor temp = actorRepo.findAll().get(i);
            if(temp.getId().equals(id)){
                actorList.set(i ,actor);
                actorRepo.save(actor);
            }
        }
    }

    //delete an actor
    public void deleteVoiceCastMember(Actor actor, Long id){
        for (int i = 0; i < actorRepo.count(); i++) {
            Actor temp = actorRepo.findAll().get(i);
            if(temp.getId().equals(id)){
                actorRepo.delete(actor);
                actorList.remove(i);


            }
        }
    }

    //get one actor
    public Actor getActor(Long id){
        for (Actor actor : actorList){
            if(actor.getId().equals(id)){
                return actor;
            }
        }
        return null;
    }










}
