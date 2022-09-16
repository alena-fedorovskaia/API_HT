package org.example;

import org.example.entities.Pet;
import org.example.steps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PetServiceTest {

    private int randomId = new Random().nextInt(1000000);
    private String petName = "Name" + randomId;

    @Test(priority = 1)
    public void createPetTest() {
        Pet expectedPet = createPet();
        Pet createdPet = PetServiceSteps.createPet(expectedPet);
        Assert.assertEquals(createdPet.getName(), expectedPet.getName(), "Expected pet doesn't have correct name");
    }

    @Test (priority = 2)
    public void getPetByIdTest() {
        Pet pet = PetServiceSteps.getPetById(randomId);
        Assert.assertEquals(pet.getName(),petName, "Expected pet doesn't have correct name");
    }

    @Test(priority = 3)
    public void updatePetTest() {
        Pet expectedPet = createPet();
        String newName = expectedPet.getName() + "Updated";
        expectedPet.setName(newName);

        PetServiceSteps.updatePet(expectedPet);

        Pet pet = PetServiceSteps.getPetById(randomId);
        Assert.assertEquals(pet.getName(), newName, "Expected pet doesn't have correct name");
    }

    private Pet createPet() {
        return new Pet()
                .setId(randomId)
                .setName(petName)
                .setPhotoUrls(new String[]{""});

    }
}
