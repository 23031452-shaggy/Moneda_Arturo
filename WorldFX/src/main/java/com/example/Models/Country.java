package com.example.Models;
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;
    private String governmentForm;

    public Country(Builder b) {
        this.code = b.code;
        this.name = b.name;
        this.continent = b.continent;
        this.region = b.region;
        this.population = b.population;
        this.governmentForm = b.governmentForm;
    }

    public static class Builder {
        private String code;
        private String name;
        private String continent;
        private String region;
        private int population;
        private String governmentForm;

        public Builder setCode(String code) { this.code = code; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setContinent(String continent) { this.continent = continent; return this; }
        public Builder setRegion(String region) { this.region = region; return this; }
        public Builder setPopulation(int population) { this.population = population; return this; }
        public Builder setGovernmentForm(String governmentForm) { this.governmentForm = governmentForm; return this; }

        public Country build() { return new Country(this); }
    }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getContinent() { return continent; }
    public String getRegion() { return region; }
    public int getPopulation() { return population; }
    public String getGovernmentForm() { return governmentForm; }
}
