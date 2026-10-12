package com.wear.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class WhatshouldIWearTest {
    wearing cloth = new wearing();
    @Test
    public void testWhatShouldIWear() {
        assertEquals("The Weather is Warm / Mild Wear something like Denim jackets, unlined blazers, cardigans, trench coats, ankle boots, loafers, or white leather sneakers", cloth.WearCloth(25,"warm"));
        assertEquals(" The Weather is Hot Wear Something like Linen shirts, flowy midi/maxi dresses, chino shorts, open-toe sandals or canvas sneaker ", cloth.WearCloth(30,"sunny"));
        //assertEquals("The Weather is Extremly cold Wear something warm like Puffer jackets (down or synthetic fill), parkas with fur-lined hoods, thermal leggings under pants, heavy wool socks.",cloth.WearCloth(4,"Extremly cold"));
        assertEquals("The Weather is chill Wear something like Turtlenecks, leather jackets, wool peacoats, trench coats with liners, Chelsea boots. ", cloth.WearCloth(10,"chill"));
        assertEquals("Trench coat and Umbrella", cloth.WearCloth(10,"light rain"));
        assertEquals("Light raincoat and waterproof shoes", cloth.WearCloth(20,"heavy rain"));
    }
    
}