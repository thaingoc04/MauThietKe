public class Facade {
    public static class AccountService {

        public void getAccount(String email) {
            System.out.println("Getting the account of " + email);
        }
    }

    public static class PaymentService {

        public void paymentByPaypal() {
            System.out.println("Payment by Paypal");
        }

        public void paymentByCreditCard() {
            System.out.println("Payment by Credit Card");
        }

        public void paymentByEbankingAccount() {
            System.out.println("Payment by E-banking account");
        }

        public void paymentByCash() {
            System.out.println("Payment by cash");
        }
    }

    public static class ShippingService {

        public void freeShipping() {
            System.out.println("Free Shipping");
        }

        public void standardShipping() {
            System.out.println("Standard Shipping");
        }

        public void expressShipping() {
            System.out.println("Express Shipping");
        }
    }

    public static class EmailService {

        public void sendMail(String mailTo) {
            System.out.println("Sending an email to " + mailTo);
        }
    }

    public static class SmsService {

        public void sendSMS(String mobilePhone) {
            System.out.println("Sending an mesage to " + mobilePhone);
        }
    }

    public static class ShopFacade {



        private static final ShopFacade INSTANCE = new ShopFacade();

        private AccountService accountService;
        private PaymentService paymentService;
        private ShippingService shippingService;
        private EmailService emailService;
        private SmsService smsService;

        private ShopFacade() {
            accountService = new AccountService();
            paymentService = new PaymentService();
            shippingService = new ShippingService();
            emailService = new EmailService();
            smsService = new SmsService();
        }

        public static ShopFacade getInstance() {
            return INSTANCE;
        }

        public void buyProductByCashWithFreeShipping(String email) {
            accountService.getAccount(email);
            paymentService.paymentByCash();
            shippingService.freeShipping();
            emailService.sendMail(email);
            System.out.println("Done\n");
        }

        public void buyProductByPaypalWithStandardShipping(String email, String mobilePhone) {
            accountService.getAccount(email);
            paymentService.paymentByPaypal();
            shippingService.standardShipping();
            emailService.sendMail(email);
            smsService.sendSMS(mobilePhone);
            System.out.println("Done\n");
        }
    }


    public static void main(String[] args) {
        ShopFacade.getInstance().buyProductByCashWithFreeShipping("contact@gpcoder.com");
        ShopFacade.getInstance().buyProductByPaypalWithStandardShipping("gpcodervn@gmail.com", "0988.999.999");
    }


}