package driver;


import animal.Endangerment;
import animal.NaturalFeature;
import animal.Reptile;
import animal.Size;
import house.ReptileHouse;
import house.ReptileHouseClass;

public class Driver {
  
  public static void main(String[] args) { 

    Reptile lilyLizard = new Reptile(Size.SMALL,
        40,
        80,
        NaturalFeature.LILYPOOL,
        false,
        Endangerment.FINE,
        true,
        "lily lizard");
    
    Reptile komododragon = new Reptile(Size.SMALL,
        30,
        60,
        NaturalFeature.FALLENLOG,
        true,
        Endangerment.FINE,
        true,
        "Komodo Dragon");
    
    
    ReptileHouseClass rh = new ReptileHouseClass(3);
    
    rh.addAnimal(lilyLizard);
    
    rh.addAnimal(komododragon);
    
  } 

}
