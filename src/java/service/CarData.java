/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.HashMap;
import java.util.Map;
import model.CarInfo;

/**
 *
 * @author HP
 */
public class CarData {


    final private Map<String, CarData> CarInfo = new HashMap<>();
    final private static CarData instance = new CarData();

    CarData() {
        CarInfo.put("brand", new CarData());
        CarInfo.put("model", new CarData());
}
}
