package Test;

import main.Length;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: talkin
 * Date: 13-11-18
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class LengthTest {

    @Test
    public void should_one_mile_equal_another_mile() throws Exception {
        Length oneMile = new Length(1760, "mile");
        Length anotherMile = new Length(1760, "mile");

        assertThat(oneMile.equals(anotherMile),is(true));

    }

    @Test
    public void should_one_yard_equal_another_yard() throws Exception {
        Length oneYard = new Length(3, "yard");
        Length anotherYard = new Length(3, "yard");

        assertThat(oneYard.equals(anotherYard),is(true));

    }

    @Test
    public void should_3_yard_not_equal_4_yard() throws Exception {
        Length threeYard = new Length(3, "yard");
        Length fourYard = new Length(4, "yard");

        assertThat(threeYard.equals(fourYard),is(false));

    }

    @Test
    public void should_1_mile_equal_1760_yard() throws Exception {
        Length oneMile = new Length(1, "mile");
        Length oneYard = new Length(1760, "yard");

        assertThat(oneMile.equals(oneYard),is(true));

    }

    @Test
    public void should_1_mile_not_equal_1761_yard() throws Exception {
        Length oneMile = new Length(1, "mile");
        Length oneYard = new Length(1761, "yard");

        assertThat(oneMile.equals(oneYard),is(false));

    }

    @Test
    public void should_1_yard_equal_3_feet() throws Exception {
        Length oneYard = new Length(1, "yard");
        Length oneFeet = new Length(3, "feet");

        assertThat(oneYard.equals(oneFeet),is(true));

    }

    @Test
    public void should_1_yard_not_equal_4_feet() throws Exception {
        Length oneYard = new Length(1, "yard");
        Length oneFeet = new Length(4, "feet");

        assertThat(oneYard.equals(oneFeet),is(false));

    }

    @Test
    public void should_1_feet_equal_12_inch() throws Exception {
        Length oneFeet = new Length(1, "feet");
        Length oneInch = new Length(12, "inch");

        assertThat(oneFeet.equals(oneInch),is(true));

    }

    @Test
    public void should_1_feet_not_equal_13_inch() throws Exception {
        Length oneFeet = new Length(1, "feet");
        Length oneInch = new Length(13, "inch");

        assertThat(oneFeet.equals(oneInch),is(false));

    }

    @Test     //4
    public void should_unit_is_exist() throws Exception {
        Length oneMile = new Length(1,"mile");
        Length oneYard = new Length(1,"yard");
        Length oneFeet = new Length(1,"feet");
        Length oneInch = new Length(1,"inch");
        Length oneTest = new Length(1,"TBSP");

        assertThat(oneMile.match(),is(true));
        assertThat(oneYard.match(),is(true));
        assertThat(oneFeet.match(),is(true));
        assertThat(oneInch.match(),is(true));
        assertThat(oneTest.match(),is(false));

    }

    @Test     //7
    public void should_Length_can_be_shown() throws Exception {
        Length length1 = new Length(2,"mile");
        Length length2 = new Length(1761,"yard");
        Length length3 = new Length(17,"feet");
        Length length4 = new Length(17,"inch");

        int biggerUnit_value;
        int smallerUnit_value;
        String biggerUnit_unit;
        String smallerUnit_unit;

        if (length1.unit == "mile"){
            biggerUnit_value = 0;
            biggerUnit_unit = "";

            smallerUnit_value = length1.value * 1760;
            smallerUnit_unit = "yard";

            Length biggerUnit = new Length(biggerUnit_value,biggerUnit_unit);
            Length smallerUnit = new Length(smallerUnit_value,smallerUnit_unit);

            Length big_except_1 = new Length(0,"");
            Length small_except_1 = new Length(1760*2,"yard");

            assertThat(combine(biggerUnit,big_except_1),is(true));
            assertThat(combine(smallerUnit,small_except_1),is(true));
        }

        if (length2.unit =="yard") {
            if (length2.value >= 1760){
                biggerUnit_value = length2.value/1760;
                biggerUnit_unit = "mile";
            }
            else {
                biggerUnit_value = 0;
                biggerUnit_unit ="";
            }

            if (length2.value%1760 > 0){
                int num = length2.value%1760;
                smallerUnit_value = num * 3;
                smallerUnit_unit = "feet";
            }
            else {
                smallerUnit_value = 0;
                smallerUnit_unit = "";
            }

            Length biggerUnit = new Length(biggerUnit_value,biggerUnit_unit);
            Length smallerUnit = new Length(smallerUnit_value,smallerUnit_unit);

            Length big_except_1 = new Length(1,"mile");
            Length small_except_1 = new Length(3,"feet");

            assertThat(combine(biggerUnit,big_except_1),is(true));
            assertThat(combine(smallerUnit,small_except_1),is(true));
        }

        if (length3.unit == "feet"){
            if (length3.value >= 3){
                biggerUnit_value = length3.value/3;
                biggerUnit_unit = "yard";
            }
            else {
                biggerUnit_value = 0;
                biggerUnit_unit = "";
            }

            if (length3.value%3 > 0){
                smallerUnit_value = length3.value%3 * 12;
                smallerUnit_unit = "inch";
            }
            else {
                smallerUnit_value = 0;
                smallerUnit_unit = "";
            }

            Length biggerUnit = new Length(biggerUnit_value,biggerUnit_unit);
            Length smallerUnit = new Length(smallerUnit_value,smallerUnit_unit);

            Length big_except_2 = new Length(5,"yard");
            Length small_except_2 = new Length(24,"inch");

            assertThat(combine(biggerUnit,big_except_2),is(true));
            assertThat(combine(smallerUnit,small_except_2),is(true));
        }

        if (length4.unit == "inch"){
            if (length4.value >= 12){
                biggerUnit_value = length4.value/12;
                biggerUnit_unit = "feet";
            }
            else {
                biggerUnit_value = 0;
                biggerUnit_unit = "";
            }
            smallerUnit_value = 0;
            smallerUnit_unit = "";

            Length biggerUnit = new Length(biggerUnit_value,biggerUnit_unit);
            Length smallerUnit = new Length(smallerUnit_value,smallerUnit_unit);

            Length big_except_3 = new Length(1,"feet");
            Length small_except_3 = new Length(0,"");

            assertThat(combine(biggerUnit,big_except_3),is(true));
            assertThat(combine(smallerUnit,small_except_3),is(true));
        }

    }

    private Boolean combine(Length o1, Length o2) {
        if (o1.value == o2.value && o1.unit == o2.unit)
            return true;
        return false;
    }

    @Test  //5
    public void should_unit_and_unit_can_add() throws Exception {
        Length oneMile = new Length(1,"mile");
        Length oneYard = new Length(1,"yard");
        Length oneFeet = new Length(1,"feet");
        Length oneInch = new Length(1,"inch");

        Length mile_and_yard_except = new Length(1760*3*12 + 3*12,"inch");
        Length mile_and_feet_except = new Length(1760*3*12 + 12,"inch");
        Length mile_and_inch_except = new Length(1760*3*12 + 1,"inch");
        Length yard_and_feet_except = new Length(3*12 + 12,"inch");
        Length yard_and_inch_except = new Length(3*12 + 1,"inch");
        Length feet_and_inch_except = new Length(12 + 1,"inch");

        int mile_and_yard_value = add(oneMile, oneYard);
        int mile_and_feet_value = add(oneMile, oneFeet);
        int mile_and_inch_value = add(oneMile, oneInch);
        int yard_and_feet_value = add(oneYard, oneFeet);
        int yard_and_inch_value = add(oneYard, oneInch);
        int feet_and_inch_value = add(oneFeet, oneInch);

        Length mile_and_yard_add = new Length(mile_and_yard_value,"");
        Length mile_and_feet_add = new Length(mile_and_feet_value,"");
        Length mile_and_inch_add = new Length(mile_and_inch_value,"");
        Length yard_and_feet_add = new Length(yard_and_feet_value,"");
        Length yard_and_inch_add = new Length(yard_and_inch_value,"");
        Length feet_and_inch_add = new Length(feet_and_inch_value,"");

        assertThat(mile_and_yard_add.equals(mile_and_yard_except),is(true));
        assertThat(mile_and_feet_add.equals(mile_and_feet_except),is(true));
        assertThat(mile_and_inch_add.equals(mile_and_inch_except),is(true));
        assertThat(yard_and_feet_add.equals(yard_and_feet_except),is(true));
        assertThat(yard_and_inch_add.equals(yard_and_inch_except),is(true));
        assertThat(feet_and_inch_add.equals(feet_and_inch_except),is(true));

    }

//    @Test
//    public void should_mile_and_yard_can_add() throws Exception {
//        Length oneMile = new Length(1, "mile");
//        Length oneYard = new Length(1, "yard");
//        Length one_except = new Length(1760*3*12 + 3*12, "inch");
//
//        int add_value = add(oneMile, oneYard);
//        Length add = new Length(add_value, "");
//
//        assertThat(add.equals(one_except),is(true));
//
//    }
//
//    @Test
//    public void should_mile_and_feet_can_add() throws Exception {
//        Length oneMile = new Length(1, "mile");
//        Length oneFeet = new Length(1, "feet");
//        Length one_except = new Length(1760*3*12 + 12, "inch");
//
//        int add_value = add(oneMile,oneFeet);
//        Length add = new Length(add_value, "");
//
//        assertThat(add.equals(one_except),is(true));
//
//    }
//
//    @Test
//    public void should_mile_and_inch_can_add() throws Exception {
//        Length oneMile = new Length(1, "mile");
//        Length oneInch = new Length(1, "inch");
//        Length one_except = new Length(1760*3*12 + 1, "inch");
//
//        int add_value = add(oneMile,oneInch);
//        Length add = new Length(add_value, "");
//
//        assertThat(add.equals(one_except),is(true));
//
//    }
//
//    @Test
//    public void should_yard_and_feet_can_add() throws Exception {
//        Length oneYard = new Length(1, "yard");
//        Length oneFeet = new Length(1, "feet");
//        Length one_except = new Length(3*12 + 12, "inch");
//
//        int add_value = add(oneYard,oneFeet);
//        Length add = new Length(add_value, "");
//
//        assertThat(add.equals(one_except),is(true));
//
//    }
//
//    @Test
//    public void should_yard_and_inch_can_add() throws Exception {
//        Length oneYard = new Length(1, "yard");
//        Length oneInch = new Length(1, "inch");
//        Length one_except = new Length(3*12 + 1, "inch");
//
//        int add_value = add(oneYard,oneInch);
//        Length add = new Length(add_value, "");
//
//        assertThat(add.equals(one_except),is(true));
//
//    }
//
//    @Test
//    public void should_feet_and_inch_can_add() throws Exception {
//        Length oneFeet = new Length(1, "feet");
//        Length oneInch = new Length(1, "inch");
//        Length one_except = new Length(12 + 1, "inch");
//
//        int add_value = add(oneFeet,oneInch);
//        Length add = new Length(add_value, "");
//
//        assertThat(add.equals(one_except),is(true));
//
//    }

    @Test //8
    public void should_Length_can_be_printed_by_inch() throws Exception {
        Length one_Mile = new Length(2,"mile");
        Length one_Yard = new Length(2,"yard");
        Length one_Feet = new Length(2,"feet");

        Length Mile_except = new Length(one_Mile.value*1760*3*12,"inch");
        Length Yard_except = new Length(one_Yard.value*3*12,"inch");
        Length Feet_except = new Length(one_Feet.value*12,"inch");

        assertThat(one_Mile.export(Mile_except),is(true));
        assertThat(one_Yard.export(Yard_except),is(true));
        assertThat(one_Feet.export(Feet_except),is(true));

    }

    private int add(Length o1, Length o2) {
        int result;
        o1.value = calculateValue(o1.unit);
        o2.value = calculateValue(o2.unit);
//        if (o1.unit == "mile")
//            o1.value = 1760*12*3;
//        else if (o1.unit == "yard")
//            o1.value = 12*3;
//        else if (o1.unit == "feet")
//            o1.value = 12;
//        else o1.value = 1;
//
//        if (o2.unit == "mile")
//            o2.value = 1760*12*3;
//        else if (o2.unit == "yard")
//            o2.value = 12*3;
//        else if (o2.unit == "feet")
//            o2.value = 12;
//        else o2.value = 1;

        result = o1.value + o2.value;
        return result;

    }

    private int calculateValue(String unit) {
        int value = 0;
        if(unit == "mile")
            value = 1760 * 12 * 3;

        if (unit == "yard")
            value = 12*3;

        if (unit == "feet")
            value = 12;

        if (unit == "inch")
            value = 1;

        return value;

    }

}
