package animal;

import habitat.Habitat;
import habitat.HabitatClass;

public class AbstractAnimal implements Animal {
  protected Size size;
  protected int temperatureLow;
  protected int temperatureHigh;
  protected NaturalFeature naturalFeature;
  protected boolean poisonous;
  protected Endangerment endangerment;
  protected boolean canShareSpace;
  protected String species;
  
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
//  @Override
//  public NaturalFeature getNaturalFeature() {
//    return naturalFeature;
//  }
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
//  @Override
//  public Size getSize() {
//    return this.size;
//  }


  @Override
  public Habitat makePerfectHabitat(int size, String location) {
    int temperature = (this.temperatureLow + this.temperatureHigh) / 2;
    HabitatClass habitat = new HabitatClass(this.naturalFeature, size, temperature, location);
    return habitat;
  }
  
  
}


