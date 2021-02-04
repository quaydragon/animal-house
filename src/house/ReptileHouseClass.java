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
  private HashMap<HabitatClass, Animal> animalsInHabitats;
  
  
  public ReptileHouseClass(int habitatLimit) {
    this.habitatLimit = habitatLimit;
  }

  
  //TODO: Write Animal Handling
  
  
  @Override
  public void addAnimal(Animal animal) {
    //adds animal to list
    animalList.add(animal);
    //finds a habitat for the animal
    this.findHabitat(animal);
    
  }
  
  
  private void findHabitat(Animal animal) {
    //Go through current habitat list and see if features match
    
    System.out.println("Find a habitat for our lil guy");
    
    int size = habitatList.size();
    
    if (size > 0) {
    
      for (Habitat home : habitatList) {
        HashMap<String, Object> habInfo = home.habitatInfo();
        
        Object naturalFeatures = habInfo.get("NaturalFeature");
        
        System.out.println("Printing Potential Home");
        System.out.println(habInfo);
        
        //TODO: Finish this when we have some habitats made
        
        int temperature = (Integer) habInfo.get("Temperature");
        
        if (temperature > 0) {
          System.out.println("Looks like we can access");
        }
        
        //TODO: GIve this to animal class to see if these is a perfect fit
        
      }
    
    } else {
      System.out.println("Time to make a new habitat");
      
      //TODO: Make this function dynamic
      
      System.out.println(animal.getClass().getName());
      
      String[] habitatNameArr = animal.getClass().getName().split("\\.", 2);
      
      String habitatName = habitatNameArr[1] + "Habitat";
      

      Habitat createdHome = animal.makePerfectHabitat(100, habitatName);
      
      System.out.println(createdHome);
      System.out.println("Now Adding to Habitat List");
      
      if (size < this.habitatLimit) {
        habitatList.add(createdHome);
      } else {
        //TODO: Add invalid argument exception
        
        System.out.println("Sorry little buddy we must turn you away");
        
      }
    }
    
    
    //if none match animal class should produce perfect habitat
    //If not at limit of habitats created
    
    
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
