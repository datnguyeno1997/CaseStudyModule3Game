package untils;

import java.util.regex.Pattern;

public class ValidatesUntils {
    public static final String USERNAME_REGEX = "^([A-Za-z0-9 ]{3,20})$";
    public static final String DESCRIPTION_REGEX = "^([A-Za-z0-9 ]{3,49})$";
    private static final String CREATEAT_REGEX = "^[0-9]{1,2}+[-]+[0-9]{1,2}+[-][0-9]{4}$";

    private static final String REGEX_NAME = "^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+)$";
    private static final String REGEX_ADDRESS = "^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+)$";
    private static final String REGEX_PHONE = "^[0-9]{10}$";
    private static final String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{8,}$";


    public static boolean isUserNameValid(String name) {
        return Pattern.matches(USERNAME_REGEX, name);
    }
    public static boolean isValidName(String name){
        return Pattern.matches(REGEX_NAME, name);
    }
    public static boolean isValidAddress(String address){
        return Pattern.matches(REGEX_ADDRESS, address);
    }
    public static boolean isValidPhone(String phone){
        return Pattern.matches(REGEX_PHONE, phone);
    }
    public static boolean isValidEmail(String email){
        return Pattern.matches(REGEX_EMAIL, email);
    }

    public static boolean isValidDescription(String email) {
        return Pattern.matches(DESCRIPTION_REGEX, email);
    }
    public static boolean isValidCreateAT(String createAt) {
        return Pattern.matches(CREATEAT_REGEX, createAt);
    }
    public static boolean isPassValid(String passnew) {
        return Pattern.matches(REGEX_PASSWORD, passnew);
    }

}
