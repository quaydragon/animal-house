package animal;

import java.util.HashMap;

import habitat.Habitat;
import habitat.HabitatClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AbstractAnimal implements Animal {
  protected Size size;
  protected int temperatureLow;
  protected int temperatureHigh;
  protected NaturalFeature naturalFeature;
  protected boolean poisonous;
  protected Endangerment endangerment;
  protected boolean canShareSpace;
  protected String species;
  protected int sizeMeters;
  
  public AbstractAnimal(Size size,
      int temperatureLow,
      int temperatureHigh,
      NaturalFeature naturalFeature,
      boolean poisonous,
      Endangerment endangerment, 
      boolean canShareSpace,
      String species) {
    this.size = size;
    this.temperatureLow = temperatureLow;
    this.temperatureHigh = temperatureHigh;
    this.naturalFeature = naturalFeature;
    this.poisonous = poisonous;
    this.endangerment = endangerment;
    this.canShareSpace = canShareSpace;
    this.species = species;
    
    this.sizeMeters = this.getSizeMeters();
  }
  

  //TODO: Delete your getters
//  @Override
//  public int getTemperatureLow() {
//    return temperatureLow;
//  }
//  
//  @Override
//  public int getTemperatureHigh() {
//    return temperatureHigh;
//  }
//  
  @Override
  public NaturalFeature getNaturalFeature() {
    return naturalFeature;
  }
//  
//  @Override
//  public boolean getPoisonous() {
//    return poisonous;
//  }
//  
//  @Override
//  public Endangerment getEndangerment() {
//    return endangerment;
//  }
//  
//  @Override
//  public boolean getCanShareSpace() {
//    return canShareSpace;
//  }
//
  @Override
  public int getSizeMeters() {
    return this.sizeMeters;
  }

  private int sizeNumber() {
    switch (this.size) {
      case SMALL:
        return 1;
      case MEDIUM:
        return 5;
      case LARGE:
        return 10;
      default:
        break;
    }
    return 0;
  }
  
  @Override
  public Habitat makePerfectHabitat(int size, String location) throws IllegalArgumentException {
    if (this.endangerment == Endangerment.EXTINCT) {
      throw new IllegalStateException("Endangered Species cannot live in a habitat.");
    }
    int temperature = (this.temperatureLow + this.temperatureHigh) / 2;
    int sizeSubtracted = size - this.sizeMeters;
    HabitatClass habitat = new HabitatClass(
        this.naturalFeature, sizeSubtracted, temperature, location, this.canShareSpace);
    return habitat;
  }


  @Override
  public int habitAnimalFit(HashMap<String, Object> habInfo) throws IllegalArgumentException {
    if (this.endangerment == Endangerment.EXTINCT) {
      throw new IllegalStateException("Endangered Species cannot live in a habitat.");
    }
    
    System.out.println(habInfo);
    
    boolean sharing = (boolean) habInfo.get("Sharing");
    int habitatSize = (Integer) habInfo.get("HabitatSize");
    int habitatTemperature = (Integer) habInfo.get("Temperature"); 
    List<String> habitatNaturalFeature = (List<String>) habInfo.get("NaturalFeature");
    int naturalFeatureLen = habitatNaturalFeature.size();
    
    if (sharing == true 
        & habitatSize > this.sizeMeters
        & habitatNaturalFeature.contains(this.naturalFeature)
        & habitatTemperature >= this.temperatureLow
        & habitatTemperature <= this.temperatureHigh) {
      
      return 0;
      
    } else if (sharing == true
        & habitatSize > this.sizeNumber()
        & naturalFeatureLen < 3
        & habitatTemperature >= this.temperatureLow
        & habitatTemperature <= this.temperatureHigh) {
      
      return 1;
      
    }
    
    
    
    return 2;
  }
  
  
}


