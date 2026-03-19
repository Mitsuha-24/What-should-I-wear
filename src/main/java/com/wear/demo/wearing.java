package com.wear.demo;
import org.springframework.stereotype.Service;

@Service
public class wearing{
    public String WearCloth( double temp , String condition ){
        boolean isRaining = condition.toLowerCase().contains("rain");

        if (isRaining) {
            return (temp < 15) ? "Trench coat and Umbrella" : "Light raincoat and waterproof shoes";
        }
        if( temp <=5){
            return (" The Weather is Extremly cold Wear something warm like Puffer jackets (down or synthetic fill), parkas with fur-lined hoods, thermal leggings under pants, heavy wool socks.");
        }
        else if(temp >5 && temp <15){
            return ("The Weather is chill Wear something like Turtlenecks, leather jackets, wool peacoats, trench coats with liners, Chelsea boots. ");
        }
        else if(temp >=15 && temp <= 25){
            return("The Weather is Warm / Mild Wear something like Denim jackets, unlined blazers, cardigans, trench coats, ankle boots, loafers, or white leather sneakers");
        }
        else if(temp>25){
            return (" The Weather is Hot Wear Something like Linen shirts, flowy midi/maxi dresses, chino shorts, open-toe sandals or canvas sneaker ");
        }
        
        return ("city not found");
    }
}