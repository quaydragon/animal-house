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




public class ReptileHouseClass implements ReptileHouse {
  //TODO: There needs to be a method that creates a habitat
  //but wont create more than the below
  private int habitatLimit;
  private List<Animal> animalList = new ArrayList<Animal>();
  private List<Habitat> habitatList = new ArrayList<Habitat>();
  private HashMap<Animal, Habitat> animalsInHabitats = new HashMap<Animal, Habitat>();
  private HashMap<Habitat, Animal> habitatsHoldingAnimals = new HashMap<Habitat, Animal>();
  private List<String> speciesList = new ArrayList<String>();


  
  
  public ReptileHouseClass(int habitatLimit) {
    this.habitatLimit = habitatLimit;
  }

  
  //TODO: Write Animal Handling
  
  
  @Override
  public void addAnimal(Animal animal) {
    //adds animal to list
    animalList.add(animal);
    //finds a habitat for the animal
    this.habitatPlacement(animal);
    
  }
  
  /**
   * Creates a new habitat for animal.
   *  
   * @param animal
   * @throws IllegalArgumentException
   */
  private void createNewHabitat(Animal animal) throws IllegalArgumentException {

    
     



    
    String[] habitatNameArr = animal.getClass().getName().split("\\.", 2);
    
    String habitatName = habitatNameArr[1] + "Habitat";
    

    Habitat createdHome = animal.makePerfectHabitat(20, habitatName);
    
   

    
    int size = this.habitatList.size();
    

    
    if (size < this.habitatLimit) {

      this.habitatList.add(createdHome);

      this.animalsInHabitats.put(animal, createdHome);
      this.habitatsHoldingAnimals.put(createdHome, animal);

      
    } else {
      throw new IllegalStateException("We have no room for this animal!");
    }
    
  }
  
  private void habitatPlacement(Animal animal) {

    int size = this.habitatList.size();

    if (size > 0) {
      
      Habitat habitatFit = this.findHabitat(animal);
     
      if (habitatFit == null) {

        this.createNewHabitat(animal);
      } else {

        this.animalsInHabitats.put(animal, habitatFit);
        this.habitatsHoldingAnimals.put(habitatFit, animal);

      }
      
     
      
    } else {
    
    
      this.createNewHabitat(animal);
    

    
    }
  
  }
  
  
  private Habitat findHabitat(Animal animal) {
    //Go through current habitat list and see if features match
    

    
    
    for (Habitat home : this.habitatList) {
      //Making sure the species can be mixed
      String classAnimal = this.habitatsHoldingAnimals.get(home).getClass().getName();
      int sizeMeters = animal.getSizeMeters();
      
      if (animal.getClass().getName() == classAnimal) {
        // TODO: Need to check if animals line up   
        int goodHabitat = animal.habitAnimalFit(home.habitatInfo());
          

          
        if (goodHabitat == 0) {
          //reduction of size from the animal
          
          home.subtractSizeForAnimal(sizeMeters);
          return home;
        } else if (goodHabitat == 1) {
          //adds natural feature to habitat
          home.addNaturalFeature(animal.getNaturalFeature());
          //Reduces the size
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
    
    //this.animalsInHabitats;
    

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
    
    //A list of all the different habitat
  //Get habitat requirements
    
    //get rid of duplicate habitats
    Set<Habitat> habList = new LinkedHashSet<>(this.habitatList);
    

    
    for (Habitat habitat: habList) {
      HashMap<String, Object> habInfo = habitat.habitatInfo();
      
      String location = (String) habInfo.get("Location");
      
      System.out.println("\n");
      System.out.println("HABITAT SIGN");
      System.out.println("Location: " + location);
      
      HashMap<Animal, Habitat> map = this.animalsInHabitats;
      
      for (HashMap.Entry<Animal, Habitat> entry : map.entrySet()) {
        Animal key = entry.getKey();
        Habitat value = entry.getValue();
        
        if (value == habitat) {
          //This is if the animal and you should get the animals information
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

    
    for (Animal ani : this.animalList) {
      List<Animal> keys = new ArrayList<Animal>(this.animalsInHabitats.keySet());
      
      if (keys.contains(ani)) {
        return true;
      } else {
        System.out.println("The below animal is missing a habitat:");
        System.out.println(ani);
        return false;
      }
      
    }
    
    return false;
  }
  
  
  @Override
  public void printNaturalFeatures() {
    Set<Habitat> habList = new LinkedHashSet<>(this.habitatList);
    
    for (Habitat hab : habList) {
      HashMap<String, Object> info = hab.habitatInfo();
      
      System.out.println("\n");
      System.out.println("NATURAL FEATURES OF HABITAT");
      System.out.println("\n");
      System.out.println("Natural Features: " + info.get("NaturalFeature"));
      System.out.println("Remaining Space: " + info.get("HabitatSize"));
    }
    
  }
  
  public List<Habitat> findHabitatForSpecies(String species) {
    
    HashMap<Animal, Habitat> map = this.animalsInHabitats;
    
    List<Habitat> speciesInHabitat = new ArrayList<Habitat>();
    for (HashMap.Entry<Animal, Habitat> entry : map.entrySet()) {
      Animal key = entry.getKey();
      Habitat value = entry.getValue();
      
      if (key.animalInfo().get("Species") == species) {
        speciesInHabitat.add(value);
        
      }
      
    }
    
    if (speciesInHabitat.size() > 0) {
      return speciesInHabitat;
    }
    return null;
  }
  

  @Override
  public HashMap<HabitatClass, Animal> addReptileToHabitat() {
    // TODO Auto-generated method stub
    return null;
  }
  
  
  
  
  
  
  
  
  //TODO: Determine Usage of below functions
  


  @Override
  public Animal[] removeAnimalList() {
    // TODO Auto-generated method stub
    return null;
  }

  
  
  @Override
  public HabitatClass[] addHabitatList() {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public HabitatClass[] removeFromHabitatList() {
    // TODO Auto-generated method stub
    return null;
  }













  @Override
  public HashMap<HabitatClass, Animal> findHabitat() {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public void printMap() {
    // TODO Auto-generated method stub
    
  }




  
  
  

}
