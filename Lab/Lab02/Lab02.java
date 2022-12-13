class AirPurifier{
    String model; //instance variable
    String serialNo; //instance variable
    String powerStat = "Off"; //instance variable
    static String mostPopularModel = "Coway Airmega AP-1512HH"; //class variable
    static String bestQualityModel = "HEPA air purifier"; //class variable
    void TurnOn() {powerStat = "On";} //instance method
    void TurnOff() {powerStat = "Off";} //instance method
    AirPurifier(String model,String serialNo){  //constructor will be instance method
        this.model = model;
        this.serialNo = serialNo;
    }
    void showDetail(){ //instance method
        System.out.println("------------------------");
        System.out.println("Air Purifier Detail");
        System.out.println("------------------------");
        System.out.println("Model Name : " + model);
        System.out.println("Serial Number : " + serialNo);
        System.out.println("Power Status : " + powerStat);
        System.out.println("------------------------");
    }
    static void updateAPF(String newMPM,String newBQM){ //class method
        bestQualityModel = newBQM;
        mostPopularModel = newMPM;
    } //class method
    static void showAPfacts(){ //class method
        System.out.println("------------------------");
        System.out.println("Air Purifier Facts");
        System.out.println("------------------------");
        System.out.println("Most Popular Model : " + mostPopularModel);
        System.out.println("Best Quality Model : " + bestQualityModel);
        System.out.println("------------------------");
    }
}

public class Lab02 {
    public static void main(String[] args) {
        System.out.println("// ======================== \\\\");
        System.out.println("|| Air Purifier class test! ||");
        System.out.println("\\\\ ======================== //");
        System.out.println("=======================================================");
        System.out.println("Test #1"); //Test #1 (Constructors Test)
        AirPurifier AP1 = new AirPurifier("Xiaomi Mi 3H","2001369603");
        AirPurifier AP2 = new AirPurifier("Honeywell HPA100","AP51697593");
        AP1.showDetail();
        AP2.showDetail();
        System.out.println("=======================================================");
        System.out.println("Test #2"); //Test #2 (TurnOn/Off Test)
        AP2.model = AP1.model;
        AP1.model = AirPurifier.mostPopularModel;
        AP1.serialNo = "PI31415926";
        AP1.TurnOff();
        AP2.TurnOn();
        AP1.showDetail();
        AP2.showDetail();
        System.out.println("=======================================================");
        System.out.println("Test #3"); //Test #3 (Class methods Test)
        AirPurifier.showAPfacts();
        AirPurifier.updateAPF("Dyson Purifier XD-69","Optimum Aerem Purgatorium AP-96");
        AirPurifier.showAPfacts();
        AirPurifier.updateAPF("Optimum Aerem Purgatorium AP-96","Plants");
        AirPurifier.showAPfacts();
    }
}