package animal;

import animal.Endangerment;
import animal.NaturalFeature;

//Should consist of the methods for animal
//Need to have these methods in here to access them. 
public interface Animal {
    

    
  //TODO: any predefined functions
  //TODO: Remove the getters 
  public int getTemperatureLow();
  
  public int getTemperatureHigh();
  
  public NaturalFeature getNaturalFeature();
  
  public boolean getPoisonous();
  
  public Endangerment getEndangerment();
  
  public boolean getCanShareSpace();
  
  public Size getSize();

}
