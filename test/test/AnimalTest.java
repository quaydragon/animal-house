package test;

import static org.junit.Assert.assertEquals;

import animal.Amphibian;
import animal.Animal;
import animal.Endangerment;
import animal.NaturalFeature;
import animal.Reptile;
import animal.Size;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;


public class AnimalTest {
  public Animal lilyLizard;
  public Animal alligator;
  public Animal komodo;
  public Animal frog;

  /**
   * Sets up the different types of animals to be tested.
   * 
   * @throws Exception if animal not set up correctly
   */
  @Before
  public void setUp() throws Exception {
    lilyLizard = new Reptile(Size.SMALL,
        40,
        80,
        NaturalFeature.FALLENLOG,
        false,
        Endangerment.FINE,
        true,
        "lily lizard",
        "Cynthia");
    
    komodo = new Reptile(Size.MEDIUM,
        40,
        80,
        NaturalFeature.LILYPOOL,
        false,
        Endangerment.EXTINCT,
        true,
        "komo komodo",
        "rupert");
    
    frog = new Amphibian(Size.MEDIUM,
        85,
        90,
        NaturalFeature.POND,
        false,
        Endangerment.FINE,
        true,
        "frogy wog",
        "shelia");
    
    alligator = new Reptile(Size.LARGE,
        75,
        90,
        NaturalFeature.SANDYBEACH,
        true,
        Endangerment.ENDANGERED,
        false,
        "Aligator",
        "Ally");
  
  }
  
  // Some things will be tested through the reptile house class
  

  @Test
  public void test() {
    assertEquals("habitat.HabitatClass", lilyLizard.makePerfectHabitat(20, 
        "Reptile Habitat").getClass().getName());
  }
  
  @Test
  public void getSizeMetersSmall() {
    assertEquals(1, lilyLizard.getSizeMeters());
  }
  
  @Test
  public void getSizeMetersMedium() {
    assertEquals(5, frog.getSizeMeters());
  }
  
  
  @Test
  public void getSizeMetersLarge() {
    assertEquals(10, alligator.getSizeMeters());
  }
  
  
  @Test
  public void testAnimalInfo() {
    HashMap<String, Object> animalInfo = new HashMap<String, Object>();
    
    animalInfo.put("Species", "Aligator");
    animalInfo.put("Name", "Ally");
    animalInfo.put("Poisonous", true);
    animalInfo.put("Endangered", Endangerment.ENDANGERED);
    
    
    assertEquals(animalInfo, alligator.animalInfo());
  }
  
  @Test
  public void testNaturalFeature() {
    assertEquals(NaturalFeature.SANDYBEACH, alligator.getNaturalFeature());
  }

  @Test(expected = IllegalStateException.class)
  public void testExtinct() {
    komodo.makePerfectHabitat(20, "Reptile House");
  }

  
}
