package org.launchcode.techjobs.oo;

import java.util.Objects;

public class PositionType extends JobField{



    public PositionType(String value) {
        super(value);
    }

    // TODO: Add a custom toString() method that returns the data stored in 'value'.
    @Override
    /*public String toString(){
        return this.value;
}*/
    // TODO: Add custom equals and hashCode methods. Consider two PositionType objects "equal" when
    //  their id fields match.

    public boolean equals(Object o){
        if (!(o instanceof PositionType)) return false;
        PositionType positionType = (PositionType) o;
        return getId() == positionType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
