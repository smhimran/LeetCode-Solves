class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        boolean success;

        switch (carType) {
            case 1:
                success = addBig();
                break;
            case 2:
                success = addMedium();
                break;
            case 3:
                success = addSmall();
                break;
            default:
                success = false;
        }

        return success;
    }

    private boolean addSmall() {
        boolean success = false;
        if (small > 0) {
            small--;
            success = true;
        }

        return success;
    }
    
    private boolean addMedium() {
        boolean success = false;
        if (medium > 0) {
            medium--;
            success = true;
        }

        return success;
    }

    private boolean addBig() {
        boolean success = false;
        if (big > 0) {
            big--;
            success = true;
        }

        return success;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */