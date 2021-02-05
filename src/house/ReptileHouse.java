package house;

import animal.Animal;
import animal.Reptile;
import animal.Amphibian;
import habitat.HabitatClass;
import java.util.HashMap;


public interface ReptileHouse {
  
  //TODO: Evaluate if we even need these
  
  public HabitatClass[] addHabitatList();
  
  public HabitatClass[] removeFromHabitatList();
  
  public void addAnimal(Animal animal);
  
  public Animal[] removeAnimalList();
  
  public HashMap<HabitatClass, Animal> addReptileToHabitat();
  
  public boolean checkForHabitat();
  
  public void printNaturalFeatures();
  
  public void printHabitatSigns();
  
  public HashMap<HabitatClass, Animal> findHabitat();
  
  public void printMap();
  
  public void printSpecies();
 

}
