package client;

public class Client {
    private String firstName;
    private String secondName;
    private String address;
    private String passportNumber;
    private boolean wantsMessages;

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getAddress() { return this.address; }

    public String getPassportNumber() { return this.passportNumber; }

    public boolean wantsGetMessages() { return this.wantsMessages; }

    public boolean isSuspicious() {
        return this.address == null || this.passportNumber == null;
    }

    public static class Builder {
        private String firstName;
        private String secondName;
        private String address;
        private String passportNumber;
        private boolean wantsMessages = false;

        public Builder withFirstName(String value) {
            this.firstName = value;
            return this;
        }

        public Builder withSecondName(String value) {
            this.secondName = value;
            return this;
        }

        public Builder withName(String firstName, String secondName){
            this.firstName = firstName;
            this.secondName = secondName;
            return this;
        }

        public Builder withAddress(String value) {
            this.address = value;
            return this;
        }

        public Builder withPassportNumber(String value) {
            this.passportNumber = value;
            return this;
        }

        public Builder withMessages(boolean wantsMessages) {
            this.wantsMessages = wantsMessages;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    private Client(Builder builder) {
        firstName = builder.firstName;
        secondName = builder.secondName;
        address = builder.address;
        passportNumber = builder.passportNumber;
        wantsMessages = builder.wantsMessages;
    }
}
