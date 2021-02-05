package house;


import animal.AbstractAnimal;
import animal.Animal;
import animal.NaturalFeature;
import habitat.Habitat;
import habitat.HabitatClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



/**
 * Specifies the ReptileHouseClass.
 * @author quaydragon
 *
 */
public class ReptileHouseClass implements Conservatory {
  private int habitatLimit;
  private List<Animal> animalList = new ArrayList<Animal>();
  private List<Habitat> habitatList = new ArrayList<Habitat>();
  private HashMap<Animal, Habitat> animalsInHabitats = new HashMap<Animal, Habitat>();
  private HashMap<Habitat, Animal> habitatsHoldingAnimals = new HashMap<Habitat, Animal>();
  private List<String> speciesList = new ArrayList<String>();
  
  public ReptileHouseClass(int habitatLimit) {
    this.habitatLimit = habitatLimit;
  }


  @Override
  public void addAnimal(Animal animal) {
    //adds animal to list
    animalList.add(animal);
    //finds a habitat for the animal
    this.habitatPlacement(animal);
    
  }
  
  private void createNewHabitat(Animal animal) throws IllegalArgumentException {
    
    // Create habitat name
    String[] habitatNameArr = animal.getClass().getName().split("\\.", 2);
    String habitatName = habitatNameArr[1] + " Habitat";
    
    // use animal class to create their perfect home
    Habitat createdHome = animal.makePerfectHabitat(20, habitatName);
    
    // Only add the habitat and animal to the conservatory if we have room
    int size = this.habitatList.size();  
    if (size < this.habitatLimit) {
      this.habitatList.add(createdHome);
      this.animalsInHabitats.put(animal, createdHome);
      this.habitatsHoldingAnimals.put(createdHome, animal);
    } else {
      // throw error if there is no room
      throw new IllegalStateException("We have no room for this animal!");
    }
    
  }

  private void habitatPlacement(Animal animal) {
    
    // only check for habitats if one already exists
    int size = this.habitatList.size();
    if (size > 0) {
      //Use habitat placement function
      Habitat habitatFit = this.findHabitat(animal);
      
      //returns null if no existing habitat can hold animal
      if (habitatFit == null) {
        this.createNewHabitat(animal);
      } else {
        // Save to hash map if habitat fits
        this.animalsInHabitats.put(animal, habitatFit);
        this.habitatsHoldingAnimals.put(habitatFit, animal);
      }
    } else {
      // create new habitat if no habitats exist
      this.createNewHabitat(animal);
    }
  }
  
  private Habitat findHabitat(Animal animal) {
    //Check if animal can live in current habitats
    for (Habitat home : this.habitatList) { 
      String classAnimal = this.habitatsHoldingAnimals.get(home).getClass().getName();
      int sizeMeters = animal.getSizeMeters();
      //Making sure the species can be mixed
      if (animal.getClass().getName() == classAnimal) {
        // TODO: Need to check if animals line up   
        int goodHabitat = animal.habitAnimalFit(home.habitatInfo());
        
        // 0 is the easiest habitat situation to handle
        if (goodHabitat == 0) {
          //reduction of size from the animal
          home.subtractSizeForAnimal(sizeMeters);
          return home;
        } else if (goodHabitat == 1) {
          //adds natural feature to habitat
          home.addNaturalFeature(animal.getNaturalFeature());
          //Reduces the size of habitat
          home.subtractSizeForAnimal(sizeMeters);
          return home;
        } else if (goodHabitat == 2) {
          return null;
        }
        
      }
      
    }
    return null;
    
  }
  
  private void addSpeciesList() {
    
    List<Animal> values = new ArrayList<Animal>(this.animalsInHabitats.keySet());
    for (Animal species: values) {
      HashMap<String, Object> info = species.animalInfo();
      
      String speciesName = (String) info.get("Species");
      
      System.out.println(speciesName);
      this.speciesList.add(speciesName);
      
    }
    
  }

  @Override
  public void printSpecies() {
    this.addSpeciesList();
    Collections.sort(this.speciesList);
    System.out.println("Current Species being held:");
    System.out.println(this.speciesList);
  }
  
  @Override
  public void printHabitatSigns() {
    
    // Get rid of duplicates and iterate through different habitats. 
    
    Set<Habitat> habList = new LinkedHashSet<>(this.habitatList);
    
    for (Habitat habitat: habList) {
      
      // Make hash map to iterate
      HashMap<String, Object> habInfo = habitat.habitatInfo();
      
      String location = (String) habInfo.get("Location");
      
      // Print the beginning of the habitat sign
      System.out.println("\n");
      System.out.println("HABITAT SIGN");
      System.out.println("Location: " + location);
      
      // Iterating over the hash map of animals to habitats
      HashMap<Animal, Habitat> map = this.animalsInHabitats;
      
      for (HashMap.Entry<Animal, Habitat> entry : map.entrySet()) {
        Animal key = entry.getKey();
        Habitat value = entry.getValue();
        
        if (value == habitat) {
          // Prints the animal's information
          HashMap<String, Object> animalInfo = key.animalInfo();
          System.out.println("\n");
          System.out.println("SPECIES INFORMATION FOR HABITAT");
          System.out.println("Species: " + animalInfo.get("Species"));
          System.out.println("Name: " + animalInfo.get("Name"));
          System.out.println("Poisonous: " + animalInfo.get("Poisonous"));
          System.out.println("Endangered Category: " + animalInfo.get("Species"));        
        } 
      }
      System.out.println("\n\n"); 
    }
  }
  
  @Override
  public boolean checkForHabitat() {

    // Iterate through animal list 
    for (Animal ani : this.animalList) {
      // get the animals who are paired with habitats
      List<Animal> keys = new ArrayList<Animal>(this.animalsInHabitats.keySet());
      
      // if keys contain animal return true
      if (keys.contains(ani)) {
        return true;
      } else {
        // Notify the user if animal is found without a habitat
        System.out.println("The below animal is missing a habitat:");
        System.out.println(ani);
        return false;
      }
      
    }
    
    return false;
  }
  
  @Override
  public void printNaturalFeatures() {
    
    //Get un-duplicated list of habitats
    Set<Habitat> habList = new LinkedHashSet<>(this.habitatList);
    
    // Get information on each of the habitats, including natural features.
    for (Habitat hab : habList) {
      HashMap<String, Object> info = hab.habitatInfo();
      
      System.out.println("\n");
      System.out.println("NATURAL FEATURES OF HABITAT");
      System.out.println("\n");
      System.out.println("Natural Features: " + info.get("NaturalFeature"));
      System.out.println("Remaining Space: " + info.get("HabitatSize"));
    }
    
  }
  
  @Override
  public List<Habitat> findHabitatForSpecies(String species) {
    
    // Get hash map to make iterable
    HashMap<Animal, Habitat> map = this.animalsInHabitats;
    
    // Create list to store all of the habitats the species lives in
    List<Habitat> speciesInHabitat = new ArrayList<Habitat>();
    for (HashMap.Entry<Animal, Habitat> entry : map.entrySet()) {
      Animal key = entry.getKey();
      Habitat value = entry.getValue();
      
      // Find if species is in habitat
      if (key.animalInfo().get("Species") == species) {
        // Add habitat to list
        speciesInHabitat.add(value);      
      }
    }
    
    // Only return habitat lists that are not empty
    if (speciesInHabitat.size() > 0) {
      return speciesInHabitat;
    }
    return null;
  }
  
  @Override
  public void printMap() {
    
    System.out.println("Printing Conservatory Map");
  
    // Create hashmap to iterate through key value pair
    HashMap<Animal, Habitat> map = this.animalsInHabitats;
    //Get rid of duplicates in habitat list
    Set<Habitat> habList = new LinkedHashSet<>(this.habitatList);
    
    //Iterate through habitat List
    for (Habitat hab : habList) {
      System.out.println("\n");
      System.out.println("Location: " + hab.habitatInfo().get("Location"));
      System.out.print("Natural Features: ");
      System.out.println(hab.habitatInfo().get("NaturalFeature"));
      System.out.println("Species of Animal: ");
      
      //Iterate through animal to habitat hash map
      for (HashMap.Entry<Animal, Habitat> entry : map.entrySet()) {
        Animal key = entry.getKey();
        Habitat value = entry.getValue();
        if (hab == value) {   
          System.out.print(key.animalInfo().get("Species"));
          System.out.print("\n");
          
        }
      
      }   
    } 
  }  

}
