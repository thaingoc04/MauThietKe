import java.util.HashMap;
import java.util.Map;
public class FlyWeight {
    // Flyweight object representing the common data shared among passports
    static class PassportInfo {
        private String name;
        private String nationality;
        private String dateOfBirth;

        public PassportInfo(String name, String nationality, String dateOfBirth) {
            this.name = name;
            this.nationality = nationality;
            this.dateOfBirth = dateOfBirth;
        }

        public String getPassportInfo() {
            return "Name: " + name + ", Nationality: " + nationality + ", Date of Birth: " + dateOfBirth;
        }
    }

    // Flyweight factory to create and manage PassportInfo objects
    static class  PassportInfoFactory {
        private static Map<String, PassportInfo> passportInfoCache = new HashMap<>();

        public static PassportInfo getPassportInfo(String name, String nationality, String dateOfBirth) {
            String key = name + nationality; // Unique key for each PassportInfo
            if (!passportInfoCache.containsKey(key)) {
                passportInfoCache.put(key, new PassportInfo(name, nationality, dateOfBirth));
            }
            return passportInfoCache.get(key);
        }
    }

    // Client code

    public static void main(String[] args) {
        PassportInfo passport1 = PassportInfoFactory.getPassportInfo("John Doe", "US", "01-01-1990");
        PassportInfo passport2 = PassportInfoFactory.getPassportInfo("Jane Smith", "UK", "02-02-1985");
        PassportInfo passport3 = PassportInfoFactory.getPassportInfo("John Doe", "US", "01-01-1990"); // Reusing existing PassportInfo

        System.out.println(passport1.getPassportInfo()); // Prints Passport info for John Doe
        System.out.println(passport2.getPassportInfo()); // Prints Passport info for Jane Smith
        System.out.println(passport3.getPassportInfo()); // Prints Passport info for John Doe (reused)
    }


}