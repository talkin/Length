package main;

/**
 * Created with IntelliJ IDEA.
 * User: talkin
 * Date: 13-11-18
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class Length {
//    private String unit;
//    private int value;
    public String unit;
    public int value;


    public Length(int value, String unit) {
        //To change body of created methods use File | Settings | File Templates.
        this.unit = unit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;

        Length length = (Length) o;

        if (unit == "mile"){
            value = 1760;
        }

        if (unit == "yard"){
            value = 3;
        }

        if (unit == "feet"){
            value = 12;
        }

        if (unit == "inch"){
            value = 1;
        }


        if (value != length.value) return false;
//        if (!unit.equals(length.unit)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unit.hashCode();
        result = 31 * result + value;
        return result;
    }

    public Boolean export(Object o) {
        Length length = (Length)o;

        if (unit == "mile"){
            value = value*1760*3*12;
        }
        if (unit == "yard"){
            value = value*3*12;
        }
        if (unit == "feet"){
            value = value*12;
        }

        if (value != length.value) return false;

        return true;

    }

    public Boolean match() {
        if (unit == "mile")
            return true;
        else if (unit == "yard")
            return true;
        else if (unit == "feet")
            return true;
        else if (unit == "inch")
            return true;
        else return false;
    }
}
