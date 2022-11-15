package com.techiekunal;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



import com.google.gson.*;
import com.google.gson.reflect.*;
import java.net.*;
class Result {

    /*
     * Complete the 'apiResponseParser' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY inputList
     *  2. INTEGER size
     */

    private static Predicate<Contacts> gePredicate(String type, Set<String> values) {

        if(type.equals("address.city")) {
            return contacts -> values.contains(contacts.address.city);
        } else {
            return contacts -> values.contains(contacts.username);
        }
    }

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        String surl = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
        String strJson = "";
        Gson gson = new Gson();
        List<Contacts> contacts = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        try {
            URL url = new URL(surl);
            HttpURLConnection uc = (HttpURLConnection)url.openConnection();
            uc.setRequestMethod("GET");
            uc.connect();

            InputStreamReader reader = new InputStreamReader(uc.getInputStream());
            contacts = gson.fromJson(reader, new TypeToken<List<Contacts>>() {}.getType());

            Predicate<Contacts> byUsername = contacts1 -> contacts1.username.equals("PrernaB");

            HashSet<String> citySet = new HashSet<>();
            citySet.add("Bengaluru");
//            citySet.add("Mumbai");
//            citySet.add("Delhi");

            Predicate<Contacts> predicate = gePredicate("address.city", citySet);

            List<Integer> responseList = contacts.stream().filter(predicate).map(Contacts::getId).collect(Collectors.toList());
            System.out.println("Responses - " + responseList);

        } catch (Exception ex) {

        }

        if (inputList.get(1).equals("EQUALS")) {
            for(Contacts c : contacts) {
                if(inputList.get(0).equals("id")) {
                    if(c.getId() == Long.getLong(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("name")) {
                    if(c.getName().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("username")) {
                    if(c.getUsername().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("email")) {
                    if(c.getEmail().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.street")) {
                    if(c.getAddress().getStreet().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.suite")) {
                    if(c.getAddress().getSuite().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.city")) {
                    if(c.getAddress().getCity().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.zipcode")) {
                    if(c.getAddress().getZipcode().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.geo.lat")) {
                    if(c.getAddress().getGeo().getLat() ==  Double.valueOf(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.geo.lng")) {
                    if(c.getAddress().getGeo().getLng() ==  Double.valueOf(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("website")) {
                    if(c.getWebsite().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("company.name")) {
                    if(c.getCompany().getName().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("company.basename")) {
                    if(c.getCompany().getBasename().equals(inputList.get(2))) {
                        results.add(c.getId());
                    }
                }
            }
        } else {
            for(Contacts c : contacts) {
                String str = inputList.get(2);
                String[] strArr = str.split(",");
                List<String> strList = Arrays.asList(strArr);
                if(inputList.get(0).equals("id")) {
                    if (strList.contains(String.valueOf(c.getId()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("name")) {
                    if (strList.contains(String.valueOf(c.getName()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("username")) {
                    if (strList.contains(String.valueOf(c.getUsername()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("email")) {
                    if (strList.contains(String.valueOf(c.getEmail()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.street")) {
                    if (strList.contains(String.valueOf(c.getAddress().getStreet()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.suite")) {
                    if (strList.contains(String.valueOf(c.getAddress().getSuite()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.city")) {
                    if (strList.contains(String.valueOf(c.getAddress().getCity()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.zipcode")) {
                    if (strList.contains(String.valueOf(c.getAddress().getZipcode()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.geo.lat")) {
                    if (strList.contains(String.valueOf(c.getAddress().getGeo().getLat()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("address.geo.lng")) {
                    if (strList.contains(String.valueOf(c.getAddress().getGeo().getLng()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("website")) {
                    if (strList.contains(String.valueOf(c.getWebsite()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("company.name")) {
                    if (strList.contains(String.valueOf(c.getCompany().getName()))) {
                        results.add(c.getId());
                    }
                } if(inputList.get(0).equals("company.basename")) {
                    if (strList.contains(String.valueOf(c.getCompany().getName()))) {
                        results.add(c.getId());
                    }
                }
            }
        }

        if(results.size() == 0) {
            results.add(-1);
            return results;
        }

        return results;
    }
}


class Contacts {
    int id;
    String name;
    String username;
    String email;
    String website;
    Address address;
    Company company;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }


}

class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }
    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }
    public void setWebsite(Geo geo) {
        this.geo = geo;
    }
}

class Geo {
    double lat;
    double lng;

    public double getLat() {
        return lat;
    }
    public void setWebsite(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
}

class Company {
    String name;
    String basename;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBasename() {
        return basename;
    }
    public void setBasename(String basename) {
        this.basename = basename;
    }
}

public class ARSolution {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inputListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> inputList = IntStream.range(0, inputListCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());
*/


        //int size = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = new String[]{"username", "EQUALS", "vinayk"};
        List<String> inputList = Arrays.asList(arr);

        List<Integer> result = Result.apiResponseParser(inputList, 1);

        System.out.println(result);
    }
}