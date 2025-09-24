public class Pizza {
    private String masa;
    private String salsa;
    private String queso;
    private boolean pepperoni;
    private boolean champinones;
    private boolean jamon;

    private Pizza(Builder builder) {
        this.masa = builder.masa;
        this.salsa = builder.salsa;
        this.queso = builder.queso;
        this.pepperoni = builder.pepperoni;
        this.champinones = builder.champinones;
        this.jamon = builder.jamon;
    }

    public static class Builder {
        private String masa;
        private String salsa;
        private String queso;
        private boolean pepperoni;
        private boolean champinones;
        private boolean jamon;

        public Builder masa(String masa) {
            this.masa = masa;
            return this;
        }

        public Builder salsa(String salsa) {
            this.salsa = salsa;
            return this;
        }

        public Builder queso(String queso) {
            this.queso = queso;
            return this;
        }

        public Builder pepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Builder champinones(boolean champinones) {
            this.champinones = champinones;
            return this;
        }

        public Builder jamon(boolean jamon) {
            this.jamon = jamon;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza con masa " + masa + ", salsa " + salsa + ", queso " + queso +
                (pepperoni ? ", pepperoni" : "") +
                (champinones ? ", champiñones" : "") +
                (jamon ? ", jamón" : "");
    }
}
