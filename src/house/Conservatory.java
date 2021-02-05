package house;

import animal.Animal;
import animal.Reptile;
import animal.Amphibian;
import habitat.Habitat;
import habitat.HabitatClass;
import java.util.HashMap;
import java.util.List;

/**
 * Specifies operation for the conservatory class.
 * @author quaydragon
 *
 */
public interface Conservatory {
  
  /**
   * Adds animal to a conservatory.
   * 
   * @param animal to be added to the conservatory
   */
  public void addAnimal(Animal animal);
  
  /**
   * Checks for a habitat for a species.
   * 
   * @return false if the species does not have a habitat.
   */
  public boolean checkForHabitat();
  
  
  /**
   * Prints the natural features for the habitats.
   */
  public void printNaturalFeatures();
  
  /**
   * Prints the habitat signs.
   */
  public void printHabitatSigns();
  
  /**
   * Finds a habitat for the species. 
   * 
   * @param species the species searching for a habitat
   * @return a list of habitats that already have that species
   */
  public List<Habitat> findHabitatForSpecies(String species);
  
  /**
   * Prints a map of the conservatory.
   */
  public void printMap();

  /**
   * Prints all of the species in the conservatory.
   */
  public void printSpecies();
 

}
