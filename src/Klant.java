public class Klant {
        private String username;
        private String password;

        private String klantType;

        public Klant(String username, String password, String klantType) {
            this.username = username;
            this.password = password;
        }

    public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
