package house;


import animal.AbstractAnimal;
import animal.Animal;
import animal.NaturalFeature;
import habitat.Habitat;
import habitat.HabitatClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class ReptileHouseClass implements ReptileHouse {
  //TODO: There needs to be a method that creates a habitat
  //but wont create more than the below
  private int habitatLimit;
  private List<Animal> animalList = new ArrayList<Animal>();
  private List<Habitat> habitatList = new ArrayList<Habitat>();
  private HashMap<Habitat, Animal> animalsInHabitats = new HashMap<Habitat, Animal>();


  
  
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

    
     
    System.out.println("Time to make a new habitat");
    

    System.out.println(animal.getClass().getName());
    
    String[] habitatNameArr = animal.getClass().getName().split("\\.", 2);
    
    String habitatName = habitatNameArr[1] + "Habitat";
    

    Habitat createdHome = animal.makePerfectHabitat(100, habitatName);
    
   
    System.out.println("Now Adding to Habitat List");
    
    int size = this.habitatList.size();
    
    System.out.println("Properly Found Size" + size);
    
    if (size < this.habitatLimit) {
      System.out.println("passed habitat limit test");
      this.habitatList.add(createdHome);
      System.out.println(createdHome);
      this.animalsInHabitats.put(createdHome, animal);
      System.out.println("Successfully created home");
      
    } else {
      throw new IllegalStateException("We have no room for this animal!");
    }
    
  }
  
  private void habitatPlacement(Animal animal) {
    System.out.println("Find a habitat for our lil guy");
    int size = this.habitatList.size();

    if (size > 0) {
      
      Habitat habitatFit = this.findHabitat(animal);
     
      if (habitatFit == null) {
        System.out.println("There were no habitat fits");
        this.createNewHabitat(animal);
      } else {
        System.out.println(habitatFit);
        this.animalsInHabitats.put(habitatFit, animal);
        
      }
      
     
      
    } else {
    
    
      this.createNewHabitat(animal);
    
      System.out.println("Out of the create habitat function");
    
    }
  
  }
  
  
  private Habitat findHabitat(Animal animal) {
    //Go through current habitat list and see if features match
    
    System.out.println("There are some availible habitats");
    
    for (Habitat home : this.habitatList) {
      //Making sure the species can be mixed
      String classAnimal = this.animalsInHabitats.get(home).getClass().getName();
      int sizeMeters = animal.getSizeMeters();
      
      if (animal.getClass().getName() == classAnimal) {
        // TODO: Need to check if animals line up   
        int goodHabitat = animal.habitAnimalFit(home.habitatInfo());
          
        System.out.println(goodHabitat);
          
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
  public HashMap<HabitatClass, Animal> addReptileToHabitat() {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public boolean checkForHabitat() {
    // TODO Auto-generated method stub
    return false;
  }


  @Override
  public void printNaturalFeatures() {
    // TODO Auto-generated method stub
    
  }


  @Override
  public void printHabitatSign() {
    // TODO Auto-generated method stub
    
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


  @Override
  public void printSpecies() {
    // TODO Auto-generated method stub
    
  }
  
  
  
  

}
