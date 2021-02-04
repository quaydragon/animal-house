package house;

import animal.Animal;
import animal.Reptile;
import habitat.HabitatClass;
import java.util.HashMap;
import animal.Amphibian;

public interface ReptileHouse {
  
  //TODO: Evaluate if we even need these
  
  public HabitatClass[] addHabitatList();
  
  public HabitatClass[] removeFromHabitatList();
  
  public Animal[] addAnimalList();
  
  public Animal[] removeAnimalList();
  
  public HashMap<HabitatClass, Animal> addReptileToHabitat();
  
  public boolean checkForHabitat();
  
  public void printNaturalFeatures();
  
  public void printHabitatSign();
  
  public HashMap<HabitatClass, Animal> findHabitat();
  
  public void printMap();
  
  public void printSpecies();
 

}
