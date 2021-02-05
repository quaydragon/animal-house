package habitat;

import animal.NaturalFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HabitatClass implements Habitat {
  private List<NaturalFeature> naturalFeatures = new ArrayList<NaturalFeature>();
  private int habitatSize;
  private int temperatureOfHabitat;
  private String location;
  private boolean sharing;
  
  
  public HabitatClass(NaturalFeature naturalFeature, 
      int habitatSize, 
      int temperatureOfHabitat,
      String location,
      boolean sharing) {
    this.habitatSize = habitatSize;
    this.temperatureOfHabitat = temperatureOfHabitat;
    this.location = location;
    this.sharing = sharing;
    
    naturalFeatures.add(naturalFeature);
  }
  
  @Override
  public HashMap<String, Object> habitatInfo() {
    HashMap<String, Object> habInfo = new HashMap<String, Object>();
    
    habInfo.put("NaturalFeature", naturalFeatures);
    habInfo.put("Location", this.location);
    habInfo.put("HabitatSize", this.habitatSize);
    habInfo.put("Temperature", this.temperatureOfHabitat);
    habInfo.put("Sharing", this.sharing);
    
    
    return habInfo;
  }
  
  
  //TODO: Get rid of unnessary getters
  
  @Override
  public List<NaturalFeature> getNaturalFeatures() {
    // TODO Auto-generated method stub
    return naturalFeatures;
  }

//  @Override
//  public int getHabitatSize() {
//    return this.habitatSize;
//  }
//
//  @Override
//  public int getTemperatureOfHabitat() {
//    // TODO Auto-generated method stub
//    return temperatureOfHabitat;
//  }
//
//  @Override
//  public String getLocation() {
//    // TODO Auto-generated method stub
//    return this.location;
//  }

  
  
  
  
  //TODO: Some of these methods are really unnecessary

  @Override
  public void subtractSizeForAnimal(int animalSize) {
    int habSize = this.habitatSize - animalSize;
    this.habitatSize = habSize;
  }

  @Override
  public int changeTemperature() {
    // TODO Auto-generated method stub
    return 0;
  }
  
//  @Override
//  public void addNaturalFeature(NaturalFeature naturalfeature) {
//    // TODO Auto-generated method stub
//    this.naturalFeatures.add(naturalfeature);
//  }

  @Override
  public NaturalFeature[] deleteNaturalFeature() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addNaturalFeature(NaturalFeature naturalFeature) throws IllegalArgumentException {
    if (this.naturalFeatures.size() >= 3) {
      throw new IllegalStateException("Cannot Hace a Habitat with more than 3 features.");
    }
    
    this.naturalFeatures.add(naturalFeature);
  
  }




}
