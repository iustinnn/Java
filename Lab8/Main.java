package org.example;
import java.sql.*;
public class Main {
    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            System.out.println(artists.findByName("Michael Jackson"));
            System.out.println(artists.findById(2));
                    Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}