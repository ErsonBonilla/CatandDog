package com.ut.catanddog.catanddog.infraestructura.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuracion {

    private static final Properties props = new Properties();
    private static boolean loaded = false;

    private static void cargar() {
        if (loaded) return;

        try (InputStream is = Configuracion.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (is != null) {
                props.load(is);
            }
        } catch (IOException e) {
            System.err.println("No se pudo cargar application.properties: " + e.getMessage());
        }

        Path externo = Paths.get("config", "db.properties");
        if (Files.exists(externo)) {
            try (InputStream is = Files.newInputStream(externo)) {
                props.load(is);
                System.out.println("Configuración externa cargada desde: " + externo.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error al cargar configuración externa: " + e.getMessage());
            }
        }

        loaded = true;
    }

    public static String getDbUrl() {
        cargar();
        return props.getProperty("db.url", "jdbc:mysql://localhost:3306/catanddog?serverTimezone=UTC");
    }

    public static String getDbUser() {
        cargar();
        return props.getProperty("db.user", "catanddog");
    }

    public static String getDbPassword() {
        cargar();
        return props.getProperty("db.password", "admin");
    }

    public static String getDbDriver() {
        cargar();
        return props.getProperty("db.driver", "com.mysql.cj.jdbc.Driver");
    }

    public static String getPersistenceUnitName() {
        cargar();
        return props.getProperty("persistence.unit.name", "CatandDogPU");
    }

    public static String getFacturasOutputDir() {
        cargar();
        return props.getProperty("facturas.output.dir", "C:/Facturas/");
    }

    public static Properties getProperties() {
        cargar();
        return new Properties(props);
    }
}
