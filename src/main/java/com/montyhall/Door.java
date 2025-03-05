package com.montyhall;

public class Door {
    private boolean isTreasureDoor;
    private DoorType doorType;

    public Door(){
        isTreasureDoor=false;
        doorType=DoorType.CLOSED;
    }

    public boolean isTreasureDoor() {
        return isTreasureDoor;
    }

    public void setTreasureDoor(boolean isTreasureDoor) {
        this.isTreasureDoor = isTreasureDoor;
    }

    public DoorType getDoorType() {
        return doorType;
    }

    public void setDoorType(DoorType doorType) {
        this.doorType = doorType;
    }
    
}
