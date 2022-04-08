package casia.isiteam.creational_pattern.builder_pattern.factory;

import casia.isiteam.creational_pattern.builder_pattern.pojo.extend.ChickenBurger;
import casia.isiteam.creational_pattern.builder_pattern.pojo.extend.Coke;
import casia.isiteam.creational_pattern.builder_pattern.pojo.extend.Pepsi;
import casia.isiteam.creational_pattern.builder_pattern.pojo.extend.VegBurger;

/**
 * @ClassName: MealBuilder
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class MealBuilder {
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
