package org.example.steps;

import org.example.entities.Pet;
import org.example.service.PetService;

import static org.example.service.uritemplate.PetServiceUri.PETS;
import static org.example.service.uritemplate.PetServiceUri.PET_BY_ID;

public class PetServiceSteps {
    private static final PetService PET_SERVICE = PetService.getInstance();

    public static Pet getPetById(int id) {
        return PET_SERVICE.getRequest(PET_BY_ID, id).as(Pet.class);
    }

    public static Pet createPet(Pet user) {
        return PET_SERVICE.postRequest(PETS, user).as(Pet.class);
    }

    public static Pet updatePet(Pet pet) {
        return PET_SERVICE.putRequest(PETS, pet).as(Pet.class);
    }
}
