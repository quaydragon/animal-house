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
  
  
  public HabitatClass(NaturalFeature naturalFeature, 
      int habitatSize, 
      int temperatureOfHabitat,
      String location) {
    this.habitatSize = habitatSize;
    this.temperatureOfHabitat = temperatureOfHabitat;
    this.location = location;
    
    naturalFeatures.add(naturalFeature);
  }
  
  @Override
  public HashMap<String, Object> habitatInfo() {
    HashMap<String, Object> habInfo = new HashMap<String, Object>();
    
    habInfo.put("NaturalFeature", naturalFeatures);
    habInfo.put("Location", this.location);
    habInfo.put("HabitatSize", this.habitatSize);
    habInfo.put("Temperature", this.temperatureOfHabitat);
    
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
//    // TODO Auto-generated method stub
//    return habitatSize;
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
  public int subtractSizeForAnimal() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int changeTemperature() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public NaturalFeature[] addNaturalFeature() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public NaturalFeature[] deleteNaturalFeature() {
    // TODO Auto-generated method stub
    return null;
  }




}
