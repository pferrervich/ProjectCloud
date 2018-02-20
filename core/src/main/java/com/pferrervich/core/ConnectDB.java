package com.pferrervich.core;

import java.sql.*;
import java.util.ArrayList;

/**
 * Llegeix les taules de la base de dades
 */

public class ConnectDB {
    public static ArrayList readRestaurant(String search) {
        ArrayList al = new ArrayList();
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");       // Driver per a que llegeixi la base de dades
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");      //Connexió a la base de dades

            PreparedStatement pstmt;

            /**
             * If que mira si la cerca no té un valor null, i fa la query a la base de dades com a un preparedStatement,
             * i ho ordena per la seva nota.
             * Passa el resultat del cercador a lowercase per a que correspongui a les dades de la base de dades
             * Si el valor de la cerca és null, mostrarà tots els restaurants
             */

            if((search!=null && !search.equals(""))){
                pstmt = con.prepareStatement("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, T.TRS_DESCRIPCIO, R.RES_URL_IMG, R.RES_CODI FROM RESTAURANTS R, TRESTAURANTS T WHERE RES_TRS_CODI = TRS_CODI AND LOWER(R.RES_NOM) LIKE ? ORDER BY RES_MITJANA ASC) WHERE ROWNUM <= 5");
                pstmt.setString(1, "%"+search.toLowerCase()+"%");
            }else{
                pstmt = con.prepareStatement("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, T.TRS_DESCRIPCIO, R.RES_URL_IMG, R.RES_CODI FROM RESTAURANTS R, TRESTAURANTS T WHERE RES_TRS_CODI = TRS_CODI ORDER BY RES_MITJANA ASC) WHERE ROWNUM <= 5");
            }

            /**
             * ResultSet que executa la query a la base de dades, i el while fa que per cada valor que tengui el
             * resultset, assigni les taules als parametres.
             */

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                /**
                 * Assignació de les taules als parametres
                 */

                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String imgurl = rs.getString("RES_URL_IMG");
                String codi = rs.getString("RES_CODI");


                /**
                 * Creacio de l'objecte rst a partir de Restaurant, i li fa els setters a partir dels parametres
                 */

                Restaurants rst = new Restaurants();
                rst.setName(name);
                rst.setAddress(address);
                rst.setWebsite(website);
                rst.setTelephone(telephone);
                rst.setType(type);
                rst.setImgurl(imgurl);
                rst.setCodi(codi);


                al.add(rst);
            }
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return al;
    }

    public static Restaurants readRestOpi(String id) {
        Restaurants rst = null;
        try {



            Class.forName("oracle.jdbc.driver.OracleDriver");       // Driver per a que llegeixi la base de dades
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");      //Connexió a la base de dades

            PreparedStatement pstmt;

            /**
             * If que mira si la cerca no té un valor null, i fa la query a la base de dades com a un preparedStatement,
             * i ho ordena per la seva nota.
             * Passa el resultat del cercador a lowercase per a que correspongui a les dades de la base de dades
             * Si el valor de la cerca és null, mostrarà tots els restaurants
             */

            pstmt = con.prepareStatement("SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, T.TRS_DESCRIPCIO, R.RES_URL_IMG, R.RES_CODI FROM RESTAURANTS R, TRESTAURANTS T WHERE RES_TRS_CODI = TRS_CODI AND RES_CODI='" + id + "'");

            /**
             * ResultSet que executa la query a la base de dades, i el while fa que per cada valor que tengui el
             * resultset, assigni les taules als parametres.
             */

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                /**
                 * Assignació de les taules als parametres
                 */

                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String imgurl = rs.getString("RES_URL_IMG");
                String codi = rs.getString("RES_CODI");
                /**
                 * Creacio de l'objecte rst a partir de Restaurant, i li fa els setters a partir dels parametres
                 */

                Restaurants rstt = new Restaurants();
                rstt.setName(name);
                rstt.setAddress(address);
                rstt.setWebsite(website);
                rstt.setTelephone(telephone);
                rstt.setType(type);
                rstt.setImgurl(imgurl);
                rstt.setCodi(codi);

            }
            con.close();


        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rst;
    }

    public static ArrayList readRestaurantapi() {
        ArrayList<Restaurants> all = new ArrayList<>();
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");       // Driver per a que llegeixi la base de dades
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");      //Connexió a la base de dades

            PreparedStatement pstmt;

            /**
             * If que mira si la cerca no té un valor null, i fa la query a la base de dades com a un preparedStatement,
             * i ho ordena per la seva nota.
             * Passa el resultat del cercador a lowercase per a que correspongui a les dades de la base de dades
             * Si el valor de la cerca és null, mostrarà tots els restaurants
             */


            pstmt = con.prepareStatement("SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, T.TRS_DESCRIPCIO, R.RES_URL_IMG, R.RES_CODI FROM RESTAURANTS R, TRESTAURANTS T WHERE RES_TRS_CODI = TRS_CODI");


            /**
             * ResultSet que executa la query a la base de dades, i el while fa que per cada valor que tengui el
             * resultset, assigni les taules als parametres.
             */

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                /**
                 * Assignació de les taules als parametres
                 */

                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String imgurl = rs.getString("RES_URL_IMG");
                String codi = rs.getString("RES_CODI");


                /**
                 * Creacio de l'objecte rst a partir de Restaurant, i li fa els setters a partir dels parametres
                 */

                Restaurants rst = new Restaurants();
                rst.setName(name);
                rst.setAddress(address);
                rst.setWebsite(website);
                rst.setTelephone(telephone);
                rst.setType(type);
                rst.setImgurl(imgurl);
                rst.setCodi(codi);


                all.add(rst);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return all;
    }
}

