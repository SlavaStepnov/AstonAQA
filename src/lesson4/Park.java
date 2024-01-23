package lesson4;

public class Park {

    public class Attraction {
        private String attrName;
        private String workingHours;
        private int cost;

        public void getAttrInfo() {
            System.out.println("Name : " + attrName + "\n"
                    +"Working Hours : " + workingHours + "\n"
                    +"Cost : " + cost);
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction attr1 = park.new Attraction();

        attr1.attrName = "Roller coaster";
        attr1.workingHours = "10:00 - 18:00";
        attr1.cost = 10;
        attr1.getAttrInfo();
    }
}
